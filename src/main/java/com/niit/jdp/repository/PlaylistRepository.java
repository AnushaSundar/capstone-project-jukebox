/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistRepository {
    Connection connection;
    Scanner scanner = new Scanner(System.in);

    public PlaylistRepository() throws SQLException {
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public List<Playlist> getAllSongsFromPlaylist() {
        List<Playlist> playlists = new ArrayList<>();
//        String selectQuery = "select * from `songs`.`playlist`;";
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(selectQuery);
//            while (resultSet.next()) {
//                int songId = resultSet.getInt("song_id");
//                int playlistId = resultSet.getInt("playlist_id");
//                String playlistName = resultSet.getString("playlist_name");
//                Playlist playlist = new Playlist(songId, playlistId, playlistName);
//                playlists.add(playlist);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
        return playlists;
    }

    public Playlist createPlaylist(String playlistName) {
        Playlist playlist = new Playlist();
        String insertQuery = "insert into `songs`.`playlist`(playlist_name) values(?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, playlistName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    playlist.setPlaylistId(resultSet.getInt(1));
                    playlist.setPlaylistName(playlistName);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlist;
    }

    public boolean addSongsToPlaylist(String songIds, int playlistId) {
        String updateQuery = "update `songs`.`playlist` set `song_id`=? where (`playlist_id`=?);";
        int updatedRow = 0;
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setString(1, songIds);
            preparedStatement.setInt(2, playlistId);
            updatedRow = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return updatedRow > 0;
    }

    public void displayPlaylist(List<Playlist> playlists) {
//        String selectQuery = "select * from `songs`.`playlist`;";
//        try (Statement statement = connection.createStatement()) {
//            ResultSet resultSet = statement.executeQuery(selectQuery);
//            while (resultSet.next()) {
//                int songId = resultSet.getInt("song_id");
//                int playlistId = resultSet.getInt("playlist_id");
//                String playlistName = resultSet.getString("playlist_name");
//                Playlist playlist = new Playlist(songId, playlistId, playlistName);
//                playlists.add(playlist);
//            }
//            System.out.println("Your Playlist");
//            if (!playlists.isEmpty()) {
//                for (Playlist eachPlaylist : playlists) {
//                    System.out.println(eachPlaylist);
//                }
//            } else {
//                System.err.println("Your Playlist Is Empty");
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }

    public void deleteSongFromPlaylist() {
        System.out.println("Enter the song Id : ");
        int songId = scanner.nextInt();
        String deleteQuery = "delete from `songs`.`playlist` where `song_id`=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, songId);
            int rowsDeleted = preparedStatement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("\u001B[32m Successfully deleted \u001B[0m");
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void playSongFromPlaylist() {
//        System.out.println("Enter the playlist you want to listen : ");
//        String playlistName = scanner.next();
//        String selectQuery = "select * from `songs`.`playlist` where(`playlist_name`=?);";
//        List<Playlist> playlists1 = new ArrayList<>();
//        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
//            preparedStatement.setString(1, playlistName);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                int songId = resultSet.getInt("song_id");
//                int playlistId = resultSet.getInt("playlist_id");
//                String Name = resultSet.getString("playlist_name");
//                Playlist playlist = new Playlist(songId, playlistId, Name);
//                playlists1.add(playlist);
//            }
//            for (Playlist play : playlists1) {
//                int songId = play.getSongId();
//                SongRepository songRepository = new SongRepository();
//                List<Song> allSongs = songRepository.getAllSongs();
//                for (Song song : allSongs) {
//                    if (song.getSongId() == songId) {
//                        new MusicPlayerService().play(song.getSongPath());
//                    }
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
    }
}
