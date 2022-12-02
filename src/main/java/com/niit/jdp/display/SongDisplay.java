/*
 * Author : Anusha
 * Date : 02-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.display;

public class SongDisplay {
    public void jukeboxDisplay() {
        System.out.println("===================================");
        System.out.println("       Welcome To Jukebox          ");
        System.out.println("===================================");
        System.out.println();
        System.out.println("1.Go to Songs");
        System.out.println("2.Exit");
    }

    public void songsDisplay() {
        System.out.println("1.Display all songs");
        System.out.println("2.Search songs by language");
        System.out.println("3.Search songs by genre");
        System.out.println("4.Search songs by artist");
        System.out.println("5.Play song");
        System.out.println("6.Go to playlist");
        System.out.println("7.create Playlist");
        System.out.println("8.Exit");
    }

    public void display() {
        System.out.println("1.Play song");
        System.out.println("2.Go to Menu");
    }
}
