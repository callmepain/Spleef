package de.callmepain.SPL.timer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;
import de.callmepain.SPL.SPLUtil;

public class TimerClose implements Runnable {
	SPL plugin;
	public TimerClose(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.Util.SPLExplosion(plugin.SPL_Spawn.get("Spawn1").getWorld());
			plugin.SPL_Block.put("11", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc1")));
			plugin.SPL_Block.get("11").setTypeId(101);
			plugin.SPL_Block.put("12", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc2")));
			plugin.SPL_Block.get("12").setTypeId(101);
			
			plugin.SPL_Block.put("21", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc1")));
			plugin.SPL_Block.get("21").setTypeId(101);
			plugin.SPL_Block.put("22", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc2")));
			plugin.SPL_Block.get("22").setTypeId(101);
			SPLUtil.fillgate(plugin.SPL_Spawn.get("Spawn1").getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 57, 101);
			SPLUtil.fillgate(plugin.SPL_Spawn.get("Spawn1").getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 57, 101);
			plugin.SPL_State.put("closed", true);
			Player p1 =  Bukkit.getPlayer(plugin.SPL_Player.getPlayer1().getName());
			Player p2 =  Bukkit.getPlayer(plugin.SPL_Player.getPlayer2().getName());
			if (plugin.SPL_State.get("closed")) {
				if (SPLUtil.checkCuboid(p1.getLocation(),plugin.SPL_SpawnRoom.get("SpawnRoom1loc1"),plugin.SPL_SpawnRoom.get("SpawnRoom1loc2"))) {
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + " ist nicht angetreten und hat verloren...");
					plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn1"));
					plugin.Util.SPL_End();
					plugin.Util.fill(plugin.SPL_Spawn.get("Spawn1").getWorld(), plugin.SPL_Bgendid);
					return;
				}
				if (SPLUtil.checkCuboid(p2.getLocation(),plugin.SPL_SpawnRoom.get("SpawnRoom2loc1"),plugin.SPL_SpawnRoom.get("SpawnRoom2loc2"))) {
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + plugin.Chattext + " ist nicht angetreten und hat verloren...");
					plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn1"));
					plugin.Util.SPL_End();
					plugin.Util.fill(plugin.SPL_Spawn.get("Spawn1").getWorld(), plugin.SPL_Bgendid);
					return;
				}
				
			}
		}
	}
}
