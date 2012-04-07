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
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			return bsc.welcome(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("join")) {
			return plugin.SPL_Join.SPLJoin(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("leave")) {
			return plugin.SPL_Leave.SPLLeave(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("reload")) {
			return plugin.SPL_Reload.SPLReload(sender, cmd, label, args);
		}
		return false;
	}
}
