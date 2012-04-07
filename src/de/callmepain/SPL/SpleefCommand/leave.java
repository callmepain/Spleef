package de.callmepain.SPL.SpleefCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;

public class leave {
	SPL plugin;
	public leave(SPL instance) {
		plugin = instance;
	}
	public boolean SPLLeave(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		if (!player.hasPermission("spl.join")) {
			player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
			return true;
		}
		else {
			if ((plugin.SPL_State.get("game")) || (plugin.SPL_State.get("running"))) {
				if ((player == plugin.SPL_Player.getPlayer1()) || (player == plugin.SPL_Player.getPlayer2())) {
					plugin.Util.SPL_End();
					plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn1"));
					if (plugin.SPL_Player.getPlayer2() != null) {
						plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn2"));
					}
					plugin.Util.SPLBroadcast(plugin.Chatplayer + player.getName() + plugin.Chattext + " hat die Arena verlassen...");
					plugin.Util.SPLGateChange(true);
					plugin.getServer().getScheduler().cancelTask(plugin.taskidplayeringame);
					plugin.SPL_Player.reset(plugin);
					return true;
				}
			}
		}
		return true;
	}
}
