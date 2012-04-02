package de.callmepain.SPL.Listener;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import de.callmepain.SPL.SPL;

public class SPLBlockListener implements Listener {
	SPL plugin;
	public SPLBlockListener(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void BlockBreaker(BlockBreakEvent event) {
		if ((plugin.SPL_State.get("running")) && (plugin.SPL_State.get("game"))) {
			if (event.getBlock().getType() == Material.SNOW_BLOCK) {
				event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
			}
			else if (event.getBlock().getType() == Material.ICE) {
				event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
			}
		}
	}
}
