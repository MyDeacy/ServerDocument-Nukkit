package net.mydeacy.serverdocument

import cn.nukkit.Player
import cn.nukkit.command.Command
import cn.nukkit.command.CommandSender
import cn.nukkit.plugin.PluginBase
import net.mydeacy.serverdocument.forms.ExplorerForm
import net.mydeacy.serverdocument.util.ElementManager
import net.mydeacy.serverdocument.util.ElementManagerImpl

class ServerDocument extends PluginBase {

    private static final String PUBLIC_DIR = "public"
    private ElementManager manager

    @Override
    void onEnable() {
        server.pluginManager.registerEvents(new EventListener(), this)
        manager = new ElementManagerImpl(dataFolder.absolutePath + "/" + PUBLIC_DIR)
    }

    @Override
    boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            sender.showFormWindow(new ExplorerForm(null, manager))
        }
        return true
    }
}
