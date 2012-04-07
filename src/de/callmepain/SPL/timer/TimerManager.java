package de.callmepain.SPL.timer;

import de.callmepain.SPL.SPL;

public class TimerManager {
	public int taskId1 = 0;
	public int taskId2 = 0;
	public int taskid3 = 0;
	public int taskidfight = 0;
	public int taskidstart = 0;
	public int taskidclose = 0;
	public int taskidleave = 0;
	public int taskidplayeringame = 0;
	
	public Timer1 T1;
	public Timer2 T2;
	public Timer3 T3;
	public TimerFight TFight;
	public TimerStart TStart;
	public TimerClose TClose;
	public TimerLeave TLeave;
	public TimerPlayeringame TPig;
	public TimerManager(SPL istance) {
		T1 = new Timer1(istance);
		T2 = new Timer2(istance);
		T3 = new Timer3(istance);
		TFight = new TimerFight(istance);
		TStart = new TimerStart(istance);
		TClose = new TimerClose(istance);
		TPig = new TimerPlayeringame(istance);
		TLeave = new TimerLeave(istance);
	}
}
