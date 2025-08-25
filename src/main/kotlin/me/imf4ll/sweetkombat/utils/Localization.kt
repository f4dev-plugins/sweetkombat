package me.imf4ll.sweetkombat.utils

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

sealed class Locale(val key: String) {
  data object InvalidValue: Locale("invalid-value");
  data object AttackValue: Locale("attack-value");
  data object Enable: Locale("enable");
  data object Disable: Locale("disable");
}

object Localization {
  private lateinit var plugin: JavaPlugin;
  private lateinit var locale: FileConfiguration;
  private var language: String = "en";

  fun init(pl: JavaPlugin) {
    plugin = pl;

    val file = File(pl.dataFolder, "locale.yml");

    if (!file.exists()) pl.saveResource("locale.yml", false);

    locale = YamlConfiguration.loadConfiguration(file);
    language = pl.config.getString("language") ?: "en";
  }

  fun get(key: Locale): String =
    locale.getString("$language.${key.key}") ?: "An error has occurred while getting localization.";
}