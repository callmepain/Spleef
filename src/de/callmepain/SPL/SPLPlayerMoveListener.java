package de.callmepain.SPL;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class SPLPlayerMoveListener implements Listener {
	SPL plugin;
	public SPLPlayerMoveListener(SPL instance) {
		plugin = instance;
	}
	World wo;
	Block bl;
	Material ma;
	Location loca;
	Location loca2;
	
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerMoveEnd(PlayerMoveEvent event) {
		if ((plugin.SPL_State.get("game")) && (plugin.SPL_State.get("running"))) {
			if (event.getPlayer().getName() == plugin.SPL_Player.get("1").getName()) {
				if (SPLUtil.checkY(event.getPlayer().getLocation(), plugin.SPL_Bg.get("Loc1"))) {
					if (plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName()) == null) {
						plugin.SPL_Playerscore.put(plugin.SPL_Player.get("2").getName(), 1);
					}
					else {
						int i = plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName());
						i++;
						plugin.SPL_Playerscore.put(plugin.SPL_Player.get("2").getName(), i);
					}
					SPLIO.saveHash(plugin.SPL_Playerscore, plugin.log);
					ItemStack item = SPLUtil.SPLItem();
					ItemStack itemsmall = SPLUtil.SPLItemSmall();
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("2").getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName())) + "] Siege" + plugin.Chattext + " hat gewonnen");
					plugin.SPL_Player.get("2").sendMessage(plugin.Chattext + "du erhälst:");
					plugin.SPL_Player.get("2").sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.get("2").sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					plugin.SPL_Player.get("1").sendMessage(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.get("1").sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					plugin.SPL_Player.get("2").getInventory().addItem(item);
					plugin.SPL_Player.get("2").getInventory().addItem(SPLUtil.SPL_Item.get(3001));
					
					plugin.SPL_Player.get("1").getInventory().addItem(itemsmall);
					
					plugin.Util.SPL_End();
					plugin.SPL_Player.get("1").teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.get("2").teleport(plugin.SPL_Spawn.get("Despawn1"));
					plugin.SPL_Player.put("1", null);
					plugin.SPL_Player.put("2", null);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
					plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
				}
			}
			else if (event.getPlayer().getName() == plugin.SPL_Player.get("2").getName()) {
			if (SPLUtil.checkY(event.getPlayer().getLocation(), plugin.SPL_Bg.get("Loc1"))) {
					if (plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName()) == null) {
						plugin.SPL_Playerscore.put(plugin.SPL_Player.get("1").getName(), 1);
					}
					else {
						int i = plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName());
						i++;
						plugin.SPL_Playerscore.put(plugin.SPL_Player.get("1").getName(), i);
					}
					SPLIO.saveHash(plugin.SPL_Playerscore, plugin.log);
					ItemStack item = SPLUtil.SPLItem();
					ItemStack itemsmall = SPLUtil.SPLItemSmall();
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName())) + "] Siege" + plugin.Chattext + " hat gewonnen");
					plugin.SPL_Player.get("1").sendMessage(plugin.Chattext + "du erhälst:");
					plugin.SPL_Player.get("1").sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.get("1").sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					plugin.SPL_Player.get("2").sendMessage(plugin.Chatplayer + plugin.SPL_Player.get("2").getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.get("2").sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					plugin.SPL_Player.get("1").getInventory().addItem(item);
					plugin.SPL_Player.get("1").getInventory().addItem(SPLUtil.SPL_Item.get(3001));
					plugin.SPL_Player.get("2").getInventory().addItem(itemsmall);
					
					plugin.Util.SPL_End();
					plugin.SPL_Player.get("1").teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.get("2").teleport(plugin.SPL_Spawn.get("Despawn1"));
					plugin.SPL_Player.put("1", null);
					plugin.SPL_Player.put("2", null);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
					plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerMoveStart(PlayerMoveEvent event) {
		if (plugin.SPL_Player.get("1") != null) {
			if ((plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("running"))) {
				if (event.getPlayer().getName() == plugin.SPL_Player.get("1").getName()) {
					if (!SPLUtil.checkCuboid(event.getPlayer().getLocation(),plugin.SPL_SpawnRoom.get("SpawnRoom1loc1"),plugin.SPL_SpawnRoom.get("SpawnRoom1loc2"))) {
						plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + plugin.Chattext + " hat die Arena verlassen!");
						plugin.Util.SPL_End();
						plugin.SPL_Player.put("1", null);
						plugin.SPL_Player.put("2", null);
						SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
						SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
						plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
						plugin.Util.SPLTimerReset();
					}
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void WrongPlayer(PlayerMoveEvent event) {
		if (plugin.SPL_State.get("game")) {
			if ((plugin.SPL_Player.get("1") != null) && (plugin.SPL_Player.get("2") != null)) {
				if ((event.getPlayer().getName() == plugin.SPL_Player.get("1").getName()) || (event.getPlayer().getName() == plugin.SPL_Player.get("2").getName())) {
						return;
					}
				else {
					if (SPLUtil.checkCuboid(event.getPlayer().getLocation(), plugin.SPL_Arena.get("1"), plugin.SPL_Arena.get("2"))) {
						event.getPlayer().teleport(plugin.SPL_Spawn.get("Despawn1"));
						event.getPlayer().sendMessage(plugin.Chattext + "du hast hier nix zu suchen!!!");
						return;
					}
				}
			}
			else if (plugin.SPL_Player.get("1") != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.get("1").getName()) {
					return;
				}
				else {
					if (SPLUtil.checkCuboid(event.getPlayer().getLocation(), plugin.SPL_Arena.get("1"), plugin.SPL_Arena.get("2"))) {
						event.getPlayer().teleport(plugin.SPL_Spawn.get("Despawn2"));
						event.getPlayer().sendMessage(plugin.Chattext + "du hast hier nix zu suchen!!!");
						return;
					}
				}
			}
		}
	}
}
