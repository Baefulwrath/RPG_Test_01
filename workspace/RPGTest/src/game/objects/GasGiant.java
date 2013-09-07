package game.objects;

import game.WorldObject;

public class GasGiant extends WorldObject {
	
	public static final int MIN_W = 256;
	public static final int MAX_W = 256;
	public static final int MIN_H = 512;
	public static final int MAX_H = 512;
	public static final int MIN_T = 1;
	public static final int MAX_T = 10;

	public int hue = 0;
	public int saturation = 0;
	
	public GasGiant(int xi, int yi) {
		super(xi, yi, genSizeValue(MIN_W, MAX_W), genSizeValue(MIN_H, MAX_H), 0, false, genTemp(MIN_T, MAX_T));
	}

	@Override
	protected void subUpdate() {
	}

}
