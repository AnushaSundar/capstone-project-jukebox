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

    public void player(String fileName) {
        file = new File(fileName);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            int choice;
            System.out.println();
            System.out.println("Stop the song before exit!!");
            System.out.println("1.pause");
            System.out.println("2.resume");
            System.out.println("3.stop");
            System.out.println("4.exit");
            do {
                System.out.println("Enter your choice");
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        clip.stop();
                        System.out.println("song is paused.");
                        break;
                    case 2:
                        clip.start();
                        System.out.println("Song is resumed.");
                        break;
                    case 3:
                        clip.stop();
                        clip.close();
                        System.out.println("Stopped the song.");
                        System.out.println("Press 4 to exit.");
                        break;
                }
            } while (choice != 4);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}