package me.imf4ll.sweetkombat.utils

import org.bukkit.attribute.Attribute
import org.bukkit.entity.Player

class Utils {
  fun setAttackSpeed(player: Player, value: Double) {
    val attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);

    if (attribute != null) attribute.baseValue = value;
  }
}