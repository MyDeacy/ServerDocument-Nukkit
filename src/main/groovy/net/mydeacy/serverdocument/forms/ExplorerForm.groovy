package net.mydeacy.serverdocument.forms

import cn.nukkit.Player
import cn.nukkit.event.player.PlayerFormRespondedEvent
import cn.nukkit.form.element.ElementButton
import cn.nukkit.form.element.ElementButtonImageData
import cn.nukkit.form.response.FormResponse
import cn.nukkit.form.response.FormResponseSimple
import cn.nukkit.form.window.FormWindowSimple
import net.mydeacy.serverdocument.util.ElementManager
import net.mydeacy.serverdocument.util.elements.DirectoryElement
import net.mydeacy.serverdocument.util.elements.interfaces.Directory
import net.mydeacy.serverdocument.util.elements.interfaces.TextFile

class ExplorerForm extends FormWindowSimple implements ServerDocumentForm {

    private static final FORM_TITLE = "§lServerDocument"
    private static final BACK_BUTTON = "BACK"

    private Directory directory

    private ElementManager manager

    ExplorerForm(Directory directory, ElementManager manager) {
        super(FORM_TITLE, directory?.title ?: "/")
        if (directory) {
            addButton(new ElementButton(BACK_BUTTON))
        }
        manager.getFilesByDirectory(directory).each {
            ServerDocumentButton button = new ServerDocumentButton(it)
            addButton(button)
        }
        this.directory = directory
        this.manager = manager
    }

    @Override
    void handleResponse(Player player, FormResponseSimple response) {
        int index = response.clickedButtonId
        if (!(buttons[index] instanceof ServerDocumentButton)) {
            player.showFormWindow(new ExplorerForm(directory.directory, manager))
            return
        }
        ServerDocumentButton button = (ServerDocumentButton) buttons[index]
        if (button.element instanceof TextFile) {
            player.showFormWindow(new ContentForm((TextFile) button.element, manager))
        } else if (button.element instanceof Directory) {
            player.showFormWindow(new ExplorerForm((Directory) button.element, manager))
        }
    }
}
