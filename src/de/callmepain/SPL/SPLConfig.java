package de.callmepain.SPL;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;

public class SPLConfig implements Listener{
	SPL plugin;
	public SPLConfig(SPL instance) {
		plugin = instance;
	}
	public void LoadConfig() {
		String demitter = ",";
		String Spawnloc1 = plugin.config.getString("Spawn.Loc1");
		String[] SPLoc1 = Spawnloc1.split(demitter);
		plugin.SPL_Spawn.put("Spawn1", new Location(Bukkit.getWorld(SPLoc1[0]), Double.parseDouble(SPLoc1[1]), Double.parseDouble(SPLoc1[2]), Double.parseDouble(SPLoc1[3]), (float)Double.parseDouble(SPLoc1[5]), (float)Double.parseDouble(SPLoc1[4])));
		String Spawnloc2 = plugin.config.getString("Spawn.Loc2");
		String[] SPLoc2 = Spawnloc2.split(demitter);
		plugin.SPL_Spawn.put("Spawn2", new Location(Bukkit.getWorld(SPLoc2[0]), Double.parseDouble(SPLoc2[1]), Double.parseDouble(SPLoc2[2]), Double.parseDouble(SPLoc2[3]), (float)Double.parseDouble(SPLoc2[5]), (float)Double.parseDouble(SPLoc2[4])));
		
		String Despawnloc1 = plugin.config.getString("Despawn.Loc1");
		String[] DESPLoc1 = Despawnloc1.split(demitter);
		plugin.SPL_Spawn.put("Despawn1", new Location(Bukkit.getWorld(DESPLoc1[0]), Double.parseDouble(DESPLoc1[1]), Double.parseDouble(DESPLoc1[2]), Double.parseDouble(DESPLoc1[3]), (float)Double.parseDouble(DESPLoc1[5]), (float)Double.parseDouble(DESPLoc1[4])));
		String Despawnloc2 = plugin.config.getString("Despawn.Loc2");
		String[] DESPLoc2 = Despawnloc2.split(demitter);
		plugin.SPL_Spawn.put("Despawn2", new Location(Bukkit.getWorld(DESPLoc2[0]), Double.parseDouble(DESPLoc2[1]), Double.parseDouble(DESPLoc2[2]), Double.parseDouble(DESPLoc2[3]), (float)Double.parseDouble(DESPLoc2[5]), (float)Double.parseDouble(DESPLoc2[4])));
		
		plugin.SPL_Bg.put("Loc1", (plugin.config.getVector("BG.Loc1")));
		plugin.SPL_Bg.put("Loc2", (plugin.config.getVector("BG.Loc2")));
		
		plugin.SPL_SpawnRoom.put("SpawnRoom1loc1", (plugin.config.getVector("SpawnRoom1.Loc1")));
		plugin.SPL_SpawnRoom.put("SpawnRoom1loc2", (plugin.config.getVector("SpawnRoom1.Loc2")));
		plugin.SPL_SpawnRoom.put("SpawnRoom2loc1", (plugin.config.getVector("SpawnRoom2.Loc1")));
		plugin.SPL_SpawnRoom.put("SpawnRoom2loc2", (plugin.config.getVector("SpawnRoom2.Loc2")));
		
		plugin.SPL_Arena.put("1", (plugin.config.getVector("Arena.Loc1")));
		plugin.SPL_Arena.put("2", (plugin.config.getVector("Arena.Loc2")));
		
		String Gate1loc1 = plugin.config.getString("Gate1.Loc1");
		String[] Gt1Loc1 = Gate1loc1.split(demitter);
		plugin.SPL_Gate.put("Gate1Loc1", new Location(Bukkit.getWorld(Gt1Loc1[0]), Double.parseDouble(Gt1Loc1[1]), Double.parseDouble(Gt1Loc1[2]), Double.parseDouble(Gt1Loc1[3])));
		String Gate1loc2 = plugin.config.getString("Gate1.Loc2");
		String[] Gt1Loc2 = Gate1loc2.split(demitter);
		plugin.SPL_Gate.put("Gate1Loc2", new Location(Bukkit.getWorld(Gt1Loc2[0]), Double.parseDouble(Gt1Loc2[1]), Double.parseDouble(Gt1Loc2[2]), Double.parseDouble(Gt1Loc2[3])));
		String Gate2loc1 = plugin.config.getString("Gate2.Loc1");
		String[] Gt2Loc1 = Gate2loc1.split(demitter);
		plugin.SPL_Gate.put("Gate2Loc1", new Location(Bukkit.getWorld(Gt2Loc1[0]), Double.parseDouble(Gt2Loc1[1]), Double.parseDouble(Gt2Loc1[2]), Double.parseDouble(Gt2Loc1[3])));
		String Gate2Loc2 = plugin.config.getString("Gate2.Loc2");
		String[] Gt2Loc2 = Gate2Loc2.split(demitter);
		plugin.SPL_Gate.put("Gate2Loc2", new Location(Bukkit.getWorld(Gt2Loc2[0]), Double.parseDouble(Gt2Loc2[1]), Double.parseDouble(Gt2Loc2[2]), Double.parseDouble(Gt2Loc2[3])));
		
	}
}
