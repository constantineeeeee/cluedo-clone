package cluedo;

import java.io.*;
import java.net.*;

import javax.sound.sampled.*;

public class MusicHandling {
	Clip clip;
	//AudioInputStream ads;
	//InputStream audioSource, bufferedIn;
	
	public void setFile(URL soundFileName) {
		//audioSource = this.getClass().getResourceAsStream("/"+soundFileName);
		
		try {
			AudioInputStream ads = AudioSystem.getAudioInputStream(soundFileName);
			clip = AudioSystem.getClip();
			clip.open(ads);
			
		}catch(Exception e) {
			System.out.println("No music found");
			e.printStackTrace();
		}
		
	}
	
	public void playLoop() {
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
	}
	public void playOnce() {
		clip.start();
	}
	public void stop() throws IOException {
        //ads.close();
        clip.close();
        clip.stop();
    }
}
