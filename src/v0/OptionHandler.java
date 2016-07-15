package v0;
import java.util.*;

public class OptionHandler {
	ArrayList<OptionGroup> allOptions;
	int curGroup;
	
	public OptionHandler(OptionGroup[] buildOptions){
		//int i = 0;
		for (OptionGroup o: buildOptions){
			//o.setID(i);
			allOptions.add(o);
			//i++;
		}
		curGroup = 0;
	}
	
	public OptionHandler (){
		curGroup = 0;
		allOptions = new ArrayList<OptionGroup>();
	}
	
	public OptionGroup getOGAt(int index){
		return allOptions.get(index);
	}
	
	public String getGroupDisplayAt(int index){
		return allOptions.get(index).getDisplay();
	}
	
	public String[] getAllOptionDialoguesAt(int index){
		return allOptions.get(index).getAllDialogues();
	}
	
	
	
	
	
	public void makeDefaultGame(Player player){
		Option[] options = new Option[]{new Option("Continue!","","",1,null,null)};
		OptionGroup OG1 = new OptionGroup("Welcome to the land of Burwick! Move the arrow keys to select your character. *light boop sounds for option scrolling* Each character has specific skills and traits that will be very important in the future. Be sure to select your character carefully! Begin to press the up and down arrow keys to hear the description of each character! When you have made your decision, press the space key. If at any time in the story you need to hear something again, press the backspace key.", options, new String[] {"s1\\1"});
		
		options = new Option[]{new Option("Knight","","s1\\2",1,null,new ChangeClass(player, 0)),new Option("Mage","","s1\\3",1,null,new ChangeClass(player, 1)),new Option("Archer","","s1\\4",1,null,new ChangeClass(player, 2))};
		OptionGroup OG2 = new OptionGroup("Select your character!", options,new String[] {"s1\\8"});
		
		options = new Option[]{new Option("Yes","","s1\\6",1,null,null),new Option("No","","s1\\7",-1,null,null)};
		OptionGroup OG3 = new OptionGroup("Are you sure", options,new String[] {"s1\\5"});
		
		String gender;
		if (player.isMale()){
			gender = "b";
		} else {
			gender = "g";
		}
		
		options = new Option[]{new Option("Call for help.","s1\\15"+gender,"s1\\11",2,null,null),new Option("Try to get up.","s1\\16"+gender,"s1\\12",2,null,null),new Option("Groan!","s1\\17"+gender,"s1\\13",2,null,null),new Option("Examine the bed you are in.","","s1\\14",1,null,null)};
		OptionGroup OG4 = new OptionGroup("You are in a room alone. What would you like to do?",options,new String[] {"s1\\9"+gender, "s1\\10"});
		
		options = new Option[]{new Option("Remove the towel.","s1\\23"+gender,"s1\\19",1,null,null), new Option("Call for help.","s1\\24"+gender,"s1\\20",1,null,null),new Option("Groan!","s1\\26","s1\\22",1,null,null), new Option("Try to get up.","s1\\25","s1\\21",1,null,null)};
		OptionGroup OG5 = new OptionGroup("The bed seems normal.", options, new String[]{"s1\\18"});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG6 = new OptionGroup("Ah, you've awoken!", options, new String[]{"s1\\27","s1\\28"+gender,"s1\\29", "s1\\30"+gender, "s1\\31", "s1\\32"+gender, "s1\\33", "s1\\34"+gender});
		
		options = new Option[]{new Option("Try to get back in bed.","s1\\39","s1\\36",1,null,null),new Option("Follow the man outside.","","s1\\37",3,null,null),new Option("Examine the room you are in.","","s1\\38",2,null,null)};
		OptionGroup OG7 = new OptionGroup("That was quite some bump on the head then!",options,new String[]{"s1\\35"});
		
		options = new Option[]{new Option("Follow the man outside.","","s1\\37",3,null,null),new Option("Examine the room you are in.","","s1\\38",1,null,null)};
		OptionGroup OG8 = new OptionGroup("Come on then, you've been sleeping for days!",options,new String[]{"s1\\39"});
		
		options = new Option[]{new Option("Keep examining the room.","","s1\\43",1,null,null),new Option("Search the chests.","s1\\52","s1\\44",2,null,new Crowbar(player)),new Option("Look in your bag.","s1\\55"+gender,"s1\\45",2,null,null),new Option("Follow Oliver outside.","","s1\\42",2,null,null)};
		OptionGroup OG9 = new OptionGroup("The room is quite typical.",options,new String[]{"s1\\40", "s1\\41"});
		
		options = new Option[]{new Option("Yes","s1\\49","s1\\47",1,null,new Apple(player)),new Option("No.","","s1\\48",1,null,null)};
		OptionGroup OG10 = new OptionGroup("There are two apples on the table. Do you want them?",options, new String[]{"s1\\46"});
		
		char pClass;
		int temp = player.getPlayerRole();
		
		if (temp == 0){
			pClass = 'w';
		} else if(temp == 1){
			pClass = 'm';
		} else {
			pClass = 'a';
		}
		options = new Option[]{new Option("Follow Oliver outside.","","s1\\51",2,null,null)};
		OptionGroup OG11 = new OptionGroup("Come on, you're burning daylight!",options, new String[]{"56"+pClass,"s1\\50"});
		
		options = new Option[]{new Option("Follow Oliver outside.","","s1\\51",1,null,null)};
		OptionGroup OG12 = new OptionGroup("Come on, you're burning daylight!",options, new String[]{"s1\\50"});
		
		options = new Option[]{new Option("Talk to fruit vendor.","","s2\\5",1,null,null),new Option("Talk to lost child.","","s2\\6",2,null,null),new Option("Talk to distressed woman.","","s2\\7",3,null,null),new Option("Keep looking for more interesting people","","s2\\8",1,null,null)};
		OptionGroup OG13 = new OptionGroup("Ah, what a wonderful town!", options, new String[]{"s2\\1","s2\\2","s2\\3","s2\\4"});
		
		options = new Option[]{new Option("Continue.","","continue",-1,null,null)};
		OptionGroup OG14 = new OptionGroup("The apple vendor babbles, but gives you an apple!",options, new String[]{"s2\\9","s2\\10","s2\\11"});
		
		options = new Option[]{new Option("Take the girl to her mother.","s2\\15"+gender,"s2\\13",2,null,null), new Option("Leave","","s2\\14",-2,null,null)};
		OptionGroup OG15 = new OptionGroup("Do you know where my mommy is? *sniffle*",options, new String[]{"s2\\12"});
		
		options = new Option[]{new Option("Take her to the little girl.","s2\\22"+gender,"s2\\20",1,null,null), new Option("Leave.","","s2\\21",-3,null,null)};
		OptionGroup OG16 = new OptionGroup("Have you seen my little girl?",options, new String[]{"s2\\19"});
		
		options = new Option[]{new Option("Keep looking for more interesting people.","","s2//8",1,null,new Gold(player))};
		OptionGroup OG17 = new OptionGroup("The girl and mother are reunited! AND you got some gold!",options, new String[]{"s2\\23","s2\\24", "s2\\25"});
		
		options = new Option[]{new Option("Talk to beggar.","","",2,null,null),new Option("Talk to busy gentleman.","","s2\\38",3,null,null),new Option("Talk to the classy lady.","","s2\\41",4,null,null),new Option("Talk to really nice lady.","","s2\\44",5,null,null),new Option("Go find Oliver.","","s2\\46",6,null,null)};
		OptionGroup OG18 = new OptionGroup("There are a whole lot of interesting people running about!",options, new String[]{"s2\\26","s2\\27","s2\\28","s2\\29"});
		
		options = new Option[]{new Option("Talk to beggar.","","",1,null,null),new Option("Talk to busy gentleman.","","s2\\38",2,null,null),new Option("Talk to the classy lady.","","s2\\41",3,null,null),new Option("Talk to really nice lady.","","s2\\44",4,null,null),new Option("Go find Oliver.","","s2\\46",5,null,null)};
		OptionGroup OG19 = new OptionGroup("There are still interesting people about.",options, new String[]{});
		
		options = new Option[]{new Option("Give him food.","s2\\35","s2\\33",-1,null,null),new Option("Give him coin.","s2\\35","s2\\34",-1,null,null), new Option("Give him nothing.","s2\\37","s2\\36",-1,null,null)};
		OptionGroup OG20 = new OptionGroup("The beggar asks for food or coin. What do you do?",options, new String[]{"s2\\31","s2\\32"});
		
		options = new Option[]{new Option("Continue.","","continue",-2,null,new Gold(player))};
		OptionGroup OG21 = new OptionGroup("He brushes you off, but drops some coin accidentally as well!",options, new String[]{"s2\\39","s2\\40"});
		
		options = new Option[]{new Option("Continue.","","continue",-3,null,null)};
		OptionGroup OG22 = new OptionGroup("She is classy, but also quite rude!",options, new String[]{"s2\\43"});
		
		options = new Option[]{new Option("Continue.","","continue",-4,null,null)};
		OptionGroup OG23 = new OptionGroup("She seems to think she knows you...",options, new String[]{"s2\\45"});
		
		options = new Option[]{new Option("Follow Oliver.","","s2\\2",1,null,null), new Option("Do nothing.","s2\\4","s2\\3",1,null,null)};
		OptionGroup OG24 = new OptionGroup("You find Oliver; it appears this is a commotion somewhere nearby.",options, new String[]{"s3\\1"});
		
		options = new Option[]{new Option("Continue! Quickly!","","",1,null,null)};
		OptionGroup OG25 = new OptionGroup("It appears that the king is coming! There is quite a commotion, and something seems off...",options, new String[]{"s3\\extra 1","s3\\extra 2","s3\\extra 3","s3\\extra 4","s3\\5","s3\\7","s3\\8","s3\\extra 7","s3\\extra 8","s3\\9"});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG26 = new OptionGroup("The king has been kidnapped! That man who took him seemed somehow familiar...",options, new String[]{"s3\\11"+pClass,"s3\\12","s3\\13"+gender,"s3\\14","s3\\15"+gender});
		
		options = new Option[]{new Option("Yes!","","s3\\19y",1,null,null), new Option("No.","s3\\20","s3\\19n",0,null,null)};
		OptionGroup OG27 = new OptionGroup("",options, new String[]{"s3\\16","s3\\17"+gender,"s3\\18"});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG28 = new OptionGroup("You set off with Oliver, who is very pleased for your help.",options, new String[]{"s4\\1"});
		
		options = new Option[]{new Option("Yes. [PAY ATTENTION IF THEY CLICK THIS, IT WILL ONLY LOOP THIS QUESTION; JUST TELL THEM TO GET UP IF THEY REALLY WANT TO QUIT!]","","s4\\3y",0,null,null), new Option("No!","","s4\\3n",1,null,null)};
		OptionGroup OG29 = new OptionGroup("Would you like to quit the game?",options, new String[]{"s4\\2"});
		
		options = new Option[]{new Option("Examine the room.","","s5\\2",1,null,null)};
		OptionGroup OG30 = new OptionGroup("Finally, we've made it! Perhaps I'm celebrating too soon?",options, new String[]{"s4\\4", "s5\\1"});
		
		options = new Option[]{new Option("Examine door.","","s5\\4",3,null,null), new Option("Examine lift.","","s5\\5",1,null,null)};
		OptionGroup OG31 = new OptionGroup("There is a door and a decrepit lift.",options, new String[]{"s5\\3"});
		
		options = new Option[]{new Option("Try the door instead.","","s5\\4",2,null,null),new Option("Try to open it with the crowbar.","","s5\\7",1,"Crowbar",null)};
		OptionGroup OG32 = new OptionGroup("The lift appears to work, despite the disrepair; if only we could open it...",options, new String[]{"s5\\6"});
		
		options = new Option[]{new Option("Continue.","s6\\1","continue",9,null,null)};
		OptionGroup OG33 = new OptionGroup("It opened! You pull yourselves up with a pulley.",options, new String[]{"s5\\11"});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG34 = new OptionGroup("You and Oliver head through the door and discuss how he has been here before and how it is more and more strangely familiar to you...",options, new String[]{"s5\\12", "s5\\13"+gender, "s5\\14", "s5\\15"+gender, "s5\\16"});
		
		options = new Option[]{new Option("Try to open door.","","s5\\19",2,null,null), new Option("Examine room.","","s5\\20",1,null,null)};
		OptionGroup OG35 = new OptionGroup("You reach the end of the hall; a dog is guarding the only door!",options, new String[]{"s5\\18","s5\\17"});
		
		options = new Option[]{new Option("Try to go through the door.","","s5\\22",1,null,null),new Option("Examine ice box.","","s5\\23",2,null,null)};
		OptionGroup OG36 = new OptionGroup("You notice there is something shiny around the dog's neck as well as an icebox in the room.",options, new String[]{"s5\\21"});
		
		options = new Option[]{new Option("Continue.","","continue",-1,null,null)};
		OptionGroup OG37 = new OptionGroup("Oi, what are you doing, mate? Back away!",options, new String[]{"s5\\24"});
		
		options = new Option[]{new Option("Try to go through the door.","","s5\\22",1,null,null),new Option("Give steak to dog.","","s5\\27",2,null,null)};
		OptionGroup OG38 = new OptionGroup("You found a steak!",options, new String[]{"s5\\25"});
		
		options = new Option[]{new Option("Continue.","","continue",-1,null,null)};
		OptionGroup OG39 = new OptionGroup("Oi, what are you doing, mate? Back away!",options, new String[]{"s5\\24"});
		
		options = new Option[]{new Option("Examine the dog.","s5\\35","s5\\32",1,null,null), new Option("Try to go through the door","s5\\33","s5\\30",0,null,null),new Option("Examine the ice box.","s5\\34","s5\\31",0,null,null)};
		OptionGroup OG40 = new OptionGroup("The dog is eating the steak now.",options, new String[]{"s5\\29"});
		
		options = new Option[]{new Option("Continue.","","continue",-1,null,null)};
		OptionGroup OG41 = new OptionGroup("The key from the dog's neck allows you through the door, and you continue up.",options, new String[]{"s5\\37","s5\\38"});
		
		options = new Option[]{new Option("Walk over to the man.","","s6\\9a",2,null,null), new Option("Stay hidden.","","s6\\9b",1,null,null)};
		OptionGroup OG42 = new OptionGroup("You continue your travels up, and Oliver postulates as to why the dungeon might be familiar to you.",options, new String[]{"s6\\1","s6\\2"+gender,"s6\\3","s6\\4"+gender,"s6\\5","s6\\6"+gender,"s6\\7","s6\\8"});
		
		options = new Option[]{new Option("Walk over to the man","","s6\\9a",1,null,null)};
		OptionGroup OG43 = new OptionGroup("I know you're here!",options, new String[]{"s6\\9c"});
		
		options = new Option[]{new Option("Continue.","s6\\13"+gender,"continue",1,null,null)};
		OptionGroup OG44 = new OptionGroup("You show yourself; the man seems to know your name and identity!",options, new String[]{"s6\\10"+gender, "s6\\11"+gender, "s6\\12"+gender});
		
		options = new Option[]{new Option("Challenge him to a fight!","s6\\20"+gender,"s6\\19a",2,null,null), new Option("Give the man your gold.","s6\\19d","s6\\19c",1,"Gold",null)};
		OptionGroup OG45 = new OptionGroup("The man taunts you with veiled details about your identity.",options, new String[]{"s6\\14"+gender+pClass,"s6\\15"+gender, "s6\\16", "s6\\17"+gender,"s6\\18"});
		
		options = new Option[]{new Option("Walk over to the man","","s6\\9a",2,null,null)};
		OptionGroup OG46 = new OptionGroup("You gave the man your gold and he left you.",options, new String[]{"s6\\19e"+gender});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG47 = new OptionGroup("He readily accept your challenge!",options, new String[]{"s6\\21","s6\\23"+gender,"s6\\22"});
		
		options = new Option[]{new Option("Examine bookshelf.","","s7\\5",1,null,null),new Option("Examine dresser.","","s7\\6",5,null,null),new Option("Examine board.","","s7\\7",7,null,null)};
		OptionGroup OG48 = new OptionGroup("The pair continues on their way once more, only to find yet another locked door!",options, new String[]{"s7\\1"+gender, "s7\\2"+gender,"s7\\3","s7\\4"});
		
		options = new Option[]{new Option("Take the key orb.","","s7\\9",1,null,null),new Option("Examine dresser.","","s7\\6",4,null,null),new Option("Examine board.","","s7\\7",6,null,null)};
		OptionGroup OG49 = new OptionGroup("There's a key in an orb on that bookshelf!",options, new String[]{"s7\\8"});
		
		options = new Option[]{new Option("Replace orb and paperweight!","","s7\\24",4,"Paperweight",null),new Option("Examine dresser.","","s7\\6",2,null,null),new Option("Examine board.","","s7\\7",3,null,null)};
		OptionGroup OG50 = new OptionGroup("There's a key in an orb on that bookshelf!",options, new String[]{"s7\\12"});
		
		options = new Option[]{new Option("Smash the orb with the hammer!","","s7\\28",6,"Hammer",null)};
		OptionGroup OG51 = new OptionGroup("You now have the orb! But how to get the key...",options, new String[]{"s7\\27"});
		
		options = new Option[]{new Option("Continue","s7\\33"+gender,"continue",6,null,null)};
		OptionGroup OG52 = new OptionGroup("You've gotten the key! The door is finally unlocked.",options, new String[]{"s7\\29"});
		
		options = new Option[]{new Option("Take paperweight.","","s7\\14",-3,null,new Paperweight(player))};
		OptionGroup OG53 = new OptionGroup("You open all the drawers. You find a paperweight",options, new String[]{"s7\\13"});
		
		options = new Option[]{new Option("Examine beam.","","s7\\16",1,null,null)};
		OptionGroup OG54 = new OptionGroup("You replace the key orb and paperweight, gaining the orb.",options, new String[]{"s7\\27"});
		
		options = new Option[]{new Option("Take hammer.","s7\\22","s7\\18",-4,null,new Hammer(player)), new Option("Take black box.","","s7\\19",1,null,null)};
		OptionGroup OG55 = new OptionGroup("The beam has a black box and hammer on it. Removing one will let the other fall into a hole.",options, new String[]{"s7\\17"});
		
		options = new Option[]{new Option("Continue.","","continue",2,null,null)};
		OptionGroup OG56 = new OptionGroup("The box contained the key! On, forward!",options, new String[]{"s7\\23", "s7\\33"+gender});
		
		options = new Option[]{new Option("Continue.","","continue",1,null,null)};
		OptionGroup OG57 = new OptionGroup("The key in the orb is now yours, the door is open, and you're on your way!",options, new String[]{"s7\\29","s7\\33"+gender});
		
		options = new Option[]{new Option("Continue.","","s8\\5",1,null,null)};
		OptionGroup OG58 = new OptionGroup("Oliver dismisses your worries about your past as you head up to Christoff.",options, new String[]{"s8\\1"+gender,"s8\\2"+gender,"s8\\3"+gender,"s8\\4"+gender});
		
		options = new Option[]{new Option("Continue.","","s8\\5",1,null,null)};
		OptionGroup OG59 = new OptionGroup("Christoff shows himself, reveals your past, and attempts to fight you!",options, new String[]{"s8\\6","s8\\7"+gender,"s8\\8"+gender+pClass, "s8\\9"+gender+pClass,"s8\\10"+pClass, "s8\\11"});
		
		String tempArcher = "";
		String tempArcher2 ="";
		if (pClass == 'a'){
			tempArcher = "s9\\6a";
			if (gender == "b"){
				tempArcher2 = "7ba";
			} else {
				tempArcher2 = "7ga";
			}
		}
		options = new Option[]{new Option("Continue.","","s8\\5",1,null,null)};
		OptionGroup OG60 = new OptionGroup("Christoff is defeated.",options,new String[]{"s8\\12","s9\\1"+gender,"s9\\2", "s9\\3"+gender+pClass, "s9\\4"+gender+pClass, "s9\\5"+gender+pClass, tempArcher, tempArcher2});
		
		options = new Option[]{new Option("Continue.","","s8\\5",1,null,null)};
		OptionGroup OG61 = new OptionGroup("Christoff is defeated.",options,new String[]{"s9\\9", "s9\\10","s9\\11"+gender,"s9\\12"+gender,"s9\\13"+gender,"s9\\14","s9\\15"+gender+pClass,"s9\\16"+gender+pClass,"s9\\17"+pClass, "s9\\18"+gender+pClass,"s9\\19w","s9\\20","s9\\21"+gender,"s9\\22"+gender,"s9\\23"+gender,"s9\\24","s9\\25", "s9\\26"+gender,"s9\\27"+gender,"s9\\28"+gender,"s9\\29"+pClass,"s9\\30"+gender+pClass,"s9\\31"+gender+pClass,"s9\\32"+gender+pClass,"s9\\33"+pClass,"s9\\35"+pClass, "s9\\35"+gender+pClass,"s9\\36"+pClass,"s9\\36"+gender+pClass,"s9\\37"+gender+pClass, "s9\\37w","s9\\38"+pClass,"s9\\39a","s9\\39"+gender+pClass,"s9\\40"+gender+pClass, "s9\\40w","s9\\41"+gender+pClass,"s9\\42"+gender+pClass,"s9\\43ga"});
		
		options = new Option[]{new Option("Continue.","","s8\\5",0,null,null)};
		OptionGroup OG62 = new OptionGroup("Repeating the ending...", options, new String[]{"s9\\41"+gender+pClass,"s9\\42"+gender+pClass,"s9\\43ga"});
		
		OptionGroup[] allGroups = new OptionGroup[]{OG1, OG2, OG3, OG4, OG5, OG6, OG7, OG8, OG9, OG10, OG11, OG12, OG13, OG14, OG15, OG16, OG17, OG18, OG19, OG20, OG21, OG22, OG23, OG24, OG25, OG26, OG27, OG28, OG29, OG30, OG31, OG32, OG33, OG34, OG35, OG36, OG37, OG38, OG39, OG40, OG41, OG42, OG43, OG44, OG45, OG46, OG47, OG48, OG49, OG50, OG51, OG52, OG53, OG54, OG55, OG56, OG57, OG58, OG59, OG60, OG61, OG62};
		
		
		//Add in the now default script
		//allOptions.clear();
		
		for (OptionGroup o: allGroups){
			allOptions.add(o);
		}
	}
}
