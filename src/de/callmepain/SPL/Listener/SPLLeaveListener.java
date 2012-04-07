package de.callmepain.SPL.Listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import de.callmepain.SPL.SPL;

public class SPLLeaveListener implements Listener{
	SPL plugin;
	public SPLLeaveListener(SPL instance) {
		plugin = instance;
	}
	
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerLeave(PlayerQuitEvent event) {
		if (plugin.SPL_State.get("game")) {
			if (plugin.SPL_Player.getPlayer1() != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer1().getName()) {
					plugin.Util.SPL_End();
					plugin.SPL_Player.setPlayerQuite(event.getPlayer(), true);
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + "hat das Spiel verlassen und somit verloren...");
					if (plugin.SPL_Player.getPlayer2() != null) {
						plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn1"));
					}
 					plugin.Util.fill(event.getPlayer().getWorld(), 79);
 					plugin.SPL_Player.setPlayerQuite(event.getPlayer(), true);
 					plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidplayeringame);
 				}
 			}
			if (plugin.SPL_Player.getPlayer2() != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer2().getName()) {
					plugin.Util.SPL_End();
					plugin.SPL_Player.setPlayerQuite(event.getPlayer(), true);
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + plugin.Chattext + "hat das Spiel verlassen und somit verloren...");
					if (plugin.SPL_Player.getPlayer1() != null) {
						plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn2"));
					}
					plugin.Util.fill(event.getPlayer().getWorld(), 79);
					plugin.SPL_Player.setPlayerQuite(event.getPlayer(), true);
					plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidplayeringame);
				}
			}
		}
	}
}
