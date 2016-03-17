package com.junkgrave.space.main;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Player {
	private Game game;
	private int x;
	private int y;
	private int velX;

	private BufferedImage image;

	public Player(Game game) {
		this.game = game;

		image = game.sheet.grabImage(0, 0);

		x = 100;
		y = 700;
		velX = 0;
	}

	public void tick() {
		if (velX < 0 && x <= 0) {
			x = 0;
		} else if (velX > 0 && x >= game.getWidth() - 32) {
			x = game.getWidth() - 32;
		} else {
			x += velX;
		}
	}

	public void goLeft() {
		velX += -1;
	}

	public void goRight() {
		velX += 1;
	}

	public void stop() {
		velX = 0;
	}

	public void render(Graphics g) {
		g.drawImage(image, x, y, null);
	}
}
