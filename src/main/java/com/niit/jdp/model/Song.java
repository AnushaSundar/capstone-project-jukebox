/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

public class Song {
    private int songId;
    private String songName;
    private String genre;
    private String artist;
    private String language;
    private double songDuration;

    public Song() {
    }

    public Song(int songId, String songName, String genre, String artist, String language, double songDuration) {
        this.songId = songId;
        this.songName = songName;
        this.genre = genre;
        this.artist = artist;
        this.language = language;
        this.songDuration = songDuration;
    }
}
