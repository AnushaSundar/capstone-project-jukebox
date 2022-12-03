package com.niit.jdp;

import com.niit.jdp.display.SongDisplay;
import com.niit.jdp.exception.CustomException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.repository.PlaylistRepository;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        SongDisplay songDisplay = new SongDisplay();
        PlaylistRepository playlistRepository = new PlaylistRepository();
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
                    System.out.println("5.Play all songs");
                    System.out.println("6.Go to playlist");
                    System.out.println("7.Exit");
                    System.out.println("Enter your choice");
                    menuChoice = scanner.nextInt();
                    switch (menuChoice) {
                        case 1:
                            songDisplay.displayAllSongs();
                            break;
                        case 2:
                            songDisplay.searchSongByLanguage();
                            break;
                        case 3:
                            songDisplay.searchSongByGenre();
                            break;
                        case 4:
                            songDisplay.searchSongByArtist();
                            break;
                        case 5:
                            songDisplay.playAllSong();
                            break;
                        case 6:
                            List<Playlist> playlist = playlistRepository.getPlaylist();
                            playlistRepository.displayPlaylist(playlist);
                            System.out.println();
                            int option5;
                            do {
                                System.out.println("1.Select a song from playlist");
                                System.out.println("2.Select a playlist ");
                                System.out.println("3.Create Playlist");
                                System.out.println("4.Add song to playlist");
                                System.out.println("5.Delete Playlist");
                                System.out.println("6.Go to menu");
                                System.out.println("Enter your choice");
                                option5 = scanner.nextInt();
                                switch (option5) {
                                    case 1:
                                        songDisplay.selectSongFromPlaylist();
                                        break;
                                    case 2:
                                        songDisplay.selectPlaylist();
                                        break;
                                    case 3:
                                        songDisplay.createPlaylist();
                                        break;
                                    case 4:
                                        try {
                                            songDisplay.addSongsToPlaylist();
                                        } catch (CustomException e) {
                                            System.err.println(e.getMessage());
                                            System.out.println();
                                        }
                                        break;
                                    case 5:
                                        try {
                                            songDisplay.deletePlaylist();
                                        } catch (CustomException e) {
                                            System.err.println(e.getMessage());
                                            System.out.println();
                                        }
                                        break;
                                }
                            } while (option5 != 6);
                            break;
                    }
                } while (menuChoice != 7);
            }
        } while (choice != 2);
    }
}