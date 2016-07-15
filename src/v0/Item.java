package v0;

public abstract class Item {
	String name; 
	Player owner;
	int ignore;
	
	public Item(String name, Player owner){
		this.name = name;
		this.owner = owner;
		ignore = 0;
	}
	
	public String getName(){
		return name;
	}
	
	public int getIgnore(){
		return ignore;
	}
	
}
