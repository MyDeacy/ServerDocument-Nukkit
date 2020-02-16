package net.mydeacy.serverdocument

import cn.nukkit.event.EventHandler
import cn.nukkit.event.Listener
import cn.nukkit.event.player.PlayerFormRespondedEvent
import cn.nukkit.form.response.FormResponseSimple
import net.mydeacy.serverdocument.forms.ServerDocumentForm

class EventListener implements Listener {

    @EventHandler
    static void handleFormResponse(PlayerFormRespondedEvent event) {
        if (!(event.window instanceof ServerDocumentForm) || !event.response) {
            return
        }
        ((ServerDocumentForm) event.window).handleResponse(event.player, event.response as FormResponseSimple)
    }
}
