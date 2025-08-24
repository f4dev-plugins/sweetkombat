package me.imf4ll.sweetkombat.listeners

import me.imf4ll.sweetkombat.utils.Utils
import org.bukkit.Bukkit
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerRespawnEvent
import org.bukkit.plugin.java.JavaPlugin

class EventsListener(private val plugin: JavaPlugin, private val config: FileConfiguration) : Listener {
  @EventHandler
  fun onEntityDamage(event: EntityDamageByEntityEvent) {
    if (!config.getBoolean("enable-sweep")) return;

    val damager = event.damager;
    val damage = event.damage;

    if (damager is Player) {
      if (event.cause == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
        event.isCancelled = true;
        event.damage = 0.0;

      } else if (event.cause == EntityDamageEvent.DamageCause.ENTITY_ATTACK) event.damage = damage;
    }
  }

  @EventHandler
  fun onPlayerJoin(event: PlayerJoinEvent) {
    if (!config.getBoolean("enable-sweep")) return;

    Utils().setAttackSpeed(event.player, config.getDouble("attack-speed"));
  }

  @EventHandler
  fun onRespawn(event: PlayerRespawnEvent) {
    if (!config.getBoolean("enable-sweep")) return;

    Bukkit.getScheduler().runTaskLater(plugin, Runnable { Utils().setAttackSpeed(event.player, config.getDouble("attack-speed")) }, 1L);
  }
}