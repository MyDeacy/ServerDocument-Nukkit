package net.mydeacy.serverdocument.util

import net.mydeacy.serverdocument.util.elements.DirectoryElement
import net.mydeacy.serverdocument.util.elements.FileElement
import net.mydeacy.serverdocument.util.elements.interfaces.Directory
import net.mydeacy.serverdocument.util.elements.interfaces.Element
import net.mydeacy.serverdocument.util.elements.interfaces.TextFile

class ElementManagerImpl implements ElementManager {

    private List<Element> elementList = new ArrayList<>()

    ElementManagerImpl(String baseDir) {
        File file = new File(baseDir)
        if (!file.exists()) {
            file.mkdirs()
        }
        loadElements(null, file.absolutePath)
        elementList.sort().sort { a, b ->
            return a instanceof Directory && b instanceof TextFile ? -1 : 1
        }
    }

    @Override
    List<Element> getFilesByDirectory(Directory directory) {
        List<Element> list = new ArrayList<>()
        elementList.each {
            if (it.directory == directory) {
                list.add(it)
            }
        }
        return list
    }

    private void loadElements(Directory directory, String path) {
        path += !directory ? "/" : directory.title + "/"
        Directory directoryElement
        (new File(path)).listFiles().each {
            if (it.file && getExtension(it.name) == ".txt") {
                elementList.add(new FileElement(it.name, it.text, directory))
            } else if (it.directory) {
                directoryElement = new DirectoryElement(it.name, directory)
                elementList.add(directoryElement)
                loadElements(directoryElement, path)
            }
        }
    }

    private static String getExtension(String fileName) {
        int index = fileName.lastIndexOf(".")
        return index == -1 ? "" : fileName.substring(index)
    }

}
