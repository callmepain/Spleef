package de.callmepain.SPL.CommandCore;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class basic {
	public boolean welcome(CommandSender sender, Command cmd, String label, String[] args) {
		sender.sendMessage(ChatColor.AQUA + "Welcome");
		return true;
	}
}
