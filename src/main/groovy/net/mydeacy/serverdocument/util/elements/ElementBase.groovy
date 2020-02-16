package net.mydeacy.serverdocument.util.elements

import net.mydeacy.serverdocument.util.elements.interfaces.Directory

class ElementBase {

    private final buttonImage

    private final title

    private final directory

    ElementBase(String title, String buttonImage, Directory directory) {
        this.title = title
        this.buttonImage = buttonImage
        this.directory = directory
    }

    String getButtonImage() {
        return buttonImage
    }

    String getTitle() {
        return title
    }

    Directory getDirectory() {
        return directory
    }
}
