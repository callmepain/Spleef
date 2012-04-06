package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerLeave implements Runnable{
	SPL plugin;
	public TimerLeave(SPL instance) {
		plugin = instance;
	}
	@Override
	public void run() {
		if (!plugin.SPL_State.get("game")) {
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chattext + "sollte sich kein Gegner finden gib " + plugin.Chatitem + "/spl leave" + plugin.Chattext + " ein");
		}
	}
}
