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
            while (true) {
                display();
            }
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public void play() {
        clip.start();
        status = "play";
    }

    public void pause() {
        this.currentFrame = this.clip.getMicrosecondLength();
        clip.stop();
        status = "paused";
    }

    public void resume() {
        clip.close();
        clip.setMicrosecondPosition(currentFrame);
        this.play();
    }

    public void stop() {
        this.currentFrame = 0L;
        clip.stop();
        clip.close();
    }

    public void display() {
        System.out.println("1.stop");
        System.out.println("2.pause");
        System.out.println("3.play");
        System.out.println("4.exit");
        System.out.println("Enter your choice");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                stop();
                break;
            case 2:
                pause();
                break;
            case 3:
                play();
                break;
        }
    }
}