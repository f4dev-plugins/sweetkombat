package me.imf4ll.sweetkombat.commands

import me.imf4ll.sweetkombat.utils.Locale
import me.imf4ll.sweetkombat.utils.Localization
import me.imf4ll.sweetkombat.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class Enable(private val pl: JavaPlugin): CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String?>): Boolean {
    if (!sender.hasPermission("sweetkombat:op") || !sender.isOp) return true;

    val newConfig = !pl.config.getBoolean("enable-sweep");
    pl.config.set("enable-sweep", newConfig);
    pl.saveConfig();

    sender.sendMessage(if (newConfig) Localization.get(Locale.Enable) else Localization.get(Locale.Disable));

    pl.server.onlinePlayers.forEach {
      Utils().setAttackSpeed(it, if (newConfig) pl.config.getDouble("attack-speed") else 4.0);

    }

    return true;
  }
}