package de.callmepain.SPL;

import org.bukkit.ChatColor;

public class SPL4PlayerStart {
	SPL plugin;
	public SPL4PlayerStart(SPL instance) {
		plugin = instance;
	
		plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1())) + "]" 
		+ plugin.Chattext + " vs. " + plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2())) + "]"
		+ plugin.Chattext + " vs. " + plugin.Chatplayer + plugin.SPL_Player.getPlayer3().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer3())) + "]"
		+ plugin.Chattext + " vs. " + plugin.Chatplayer + plugin.SPL_Player.getPlayer4().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer4())) + "]");
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidplayeringame);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidleave);
		plugin.SPL_Timer.taskId1 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T3, 40L);
		plugin.SPL_Timer.taskId2 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T2, 60L);
		plugin.SPL_Timer.taskid3 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T1, 80L);
		plugin.SPL_Timer.taskidfight = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TFight, 95L);
		plugin.SPL_Timer.taskidstart = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TStart4p, 100L);
		plugin.SPL_Timer.taskidclose = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TClose4p, 200L);
		plugin.SPL_State.put("running", true);
	}
}
