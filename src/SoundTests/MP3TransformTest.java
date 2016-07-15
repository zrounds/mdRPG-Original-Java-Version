package SoundTests;

import javazoom.jl.player.Player;
import java.io.FileInputStream;

public class MP3TransformTest {

	
	public static void main(String[] args) {
		playMP3("Takao_Kazunari_cv_Suzuki_Tatsuhisa-Catal_Rhythm(myfreemp3.eu).mp3");
		
		System.out.println("Sounds completed!");
	}

	public static void playMP3(String name){
		try {
		FileInputStream source = new FileInputStream("C:\\Users\\Zach\\Music\\"+name);
		Player playSong = new Player(source);
		playSong.play();
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
