package com.junkgrave.space.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Keys extends KeyAdapter {

	public static ArrayList<Integer> keys = new ArrayList<>();

	public static int indexOf(Integer keyCode) {
		for (int i = 0; i < keys.size(); ++i) {
			if (keys.get(i).equals(keyCode)) {
				return i;
			}
		}
		return -1;
	}

	public void keyPressed(KeyEvent e) {
		Integer key = e.getKeyCode();

		if (keys.contains(key)) return;

		keys.add(key);
	}

	public void keyReleased(KeyEvent e) {
		Integer key = e.getKeyCode();

		keys.remove(key);
	}
}
