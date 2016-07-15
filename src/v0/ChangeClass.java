package v0;

public class ChangeClass extends Item{
	
	public ChangeClass(Player p, int role){
		super("ChangeClass",p);
		ignore = role;
	}
}
