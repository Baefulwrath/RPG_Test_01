package ui;

import ui.stages.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public class UserInterfaceHandler {
	
	private static InputMultiplexer multiP = new InputMultiplexer();
	public static InputHandler[] ih = new InputHandler[2];
	public static GUI[] GUIs = new GUI[5];

	public static void setup() {
		GUIs[0] = new GUI_EDITORMENU(GUIType.MENU);
		GUIs[1] = new GUI_GAMEMENU(GUIType.MENU);
		GUIs[2] = new GUI_MAINMENU(GUIType.MENU);
		GUIs[3] = new GUI_GAMEHUD(GUIType.HUD);
		GUIs[4] = new GUI_EDITORHUD(GUIType.HUD);
	}
	
	public static void init() {
		for(int i = 0; i < GUIs.length; i++){
			multiP.addProcessor(GUIs[i]);
		}
		for(int i = 0; i < ih.length; i++){
			multiP.addProcessor(ih[i]);
		}
		Gdx.input.setInputProcessor(multiP);
	}
	
	public static void update() {
		for(int i = 0; i < GUIs.length; i++){
			GUIs[i].update();
		}
	}
	
	public static void render(){
		for(int i = 0; i < GUIs.length; i++){
			if(GUIs[i].state == GUIState.VISIBLE){
				GUIs[i].draw();
			}
		}
	}
	
}
