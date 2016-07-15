package v0;
import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		//Player Definition
		Scanner c = new Scanner(System.in);
		System.out.println("Are you a boy or a girl? Type either in below [no caps]: ");
		String gender = c.next();
		boolean isMale;
		if (gender.equals("boy")){
			isMale = true;
		} else {
			isMale = false;
		}
		/*System.out.println("What class are you? (Enter : Knight, Mage, or Archer): ");
		String pClass = c.next();
		int pRole;
		if (pClass.equals("Knight")){
			pRole = 0;
		} else if(pClass.equals("Mage")){
			pRole = 1;
		} else {
			pRole =2;
		}
		*/
		Player player = new Player(isMale, 0);
		//System.out.println("You are a boy: " + player.isMale());
		
		
		
		OptionHandler script = new OptionHandler();
		script.makeDefaultGame(player);
		GameInstance game = new GameInstance(player, script);
		game.run();
		
		//game.curIndex = WHATEVER int location from the OptionGroup list in OptionHandler that you want to start from
							//such as 46, for example
		
	}

}
