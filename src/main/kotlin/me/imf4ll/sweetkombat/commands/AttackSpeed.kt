package me.imf4ll.sweetkombat.commands

import me.imf4ll.sweetkombat.utils.Locale
import me.imf4ll.sweetkombat.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.Plugin

class AttackSpeed(val pl: Plugin) : CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String?>): Boolean {
    if (!sender.hasPermission("sweetkombat.op") || !sender.isOp) return true;

    if (args.isEmpty()) {
      sender.sendMessage("§c${ Locale.t(pl.config, "invalidvalue") }.§r");

      return true;
    }

    val newValue = args[0]?.toDoubleOrNull();

    if (newValue == null) {
      sender.sendMessage("§c${ Locale.t(pl.config, "invalidvalue") }: $newValue.§r");

      return true;
    }

    pl.config.set("attack-speed", newValue);
    pl.saveConfig();

    sender.sendMessage("§a${ Locale.t(pl.config, "attackvalue") } §e$newValue.§r");

    pl.server.onlinePlayers.forEach { Utils().setAttackSpeed(it, newValue) };

    return true;
  }
}