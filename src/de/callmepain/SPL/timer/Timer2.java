package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class Timer2 implements Runnable {
	SPL plugin;
	public Timer2(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.Util.fill(plugin.SPL_Spawn.get("Spawn1").getWorld(), 41);
			plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chattext + "2");
			plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chattext + "2");
		}
	}
}
