package de.callmepain.SPL;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;

public class SPLBlockDamage implements Listener {
	SPL plugin;
	public SPLBlockDamage(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void BlockBreaker(BlockDamageEvent event) {
		if ((plugin.SPL_State.get("running")) && (plugin.SPL_State.get("game"))) {
			if (event.getBlock().getType() == Material.ICE) {
				event.setInstaBreak(true);
			}
		}
		else {
				event.setInstaBreak(false);
		}
		if ((plugin.SPL_State.get("running")) && (plugin.SPL_State.get("game"))) {
			if (event.getBlock().getType() == Material.SNOW_BLOCK) {
				event.setInstaBreak(true);
			}
		}
		else {
			event.setInstaBreak(false);
		}
	}
}
