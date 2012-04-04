package de.callmepain.SPL.Listener;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import de.callmepain.SPL.SPL;
import de.callmepain.SPL.SPLUtil;

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
			if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer1().getName()) {
				if (SPLUtil.checkY(event.getPlayer().getLocation(), plugin.SPL_Bg.get("Loc1"))) {
					int i = plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2());
					i++;
					plugin.SPL_Player.setPlayerScore(plugin.SPL_Player.getPlayer2(), i);
						
					ItemStack item = SPLUtil.SPLItem();
					ItemStack itemsmall = SPLUtil.SPLItemSmall();
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2())) + "] Siege" + plugin.Chattext + " hat gewonnen");
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chattext + "du erhälst:");
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + " erhält:");
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					plugin.SPL_Player.getPlayer2().getInventory().addItem(item);
					plugin.SPL_Player.getPlayer2().getInventory().addItem(SPLUtil.SPL_Item.get(3001));
					
					plugin.SPL_Player.getPlayer1().getInventory().addItem(itemsmall);
					
					plugin.Util.SPL_End();
					plugin.SPL_Player.reset();
					plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn1"));
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
					plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
				}
			}
			else if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer2().getName()) {
			if (SPLUtil.checkY(event.getPlayer().getLocation(), plugin.SPL_Bg.get("Loc1"))) {
					int i = plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1());
					i++;
					plugin.SPL_Player.setPlayerScore(plugin.SPL_Player.getPlayer1(), i);

					ItemStack item = SPLUtil.SPLItem();
					ItemStack itemsmall = SPLUtil.SPLItemSmall();
					plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer1())) + "] Siege" + plugin.Chattext + " hat gewonnen");
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chattext + "du erhälst:");
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + " erhält:");
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(item.getAmount()) + " * " + item.getType().name());
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(SPLUtil.SPL_Item.get(3001).getAmount()) + " * " + SPLUtil.SPL_Item.get(3001).getType().name());
					
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.getPlayer2().sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatplayer + plugin.SPL_Player.getPlayer2().getName() + plugin.Chatsiege + " [" + String.valueOf(plugin.SPL_Player.getPlayerScore(plugin.SPL_Player.getPlayer2())) + "] Siege" + plugin.Chattext + " hat verloren und erhält:");
					plugin.SPL_Player.getPlayer1().sendMessage(plugin.Chatitem + String.valueOf(itemsmall.getAmount()) + " * " + itemsmall.getType().name());
					
					plugin.SPL_Player.getPlayer1().getInventory().addItem(item);
					plugin.SPL_Player.getPlayer1().getInventory().addItem(SPLUtil.SPL_Item.get(3001));
					plugin.SPL_Player.getPlayer2().getInventory().addItem(itemsmall);
					
					plugin.Util.SPL_End();
					plugin.SPL_Player.reset();
					plugin.SPL_Player.getPlayer1().teleport(plugin.SPL_Spawn.get("Despawn2"));
					plugin.SPL_Player.getPlayer2().teleport(plugin.SPL_Spawn.get("Despawn1"));
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
					SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
					plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void PlayerMoveStart(PlayerMoveEvent event) {
		if (plugin.SPL_Player.getPlayer1() != null) {
			if ((plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("running"))) {
				if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer1().getName()) {
					if (!SPLUtil.checkCuboid(event.getPlayer().getLocation(),plugin.SPL_SpawnRoom.get("SpawnRoom1loc1"),plugin.SPL_SpawnRoom.get("SpawnRoom1loc2"))) {
						plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.getPlayer1().getName() + plugin.Chattext + " hat die Arena verlassen!");
						plugin.Util.SPL_End();
						SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
						SPLUtil.fillgate(event.getPlayer().getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
						plugin.Util.fill(event.getPlayer().getWorld(), plugin.SPL_Bgendid);
						plugin.Util.SPLTimerReset();
						plugin.SPL_Player.reset();
					}
				}
			}
		}
	}
	@EventHandler(priority = EventPriority.LOW)
	public void WrongPlayer(PlayerMoveEvent event) {
		if (plugin.SPL_State.get("game")) {
			if ((plugin.SPL_Player.getPlayer1() != null) && (plugin.SPL_Player.getPlayer2() != null)) {
				if ((event.getPlayer().getName() == plugin.SPL_Player.getPlayer1().getName()) || (event.getPlayer().getName() == plugin.SPL_Player.getPlayer2().getName())) {
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
			else if (plugin.SPL_Player.getPlayer1() != null) {
				if (event.getPlayer().getName() == plugin.SPL_Player.getPlayer1().getName()) {
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
