package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class Timer3 implements Runnable{
	SPL plugin;
	public Timer3(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.Util.fill(plugin.SPL_Spawn.get("Spawn1").getWorld(), 57);
			plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chattext + "3");
			plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chattext + "3");
		}
	}

}
