package net.mydeacy.serverdocument.util.elements

import net.mydeacy.serverdocument.util.elements.interfaces.Directory

class DirectoryElement extends ElementBase implements Directory {

    public static final BUTTON_IMAGE = "textures/blocks/bookshelf.png"

    DirectoryElement(String title, Directory directory) {
        super(title, BUTTON_IMAGE, directory)
    }
}
