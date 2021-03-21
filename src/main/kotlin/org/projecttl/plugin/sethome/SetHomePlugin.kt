package org.projecttl.plugin.sethome

import org.bukkit.Bukkit
import org.bukkit.Location
import org.bukkit.World
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class SetHomePlugin: JavaPlugin() {

    private var configFile: File? = null
    private var configuration: FileConfiguration? = null

    override fun onEnable() {
        load()
        logger.info("Enable")

        getCommand("home")?.setExecutor(Home(this))
        getCommand("sethome")?.setExecutor(SetHome(this))
    }

    override fun onDisable() {
        save()
        logger.info("Disable")
    }

    private fun load() {
        configFile = File(dataFolder, "config.yml").also {
            if (!it.exists()) {
                configuration?.save(it)
            }

            configuration?.load(it)
        }

        configuration = YamlConfiguration.loadConfiguration(configFile!!)
    }

    private fun save() {
        configuration?.save(configFile!!)
    }

    fun setHomeConfig(): FileConfiguration {
        return configuration!!
    }
}