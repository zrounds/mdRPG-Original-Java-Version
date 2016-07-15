package v0;
import javax.swing.JButton;

public class OptionButton extends JButton {

	private Option o;

	
	public OptionButton(Option o){
		super(o.getDialogue());
		this.o = o;
		
	}
	
	public Option getOption(){
		return o;
	}
	
	
}
