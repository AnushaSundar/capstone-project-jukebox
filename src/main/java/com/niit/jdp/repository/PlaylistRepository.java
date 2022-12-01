/*
 * Author : Anusha
 * Date : 30-11-2022
 * Created with : IntelliJ IDEA Community Edition
 */


package com.niit.jdp.repository;

import com.niit.jdp.service.DatabaseService;

import java.sql.Connection;
import java.sql.SQLException;

public class PlaylistRepository {
    Connection connection;

    public PlaylistRepository() throws SQLException {
        connection = new DatabaseService().getConnectionToDatabase();
    }

    public void createPlaylist() {

    }

    public void displaySongs() {
    }
}
