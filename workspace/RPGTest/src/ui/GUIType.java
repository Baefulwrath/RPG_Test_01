package ui;

public enum GUIType {
	MENU, HUD;
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    public static GUIType parseType(String type){
    	GUIType temp = MENU;
    	for(int i = 0; i < values().length; i++){
    		if(type.equals(values()[i].toString())){
    			temp = values()[i];
    		}
    	}
    	return temp;
    }
}
