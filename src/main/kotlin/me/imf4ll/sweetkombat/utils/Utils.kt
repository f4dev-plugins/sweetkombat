package me.imf4ll.sweetkombat.utils

import org.bukkit.attribute.Attribute
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player

class Utils {
  fun setAttackSpeed(player: Player, config: FileConfiguration) {
    val attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);

    if (attribute != null) attribute.baseValue = config.getDouble("attack-speed");
  }
}