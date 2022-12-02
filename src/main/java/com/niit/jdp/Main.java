package com.niit.jdp;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            SongRepository songRepository = new SongRepository();
            List<Song> allSongs = songRepository.getAllSongs();
//            System.out.println("enter the name:");
//            String name = scanner.next();
//            List<Song> songs = songRepository.searchSongByLanguage(name);
//            songRepository.displaySongList(songs);
            PlaylistRepository playlistRepository = new PlaylistRepository();
            System.out.println("Enter the playlist Id:");
            int playlistId = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the songs ids separate them with comma ',':");
            String songIds = scanner.nextLine();
//            Playlist playlistId = playlistRepository.createPlaylist(name);
//            System.out.println("Id of your playlist is : "+playlistId.getPlaylistId());
            boolean addedSongs = playlistRepository.addSongsToPlaylist(songIds, playlistId);
            if (addedSongs) {
                System.out.println("added to playlist");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}