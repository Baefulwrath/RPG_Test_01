package game.objects;

import game.WorldObject;

public class Ship extends WorldObject {

	public Ship(int xi, int yi, int wi, int hi, float fric, boolean dyna) {
		super(xi, yi, wi, hi, 0, true, 0);
	}

	@Override
	protected void subUpdate() {
	}
	
}
