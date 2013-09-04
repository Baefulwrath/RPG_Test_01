package head;

public class ProgramNode {
	public long lastUpdate = 0;
	public long interval = 5;
	public float deltaTime = 0;
	
	protected boolean readyToUpdate(){
		if(lastUpdate + interval <= System.currentTimeMillis()){
			deltaTime = System.currentTimeMillis() - lastUpdate;
			lastUpdate = System.currentTimeMillis();
			return true;
		}else{
			return false;
		}
	}
}
