package com.junkgrave.space.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

	private Game game;

	public KeyListener(Game game) {
		this.game = game;
	}

	public void keyPressed(KeyEvent e) {
		game.keyPressed(e);
	}

	public void keyReleased(KeyEvent e) {
		game.keyReleased(e);
	}
}
