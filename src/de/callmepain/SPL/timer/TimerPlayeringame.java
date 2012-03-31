package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerPlayeringame implements Runnable{
		SPL plugin;
		public TimerPlayeringame(SPL instance) {
			plugin = instance;
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + plugin.Chattext + "Wartet noch immer auf einen Gegner!");
		}
}
