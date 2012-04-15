package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerStart4p implements Runnable {
	SPL plugin;
	public TimerStart4p(SPL instance) {
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