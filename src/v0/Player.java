package v0;
import java.util.*;

public class Player {

	//Are we taking in a name? I suppose not.
	private int maxHP;
	private int curHP;
	private int playerRole;
	private boolean isMale; 
	private ArrayList<Item> inventory = new ArrayList<Item>();; 
	
	Player (boolean isMale, int pRole){
		playerRole = pRole;
		if (pRole == 0){
			maxHP = 4;
		} else if(pRole == 1) {
			maxHP = 2;
		} else {
			maxHP = 3;
		}
		curHP = maxHP;
		this.isMale = isMale;
	}
	
	public int getCurHP(){
		return curHP;
	}
	
	public int getMaxHP(){
		return maxHP;
	}
	
	public int getPlayerRole(){
		return playerRole;
	}
	
	public void setPRole(int role){
		playerRole = role;
	}
	
	public void getHit(){
		curHP -= 1;
		if (curHP == 0){
			//END THE GAME OR W/E
		}
	}
	
	public boolean isMale(){
		return isMale;
	}
	
	public void addToInventory(Item item){
		inventory.add(item);
	}
	
	public void removeFromInventory(Item item){
		inventory.remove(item);
	}
	
	public boolean checkInventory(String item){
		for (Item i: inventory){
			if (i.getName().equals(item)){
				return true;
			}
		}
		return false;
	}
	
	public Item checkInventoryItem(String item){
		for (Item i: inventory){
			if (i.getName().equals(item)){
				return i;
			}
		}
		return null;
	}
	
	

}
