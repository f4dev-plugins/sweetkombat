package me.imf4ll.sweetkombat

import me.imf4ll.sweetkombat.commands.AttackSpeed
import me.imf4ll.sweetkombat.commands.Enable
import me.imf4ll.sweetkombat.listeners.EventsListener
import me.imf4ll.sweetkombat.utils.Localization
import org.bukkit.plugin.java.JavaPlugin

class SweetKombat : JavaPlugin() {
  override fun onEnable() {
    Localization.init(this);
    saveDefaultConfig();

    // Listeners
    server.pluginManager.registerEvents(EventsListener(this, config), this);

    // Commands
    getCommand("sk.enable")?.setExecutor(Enable(this));
    getCommand("sk.attackspeed")?.setExecutor(AttackSpeed(this));

    logger.info("Events successful registered.");
  }

  override fun onDisable() {
    logger.info("Goodbye.");

  }
}