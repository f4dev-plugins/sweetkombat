package me.imf4ll.sweetkombat.listeners

import org.bukkit.Bukkit
import org.bukkit.attribute.Attribute
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.plugin.java.JavaPlugin

class EventsListener(private val plugin: JavaPlugin, private val config: FileConfiguration) : Listener {
  @EventHandler
  fun onPlayerJoin(event: PlayerJoinEvent) {
    val player = event.player;
    val attribute = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);

    if (attribute != null) {
      attribute.baseValue = config.getDouble("attack-speed");

    }
  }

  @EventHandler
  fun onEntityDamage(event: EntityDamageByEntityEvent) {
    if (event.damager is Player && !config.getBoolean("enable-sweep")) {
      if (event.cause == EntityDamageEvent.DamageCause.ENTITY_SWEEP_ATTACK) {
        event.damage = 0.0;
        event.isCancelled = true;

        Bukkit.getScheduler().runTaskLater(plugin, Runnable {
          event.entity.velocity = org.bukkit.util.Vector(0, 0, 0) }, 1L);
      }

      event.isCancelled = false;
    }
  }
}