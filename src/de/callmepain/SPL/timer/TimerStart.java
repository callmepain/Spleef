package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerStart implements Runnable {
	SPL plugin;
	public TimerStart(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.getServer().getScheduler().cancelTask(plugin.taskId1);
			plugin.getServer().getScheduler().cancelTask(plugin.taskId2);
			plugin.getServer().getScheduler().cancelTask(plugin.taskId3);
			plugin.getServer().getScheduler().cancelTask(plugin.taskId4);
			plugin.getServer().getScheduler().cancelTask(plugin.taskId5);
			plugin.getServer().getScheduler().cancelTask(plugin.taskId6);
		}
		else {
			plugin.SPL_Block.put("11", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc1")));
			plugin.SPL_Block.get("11").setTypeId(0);
			plugin.SPL_Block.put("12", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc2")));
			plugin.SPL_Block.get("12").setTypeId(0);
			
			plugin.SPL_Block.put("21", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc1")));
			plugin.SPL_Block.get("21").setTypeId(0);
			plugin.SPL_Block.put("22", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc2")));
			plugin.SPL_Block.get("22").setTypeId(0);
		}
	}
}
