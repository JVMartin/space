package com.junkgrave.space.main;

import java.awt.*;
import java.util.ArrayList;
import java.util.ListIterator;

public class EntityManager {
	private ArrayList<Entity> entities = new ArrayList<>();

	public void addEntity(Entity e) {
		entities.add(e);
	}

	public void tick() {
		for (int i = 0; i < entities.size(); ++i) {
			entities.get(i).tick();
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < entities.size(); ++i) {
			entities.get(i).render(g);
		}
	}

}
