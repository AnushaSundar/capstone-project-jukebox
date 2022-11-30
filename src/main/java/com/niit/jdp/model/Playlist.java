/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

public class Playlist {
    private int songId;
    private int playlistId;
    private String playlistName;

    public Playlist() {
    }

    public Playlist(int songId, int playlistId, String playlistName) {
        this.songId = songId;
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }

    public int getSongId() {
        return songId;
    }

    public void setSongId(int songId) {
        this.songId = songId;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songId=" + songId +
                ", playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }
}
