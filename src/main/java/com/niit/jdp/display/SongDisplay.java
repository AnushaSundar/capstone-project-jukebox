/*
 * Author : Anusha
 * Date : 02-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.display;

import com.niit.jdp.exception.CustomException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.repository.PlaylistRepository;
import com.niit.jdp.repository.SongRepository;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SongDisplay {
    SongRepository songRepository;
    PlaylistRepository playlistRepository;
    MusicPlayerService musicPlayerService;
    Scanner scanner = new Scanner(System.in);

    public SongDisplay() throws SQLException {
        songRepository = new SongRepository();
        playlistRepository = new PlaylistRepository();
        musicPlayerService = new MusicPlayerService();
    }

    public void displayAllSongs() {
        List<Song> allSongs = songRepository.getAllSongs();
        songRepository.displaySongList(allSongs);
        System.out.println();
        int option1;
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
        System.out.println();
        int option2;
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
        System.out.println();
        int option3;
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
        System.out.println();
        int option4;
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

    public void selectSongFromPlaylist() throws CustomException {
        System.out.println("Enter the playlist_id :");
        int playlistId = scanner.nextInt();
        List<Song> songsFromSelectedPlaylist = playlistRepository.getAllSongsFromPlaylist(playlistId);
        boolean empty = songsFromSelectedPlaylist.isEmpty();
        songRepository.displaySongList(songsFromSelectedPlaylist);
        System.out.println();
        System.out.println("Enter the song_id");
        int songId = scanner.nextInt();
        Song aSongFromPlaylist = playlistRepository.getASongFromPlaylist(songId, playlistId);
        songRepository.playSong(aSongFromPlaylist);
    }

    public void selectPlaylist() {
        System.out.println("Your playlist !!");
        List<Playlist> playlist = playlistRepository.getPlaylist();
        playlistRepository.displayPlaylist(playlist);
        System.out.println();
        System.out.println("Enter the playlist_id");
        int playlistId2 = scanner.nextInt();
        List<Song> songsFromPlaylist = null;
        try {
            songsFromPlaylist = playlistRepository.getAllSongsFromPlaylist(playlistId2);
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
        songRepository.displaySongList(songsFromPlaylist);
        int option6;
        do {
            System.out.println("1.Play all song");
            System.out.println("2.Select song");
            System.out.println("3.Go to menu");
            System.out.println("Enter your choice");
            option6 = scanner.nextInt();
            if (option6 == 1) {
                songRepository.playAllSongs(songsFromPlaylist);
            } else if (option6 == 2) {
                System.out.println("Enter the song_id");
                int id2 = scanner.nextInt();
                Song song = songRepository.getSong(id2);
                songRepository.playSong(song);
            }
        } while (option6 != 3);
    }

    public void createPlaylist() {
        System.out.println("Enter the playlist name: ");
        String name = scanner.next();
        Playlist playlist1 = playlistRepository.createPlaylist(name);
        System.out.println("successfully created your playlist.");
        System.out.println("Your playlist id is: " + playlist1.getPlaylistId());
        System.out.println();
    }

    public void addSongsToPlaylist() throws CustomException {
        List<Song> allSongs = songRepository.getAllSongs();
        songRepository.displaySongList(allSongs);
        System.out.println();
        System.out.println("Your playlist !!");
        List<Playlist> playlist = playlistRepository.getPlaylist();
        playlistRepository.displayPlaylist(playlist);
        System.out.println("Enter the playlist_id : ");
        int playlistId1 = scanner.nextInt();
        System.out.println("Enter the song_Id separated by comma if you are adding more than one song: ");
        String songId1 = scanner.next();
        boolean addedSongs = playlistRepository.addSongsToPlaylist(songId1, playlistId1);
        if (addedSongs) {
            System.out.println("\u001B[32m Songs added to playlist\u001B[0m");
            System.out.println();
        } else {
            throw new CustomException("Sorry,Check the song_id or playlist_id!!");
        }
    }

    public void deletePlaylist() throws CustomException {
        List<Playlist> playlist = playlistRepository.getPlaylist();
        playlistRepository.displayPlaylist(playlist);
        System.out.println("Enter the playlist_id : ");
        int playlistId3 = scanner.nextInt();
        boolean deletedPlaylist = playlistRepository.deletePlaylist(playlistId3);
        if (deletedPlaylist) {
            System.out.println("\u001B[32m Deletted playlist : \u001B[0m" + playlistId3);
            System.out.println();
        } else {
            throw new CustomException("Sorry,playlist_id doesn't exists!!");
        }
    }
}
