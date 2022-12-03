/*
 * Author : Anusha
 * Date : 02-12-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.display;

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

    public void goToPlaylist() {
        List<Playlist> playlist = playlistRepository.getPlaylist();
        playlistRepository.displayPlaylist(playlist);
        int option5 = 0;
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
                    System.out.println("Enter the playlist_id :");
                    int playlistId = scanner.nextInt();
                    System.out.println("Enter the song_id");
                    int songId = scanner.nextInt();
                    Song aSongFromPlaylist = playlistRepository.getASongFromPlaylist(songId, playlistId);
                    songRepository.playSong(aSongFromPlaylist);
                    break;
                case 2:
                    System.out.println("Enter the playlist_id");
                    int playlistId2 = scanner.nextInt();
                    List<Song> songsFromPlaylist = playlistRepository.getAllSongsFromPlaylist(playlistId2);
                    songRepository.displaySongList(songsFromPlaylist);
                    int option6 = 0;
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
                    break;
                case 3:
                    System.out.println("Enter the playlist name: ");
                    String name = scanner.next();
                    Playlist playlist1 = playlistRepository.createPlaylist(name);
                    System.out.println("successfully created your playlist.");
                    System.out.println("Your playlist id is: " + playlist1.getPlaylistId());
                    System.out.println("Want to see the playlist then press 1 or 0 to exit");
                    int option7 = scanner.nextInt();
                    List<Playlist> playlist2 = null;
                    if (option7 == 1) {
                        playlist2 = playlistRepository.getPlaylist();
                        playlistRepository.displayPlaylist(playlist2);
                        System.out.println();
                        break;
                    }
                    if (option7 == 0)
                        break;
                    break;
                case 4:
                    System.out.println("Enter the playlist_id : ");
                    int playlistId1 = scanner.nextInt();
                    System.out.println("Enter the song_Id : ");
                    String songId1 = scanner.next();
                    boolean addedSongs = playlistRepository.addSongsToPlaylist(songId1, playlistId1);
                    if (addedSongs) {
                        System.out.println("\u001B[32m Songs added to playlist\u001B[0m");
                    } else {
                        System.err.println("Sorry,Check the song_id!!");
                    }
                    break;
                case 5:
                    System.out.println("Enter the playlist_id : ");
                    int playlistId3 = scanner.nextInt();
                    boolean deletedPlaylist = playlistRepository.deletePlaylist(playlistId3);
                    if (deletedPlaylist) {
                        System.out.println("\u001B[32m Deletted playlist : \u001B[0m" + playlistId3);
                    } else {
                        System.err.println("Sorry,Check the playlist_id!!");
                    }
                    break;
            }
            break;
        } while (option5 != 6);
    }

    public void selectSongFromPlaylist() {
        System.out.println("Enter the playlist_id :");
        int playlistId = scanner.nextInt();
        System.out.println("Enter the song_id");
        int songId = scanner.nextInt();
        Song aSongFromPlaylist = playlistRepository.getASongFromPlaylist(songId, playlistId);
        songRepository.playSong(aSongFromPlaylist);
    }

    public void selectPlaylist() {
        System.out.println("Enter the playlist_id");
        int playlistId2 = scanner.nextInt();
        List<Song> songsFromPlaylist = playlistRepository.getAllSongsFromPlaylist(playlistId2);
        songRepository.displaySongList(songsFromPlaylist);
        int option6 = 0;
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

    public void addSongsToPlaylist() {
        System.out.println("Enter the playlist_id : ");
        int playlistId1 = scanner.nextInt();
        System.out.println("Enter the song_Id : ");
        String songId1 = scanner.next();
        boolean addedSongs = playlistRepository.addSongsToPlaylist(songId1, playlistId1);
        if (addedSongs) {
            System.out.println("\u001B[32m Songs added to playlist\u001B[0m");
        } else {
            System.err.println("Sorry,Check the song_id!!");
        }
    }
}
