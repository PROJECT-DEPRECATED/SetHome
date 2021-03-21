package org.projecttl.plugin.sethome

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player

class Home(private val plugin: SetHomePlugin): CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender is Player) {
            when (command.name) {
                "home" -> {
                    val world: World? = Bukkit.getWorld(plugin.setHomeConfig().getString("sethome.${sender.name}.world").toString())
                    val x: Double = plugin.setHomeConfig().getDouble("sethome.${sender.name}.x")
                    val y: Double = plugin.setHomeConfig().getDouble("sethome.${sender.name}.y")
                    val z: Double = plugin.setHomeConfig().getDouble("sethome.${sender.name}.z")

                    val location = Location(world, x, y, z)

                    sender.teleport(location)
                    sender.sendMessage("SetHome> ${ChatColor.GREEN}You move to home!")

                    return true
                }
            }
        }

        return false
    }
}