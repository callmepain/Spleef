package de.callmepain.SPL;

public class SPLState {
	boolean game;
	boolean close;
	boolean running;
	public SPLState(boolean start) {
		game = start;
		close = start;
		running = start;
	}
	
}
