package de.callmepain.SPL.Listener;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import de.callmepain.SPL.SPL;

public class SPLBlockDamage implements Listener {
	SPL plugin;
	public SPLBlockDamage(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void BlockBreaker(BlockDamageEvent event) {
		if ((plugin.SPL_State.get("running")) && (plugin.SPL_State.get("game"))) {
			if (event.getBlock().getType() == Material.SNOW_BLOCK) {
				for (int i = 0; i < 19; i++) {
					if (((int)event.getBlock().getLocation().getX() == (int) plugin.SPL_Explosion.get(i).getX()) && ((int)event.getBlock().getLocation().getZ() == (int)plugin.SPL_Explosion.get(i).getZ())) {
						event.getBlock().getWorld().createExplosion(plugin.SPL_Explosion.get(i), 2);
						event.setInstaBreak(true);
					}
					else {
						event.setInstaBreak(true);
					}
				}
			}
		}
		else {
			event.setInstaBreak(false);
		}
		if ((plugin.SPL_State.get("running")) && (plugin.SPL_State.get("game"))) {
			if (event.getBlock().getType() == Material.ICE) {
				for (int i = 0; i < 19; i++) {
					if (((int)event.getBlock().getLocation().getX() == (int) plugin.SPL_Explosion.get(i).getX()) && ((int)event.getBlock().getLocation().getZ() == (int)plugin.SPL_Explosion.get(i).getZ())) {
						event.getBlock().getWorld().createExplosion(plugin.SPL_Explosion.get(i), 2);
						event.setInstaBreak(true);
					}
					else {
						event.setInstaBreak(true);
					}
				}
			}
		}
		else {
			event.setInstaBreak(false);
		}
/*		if (event.getPlayer() == Bukkit.getPlayer("xxmohxx")) {
			if (event.getBlock().getType() == Material.GRASS) {
				for (int i = 0; i < 19; i++) {
					if (((int)event.getBlock().getLocation().getX() == (int) plugin.SPL_Explosion.get(i).getX()) && ((int)event.getBlock().getLocation().getZ() == (int)plugin.SPL_Explosion.get(i).getZ())) {
						event.getBlock().getWorld().createExplosion(plugin.SPL_Explosion.get(i), 4);
						event.setInstaBreak(true);
					}
					else {
						event.setInstaBreak(true);
					}
				}
			}
		}
		else {
			event.setInstaBreak(false);
		}*/
	}
}
