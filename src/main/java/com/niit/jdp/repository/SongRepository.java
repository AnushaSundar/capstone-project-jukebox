/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongRepository {
    DatabaseService databaseService;
    Connection connection;
    List<Song> songList;

    public SongRepository() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnectionToDatabase();
    }

    public List<Song> displaySongs() {
        songList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`song`;";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(selectQuery);
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                double songDuration = resultSet.getDouble("song_duration");
                String language = resultSet.getString("language");
                String album = resultSet.getString("album");
                String songPath = resultSet.getString("song_path");
                Song song = new Song(songId, songName, genre, artist, language, songDuration, album, songPath);
                songList.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public void playAllSong() {
        for (Song song : songList) {
            new MusicPlayerService().play(song.getSongPath());
        }
        System.out.println("Song is playing");
    }

    public List<Song> searchSongByArtistLanguageGenre(String columnName, String value) {
        List<Song> songSortedList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`song` where (?= ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, columnName);
            preparedStatement.setString(2, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int songId = resultSet.getInt("song_id");
                String songName = resultSet.getString("song_name");
                String genre = resultSet.getString("genre");
                String artist = resultSet.getString("artist");
                double songDuration = resultSet.getDouble("song_duration");
                String language = resultSet.getString("language");
                String album = resultSet.getString("album");
                String songPath = resultSet.getString("song_path");
                Song song = new Song(songId, songName, genre, artist, language, songDuration, album, songPath);
                songSortedList.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songSortedList;
    }

    public void playOneSong(int songId) {
        for (Song song : songList) {
            if (song.getSongId() == songId) {
                new MusicPlayerService().play(song.getSongPath());
            }
        }
        System.out.println("The song you have selected is playing");
    }
}
