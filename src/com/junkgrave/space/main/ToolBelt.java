package com.junkgrave.space.main;

import java.util.Random;

public class ToolBelt {
	public static Random rand = new Random();
	public static int randomBetween(int low, int high) {
		return rand.nextInt(high - low + 1) + low;
	}
}
