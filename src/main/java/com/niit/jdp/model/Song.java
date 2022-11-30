/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.Objects;

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

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public double getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(double songDuration) {
        this.songDuration = songDuration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "songId=" + songId +
                ", songName='" + songName + '\'' +
                ", genre='" + genre + '\'' +
                ", artist='" + artist + '\'' +
                ", language='" + language + '\'' +
                ", songDuration=" + songDuration +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Song song = (Song) o;
        return songId == song.songId && Double.compare(song.songDuration, songDuration) == 0 && Objects.equals(songName, song.songName) && Objects.equals(genre, song.genre) && Objects.equals(artist, song.artist) && Objects.equals(language, song.language);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, songName, genre, artist, language, songDuration);
    }
}
