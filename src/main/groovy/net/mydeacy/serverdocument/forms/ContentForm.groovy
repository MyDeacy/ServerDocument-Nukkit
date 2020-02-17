package net.mydeacy.serverdocument.forms

import cn.nukkit.Player
import cn.nukkit.form.element.ElementButton
import cn.nukkit.form.response.FormResponseSimple
import cn.nukkit.form.window.FormWindowSimple
import net.mydeacy.serverdocument.util.ElementManager
import net.mydeacy.serverdocument.util.elements.interfaces.TextFile

class ContentForm extends FormWindowSimple implements ServerDocumentForm {

    private static final BACK_BUTTON = "Back"

    private final TextFile fileElement

    private final ElementManager manager

    ContentForm(TextFile fileElement, ElementManager manager) {
        super(fileElement.title, fileElement.content, [new ElementButton(BACK_BUTTON)])
        this.fileElement = fileElement
        this.manager = manager
    }

    @Override
    void handleResponse(Player player, FormResponseSimple response) {
        player.showFormWindow(new ExplorerForm(fileElement.directory, manager))
    }
}
