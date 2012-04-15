package de.callmepain.SPL.SpleefCommand;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;
import de.callmepain.SPL.SPLUtil;

public class join4p {
	SPL plugin;
	public join4p(SPL instance) {
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
		if(!plugin.SPL_State.get("player1")) {
			plugin.Util.SPL_ModeChange();
			SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
			SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
			plugin.Util.SPLGateChange(true);
			plugin.SPL_Player.setPlayer1(player);
			player.teleport(plugin.SPL_Spawn.get("Spawn1"));
			plugin.Util.SPLBroadcast(plugin.Chatplayer + player.getName() + plugin.Chattext + " hat die " + plugin.Chatitem + "Spleef Arena v." +  plugin.getDescription().getVersion() + plugin.Chatitem + " 4 player's" + plugin.Chattext + " betreten ");
			plugin.SPL_Timer.taskidleave = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.SPL_Timer.TLeave, 600L);
			plugin.SPL_Timer.taskidplayeringame = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, plugin.SPL_Timer.TPig, 1200L, 1200L);
			plugin.SPL_State.put("player1", true);
			plugin.SPL_State.put("4players", true);
			return true;
		}
		else if ((!plugin.SPL_State.get("player2")) && (plugin.SPL_State.get("player1"))) {
/*			if (plugin.SPL_Player.getPlayer1().getName() == player.getName()) {
				player.sendMessage(plugin.Chattext + "Du kannst nicht gegen dich selber antreten...");
			}
			else {*/
				plugin.SPL_Player.setPlayer2(player);
				player.teleport(plugin.SPL_Spawn.get("Spawn2"));
				
				return true;
//			}
		}
		else if ((!plugin.SPL_State.get("player3")) && (plugin.SPL_State.get("player2")) && (plugin.SPL_State.get("player1"))) {
			plugin.SPL_Player.setPlayer3(player);
			player.teleport(plugin.SPL_Spawn.get("Spawn3"));
			plugin.SPL_State.put("player3", true);
			
			return true;
		}
		else if ((!plugin.SPL_State.get("player4")) && (plugin.SPL_State.get("player3")) && (plugin.SPL_State.get("player2")) && (plugin.SPL_State.get("player1"))) {
			plugin.SPL_Player.setPlayer4(player);
			player.teleport(plugin.SPL_Spawn.get("Spawn4"));
			plugin.SPL_State.put("player4", true);
			
			return true;
		}
		else {
			player.sendMessage(plugin.Chaterr + "Spiel bereit's im gange");
			
			return true;
		}
	}
}
