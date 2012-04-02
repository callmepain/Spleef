package de.callmepain.SPL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SPLCommandExecutor implements CommandExecutor {
	SPL plugin;
	public SPLCommandExecutor(SPL instance) {
		plugin = instance;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = null;
		if ((sender instanceof Player)) {
			player = (Player)sender;
		}
		else {
			sender.sendMessage(ChatColor.RED + "Du bist kein Spieler!");
		}
		final World w = player.getWorld();
		if (command.getName().equalsIgnoreCase("SPL")) {
			if (args.length > 1) {
				player.sendMessage(ChatColor.RED + "Zu viele Argumente");
				return false;
			}
			else if (args.length < 1) {
				player.sendMessage(ChatColor.RED + "Zu wenig Argumente");
				return false;
			}
			if (args[0].equalsIgnoreCase("reload")) {
				if (!player.hasPermission("spl.admin")) {
					player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
					return true;
				}
				plugin.Util.SPL_End();
				plugin.Util.fill(w, plugin.SPL_Bgendid);
				plugin.Config.LoadConfig();
				player.sendMessage(plugin.Chattext + "reload complete");
				return true;
			}
			else if (args[0].equalsIgnoreCase("top")) {
				SPLPlayer p = new SPLPlayer(player, false, 100);
				Bukkit.broadcastMessage(String.valueOf(p.getPlayerScore(player)));
				Bukkit.broadcastMessage(String.valueOf(p.isPlayerQuite(player)));
			}
			else if (args[0].equalsIgnoreCase("join")) {
				if (!player.hasPermission("spl.join")) {
					player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
					return true;
				}
				if (player.isOp()) {
					player.sendMessage(plugin.Chattext + "als OP darfst du nicht teilnehmen weil du mir immer versehentlich die arena zerstörst!");
					return true;
				}
				if (player.getGameMode() == GameMode.CREATIVE) {
					player.sendMessage(plugin.Chattext + "im Creative modus darfst du nicht teilnehmen!");
					return true;
				}
				if(!plugin.SPL_State.get("game")) {
					if (SPLUtil.SPL_Mode())
					{
						plugin.SPL_Bgid = 79;
						plugin.SPL_Fieldtyp = "Ice";
					}
					else {
						plugin.SPL_Bgid = 80;
						plugin.SPL_Fieldtyp = "Schnee";
					}
					SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate1Loc1"), 101, 57);
					SPLUtil.fillgate(player.getWorld(), plugin.SPL_Gate.get("Gate2Loc1"), 101, 57);
					plugin.SPL_Player.put("1", player);
					if (plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName()) == null) {
						plugin.SPL_Playerscore.put(plugin.SPL_Player.get("1").getName(), 0);
					}
					player.teleport(plugin.SPL_Spawn.get("Spawn1"));
					plugin.Util.SPLBroadcast(plugin.Chatplayer + player.getName() + plugin.Chattext + " hat die " + plugin.Chatitem + "Spleef Arena v." +  plugin.getDescription().getVersion() + plugin.Chattext + " betreten ");
					player.sendMessage(plugin.Chattext + "sollte sich kein Gegner finden gib " + plugin.Chatitem + "/spl leave" + plugin.Chattext + " ein");
					plugin.taskId7 = plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, plugin.TPig, 1200L, 1200L);
					plugin.SPL_State.put("game", true);
					return true;
				}
				else if ((plugin.SPL_State.get("game")) && (!plugin.SPL_State.get("running"))) {
					if (plugin.SPL_Player.get("1").getName() == player.getName()) {
						player.sendMessage(plugin.Chattext + "Du kannst nicht gegen dich selber antreten...");
					}
					else {
						plugin.SPL_Player.put("2", player);
						if (plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName()) == null) {
							plugin.SPL_Playerscore.put(plugin.SPL_Player.get("2").getName(), 0);
						}
						player.teleport(plugin.SPL_Spawn.get("Spawn2"));
						plugin.Util.SPLBroadcast(plugin.Chatplayer + plugin.SPL_Player.get("1").getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("1").getName())) + "]" + plugin.Chattext + " vs. " + plugin.Chatplayer + plugin.SPL_Player.get("2").getName() + ChatColor.AQUA + " [" + String.valueOf(plugin.SPL_Playerscore.get(plugin.SPL_Player.get("2").getName())) + "]");
						plugin.getServer().getScheduler().cancelTask(plugin.taskId7);
						plugin.taskId1 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.T3, 140L);
						plugin.taskId2 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.T2, 160L);
						plugin.taskId3 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.T1, 180L);
						plugin.taskId4 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.TFight, 195L);
						plugin.taskId5 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.TStart, 200L);
						plugin.taskId6 = plugin.getServer().getScheduler().scheduleAsyncDelayedTask(plugin, plugin.TClose, 300L);
						plugin.SPL_State.put("running", true);
						return true;
					}
				}
			}
			else if (args[0].equalsIgnoreCase("Leave")) {
				if (!player.hasPermission("spl.join")) {
					player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
					plugin.getServer().getScheduler().cancelTask(plugin.taskId7);
					return true;
				}
				else {
					plugin.Util.SPL_End();
					plugin.SPL_Player.get("1").teleport(plugin.SPL_Spawn.get("Despawn1"));
					if (plugin.SPL_Player.get("2") != null) {
						plugin.SPL_Player.get("2").teleport(plugin.SPL_Spawn.get("Despawn2"));
					}
					plugin.Util.SPLBroadcast(plugin.Chatplayer + player.getName() + plugin.Chattext + " hat die Arena verlassen...");
					return true;
				}
			}
		}
		if (command.getName().equalsIgnoreCase("SPLAdmin")) {
			if (args.length > 2) {
				player.sendMessage(ChatColor.RED + "Zu viele Argumente");
				return false;
			}
			else if (args.length < 2) {
				player.sendMessage(ChatColor.RED + "Zu wenig Argumente");
				return false;
			}
			if (!player.hasPermission("spl.admin")) {
				player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Befehl zu nutzen!");
				return true;
			}
			if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("spawn1"))) {
				String Loc = player.getLocation().getWorld().getName() + "," + String.valueOf(player.getLocation().getX()) + "," + String.valueOf(player.getLocation().getY()) + "," + String.valueOf(player.getLocation().getZ()) + "," + String.valueOf(player.getLocation().getPitch()) + "," + String.valueOf(player.getLocation().getYaw());
				plugin.getConfig().set("Spawn.Loc1", Loc);
				plugin.saveConfig();
				plugin.SPL_Spawn.put("Spawn1", new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getPitch(), player.getLocation().getYaw()));
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Spawn1 gesetzt");
				return true;
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("spawn2"))) {
				String Loc = player.getLocation().getWorld().getName() + "," + String.valueOf(player.getLocation().getX()) + "," + String.valueOf(player.getLocation().getY()) + "," + String.valueOf(player.getLocation().getZ()) + "," + String.valueOf(player.getLocation().getPitch()) + "," + String.valueOf(player.getLocation().getYaw());
				plugin.getConfig().set("Spawn.Loc2", Loc);
				plugin.saveConfig();
				plugin.SPL_Spawn.put("Spawn2", new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getPitch(), player.getLocation().getYaw()));
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Spawn2 gesetzt");
				return true;
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("despawn1"))) {
				String Loc = player.getLocation().getWorld().getName() + "," + String.valueOf(player.getLocation().getX()) + "," + String.valueOf(player.getLocation().getY()) + "," + String.valueOf(player.getLocation().getZ()) + "," + String.valueOf(player.getLocation().getPitch()) + "," + String.valueOf(player.getLocation().getYaw());
				plugin.getConfig().set("Despawn.Loc1", Loc);
				plugin.saveConfig();
				plugin.SPL_Spawn.put("Despawn1", new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getPitch(), player.getLocation().getYaw()));
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Despawn1 gesetzt");
				return true;
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("despawn2"))) {
				String Loc = player.getLocation().getWorld().getName() + "," + String.valueOf(player.getLocation().getX()) + "," + String.valueOf(player.getLocation().getY()) + "," + String.valueOf(player.getLocation().getZ()) + "," + String.valueOf(player.getLocation().getPitch()) + "," + String.valueOf(player.getLocation().getYaw());
				plugin.getConfig().set("Despawn.Loc2", Loc);
				plugin.saveConfig();
				plugin.SPL_Spawn.put("Despawn2", new Location(player.getLocation().getWorld(), player.getLocation().getX(), player.getLocation().getY(), player.getLocation().getZ(), player.getLocation().getPitch(), player.getLocation().getYaw()));
				sender.sendMessage(ChatColor.LIGHT_PURPLE + "Despawn2 gesetzt");
				return true;
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("bg"))) {
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					plugin.SPL_Bg.put("Loc1", plugin.SPL_Sel.get("Sel1").toVector());
					plugin.SPL_Bg.put("Loc2", plugin.SPL_Sel.get("Sel2").toVector());
					plugin.getConfig().set("BG.Loc1", plugin.SPL_Bg.get("Loc1"));
					plugin.getConfig().set("BG.Loc2", plugin.SPL_Bg.get("Loc2"));
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "BG gesetzt");
					return true;
				}
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("startraum1"))) {
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					plugin.SPL_SpawnRoom.put("SpawnRoom1loc1", plugin.SPL_Sel.get("Sel1").toVector());
					plugin.SPL_SpawnRoom.put("SpawnRoom1loc2", plugin.SPL_Sel.get("Sel2").toVector());
					plugin.getConfig().set("SpawnRoom1.Loc1", plugin.SPL_SpawnRoom.get("SpawnRoom1loc1"));
					plugin.getConfig().set("SpawnRoom1.Loc2", plugin.SPL_SpawnRoom.get("SpawnRoom1loc2"));
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Start Raum1 gesetzt");
					return true;
				}
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("startraum2"))) {
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					plugin.SPL_SpawnRoom.put("SpawnRoom2loc1", plugin.SPL_Sel.get("Sel1").toVector());
					plugin.SPL_SpawnRoom.put("SpawnRoom2loc2", plugin.SPL_Sel.get("Sel2").toVector());
					plugin.getConfig().set("SpawnRoom2.Loc1", plugin.SPL_SpawnRoom.get("SpawnRoom2loc1"));
					plugin.getConfig().set("SpawnRoom2.Loc2", plugin.SPL_SpawnRoom.get("SpawnRoom2loc2"));
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Start Raum2 gesetzt");
					return true;
				}
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("gate1"))) {
				String Loc1 = player.getLocation().getWorld().getName() + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getX()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getY()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getZ());
				String Loc2 = player.getLocation().getWorld().getName() + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getX()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getY()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getZ());
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					plugin.SPL_Gate.put("Gate1loc1", plugin.SPL_Sel.get("Sel1"));
					plugin.SPL_Gate.put("Gate1loc2", plugin.SPL_Sel.get("Sel2"));
					plugin.getConfig().set("Gate1.Loc1", Loc1);
					plugin.getConfig().set("Gate1.Loc2", Loc2);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Gate1 gesetzt");
					return true;
				}
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("gate2"))) {
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					String Loc1 = player.getLocation().getWorld().getName() + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getX()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getY()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel1").getZ());
					String Loc2 = player.getLocation().getWorld().getName() + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getX()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getY()) + "," + String.valueOf(plugin.SPL_Sel.get("Sel2").getZ());
					plugin.SPL_Gate.put("Gate2loc1", plugin.SPL_Sel.get("Sel1"));
					plugin.SPL_Gate.put("Gate2loc2", plugin.SPL_Sel.get("Sel2"));
					plugin.getConfig().set("Gate2.Loc1", Loc1);
					plugin.getConfig().set("Gate2.Loc2", Loc2);
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Gate2 gesetzt");
					return true;
				}
			}
			else if ((args[0].equalsIgnoreCase("set")) && (args[1].equalsIgnoreCase("arena"))) {
				if((plugin.SPL_Sel.get("Sel1") != null) && (plugin.SPL_Sel.get("Sel2") != null)) {
					plugin.SPL_Arena.put("1", plugin.SPL_Sel.get("Sel1").toVector());
					plugin.SPL_Arena.put("2", plugin.SPL_Sel.get("Sel2").toVector());
					plugin.getConfig().set("Arena.Loc1", plugin.SPL_Arena.get("1"));
					plugin.getConfig().set("Arena.Loc2", plugin.SPL_Arena.get("2"));
					plugin.saveConfig();
					sender.sendMessage(ChatColor.LIGHT_PURPLE + "Arena gesetzt");
					return true;
				}
			}
		}
		return true;
	}
}
