/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.exception.CustomException;
import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistRepository {
    Connection connection;
    public PlaylistRepository() throws SQLException {
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public List<Song> getAllSongsFromPlaylist(int playlistId) throws CustomException {
        List<Song> songList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`playlist` where (`playlist_id`=?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, playlistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String songIds = resultSet.getString("song_id");
                if (songIds != null) {
                    String[] songIdArray = songIds.split(",");
                    for (String songId : songIdArray) {
                        Song song = new SongRepository().getSong(Integer.parseInt(songId));
                        songList.add(song);
                    }
                } else {
                    throw new CustomException("Playlist is empty");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public Song getASongFromPlaylist(int songId, int playlistId) {
        Song song = new Song();
        String selectQuery = "select * from `songs`.`playlist` where (`playlist_id`=?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, playlistId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String songIds = resultSet.getString("song_id");
                String[] songIdArray = songIds.split(",");
                for (String song_Id : songIdArray) {
                    Song aSong = new SongRepository().getSong(Integer.parseInt(song_Id));
                    if (aSong.getSongId() == songId) {
                        song = new SongRepository().getSong(aSong.getSongId());
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return song;
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

    public List<Playlist> getPlaylist() {
        List<Playlist> playlist = new ArrayList<>();
        String selectQuery = "Select * from `songs`.`playlist`;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int playlistId = resultSet.getInt("playlist_id");
                String playlistName = resultSet.getString("playlist_name");
                Playlist playlist2 = new Playlist(playlistId, playlistName);
                playlist.add(playlist2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return playlist;
    }

    public void displayPlaylist(List<Playlist> playlist) {
        playlist.forEach(System.out::println);
    }
}
