package de.callmepain.SPL;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class SPLLeaveJoinListener implements Listener{
	SPL plugin;
	public SPLLeaveJoinListener(SPL instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerLeave(PlayerQuitEvent event) {
		if (plugin.SPL_State.get("game")) {
			if (plugin.SPL_Player.get("1") != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.get("1").getName()) {
					plugin.Util.SPL_End();
					plugin.SPL_Player.put("quite", event.getPlayer());
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + plugin.Chattext + "hat das Spiel verlassen und somit verloren...");
					if (plugin.SPL_Player.get("2") != null) {
						plugin.SPL_Player.get("2").teleport(plugin.SPL_Spawn.get("Despawn1"));
					}
 					plugin.Util.fill(event.getPlayer().getWorld(), 79);
 					plugin.SPL_Player.put("1", null);
 					plugin.SPL_Player.put("2", null);
 					plugin.getServer().getScheduler().cancelTask(plugin.taskId7);
 				}
 			}
			else if (plugin.SPL_Player.get("2") != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.get("2").getName()) {
					plugin.Util.SPL_End();
					plugin.SPL_Player.put("quite", event.getPlayer());
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("2").getName() + plugin.Chattext + "hat das Spiel verlassen und somit verloren...");
					plugin.SPL_Player.get("1").teleport(plugin.SPL_Spawn.get("Despawn1"));
					if (plugin.SPL_Player.get("1") != null) {
						plugin.SPL_Player.get("1").teleport(plugin.SPL_Spawn.get("Despawn2"));
					}
					plugin.Util.fill(event.getPlayer().getWorld(), 79);
					plugin.SPL_Player.put("1", null);
					plugin.SPL_Player.put("2", null);
					plugin.getServer().getScheduler().cancelTask(plugin.taskId7);
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerJoin(PlayerJoinEvent event) {
		if (plugin.SPL_Player.get("quite") != null) {
			if (event.getPlayer().getName() == plugin.SPL_Player.get("quite").getName()) {
				event.getPlayer().teleport(plugin.SPL_Spawn.get("Despawn1"));
				event.getPlayer().sendMessage(plugin.Chaterr + "du hast dich werden eines laufenden Spleef Spieles ausgelogt und hast somit verloren!");
				plugin.SPL_Player.put("quite", null);
			}
		}
	}
}
