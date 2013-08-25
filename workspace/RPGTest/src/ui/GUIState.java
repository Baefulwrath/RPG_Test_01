package ui;

public enum GUIState {
	HIDDEN, VISIBLE;
    
    @Override
    public String toString() {
        return super.toString();
    }
    
    public static GUIState parseState(String type){
    	GUIState temp = HIDDEN;
    	for(int i = 0; i < values().length; i++){
    		if(type.equals(values()[i].toString())){
    			temp = values()[i];
    		}
    	}
    	return temp;
    }
}
