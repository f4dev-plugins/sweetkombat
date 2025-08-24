package me.imf4ll.sweetkombat.utils

import org.bukkit.configuration.Configuration

object Locale {
  fun t(config: Configuration, value: String): String {
    val language = config.getString("language");

    val pt: Map<String, String> = mapOf(
      "invalidvalue" to "Valor inválido",
      "attackvalue" to "Valor do 'attack-speed' setado para",
      "enable" to "ativado",
      "disable" to "desatiado",
    );

    val en: Map<String, String> = mapOf(
      "invalidvalue" to "Invalid value",
      "attackvalue" to "'attack-speed' value set to",
      "enable" to "enabled",
      "disable" to "disabled",
    );

    return when (language) {
      "pt" -> pt.getValue(value);
      else -> en.getValue(value);
    }
  }
}