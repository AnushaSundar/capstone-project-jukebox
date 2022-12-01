/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayerService {
    File file;
    AudioInputStream audioInputStream;
    Clip clip;

    public void play(String path) {
        file = new File(path);
        try {
            audioInputStream = AudioSystem.getAudioInputStream(file);
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000L);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                 InterruptedException exception) {
            exception.printStackTrace();
        }
    }

}
