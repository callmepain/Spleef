package de.callmepain.SPL;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class SPLPlayer {
	public HashMap<String, Player> SPL_Player = new HashMap<String, Player>();
	public HashMap<String, Boolean> SPL_Quite = new HashMap<String, Boolean>();
	public HashMap<String, Integer> SPL_Score = new HashMap<String, Integer>();
	public SPLPlayer(Player player, boolean quite, int Score) {
		if(SPL_Player.get("1") == null) {
			SPL_Player.put("1", player);
			SPL_Quite.put("1", quite);
			SPL_Score.put("1", Score);
		}
		else if (SPL_Player.get("2") == null) {
			SPL_Player.put("2", player);
			SPL_Quite.put("2", quite);
			SPL_Score.put("2", Score);
		}
		else if (SPL_Player.get("3") == null) {
			SPL_Player.put("3", player);
			SPL_Quite.put("3", quite);
			SPL_Score.put("3", Score);
		}
		else if (SPL_Player.get("4") == null) {
			SPL_Player.put("4", player);
			SPL_Quite.put("4", quite);
			SPL_Score.put("4", Score);
		}
		else {
			
		}
	}
	public boolean isPlayerQuite(String Count) {
		return SPL_Quite.get(Count);
	}
	public int getPlayerScore(String Count) {
		return SPL_Score.get(Count);
	}
}
