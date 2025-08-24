package me.imf4ll.sweetkombat.commands

import me.imf4ll.sweetkombat.utils.Locale
import me.imf4ll.sweetkombat.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

class Enable(private val pl: Plugin): CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String?>): Boolean {
    if (!sender.hasPermission("sweetkombat:op") || !sender.isOp) return true;

    val newConfig = !pl.config.getBoolean("enable-sweep");
    pl.config.set("enable-sweep", newConfig);
    pl.saveConfig();

    sender.sendMessage("§eSweet Kombat: ${ if (newConfig) "§a${ Locale.t(pl.config, "enable") }" else "§c${ Locale.t(pl.config, "disable") }" }.§r");

    pl.server.onlinePlayers.forEach {
      Utils().setAttackSpeed(it, if (newConfig) pl.config.getDouble("attack-speed") else 4.0);

    }

    return true;
  }
}