/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
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

    public List<Song> getAllSongsFromPlaylist(int playlistId) {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`playlist` where (`playlist_id`=?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, playlistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String songIds = resultSet.getString("song_id");
                String[] songIdArray = songIds.split(",");
                for (String songId : songIdArray) {
                    Song song = new SongRepository().getSong(Integer.parseInt(songId));
                    songList.add(song);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
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

    public boolean deletePlaylist(int playlistId) {
        int rowDeleted = 0;
        String deleteQuery = "delete from `songs`.`playlist` where `playlist_id`=?;";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setInt(1, playlistId);
            rowDeleted = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDeleted > 0;
    }


}
