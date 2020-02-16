package net.mydeacy.serverdocument.forms

import cn.nukkit.form.element.ElementButton
import cn.nukkit.form.element.ElementButtonImageData
import net.mydeacy.serverdocument.util.elements.interfaces.Element

class ServerDocumentButton extends ElementButton {

    private final Element element

    ServerDocumentButton(Element element) {
        super(element.title, new ElementButtonImageData(ElementButtonImageData.IMAGE_DATA_TYPE_PATH, element.buttonImage))
        this.element = element
    }

    Element getElement(){
        return element
    }
}
