package v0;

public class OptionGroup {
	Option[] options; 
	
	String display;
	String[] groupSoundNames;
	
	public OptionGroup(String display, Option[] oArray, String[] s){
		options = oArray.clone();
		this.display = display;
		groupSoundNames = s;
	}
	
	public String getDisplay(){
		return display;
	}
	
	public Option getOptionAt(int index){
		return options[index];
	}
	
	public String optionDialogueAt(int index){
		return options[index].getDialogue();
	}
	
	public String optionSoundNameAt(int index){
		return options[index].getSoundName();
	}
	
	public String[] getAllDialogues(){
		return new String[]{"Option 1", "Option 2", "Fuck yeah!"};
	}
	
	public int getNumOptions(){
		return options.length;
	}
	
	public String[] getSoundNames(){
		return groupSoundNames; 
	}
}
