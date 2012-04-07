package de.callmepain.SPL.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import de.callmepain.SPL.SPL;

public class SPLJoinListener implements Listener {
	SPL plugin;
	public SPLJoinListener(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerJoin(PlayerJoinEvent event) {
		if (plugin.SPL_Player.SPL_Quite.get(event.getPlayer().getName()) == null) {
			plugin.SPL_Player.setPlayerQuite(event.getPlayer(), false);
		}
		if (plugin.SPL_Player.getPlayerQuite(event.getPlayer())) {
			event.getPlayer().teleport(plugin.SPL_Spawn.get("Despawn1"));
			event.getPlayer().sendMessage(plugin.Chaterr + "du hast dich werden eines laufenden Spleef Spieles ausgelogt und hast somit verloren!");
			plugin.SPL_Player.setPlayerQuite(event.getPlayer(), false);
		}
	}
}
