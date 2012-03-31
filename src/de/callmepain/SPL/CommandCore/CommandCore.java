package de.callmepain.SPL.CommandCore;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.callmepain.SPL.SPL;

public class CommandCore implements CommandExecutor{
	SPL plugin;
	public CommandCore(SPL instance) {
		plugin = instance;
	}
	private basic bsc = new basic();
	private join jn = new join(plugin);
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			return bsc.welcome(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("join")) {
			return jn.SPLJoin(sender, cmd, label, args);
		}
		return false;
	}
}
