package de.callmepain.SPL;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import de.callmepain.SPL.Listener.SPLListenerManager;
import de.callmepain.SPL.SpleefCommand.*;
import de.callmepain.SPL.timer.*;


public class SPL extends JavaPlugin {
	public static Logger log = Logger.getLogger("Minecraft");
	public SPLConfig Config;
	private SPLCommandExecutor CommandExe;
	

	public SPLUtil Util;
	public SPLPlayer SPL_Player;
	public TimerManager SPL_Timer;
	public SPLListenerManager SPL_ListenerManager;
	public SPLCmdManager SPL_CmdManager;
	
	
	
	public int SPL_SelTool;
	public HashMap<String, Location> SPL_Sel = new HashMap<String, Location>();
	public HashMap<Integer, Location> SPL_Explosion = new HashMap<Integer, Location>();
	public HashMap<String, Vector> SPL_SpawnRoom = new HashMap<String, Vector>();
	public HashMap<String, Vector> SPL_Bg = new HashMap<String, Vector>();
	public HashMap<String, Vector> SPL_Arena = new HashMap<String, Vector>();
	public HashMap<String, Location> SPL_Spawn = new HashMap<String, Location>();
	public Map<String, Location> SPL_Gate = new HashMap<String, Location>();
	public HashMap<String, Boolean> SPL_State = new HashMap<String, Boolean>();
	public HashMap<String, Block> SPL_Block = new HashMap<String, Block>();
	public int SPL_Bgid;
	public int SPL_Bgendid;
	public ChatColor Chattext = ChatColor.GREEN;
	public ChatColor Chatplayer = ChatColor.RED;
	public ChatColor Chatmoney = ChatColor.GOLD;
	public ChatColor Chatitem = ChatColor.LIGHT_PURPLE;
	public ChatColor Chatsiege = ChatColor.AQUA;
	public ChatColor Chaterr = ChatColor.RED;
	
	public void onEnable() {
		SPL_Timer = new TimerManager(this);
		SPL_ListenerManager = new SPLListenerManager(this);
		SPL_CmdManager = new SPLCmdManager(this);
		
		SPL_Player = new SPLPlayer();
		Util = new SPLUtil(this);
		
		CommandExe = new SPLCommandExecutor(this);
		
		Config = new SPLConfig(this);
		
		
		getServer().getPluginManager().registerEvents(Config, this);
		
		getCommand("SPLAdmin").setExecutor(CommandExe);
		
		SPL_SelTool = 271;
		SPL_State.put("game", false);
		SPL_State.put("running", false);
		SPL_State.put("closed", false);
		SPL_State.put("ice", false);
		SPL_State.put("4players", false);
		SPL_Bgid = 80;
		SPL_Bgendid = 79;
		
		System.out.println(toString() + " enabled");
        log.info("Your plugin has been enabled.");       
	}
	
	public void onDisable() {
		System.out.println(toString() + " disabled");
		log.info("Your plugin has been disabled.");
	}
}
