package de.callmepain.SPL.SpleefCommand;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;

public class accept4p {
	SPL plugin;
	public accept4p(SPL instance) {
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
		if ((plugin.SPL_Player.getPlayer1().getName() == player.getName()) && (!plugin.SPL_State.get("p1rdy"))) {
			plugin.SPL_State.put("p1rdy", true);
			player.sendMessage(plugin.Chattext + "Du wurdest als bereit makiert!");
			return true;
		}
		else if ((plugin.SPL_Player.getPlayer2().getName() == player.getName()) && (!plugin.SPL_State.get("p2rdy"))) {
			plugin.SPL_State.put("p2rdy", true);
			player.sendMessage(plugin.Chattext + "Du wurdest als bereit makiert!");
			return true;
		}
		else if ((plugin.SPL_Player.getPlayer3().getName() == player.getName()) && (!plugin.SPL_State.get("p3rdy"))) {
			plugin.SPL_State.put("p3rdy", true);
			player.sendMessage(plugin.Chattext + "Du wurdest als bereit makiert!");
			return true;
		}
		else if ((plugin.SPL_Player.getPlayer4().getName() == player.getName()) && (!plugin.SPL_State.get("p4rdy"))) {
			plugin.SPL_State.put("p4rdy", true);
			player.sendMessage(plugin.Chattext + "Du wurdest als bereit makiert!");
			return true;
		}
		else {
			player.sendMessage(plugin.Chaterr + "du bist als bereit makiert oder nimmst nicht teil!");
		}
		return true;
	}
}
