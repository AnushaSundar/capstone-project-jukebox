package com.niit.jdp;

import com.niit.jdp.model.Song;
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
            System.out.println("enter the name:");
            String name = scanner.next();
            List<Song> songs = songRepository.searchSongByLanguage(name);
            songRepository.displaySongList(songs);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}