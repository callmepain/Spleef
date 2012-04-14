package de.callmepain.SPL.Listener;

import de.callmepain.SPL.SPL;

public class SPLListenerManager {
	public SPLPlayerMoveListener PlayerMoveListener;
	public SPLBlockListener BlockListener;
	public SPLPlayerInteractListener PlayerInteractListener;
	public SPLLeaveListener LeaveListener;
	public SPLJoinListener JoinListener;
	public SPLBlockDamage BlockDamage;
	public SPLBlockExplode BlockExplode;
	
	public SPLListenerManager(SPL Instance) {
		Instance.getServer().getPluginManager().registerEvents(PlayerMoveListener, Instance);
		Instance.getServer().getPluginManager().registerEvents(BlockListener, Instance);
		Instance.getServer().getPluginManager().registerEvents(PlayerInteractListener, Instance);
		Instance.getServer().getPluginManager().registerEvents(LeaveListener, Instance);
		Instance.getServer().getPluginManager().registerEvents(JoinListener, Instance);
		Instance.getServer().getPluginManager().registerEvents(BlockDamage, Instance);
		Instance.getServer().getPluginManager().registerEvents(BlockExplode, Instance);
	}
}
