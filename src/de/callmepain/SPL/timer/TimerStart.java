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
			plugin.Util.SPLTimerReset();
		}
		else {
			plugin.Util.SPLGateChange(false);
		}
	}
}
