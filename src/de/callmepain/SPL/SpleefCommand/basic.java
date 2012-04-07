package de.callmepain.SPL.SpleefCommand;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class basic {
	public boolean TMArgument(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.RED + "Zu viele Argumente");
		return true;
	}
	public boolean NEArgument(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.RED + "Zu wenig Argumente");
		return true;
	}
}
