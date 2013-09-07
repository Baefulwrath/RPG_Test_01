package game.objects;

import game.WorldObject;

public class Planet extends WorldObject {
	
	public static final int MIN_W = 128;
	public static final int MAX_W = 128;
	public static final int MIN_H = 256;
	public static final int MAX_H = 256;
	public static final int MIN_T = 1;
	public static final int MAX_T = 10;
	
	public int hue = 0;
	public int saturation = 0;

	public Planet(int xi, int yi, int wi, int hi) {
		super(xi, yi, genSizeValue(MIN_W, MAX_W), genSizeValue(MIN_H, MAX_H), 0, false, genTemp(MIN_T, MAX_T));
	}

	@Override
	protected void subUpdate() {
	}
	
}
