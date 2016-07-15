package v0;

public class Option {
	String dialogue;
	String alterations; 
	String narratorSound;
	int relativeShift;
	String req;
	Item itemToAdd;
	
	public Option(String dialogue, String alterations, String nSound, int shift, String req, Item toAdd){
		this.dialogue = dialogue;
		this.alterations = alterations; 
		narratorSound = nSound;
		relativeShift = shift;
		this.req = req;
		itemToAdd = toAdd;
	}
	
	public String getDialogue(){
		return dialogue;
	}
	
	public String getSoundName(){
		return alterations; 
	}
	
	public int getShift(){
		return relativeShift;
	}
	
	public String getItemReq(){
		return req;
	}
	
	public Item getItemToAdd(){
		return itemToAdd;
	}
	
	public String getNarratorSound(){
		return narratorSound;
	}
}
