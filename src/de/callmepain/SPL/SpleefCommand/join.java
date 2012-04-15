package de.callmepain.SPL.SpleefCommand;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;
import de.callmepain.SPL.SPLUtil;

public class join {
	SPL plugin;
	public join(SPL instance) {
		plugin = instance;
	}
	public boolean SPLJoin(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("spl.join")) {
			player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
			return true;
		}
		if (player.isOp()) {
			player.sendMessage(plugin.Chattext + "als OP darfst du nicht teilnehmen weil du mir immer versehentlich die arena zerstörst!");
			return true;
		}
		if (player.getGameMode() == GameMode.CREATIVE) {
			player.sendMessage(plugin.Chattext + "im Creative modus darfst du nicht teilnehmen!");
			return true;
		}
		if((!plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("4players"))) {
			plugin.Util.SPL_ModeChange();
			SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
			SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
			plugin.Util.SPLGateChange(true);
			plugin.SPL_Player.setPlayer1(player);
			player.teleport(plugin.SPL_Spawn.get("Spawn1"));
			plugin.Util.SPLBroadcast(plugin.Chatplayer + player.getName() + plugin.Chattext + " hat die " + plugin.Chatitem + "Spleef Arena v." +  plugin.getDescription().getVersion() + plugin.Chattext + " betreten ");
			plugin.SPL_Timer.taskidleave = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TLeave, 600L);
			plugin.SPL_Timer.taskidplayeringame = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, plugin.SPL_Timer.TPig, 1200L, 1200L);
			plugin.SPL_State.put("game", true);
			return true;
		}
		else if ((plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("running")) && (!plugin.SPL_State.get("4players"))) {
			if (plugin.SPL_Player.getPlayer1().getName() == player.getName()) {
				player.sendMessage(plugin.Chattext + "Du kannst nicht gegen dich selber antreten...");
			}
			else {
				plugin.SPL_Player.setPlayer2(player);
				player.teleport(plugin.SPL_Spawn.get("Spawn2"));
				plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1())) + "]" + plugin.Chattext + " vs. " + plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2())) + "]");
				plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidplayeringame);
				plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidleave);
				plugin.SPL_Timer.taskId1 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T3, 40L);
				plugin.SPL_Timer.taskId2 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T2, 60L);
				plugin.SPL_Timer.taskid3 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.T1, 80L);
				plugin.SPL_Timer.taskidfight = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TFight, 95L);
				plugin.SPL_Timer.taskidstart = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TStart, 100L);
				plugin.SPL_Timer.taskidclose = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TClose, 200L);
				plugin.SPL_State.put("running", true);
				return true;
			}
		}
		return true;
	}
}
