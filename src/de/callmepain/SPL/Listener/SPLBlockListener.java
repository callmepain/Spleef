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
				for (int i = 0; i < 19; i++) {
					if (event.getBlock().getLocation() == plugin.SPL_Explosion.get(i)) {
						event.getBlock().getWorld().createExplosion(plugin.SPL_Explosion.get(i), 20);
						event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
					}
					else {
						event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
					}
				}
			}
			else if (event.getBlock().getType() == Material.ICE) {
				for (int i = 0; i < 19; i++) {
					if (event.getBlock().getLocation() == plugin.SPL_Explosion.get(i)) {
						event.getBlock().getWorld().createExplosion(plugin.SPL_Explosion.get(i), 20);
						event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
					}
					else {
						event.getBlock().breakNaturally(new ItemStack(Material.AIR, 1));
					}
				}
				
			}
		}
	}
}
