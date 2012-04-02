package de.callmepain.SPL;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class SPLPlayer {
	private HashMap<String, Player> SPL_Player = new HashMap<String, Player>();
	private HashMap<String, Boolean> SPL_Quite = new HashMap<String, Boolean>();
	private HashMap<String, Integer> SPL_Score = new HashMap<String, Integer>();
	public SPLPlayer(Player player, boolean quite, int Score) {
		SPL_Player.put(player.getName(), player);
		SPL_Quite.put(player.getName(), quite);
		SPL_Score.put(player.getName(), Score);
	}
	public boolean isPlayerQuite(Player player) {
		return SPL_Quite.get(player.getName());
	}
	public int getPlayerScore(Player player) {
		return SPL_Score.get(player.getName());
	}
	public void setPlayerScore(Player player, int score) {
		SPL_Score.put(player.getName(), score);
	}
	public void setPlayerQuite(Player player, boolean quite) {
		SPL_Quite.put(player.getName(), quite);
	}
}
