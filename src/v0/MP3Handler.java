package v0;
import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class MP3Handler {

	public MP3Handler(){
		super();
	}
	
	public static void playMP3(String name){
		try {
		FileInputStream source = new FileInputStream("C:\\Users\\Zach\\Music\\mdRPG\\"+name);
		Player playSong = new Player(source);
		playSong.play();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
