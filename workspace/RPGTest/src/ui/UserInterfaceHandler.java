package ui;

import head.ProgramNode;
import ui.handlers.*;
import ui.stages.*;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;

public class UserInterfaceHandler extends ProgramNode{
	
	private static InputMultiplexer multiP = new InputMultiplexer();
	public static InputHandler[] ih = new InputHandler[3];
	public static GUI[] GUIs = new GUI[5];
	//public static TweenManager tweenManager = new TweenManager();

	public static void setup() {
		GUIs[0] = new GUI_EDITORMENU(GUIType.MENU);
		GUIs[1] = new GUI_GAMEMENU(GUIType.MENU);
		GUIs[2] = new GUI_MAINMENU(GUIType.MENU);
		GUIs[3] = new GUI_GAMEHUD(GUIType.HUD);
		GUIs[4] = new GUI_EDITORHUD(GUIType.HUD);
		ih[0] = new INHA_DEBUG();
		ih[1] = new INHA_MENU();
		ih[2] = new INHA_GAME();
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
