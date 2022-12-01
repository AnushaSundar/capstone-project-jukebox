/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import java.util.Scanner;

public class PlaylistRepository {
    public void createPlaylist() {
        System.out.println("Create your playlist here");
        System.out.println("Enter your playlist Name : ");
        Scanner scanner = new Scanner(System.in);
        String playlistName = scanner.next();
        System.out.println("Enter the song Id ");
        int songId = scanner.nextInt();

    }

    public void displaySongs() {
    }
}
