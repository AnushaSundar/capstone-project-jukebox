/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistRepository {
    Connection connection;
    Scanner scanner = new Scanner(System.in);
    public PlaylistRepository() throws SQLException {
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public void createPlaylist() {
        System.out.println("Create your playlist here");
        System.out.println("Enter your playlist Name : ");
        String playlistName = scanner.next();
        System.out.println("Enter the song Id ");
        int songId = scanner.nextInt();
        scanner.close();
        String insertQuery = "insert into `songs`.`song`(`song_id`,`playlist_name`) values(?,?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            preparedStatement.setInt(1, songId);
            preparedStatement.setString(2, playlistName);
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("\u001B[32m Created your playlist!!\u001B[0m");
            } else {

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void displayPlaylist() {
        List<Playlist> playlists = new ArrayList<>();
        String selectQuery = "select * from `songs`.`playlist`;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                int playlistId = resultSet.getInt("playlist_id");
                String playlistName = resultSet.getString("playlist_name");
                Playlist playlist = new Playlist(songId, playlistId, playlistName);
                playlists.add(playlist);
            }
            System.out.println("Your Playlist");
            for (Playlist eachPlaylist : playlists) {
                System.out.println(eachPlaylist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
}
