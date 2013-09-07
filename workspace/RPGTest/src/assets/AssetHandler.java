package assets;

import head.Head;

import java.util.HashMap;
import java.util.Scanner;

import com.badlogic.gdx.Gdx;

public class AssetHandler {
	
	public static void setup(){
		load();
	}
	
	public static void load(){
		try{
			loadShipAssets();
		}catch(Exception ex){
			ex.printStackTrace(System.out);
			System.exit(0);
		}
	}
	
	public static void loadShipAssets() throws Exception{
	}
	
	public static void init(){
		
	}
	
	public static void update(){
		
	}
	
	public static void dispose(){
		
	}
}
