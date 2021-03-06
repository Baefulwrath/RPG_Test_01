package ui;

import head.ProgramState;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.scenes.scene2d.Stage;

public abstract class GUI extends Stage{
	
	public GUIType type = GUIType.MENU;
	public GUIState state = GUIState.HIDDEN;
	public ProgramState programState = ProgramState.DEFAULT;
	
	public GUI(GUIType gType, ProgramState progState){
		type = gType;
		programState = progState;
	}
	
	public abstract void setup();

	public void update(){
		specificUpdate();
	}
	
	public abstract void specificUpdate();
	
	public void enter(){
		//Show, then tween in
	}
	
	public void exit(){
		//Tween out, then hide
	}
}
