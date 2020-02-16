package net.mydeacy.serverdocument.util.elements

import net.mydeacy.serverdocument.util.elements.interfaces.Directory
import net.mydeacy.serverdocument.util.elements.interfaces.TextFile

class FileElement extends ElementBase implements TextFile {

    private content

    public static final BUTTON_IMAGE = "textures/items/book_written.png"

    FileElement(String title, String content, Directory directory) {
        super(title, BUTTON_IMAGE, directory)
        this.content = content
    }

    @Override
    String getContent() {
        return content
    }
}
