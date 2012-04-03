package de.callmepain.SPL;

import java.util.HashMap;
import org.bukkit.entity.Player;

public class SPLPlayer {
	private HashMap<String, Player> SPL_Player = new HashMap<String, Player>();
	private HashMap<String, Boolean> SPL_Quite = new HashMap<String, Boolean>();
	private HashMap<String, Integer> SPL_Score = new HashMap<String, Integer>();
	public SPLPlayer() {
		SPLIO.loadHash(SPL_Score, SPL.log);
	}
	public void setPlayer1(Player player) {
		SPL_Player.put("player1", player);
		SPL_Quite.put("player1", false);
		if (SPL_Score.get(player.getName()) == null) {
			SPL_Score.put(player.getName(), 0);
			SPLIO.saveHash(SPL_Score, SPL.log);
		}
	}
	public void setPlayer2(Player player) {
		SPL_Player.put("player2", player);
		SPL_Quite.put("player2", false);
		if (SPL_Score.get(player.getName()) == null) {
			SPL_Score.put(player.getName(), 0);
			SPLIO.saveHash(SPL_Score, SPL.log);
		}
	}
	public void setPlayer3(Player player) {
		SPL_Player.put("player3", player);
		SPL_Quite.put("player3", false);
		if (SPL_Score.get(player.getName()) == null) {
			SPL_Score.put(player.getName(), 0);
			SPLIO.saveHash(SPL_Score, SPL.log);
		}
	}
	public void setPlayer4(Player player) {
		SPL_Player.put("player4", player);
		SPL_Quite.put("player4", false);
		if (SPL_Score.get(player.getName()) == null) {
			SPL_Score.put(player.getName(), 0);
			SPLIO.saveHash(SPL_Score, SPL.log);
		}
	}
	public boolean getPlayerQuite(Player player) {
		return SPL_Quite.get(player.getName());
	}
	public int getPlayerScore(Player player) {
		return SPL_Score.get(player.getName());
	}
	public void setPlayerScore(Player player, int score) {
		SPL_Score.put(player.getName(), score);
		SPLIO.saveHash(SPL_Score, SPL.log);
	}
	public void setPlayerQuite(Player player, boolean quite) {
		SPL_Quite.put(player.getName(), quite);
	}
	public Player getPlayer1() {
		Player p = SPL_Player.get("player1");
		return p;
	}
	public Player getPlayer2() {
		Player p = SPL_Player.get("player2");
		return p;
	}
	public Player getPlayer3() {
		Player p = SPL_Player.get("player3");
		return p;
	}
	public Player getPlayer4() {
		Player p = SPL_Player.get("player4");
		return p;
	}
	public void reset() {
		SPL_Player = null;
		SPL_Quite = null;
	}
}