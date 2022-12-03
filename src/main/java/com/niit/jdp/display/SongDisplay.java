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

    public void searchSongByGenre() {
        System.out.println("Enter the Genre");
        String genre = scanner.next();
        List<Song> songs2 = songRepository.searchSongByGenre(genre);
        songRepository.displaySongList(songs2);
        int option3 = 0;
        do {
            System.out.println("1.Play all songs");
            System.out.println("2.Select song");
            System.out.println("3.Go to menu");
            System.out.println("Enter your choice");
            option3 = scanner.nextInt();
            if (option3 == 1) {
                songRepository.playAllSongs(songs2);
            } else if (option3 == 2) {
                System.out.println("Enter the song Id: ");
                int songId = scanner.nextInt();
                Song song = songRepository.getSong(songId);
                songRepository.playSong(song);
            }
        } while (option3 != 3);
    }

    public void searchSongByArtist() {
        System.out.println("Enter the Artist name");
        String artist = scanner.next();
        List<Song> songs3 = songRepository.searchSongByArtist(artist);
        songRepository.displaySongList(songs3);
        int option4 = 0;
        do {
            System.out.println("1.play all songs");
            System.out.println("2.Select song");
            System.out.println("3.Go to menu");
            System.out.println("Enter your choice");
            option4 = scanner.nextInt();
            if (option4 == 2) {
                System.out.println("Enter the song_id");
                int id2 = scanner.nextInt();
                Song song = songRepository.getSong(id2);
                songRepository.playSong(song);
            } else if (option4 == 1) {
                songRepository.playAllSongs(songs3);
            }
        } while (option4 != 3);
    }

    public void playAllSong() {
        List<Song> allSongs2 = songRepository.getAllSongs();
        songRepository.playAllSongs(allSongs2);
    }
}
