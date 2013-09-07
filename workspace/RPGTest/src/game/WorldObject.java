package game;

import java.util.Random;

public abstract class WorldObject {
	public float x = 0;
	public float y = 0;
	public float w = 0;
	public float h = 0;
	private float fx = 0;
	private float fy = 0;
	private float friction = 0;
	private boolean dynamic = false;
	public int rotation = 0;

	public int temperature = 0;
	
	public WorldObject(int xi, int yi, int wi, int hi, float fric, boolean dyna, int temp){
		x = xi;
		y = yi;
		w = wi;
		h = hi;
		friction = fric;
		dynamic = dyna;
		temperature = temp;
	}
	
	public WorldObject(int xi, int yi, int wi, int hi, float fxi, float fyi, float fric, boolean dyna, int temp){
		x = xi;
		y = yi;
		w = wi;
		h = hi;
		fx = fxi;
		fy = fyi;
		friction = fric;
		dynamic = dyna;
		temperature = temp;
	}
	
	public void update(){
		physicsUpdate();
		subUpdate();
	}
	
	protected abstract void subUpdate();

	public void physicsUpdate(){
		if(dynamic){
			x += fx;
			y += fy;
			fx *= friction;
			fy *= friction;
		}
	}
	
	protected static int genSizeValue(int min, int max){
		return min + new Random().nextInt(max - min);
	}
	
	protected static float genForceValue(int min, int max){
		return (float) (new Random().nextInt(max * 2) / 100) - max + min;
	}
	
	protected static int genTemp(int min, int max){
		return new Random().nextInt(max - min) + min;
	}
}
