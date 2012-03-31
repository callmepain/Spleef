package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerFight implements Runnable{
	SPL plugin;
	public TimerFight(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.Util.fill(plugin.SPL_Spawn.get("Spawn1").getWorld(), plugin.SPL_Bgid);
			plugin.SPL_Player.get("1").sendMessage(plugin.Chattext + "Fight!!!");
			plugin.SPL_Player.get("2").sendMessage(plugin.Chattext + "Fight!!!");
		}
	}
}
