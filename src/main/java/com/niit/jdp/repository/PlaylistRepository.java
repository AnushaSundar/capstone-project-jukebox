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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlaylistRepository {
    Connection connection;

    public PlaylistRepository() throws SQLException {
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public void createPlaylist() {
        System.out.println("Create your playlist here");
        System.out.println("Enter your playlist Name : ");
        Scanner scanner = new Scanner(System.in);
        String playlistName = scanner.next();
        System.out.println("Enter the song Id ");
        int songId = scanner.nextInt();
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

    public void displaySongs() {
        List<Playlist> playlists = new ArrayList<>();
        String SelectQuery = "select * from `songs`.`playlist`;";
        Statement
    }
}
