package me.imf4ll.sweetkombat

import me.imf4ll.sweetkombat.listeners.EventsListener
import org.bukkit.plugin.java.JavaPlugin

class SweetKombat : JavaPlugin() {
  override fun onEnable() {
    saveDefaultConfig();

    server.pluginManager.registerEvents(EventsListener(this, config), this);

    logger.info("Events successful registered.");
  }

  override fun onDisable() {
    logger.info("Goodbye.");

  }
}