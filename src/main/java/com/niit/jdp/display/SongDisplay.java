/*
 * Author : Anusha
 * Date : 02-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.display;

import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SongDisplay {
    SongRepository songRepository;
    Scanner scanner = new Scanner(System.in);

    {
        try {
            songRepository = new SongRepository();
            PlaylistRepository playlistRepository = new PlaylistRepository();
            MusicPlayerService musicPlayerService = new MusicPlayerService();
            SongDisplay songDisplay = new SongDisplay();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void displayAllSongs() {
        List<Song> allSongs = songRepository.getAllSongs();
        songRepository.displaySongList(allSongs);
        int option1 = 0;
        do {
            System.out.println("1.Play all songs");
            System.out.println("2.Select song");
            System.out.println("3.Go to menu");
            System.out.println("Enter your choice");
            option1 = scanner.nextInt();
            if (option1 == 1) {
                songRepository.playAllSongs(allSongs);
            } else if (option1 == 2) {
                System.out.println("Enter the song Id: ");
                int songId = scanner.nextInt();
                Song song = songRepository.getSong(songId);
                songRepository.playSong(song);
            }
        } while (option1 != 3);
    }

    public void searchSongByLanguage() {
        System.out.println("Enter the language");
        String language = scanner.next();
        List<Song> songs = songRepository.searchSongByLanguage(language);
        songRepository.displaySongList(songs);
        int option2 = 0;
        do {
            System.out.println("1.Play all songs");
            System.out.println("2.Select song");
            System.out.println("3.Go to menu");
            System.out.println("Enter your choice");
            option2 = scanner.nextInt();
            if (option2 == 1) {
                songRepository.playAllSongs(songs);
            } else if (option2 == 2) {
                System.out.println("Enter the song Id: ");
                int songId = scanner.nextInt();
                Song song = songRepository.getSong(songId);
                songRepository.playSong(song);
            }
        } while (option2 != 3);
    }
}
