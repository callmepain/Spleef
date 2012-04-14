package de.callmepain.SPL.SpleefCommand;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.callmepain.SPL.SPL;

public class SpleefCommand implements CommandExecutor{
	SPL plugin;
	public SpleefCommand(SPL instance) {
		plugin = instance;
	}
	private basic bsc = new basic();
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length > 1) {
			return bsc.TMArgument(sender, cmd, label, args);
		}
		else if (args.length < 1) {
			return bsc.NEArgument(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("join")) {
			return plugin.SPL_CmdManager.SPL_Join.SPLJoin(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("leave")) {
			return plugin.SPL_CmdManager.SPL_Leave.SPLLeave(sender, cmd, label, args);
		}
		else if (args[0].equalsIgnoreCase("reload")) {
			return plugin.SPL_CmdManager.SPL_Reload.SPLReload(sender, cmd, label, args);
		}
		return false;
	}
}
