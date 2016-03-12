package com.junkgrave.space.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private Game game;
	private int x;
	private int y;

	private BufferedImage image;

	public Player(Game game) {
		this.game = game;

		image = game.sheet.grabImage(0, 0);

		x = 100;
		y = 100;
	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
}
