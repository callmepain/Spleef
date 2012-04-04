package de.callmepain.SPL;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import de.callmepain.SPL.CommandCore.CommandCore;
import de.callmepain.SPL.Listener.SPLBlockDamage;
import de.callmepain.SPL.Listener.SPLBlockListener;
import de.callmepain.SPL.Listener.SPLLeaveJoinListener;
import de.callmepain.SPL.Listener.SPLPlayerInteractListener;
import de.callmepain.SPL.Listener.SPLPlayerMoveListener;
import de.callmepain.SPL.timer.*;


public class SPL extends JavaPlugin {
	public static Logger log = Logger.getLogger("Minecraft");
	public SPLPlayerMoveListener PlayerMoveListener;
	public SPLBlockListener BlockListener;
	public SPLPlayerInteractListener PlayerInteractListener;
	public SPLLeaveJoinListener LeaveJoinListener;
	public SPLConfig Config;
	private SPLCommandExecutor CommandExe;
	public SPLBlockDamage BlockDamage;
	public Timer1 T1;
	public Timer2 T2;
	public Timer3 T3;
	public TimerFight TFight;
	public TimerStart TStart;
	public TimerClose TClose;
	public TimerPlayeringame TPig;
	public static Economy economy = null;
	private CommandCore cmdc;
	public SPLUtil Util;
	public SPLPlayer SPL_Player;
	
	
	public FileConfiguration config;
	public int SPL_SelTool;
	public double SPL_Einsatz;
	public boolean SPL_hasEinsatz;
	public HashMap<String, Location> SPL_Sel = new HashMap<String, Location>();
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
	public String SPL_Fieldtyp = "Schnee";
	public int taskId1 = 0;
	public int taskId2 = 0;
	public int taskid3 = 0;
	public int taskidfight = 0;
	public int taskidstart = 0;
	public int taskidclose = 0;
	public int taskidplayeringame = 0;
	
	public void onEnable() {
		SPL_Player = new SPLPlayer();
		Util = new SPLUtil(this);
		config = this.getConfig();
		PlayerMoveListener = new SPLPlayerMoveListener(this);
		BlockListener = new SPLBlockListener(this);
		PlayerInteractListener = new SPLPlayerInteractListener(this);
		CommandExe = new SPLCommandExecutor(this);
		Config = new SPLConfig(this);
		LeaveJoinListener = new SPLLeaveJoinListener(this);
		BlockDamage = new SPLBlockDamage(this);
		T1 = new Timer1(this);
		T2 = new Timer2(this);
		T3 = new Timer3(this);
		TFight = new TimerFight(this);
		TStart = new TimerStart(this);
		TClose = new TimerClose(this);
		TPig = new TimerPlayeringame(this);
		
		cmdc = new CommandCore(this);
		getServer().getPluginManager().registerEvents(PlayerMoveListener, this);
		getServer().getPluginManager().registerEvents(BlockListener, this);
		getServer().getPluginManager().registerEvents(PlayerInteractListener, this);
		getServer().getPluginManager().registerEvents(Config, this);
		getServer().getPluginManager().registerEvents(LeaveJoinListener, this);
		getServer().getPluginManager().registerEvents(BlockDamage, this);
		getCommand("Spleef").setExecutor(cmdc);
		getCommand("SPL").setExecutor(CommandExe);
		getCommand("SPLAdmin").setExecutor(CommandExe);
		SPL_SelTool = 271;
		SPL_State.put("game", false);
		SPL_State.put("running", false);
		SPL_State.put("closed", false);
		SPL_State.put("ice", false);
		SPL_Bgid = 80;
		SPL_Bgendid = 79;
		Config.LoadConfig();
		
		if (!setupEconomy()) {
			log.info(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
		}
		System.out.println(toString() + " enabled");
        log.info("Your plugin has been enabled.");       
	}
	
	public void onDisable() {
		System.out.println(toString() + " disabled");
		log.info("Your plugin has been disabled.");
	}
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        economy = rsp.getProvider();
        return economy != null;
    }
	public void filltop(World w, Location loc1, int id, int id2) {
		Block b1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 3, (int)loc1.getZ());
		Block bx1 = w.getBlockAt((int)loc1.getX() + 1, (int)loc1.getY() + 3, (int)loc1.getZ());
		Block bx2 = w.getBlockAt((int)loc1.getX() - 1, (int)loc1.getY() + 3, (int)loc1.getZ());
		Block bz1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 3, (int)loc1.getZ() + 1);
		Block bz2 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 3, (int)loc1.getZ() - 1);
		if(b1.getTypeId() == id) {
			b1.setTypeId(id2);
		}
		if(bx1.getTypeId() == id2) {
			bx1.setTypeId(id);
		}
		if(bx2.getTypeId() == id2) {
			bx2.setTypeId(id);
		}
		if(bz1.getTypeId() == id2) {
			bz1.setTypeId(id);
		}
		if(bz2.getTypeId() == id2) {
			bz2.setTypeId(id);
		}
	}
}
