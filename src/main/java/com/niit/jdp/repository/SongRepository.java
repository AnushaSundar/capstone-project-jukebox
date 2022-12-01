/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;
import com.niit.jdp.service.MusicPlayerService;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        try {
            Statement statement = connection.createStatement();
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
                Song song = new Song(songId, songName, genre, artist, language, songDuration, songPath);
                songList.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }

    public void playSong() {
        MusicPlayerService musicPlayerService = new MusicPlayerService();
        for (Song song : songList) {
            musicPlayerService.play(song.getSongPath());
        }
    }

    public void searchSongByArtistLanguageGenre() {
    }
}
