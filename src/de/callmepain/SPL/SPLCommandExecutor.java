package de.callmepain.SPL;

import org.bukkit.ChatColor;
import org.bukkit.Location;
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
		if (command.getName().equalsIgnoreCase("SPL")) {
			if (args.length > 1) {
				player.sendMessage(ChatColor.RED + "Zu viele Argumente");
				return false;
			}
			else if (args.length < 1) {
				player.sendMessage(ChatColor.RED + "Zu wenig Argumente");
				return false;
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
