package game.objects;

import game.WorldObject;

public class Asteroid extends WorldObject {
	
	public static final int MIN_W = 16;
	public static final int MAX_W = 16;
	public static final int MIN_H = 32;
	public static final int MAX_H = 32;
	public static final int MIN_V = 1;
	public static final int MAX_V = 10;
	public static final int MIN_T = 1;
	public static final int MAX_T = 10;
	
	public Asteroid(int xi, int yi) {
		super(xi, yi, genSizeValue(MIN_W, MAX_W), genSizeValue(MIN_H, MAX_H), genForceValue(MIN_V, MAX_V), genForceValue(MIN_V, MAX_V), 0, true, genTemp(MIN_T, MAX_T));
	}

	@Override
	protected void subUpdate() {
	}

}
