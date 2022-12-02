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
import java.util.Collections;
import java.util.List;

public class SongRepository {
    Connection connection;
    List<Song> songList;

    public SongRepository() throws SQLException {
        songList = new ArrayList<>();
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public List<Song> getAllSongs() {
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

    public void displaySongList(List<Song> songList) {
        System.out.println("Songs For You TO Enjoy");
        Collections.sort(songList,
                (Song o1, Song o2) -> String.CASE_INSENSITIVE_ORDER.compare(o1.getSongName(), o2.getSongName()));
        for (Song song : songList) {
            System.out.println(song);
        }
    }

    public void playAllSong(List<Song> songList) {
        for (Song song : songList) {
            new MusicPlayerService().player(song.getSongPath());
        }
        System.out.println("Song is playing");
    }

    public List<Song> searchSongByLanguage(String value) {
        List<Song> songSortedList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`song` where (`language`= ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, value);
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

    public List<Song> searchSongByGenre(String value) {
        List<Song> songSortedList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`song` where (`Genre`= ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, value);
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

    public List<Song> searchSongByArtist(String value) {
        List<Song> songSortedList = new ArrayList<>();
        String selectQuery = "select * from `songs`.`song` where (`Artist`= ?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setString(1, value);
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

    public Song getSong(int songId) {
        Song song = new Song();
        String selectQuery = "select * from `songs`.`song` where(`song_id`=?);";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1, songId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                song.setSongId(resultSet.getInt("song_id"));
                song.setSongName(resultSet.getString("song_name"));
                song.setGenre(resultSet.getString("genre"));
                song.setArtist(resultSet.getString("artist"));
                song.setSongDuration(resultSet.getDouble("song_duration"));
                song.setLanguage(resultSet.getString("language"));
                song.setAlbum(resultSet.getString("album"));
                song.setSongPath(resultSet.getString("song_path"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return song;
    }
}
