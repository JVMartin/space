package com.junkgrave.space.background;

import java.awt.*;

public class Stars {

	private Star[] stars;

	public Stars(int numberOfStars) {
		stars = new Star[numberOfStars];
		for (int i = 0; i < stars.length; ++i) {
			stars[i] = new Star();
		}
	}

	public void tick() {
		for (Star star : stars) {
			star.tick();
		}
	}

	public void render(Graphics g) {
		for (Star star : stars) {
			star.render(g);
		}
	}
}
