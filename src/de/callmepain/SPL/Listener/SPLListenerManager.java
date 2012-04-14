package de.callmepain.SPL.Listener;

import org.bukkit.Bukkit;

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
		PlayerMoveListener = new SPLPlayerMoveListener(Instance);
		BlockListener = new SPLBlockListener(Instance);
		PlayerInteractListener = new SPLPlayerInteractListener(Instance);
		LeaveListener = new SPLLeaveListener(Instance);
		JoinListener = new SPLJoinListener(Instance);
		BlockDamage = new SPLBlockDamage(Instance);
		BlockExplode = new SPLBlockExplode(Instance);
		Bukkit.getServer().getPluginManager().registerEvents(PlayerMoveListener, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(BlockListener, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(PlayerInteractListener, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(LeaveListener, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(JoinListener, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(BlockDamage, Instance);
		Bukkit.getServer().getPluginManager().registerEvents(BlockExplode, Instance);
	}
}
