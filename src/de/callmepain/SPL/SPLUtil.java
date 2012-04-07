package de.callmepain.SPL;

import java.util.HashMap;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class SPLUtil {
	public static HashMap<Integer, ItemStack> SPL_Item = new HashMap<Integer, ItemStack>();
	SPL plugin;
	public SPLUtil(SPL instance) {
		plugin = instance;
	}

	public static boolean checkHand(Player p){
		if (p.getItemInHand().getType() == Material.DIAMOND_SPADE) {
			return true;
		}
		else if (p.getItemInHand().getType() == Material.IRON_SPADE) {
			return true;
		}
		else if (p.getItemInHand().getType() == Material.WOOD_SPADE) {
			return true;
		}
		else if (p.getItemInHand().getType() == Material.STONE_SPADE) {
			return true;
		}
		else {
			return false;
		}
	}
	public static boolean checkCuboid(Location playerloc, Location loc, Location loc2) {
        if(loc != null && loc2 != null) {
            if(((playerloc.getX() >= loc.getX()) && (playerloc.getX() <= loc2.getX())) || ((playerloc.getX() <= loc.getX()) && (playerloc.getX() >= loc2.getX()))) {
                if(((playerloc.getY() >= loc.getY()) && (playerloc.getY() <= loc2.getY())) || ((playerloc.getY() <= loc.getY()) && (playerloc.getY() >= loc2.getY()))) {
                    if(((playerloc.getZ() >= loc.getZ()) && (playerloc.getZ() <= loc2.getZ())) || ((playerloc.getZ() <= loc.getZ()) && (playerloc.getZ() >= loc2.getZ()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	public static boolean checkCuboid(Location playerloc, Vector loc, Vector loc2) {
        if(loc != null && loc2 != null) {
            if(((playerloc.getX() >= loc.getX()) && (playerloc.getX() <= loc2.getX())) || ((playerloc.getX() <= loc.getX()) && (playerloc.getX() >= loc2.getX()))) {
                if(((playerloc.getY() >= loc.getY()) && (playerloc.getY() <= loc2.getY())) || ((playerloc.getY() <= loc.getY()) && (playerloc.getY() >= loc2.getY()))) {
                    if(((playerloc.getZ() >= loc.getZ()) && (playerloc.getZ() <= loc2.getZ())) || ((playerloc.getZ() <= loc.getZ()) && (playerloc.getZ() >= loc2.getZ()))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
	public static boolean checkY(Location playerloc, Vector loc) {
        if(loc != null) {
        	if(playerloc.getY() <= loc.getY()) {
        		return true;
            }
        }
        return false;
    }
	public static Location SPLVectortoLocation(World w, Vector v) {
		Location loc = new Location(w,v.getX(),v.getY(),v.getZ());
		return(loc);
	}
	public static ItemStack SPLItem() {
		Random rnd = new Random();
		Random rnd2 = new Random();
		Random rnd3 = new Random();
		Random rnd4 = new Random();
		Random rnd5 = new Random();
		Random rnd6 = new Random();
		Random rnd7 = new Random();
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		int max64 = 0;
		int max32 = 0;
		int max16 = 0;
		int max5y1 = 0;
		int max5y2 = 0;
		int max5y3 = 0;
		for (int i = 0; i < 5; i++) {
			max5y1 = rnd.nextInt(5);
			if (max5y1 <= 1) {
				max5y1 = 1;
			}
		}
		for (int i = 0; i < 23; i++) {
			max5y2 = rnd2.nextInt(5);
			if (max5y2 <= 1) {
				max5y2 = 1;
			}
		}
		for (int i = 0; i < 14; i++) {
			max5y3 = rnd3.nextInt(5);
			if (max5y3 <= 1) {
				max5y3 = 1;
			}
		}
		for (int i = 0; i < 7; i++) {
			max16 = rnd4.nextInt(16);
			if (max16 <= 5) {
				max16 = 5;
			}
		}
		for (int i = 0; i < 9; i++) {
			max32 = rnd5.nextInt(32);
			if (max32 <= 16) {
				max32 = 16;
			}
		}
		for (int i = 0; i < 13; i++) {
			max64 = rnd6.nextInt(64);
			if (max64 <= 32) {
				max64 = 32;
			}
		}
		SPL_Item.put(1, new ItemStack(Material.SADDLE, 1));
		SPL_Item.put(2, new ItemStack(Material.DIAMOND, max5y3));
		SPL_Item.put(3, new ItemStack(Material.GOLD_INGOT, max5y3));
		SPL_Item.put(4, new ItemStack(Material.IRON_INGOT, max5y3));
		SPL_Item.put(5, new ItemStack(Material.BLAZE_ROD, max5y3));
		SPL_Item.put(20, new ItemStack(Material.BLAZE_ROD, max5y3));
		SPL_Item.put(6, new ItemStack(Material.COOKED_BEEF, max16));
		SPL_Item.put(21, new ItemStack(Material.COOKED_BEEF, max16));
		SPL_Item.put(7, new ItemStack(Material.COOKED_CHICKEN, max16));
		SPL_Item.put(22, new ItemStack(Material.COOKED_CHICKEN, max16));
		SPL_Item.put(8, new ItemStack(Material.COOKIE, max16));
		SPL_Item.put(9, new ItemStack(Material.STONE, max32));
		SPL_Item.put(23, new ItemStack(Material.STONE, max64));
		SPL_Item.put(10, new ItemStack(Material.WOOD, max32));
		SPL_Item.put(24, new ItemStack(Material.WOOD, max32));
		SPL_Item.put(27, new ItemStack(Material.WOOD, max64));
		SPL_Item.put(11, new ItemStack(Material.GOLDEN_APPLE, max5y3));
		SPL_Item.put(12, new ItemStack(Material.TORCH, max64));
		SPL_Item.put(25, new ItemStack(Material.TORCH, max32));
		SPL_Item.put(13, new ItemStack(Material.GLASS, max32));
		SPL_Item.put(26, new ItemStack(Material.GLASS, max32));
		SPL_Item.put(28, new ItemStack(Material.GLASS, max64));
		SPL_Item.put(14, new ItemStack(Material.IRON_PICKAXE, 1));
		SPL_Item.put(15, new ItemStack(Material.IRON_SPADE, 1));
		SPL_Item.put(16, new ItemStack(Material.IRON_AXE, 1));
		SPL_Item.put(17, new ItemStack(Material.DIAMOND_BLOCK, 1));
		SPL_Item.put(18, new ItemStack(Material.GOLD_BLOCK, 1));
		SPL_Item.put(19, new ItemStack(Material.IRON_BLOCK, 1));
		SPL_Item.put(3001, new ItemStack(Material.EXP_BOTTLE, max5y1));
		for (int i = 0; i < 14; i++) {
			int x = rnd7.nextInt(28);
			if (x < 1) {
				item = SPL_Item.get(1);
			}
			else {
				item = SPL_Item.get(x);
			}
		}
		return (item);
	}
	public static ItemStack SPLItemSmall() {
		Random rnd = new Random();
		Random rnd2 = new Random();
		Random rnd3 = new Random();
		ItemStack item = new ItemStack(Material.BLAZE_ROD);
		int max5y1 = 0;
		int max5y2 = 0;
		for (int i = 0; i < 5; i++) {
			max5y1 = rnd.nextInt(5);
			if (max5y1 <= 1) {
				max5y1 = 1;
			}
		}
		for (int i = 0; i < 23; i++) {
			max5y2 = rnd2.nextInt(5);
			if (max5y2 <= 1) {
				max5y2 = 1;
			}
		}
		SPL_Item.put(3001, new ItemStack(Material.EXP_BOTTLE, max5y1));
		SPL_Item.put(1, new ItemStack(Material.GOLD_NUGGET, max5y2));
		SPL_Item.put(2, new ItemStack(Material.COAL, max5y2));
		SPL_Item.put(9, new ItemStack(Material.COAL, max5y2));
		SPL_Item.put(3, new ItemStack(Material.APPLE, max5y2));
		SPL_Item.put(6, new ItemStack(Material.APPLE, max5y2));
		SPL_Item.put(4, new ItemStack(Material.SLIME_BALL, max5y2));
		SPL_Item.put(7, new ItemStack(Material.SLIME_BALL, max5y2));
		SPL_Item.put(5, new ItemStack(Material.ENDER_PEARL, max5y2));
		SPL_Item.put(8, new ItemStack(Material.ENDER_PEARL, max5y2));
		SPL_Item.put(10, new ItemStack(Material.ARROW, max5y2));
		for (int i = 0; i < 14; i++) {
			int x = rnd3.nextInt(10);
			if (x < 1) {
				item = SPL_Item.get(1);
			}
			else {
				item = SPL_Item.get(x);
			}
		}
		return (item);
	}
	public static void fillgate(final World w, final Location loc1, final int id, final int id2) {
		Thread Tgfill = new Thread(new Runnable() {
			@Override
			public void run() {
				Block b1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY(), (int)loc1.getZ());
				Block bx1 = w.getBlockAt((int)loc1.getX() + 1, (int)loc1.getY(), (int)loc1.getZ());
				Block bx2 = w.getBlockAt((int)loc1.getX() - 1, (int)loc1.getY(), (int)loc1.getZ());
				Block bz1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY(), (int)loc1.getZ() + 1);
				Block bz2 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY(), (int)loc1.getZ() - 1);
				Block by1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 1, (int)loc1.getZ());
				Block by2 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() - 1, (int)loc1.getZ());
				Block bxy1 = w.getBlockAt((int)loc1.getX() + 1, (int)loc1.getY() + 1, (int)loc1.getZ());
				Block bxy2 = w.getBlockAt((int)loc1.getX() - 1, (int)loc1.getY() - 1, (int)loc1.getZ());
				Block bxy3 = w.getBlockAt((int)loc1.getX() - 1, (int)loc1.getY() + 1, (int)loc1.getZ());
				Block bxy4 = w.getBlockAt((int)loc1.getX() + 1, (int)loc1.getY() - 1, (int)loc1.getZ());
				Block byz1 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 1, (int)loc1.getZ() + 1);
				Block byz2 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() - 1, (int)loc1.getZ() - 1);
				Block byz3 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() + 1, (int)loc1.getZ() - 1);
				Block byz4 = w.getBlockAt((int)loc1.getX(), (int)loc1.getY() - 1, (int)loc1.getZ() + 1);
				if(b1.getTypeId() == id2) {
					b1.setTypeId(id);
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
				if(by1.getTypeId() == id2) {
					by1.setTypeId(id);
				}
				if(by2.getTypeId() == id2) {
					by2.setTypeId(id);
				}
				if(bxy1.getTypeId() == id2) {
					bxy1.setTypeId(id);
				}
				if(bxy2.getTypeId() == id2) {
					bxy2.setTypeId(id);
				}
				if(bxy3.getTypeId() == id2) {
					bxy3.setTypeId(id);
				}
				if(bxy4.getTypeId() == id2) {
					bxy4.setTypeId(id);
				}
				if(byz1.getTypeId() == id2) {
					byz1.setTypeId(id);
				}
				if(byz2.getTypeId() == id2) {
					byz2.setTypeId(id);
				}
				if(byz3.getTypeId() == id2) {
					byz3.setTypeId(id);
				}
				if(byz4.getTypeId() == id2) {
					byz4.setTypeId(id);
				}
			}
		});
		Tgfill.run();
		Tgfill = null;
	}
	private static boolean SPL_Mode() {
		boolean bo = false;
		Random rnd = new Random();
		for (int i = 0; i < rnd.nextInt(35); i++) {
			int x = rnd.nextInt(2);
			if (x == 1) {
				bo = true;
			}
			else if (x == 2) {
				bo = true;
			}
			else {
				bo = false;
			}
		}
		return bo;
	}
	public void SPL_ModeChange() {
		if (SPLUtil.SPL_Mode())
		{
			plugin.SPL_Bgid = 79;
		}
		else {
			plugin.SPL_Bgid = 80;
		}
	}
	public void SPL_End() {
		plugin.SPL_State.put("game", false);
		plugin.SPL_State.put("running", false);
		plugin.SPL_State.put("closed", false);
	}
	public void fill(final World w, final int id) {
		Thread Tfill = new Thread(new Runnable() {
			@Override
			public void run() {
				
				double x1 = plugin.SPL_Bg.get("Loc1").getX();
				double x2 = plugin.SPL_Bg.get("Loc2").getX();
				double z1 = plugin.SPL_Bg.get("Loc1").getZ();
				double z2 = plugin.SPL_Bg.get("Loc2").getZ();
				String x3 = "";
				String x4 = "";
				String z3 = "";
				String z4 = "";
				if (x1 < x2) {
					x3 = "Loc1";
					x4 = "Loc2";
				}
				else {
					x3 = "Loc2";
					x4 = "Loc1";
				}
				if (z1 < z2) {
					z3 = "Loc1";
					z4 = "Loc2";
				}
				else {
					z3 = "Loc2";
					z4 = "Loc1";
				}
				for (int x_operate = (int) plugin.SPL_Bg.get(x3).getX(); x_operate <= plugin.SPL_Bg.get(x4).getX(); x_operate++) {
					for (int z_operate = (int) plugin.SPL_Bg.get(z3).getZ(); z_operate <= plugin.SPL_Bg.get(z4).getZ(); z_operate++) {
						Block blockToChange = w.getBlockAt(x_operate, (int) plugin.SPL_Bg.get(z3).getY(), z_operate);
						blockToChange.setTypeId(id);
					}
				}
			}
		});
		Tfill.run();
		Tfill = null;
	}
	private void SPLRndExplosion(final World w, final int id) {
		Thread TExplosion = new Thread(new Runnable() {
			@Override
			public void run() {
				double x1 = plugin.SPL_Bg.get("Loc1").getX();
				double x2 = plugin.SPL_Bg.get("Loc2").getX();
				double z1 = plugin.SPL_Bg.get("Loc1").getZ();
				double z2 = plugin.SPL_Bg.get("Loc2").getZ();
				double x4;
				double z4;
				double x3;
				double z3;
				if (x1 < x2) {
					x4 =plugin.SPL_Bg.get("Loc2").getX();
					x3 =plugin.SPL_Bg.get("Loc1").getX();
				}
				else {
					x4 =plugin.SPL_Bg.get("Loc1").getX();
					x3 =plugin.SPL_Bg.get("Loc2").getX();
				}
				if (z1 < z2) {
					z4 =plugin.SPL_Bg.get("Loc2").getZ();
					z3 =plugin.SPL_Bg.get("Loc1").getZ();
				}
				else {
					z4 =plugin.SPL_Bg.get("Loc1").getZ();
					z3 =plugin.SPL_Bg.get("Loc2").getZ();
				}
				double rnd = new Random().nextDouble();
				double rnd2 = new Random().nextDouble();
				double resultx = x4 + (rnd * (x3 - x4));
				double resultz = z4 + (rnd2 * (z3 - z4));
				plugin.SPL_Explosion.put(id, new Location(w, resultx, plugin.SPL_Bg.get("Loc1").getY(), resultz));
			}
		});
		TExplosion.run();
		TExplosion = null;
	}
	public void SPLExplosion(final World w, final int id) {
		Thread TExplosion = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i < 19; i++) {
					SPLRndExplosion(w, i);
					Block btc = w.getBlockAt(plugin.SPL_Explosion.get(i));
					btc.setTypeId(id);
				}
			}
		});
		TExplosion.run();
		TExplosion = null;
	}
	public void SPLBroadcast(String args) {
		plugin.getServer().broadcastMessage(args);
	}
	public void SPLTimerReset() {
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskId1);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskId2);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskid3);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidfight);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidstart);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidclose);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidplayeringame);
		plugin.getServer().getScheduler().cancelTask(plugin.SPL_Timer.taskidleave);
	}
	public void SPLGateChange(boolean co) {
		if (!co) {
			plugin.SPL_Block.put("11", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc1")));
			plugin.SPL_Block.get("11").setTypeId(0);
			plugin.SPL_Block.put("12", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc2")));
			plugin.SPL_Block.get("12").setTypeId(0);
			
			plugin.SPL_Block.put("21", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc1")));
			plugin.SPL_Block.get("21").setTypeId(0);
			plugin.SPL_Block.put("22", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc2")));
			plugin.SPL_Block.get("22").setTypeId(0);
		}
		else {
			plugin.SPL_Block.put("11", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc1")));
			plugin.SPL_Block.get("11").setTypeId(101);
			plugin.SPL_Block.put("12", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate1Loc2")));
			plugin.SPL_Block.get("12").setTypeId(101);
			
			plugin.SPL_Block.put("21", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc1")));
			plugin.SPL_Block.get("21").setTypeId(101);
			plugin.SPL_Block.put("22", plugin.SPL_Spawn.get("Spawn1").getWorld().getBlockAt(plugin.SPL_Gate.get("Gate2Loc2")));
			plugin.SPL_Block.get("22").setTypeId(101);
		}
	}
}
