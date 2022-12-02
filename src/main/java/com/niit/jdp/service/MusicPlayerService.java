/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class MusicPlayerService {
    File file;
    AudioInputStream audioInputStream;
    Clip clip;
    long currentFrame;
    String status;

    public void player(String fileName) {
        file = new File(fileName);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            play();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            int choice = 0;
            do {
                System.out.println("1.pause");
                System.out.println("2.resume");
                System.out.println("3.stop");
                System.out.println("Enter your choice");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        pause();
                        break;
                    case 2:
                        resume();
                        break;
                }
            } while (choice != 3);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
        status = "play";
    }

    public void pause() {
        this.currentFrame = clip.getMicrosecondLength();
        clip.stop();
        status = "paused";
    }

    public void resume() throws LineUnavailableException, IOException {
        this.play();
    }

    public void stop() {
        this.currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void resetAudio() throws LineUnavailableException, IOException {
        clip.open(audioInputStream);
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

}