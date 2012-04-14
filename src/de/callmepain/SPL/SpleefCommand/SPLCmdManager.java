package de.callmepain.SPL.SpleefCommand;

import de.callmepain.SPL.SPL;

public class SPLCmdManager {
	public join SPL_Join;
	public leave SPL_Leave;
	public reload SPL_Reload;
	private SpleefCommand splcmd;
	
	public SPLCmdManager(SPL instance) {
		SPL_Reload = new reload(instance);
		SPL_Leave = new leave(instance);
		SPL_Join = new join(instance);
		splcmd = new SpleefCommand(instance);
		instance.getCommand("Spleef").setExecutor(splcmd);
	}
}
