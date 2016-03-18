package com.junkgrave.space.main;

import java.util.Random;

public class ToolBelt {
	public static int randomBetween(int low, int high) {
		Random rand = new Random();
		return rand.nextInt(high - low + 1) + low;
	}
}
