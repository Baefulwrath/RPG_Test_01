package head;

import java.util.HashMap;

import render.RenderingHandler;
import ui.UserInterfaceHandler;

import com.badlogic.gdx.ApplicationListener;

import head.modes.*;
import static head.ProgramState.*;

public class Head implements ApplicationListener {
	
	public static ProgramState state = ProgramState.DEFAULT;
	public static boolean exitProgram = false;
	public static HashMap<ProgramState, ProgramMode> modes = new HashMap<ProgramState, ProgramMode>();
	
	public Head(ProgramState startupState){
    	state = startupState;
	}
	
	@Override
	public void create() {
		setup();
		init();
	}

	public static void setup(){
		UserInterfaceHandler.setup();
		RenderingHandler.setup();
		setupModes();
	}
	
	public static void setupModes(){
		modes.put(DEFAULT, new MODE_DEFAULT(DEFAULT));
		modes.put(MENU, new MODE_MENU(MENU));
		modes.put(GAME, new MODE_GAME(GAME));
		modes.put(EDITOR, new MODE_EDITOR(EDITOR));
	}
	
	public static void init(){
		UserInterfaceHandler.init();
	}

	@Override
	public void dispose() {
		RenderingHandler.dispose();
	}

	@Override
	public void render() {
		if(exitProgram){
			exit();
		}else{
			try{
				Thread.sleep(1);
				updateSpecific();
				updateGeneral();
			}catch(Exception ex){
				ex.printStackTrace(System.out);
			}
		}
	}
	
	public void updateSpecific(){
		switch(state){
			case DEFAULT:
				modes.get(DEFAULT).update();
				break;
			case MENU:
				modes.get(MENU).update();
				break;
			case EDITOR:
				modes.get(EDITOR).update();
				break;
			case GAME:
				modes.get(GAME).update();
				break;
		}
	}
	
	public void updateGeneral(){
		RenderingHandler.render();
	}

	@Override
	public void resize(int width, int height) {
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
	
	public static void changeState(ProgramState s){
		state = s;
	}
	
	public static void changeState(String s){
		state = ProgramState.parseState(s);
	}
	
	public void exit(){
		dispose();
		System.exit(0);
	}
}
