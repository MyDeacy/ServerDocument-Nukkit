package net.mydeacy.serverdocument.forms

import cn.nukkit.Player
import cn.nukkit.form.response.FormResponseSimple

interface ServerDocumentForm {

    void handleResponse(Player player, FormResponseSimple response)

}