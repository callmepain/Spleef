package de.callmepain.SPL.Listener;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import de.callmepain.SPL.SPL;

public class SPLPlayerInteractListener implements Listener {
	SPL plugin;
	public SPLPlayerInteractListener(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerInteract(PlayerInteractEvent event) {
		if ((event.getAction() == Action.LEFT_CLICK_BLOCK) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
			if (event.getPlayer().getItemInHand().getTypeId() == Material.getMaterial(plugin.SPL_SelTool).getId()) {
				if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
					plugin.SPL_Sel.put("Sel1", event.getClickedBlock().getLocation());
					event.getPlayer().sendMessage(ChatColor.GREEN + "Ausgewählter Primär Punkt: " + ChatColor.DARK_PURPLE + event.getClickedBlock().getLocation().getBlockX() + "," + event.getClickedBlock().getLocation().getBlockY() + "," + event.getClickedBlock().getLocation().getBlockZ());
					return;
				}
				else if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
					plugin.SPL_Sel.put("Sel2", event.getClickedBlock().getLocation());
					event.getPlayer().sendMessage(ChatColor.GREEN + "Ausgewählter Sekundär Punkt: " + ChatColor.DARK_PURPLE + event.getClickedBlock().getLocation().getBlockX() + "," + event.getClickedBlock().getLocation().getBlockY() + "," + event.getClickedBlock().getLocation().getBlockZ());
					return;
				}
			}
		}
		if (event.getAction() == Action.LEFT_CLICK_BLOCK) {
			if (event.getClickedBlock().getState() instanceof Sign) {
				BlockState st = event.getClickedBlock().getState();
				Sign s = (Sign) st;
				if (s.getLine(0).contains("[Join]")) {
					if (s.getLine(1).isEmpty()) {
						if (!plugin.SPL_State.get("game")) {
							s.setLine(1, ChatColor.RED + event.getPlayer().getName());
							s.setLine(2, ChatColor.GOLD + "vs");
							s.update();
							plugin.SPL_State.put("game", true);
							event.getPlayer().sendMessage(plugin.Chattext + "Du hast dich erfolgreich für die nächste runde Spleef angemeldet");
						}
					}
					else {
						if ((plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("running"))) {
							s.setLine(3, ChatColor.RED + event.getPlayer().getName());
							s.update();
							plugin.SPL_State.put("running", true);
							event.getPlayer().sendMessage(plugin.Chattext + "Du hast dich erfolgreich für die nächste runde Spleef angemeldet");
						}
					}
				}
				else if (s.getLine(0).contains("[Spleef]")) {
					if (s.getLine(1).isEmpty()) {
					//	s.setLine(1, ChatColor.RED + event.getPlayer().getName());
					}
				}
			}
		}
	}
}
