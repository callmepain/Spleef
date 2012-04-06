package de.callmepain.SPL.Listener;	

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
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
		plugin.Util.SPLBroadcast(event.getEntity().getItemStack().getType().toString());

		if (event.getEntity().getItemStack().getTypeId() == 332) {
			event.getEntity().remove();
		}
    }
}
