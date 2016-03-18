package com.junkgrave.space.background;

import com.junkgrave.space.main.Game;
import com.junkgrave.space.main.ToolBelt;

import java.awt.*;

public class Star {
	private int x;
	private int y;
	private int velY;
	private int size;

	public Star() {
		init();
	}

	public void tick() {
		if (y > Game.height) {
			reset();
		}
		else {
			y += velY;
		}
	}

	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, size, size);
	}

	private void init() {
		size = ToolBelt.randomBetween(1, 4);
		velY = ToolBelt.randomBetween(1, 10);
		x = ToolBelt.randomBetween(0, Game.width);
		y = ToolBelt.randomBetween(0, Game.height);
	}

	private void reset() {
		size = ToolBelt.randomBetween(1, 4);
		velY = ToolBelt.randomBetween(1, 10);
		x = ToolBelt.randomBetween(0, Game.width);
		y = -1 * size;
	}
}
