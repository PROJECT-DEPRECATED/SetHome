package org.projecttl.plugin.sethome

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class SetHome(private val plugin: SetHomePlugin): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            when (command.name) {
                "sethome" -> {
                    val world = sender.world.name
                    val x = sender.location.x
                    val y = sender.location.y
                    val z = sender.location.z

                    plugin.setHomeConfig().set("sethome.${sender.name}.world", world)
                    plugin.setHomeConfig().set("sethome.${sender.name}.x", x)
                    plugin.setHomeConfig().set("sethome.${sender.name}.y", y)
                    plugin.setHomeConfig().set("sethome.${sender.name}.z", z)

                    sender.sendMessage("SetHome> ${ChatColor.GREEN}Complete setting home.")

                    return true
                }
            }
        }

        return false
    }
}