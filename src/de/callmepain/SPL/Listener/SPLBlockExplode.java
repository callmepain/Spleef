package de.callmepain.SPL.Listener;	

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import de.callmepain.SPL.SPL;

public class SPLBlockExplode implements Listener{
	SPL plugin;
	public SPLBlockExplode(SPL instance) {
		plugin = instance;
	}
	@EventHandler(priority = EventPriority.LOW)
	public void onItemSoawn(ItemSpawnEvent event)
    {
		if ((plugin.SPL_State.get("game")) && (plugin.SPL_State.get("running"))) {
			if (event.getEntity().getItemStack().getTypeId() == 332) {
				event.getEntity().remove();
			}
		}
    }
	@EventHandler(priority = EventPriority.LOW)
	public void onEntityExplode(EntityExplodeEvent event)
    {
		if ((plugin.SPL_State.get("game")) && (plugin.SPL_State.get("running"))) {
			List<Block> blockListCopy = new ArrayList<Block>();
	        blockListCopy.addAll(event.blockList());
	        for (Block block : blockListCopy) {
	            if ((block.getType() != Material.ICE) && (block.getType() != Material.SNOW_BLOCK)) {
	            	event.blockList().remove(block);
	            }
	        }
		}
    }
}
