package net.mydeacy.serverdocument.util

import net.mydeacy.serverdocument.util.elements.interfaces.Directory
import net.mydeacy.serverdocument.util.elements.interfaces.Element

interface ElementManager {

    List<Element> getFilesByDirectory(Directory directory)
}
