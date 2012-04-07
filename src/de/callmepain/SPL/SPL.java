package de.callmepain.SPL;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import de.callmepain.SPL.Listener.SPLBlockDamage;
import de.callmepain.SPL.Listener.SPLBlockExplode;
import de.callmepain.SPL.Listener.SPLBlockListener;
import de.callmepain.SPL.Listener.SPLJoinListener;
import de.callmepain.SPL.Listener.SPLLeaveListener;
import de.callmepain.SPL.Listener.SPLPlayerInteractListener;
import de.callmepain.SPL.Listener.SPLPlayerMoveListener;
import de.callmepain.SPL.SpleefCommand.*;
import de.callmepain.SPL.timer.*;


public class SPL extends JavaPlugin {
	public static Logger log = Logger.getLogger("Minecraft");
	public SPLPlayerMoveListener PlayerMoveListener;
	public SPLBlockListener BlockListener;
	public SPLPlayerInteractListener PlayerInteractListener;
	public SPLLeaveListener LeaveListener;
	public SPLJoinListener JoinListener;
	public SPLConfig Config;
	private SPLCommandExecutor CommandExe;
	public SPLBlockDamage BlockDamage;
	public SPLBlockExplode BlockExplode;

	private SpleefCommand splcmd;
	public SPLUtil Util;
	public SPLPlayer SPL_Player;
	public TimerManager SPL_Timer;
	
	
	public FileConfiguration config;
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
	
	public join SPL_Join;
	public leave SPL_Leave;
	public reload SPL_Reload;
	
	public void onEnable() {
		SPL_Timer = new TimerManager(this);
		
		SPL_Reload = new reload(this);
		SPL_Leave = new leave(this);
		SPL_Join = new join(this);
		SPL_Player = new SPLPlayer();
		Util = new SPLUtil(this);
		config = this.getConfig();
		PlayerMoveListener = new SPLPlayerMoveListener(this);
		BlockListener = new SPLBlockListener(this);
		PlayerInteractListener = new SPLPlayerInteractListener(this);
		CommandExe = new SPLCommandExecutor(this);
		Config = new SPLConfig(this);
		LeaveListener = new SPLLeaveListener(this);
		JoinListener = new SPLJoinListener(this);
		BlockDamage = new SPLBlockDamage(this);
		BlockExplode = new SPLBlockExplode(this);
		
		splcmd = new SpleefCommand(this);
		getServer().getPluginManager().registerEvents(PlayerMoveListener, this);
		getServer().getPluginManager().registerEvents(BlockListener, this);
		getServer().getPluginManager().registerEvents(PlayerInteractListener, this);
		getServer().getPluginManager().registerEvents(Config, this);
		getServer().getPluginManager().registerEvents(LeaveListener, this);
		getServer().getPluginManager().registerEvents(JoinListener, this);
		getServer().getPluginManager().registerEvents(BlockDamage, this);
		getServer().getPluginManager().registerEvents(BlockExplode, this);
		getCommand("Spleef").setExecutor(splcmd);
		getCommand("SPLAdmin").setExecutor(CommandExe);
		SPL_SelTool = 271;
		SPL_State.put("game", false);
		SPL_State.put("running", false);
		SPL_State.put("closed", false);
		SPL_State.put("ice", false);
		SPL_Bgid = 80;
		SPL_Bgendid = 79;
		Config.LoadConfig();
		
		System.out.println(toString() + " enabled");
        log.info("Your plugin has been enabled.");       
	}
	
	public void onDisable() {
		System.out.println(toString() + " disabled");
		log.info("Your plugin has been disabled.");
	}
}
