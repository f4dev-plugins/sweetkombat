package me.imf4ll.sweetkombat.commands

import me.imf4ll.sweetkombat.utils.Locale
import me.imf4ll.sweetkombat.utils.Localization
import me.imf4ll.sweetkombat.utils.Utils
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.plugin.java.JavaPlugin

class AttackSpeed(private val pl: JavaPlugin) : CommandExecutor {
  override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String?>): Boolean {
    if (!sender.hasPermission("sweetkombat.op") || !sender.isOp) return true;

    if (args.isEmpty()) {
      sender.sendMessage(Localization.get(Locale.InvalidValue));

      return true;
    }

    val newValue = args[0]?.toDoubleOrNull();

    if (newValue == null) {
      sender.sendMessage("${ Localization.get(Locale.InvalidValue) }: $newValue.§r");

      return true;
    }

    pl.config.set("attack-speed", newValue);
    pl.saveConfig();

    sender.sendMessage("${ Localization.get(Locale.AttackValue) } §e$newValue.§r");

    pl.server.onlinePlayers.forEach { Utils().setAttackSpeed(it, newValue) };

    return true;
  }
}