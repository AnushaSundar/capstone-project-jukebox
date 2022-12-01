/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.model;

import java.util.List;
import java.util.Objects;

public class Playlist {
    private List<Song> songId;
    private int playlistId;
    private String playlistName;

    public Playlist() {
    }

    public Playlist(int playlistId, String playlistName) {
        this.playlistId = playlistId;
        this.playlistName = playlistName;
    }


    public int getPlaylistId() {
        return playlistId;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "songId=" + songId +
                ", playlistId=" + playlistId +
                ", playlistName='" + playlistName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Playlist playlist = (Playlist) o;
        return playlistId == playlist.playlistId && Objects.equals(songId, playlist.songId) && Objects.equals(playlistName, playlist.playlistName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(songId, playlistId, playlistName);
    }
}
