package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerPlayeringame implements Runnable{
		SPL plugin;
		public TimerPlayeringame(SPL instance) {
			plugin = instance;
		}
		@Override
		public void run() {
			plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + " Wartet noch immer auf einen Gegner!");
		}
}
