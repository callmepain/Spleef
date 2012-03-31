package de.callmepain.SPL;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

public class SPLSign implements Listener {
	SPL plugin;
	public SPLSign(SPL instance) {
		plugin = instance;
	}
	
	@EventHandler
	public void SignChange(SignChangeEvent event) {
		if (event.getLine(0).equals("[Spleef]")) {
			event.setLine(0, ChatColor.DARK_GREEN + "[Join]");
			event.getPlayer().sendMessage(plugin.Chattext + "Sign erfolgreich gesetzt");
		}
		else if (event.getLine(0).equals("[PL 1]")) {
			event.setLine(0, ChatColor.DARK_GREEN + "[Spleef]");
			event.getPlayer().sendMessage(plugin.Chattext + "Sign erfolgreich gesetzt");
		}
	}
}
