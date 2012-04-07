package de.callmepain.SPL.CommandCore;

import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.callmepain.SPL.SPL;

public class reload {
	SPL plugin;
	
	public reload(SPL instance) {
		plugin = instance;
	}
	public boolean SPLReload(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = (Player) sender;
		final World w = player.getWorld();
		if (!player.hasPermission("spl.admin")) {
			player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
			return true;
		}
		plugin.Util.SPL_End();
		plugin.Util.fill(w, plugin.SPL_Bgendid);
		plugin.Util.SPLGateChange(true);
		plugin.Config.LoadConfig();
		player.sendMessage(plugin.Chattext + "reload complete");
		return true;
	}
}
