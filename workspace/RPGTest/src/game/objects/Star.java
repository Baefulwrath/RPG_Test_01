package game.objects;

import game.WorldObject;

public class Star extends WorldObject {
	
	public static final int MIN_W = 512;
	public static final int MAX_W = 512;
	public static final int MIN_H = 1024;
	public static final int MAX_H = 1024;
	public static final int MIN_T = 1;
	public static final int MAX_T = 10;

	public int hue = 0;
	public int saturation = 0;
	
	public Star(int xi, int yi) {
		super(xi, yi, genSizeValue(MIN_W, MAX_W), genSizeValue(MIN_H, MAX_H), 0, false, genTemp(MIN_T, MAX_T));
	}

	@Override
	protected void subUpdate() {
	}

}
