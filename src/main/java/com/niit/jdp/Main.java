package com.niit.jdp;

import com.niit.jdp.display.SongDisplay;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
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
                            songDisplay.goToPlaylist();
                            break;
                    }
                } while (menuChoice != 7);
            }
        } while (choice != 2);
    }
}