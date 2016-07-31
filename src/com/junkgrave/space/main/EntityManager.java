package com.junkgrave.space.main;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class EntityManager {
	/**
	 * A list of active entities.
	 */
	private List<Entity> entities = new ArrayList<>();

	/**
	 * When adding an entity, first put it in this buffer to be added at the
	 * end of the tick.
	 */
	private Stack<Entity> entityBuffer = new Stack<>();

	public void addEntity(Entity e) {
		entityBuffer.push(e);
	}

	public void flushBuffer() {
		while ( ! entityBuffer.isEmpty()) {
			entities.add(entityBuffer.pop());
		}
	}

	public void tick() {
		for (Entity e : entities) {
			e.tick();
		}
		flushBuffer();
	}

	public void render(Graphics g) {
		for (Entity e : entities) {
			e.render(g);
		}
	}

}
