package com.niit.jdp;

import com.niit.jdp.display.SongDisplay;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        SongRepository songRepository = new SongRepository();
        PlaylistRepository playlistRepository = new PlaylistRepository();
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        SongDisplay songDisplay = new SongDisplay();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("===================================");
            System.out.println("       Welcome To Jukebox          ");
            System.out.println("===================================");
            System.out.println();
            System.out.println("1.Go to Songs");
            System.out.println("2.Exit");
            System.out.println("Enter your choice");
            choice = scanner.nextInt();
            if (choice == 1) {
                int menuChoice;
                do {
                    System.out.println("1.Display all songs");
                    System.out.println("2.Search songs by language");
                    System.out.println("3.Search songs by genre");
                    System.out.println("4.Search songs by artist");
                    System.out.println("5.Play song");
                    System.out.println("6.Go to playlist");
                    System.out.println("7.Exit");
                    System.out.println("Enter your choice");
                    menuChoice = scanner.nextInt();
                    switch (menuChoice) {
                        case 1:
                            List<Song> allSongs = songRepository.getAllSongs();
                            songRepository.displaySongList(allSongs);
                            System.out.println("1.Play song");
                            System.out.println("2.Go to menu");
                            System.out.println("Enter your choice");
                            int option1 = scanner.nextInt();
                            songRepository.playAllSongs(allSongs);
                            if (option1 == 2)
                                break;
                        case 2:
                            System.out.println("Enter the language");
                            String language = scanner.next();
                            List<Song> songs = songRepository.searchSongByLanguage(language);
                            songRepository.displaySongList(songs);
                            System.out.println("1.Play song");
                            System.out.println("2.Go to menu");
                            System.out.println("Enter your choice");
                            int option2 = scanner.nextInt();
                            songRepository.playAllSongs(songs);
                            if (option2 == 2)
                                break;
                        case 3:
                            System.out.println("Enter the Genre");
                            String genre = scanner.next();
                            List<Song> songs2 = songRepository.searchSongByLanguage(genre);
                            songRepository.displaySongList(songs2);
                            System.out.println("1.Play song");
                            System.out.println("2.Go to menu");
                            System.out.println("Enter your choice");
                            int option3 = scanner.nextInt();
                            songRepository.playAllSongs(songs2);
                            if (option3 == 2)
                                break;
                        case 4:
                            System.out.println("Enter the Artist name");
                            String artist = scanner.next();
                            List<Song> songs3 = songRepository.searchSongByLanguage(artist);
                            songRepository.displaySongList(songs3);
                            System.out.println("1.Play song");
                            System.out.println("2.Go to menu");
                            System.out.println("Enter your choice");
                            int option4 = scanner.nextInt();
                            songRepository.playAllSongs(songs3);
                            if (option4 == 2)
                                break;
                        case 5:
                            List<Song> allSongs2 = songRepository.getAllSongs();
                            songRepository.playAllSongs(allSongs2);
                            break;
                        case 6:
                            System.out.println("1.Display playlist");
                            System.out.println("2.Create Playlist");
                            System.out.println("3.Add song to playlist");
                            System.out.println("4.Delete Playlist");
                    }
                } while (menuChoice != 7);
            }
        } while (choice != 2);
    }
}