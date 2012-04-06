package de.callmepain.SPL.Listener;	

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
	public void onEntityExplode(ItemSpawnEvent event)
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
			event.blockList().clear();
		}
    }
}
