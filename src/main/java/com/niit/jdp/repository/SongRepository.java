/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SongRepository {
    DatabaseService databaseService;
    Connection connection;

    public SongRepository() throws SQLException {
        databaseService = new DatabaseService();
        connection = databaseService.getConnectionToDatabase();
    }

    public List<Song> displaySongs() {

    }

    public void playSong() {
    }

    public void searchSongByArtistLanguageGenre() {
    }
}
