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
			plugin.getServer().getScheduler().cancelTask(plugin.taskid3);
			plugin.getServer().getScheduler().cancelTask(plugin.taskidfight);
			plugin.getServer().getScheduler().cancelTask(plugin.taskidstart);
			plugin.getServer().getScheduler().cancelTask(plugin.taskidclose);
		}
		else {
			plugin.Util.SPLGateChange(false);
		}
	}
}
