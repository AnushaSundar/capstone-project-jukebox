package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

class SongRepositoryTest {
    SongRepository songRepository;
    Song song;

    @BeforeEach
    void setUp() throws SQLException {
        songRepository = new SongRepository();
        song = new Song();
    }

    @AfterEach
    void tearDown() {
        songRepository = null;
        song = null;
    }

    @Test
    void getAllSongs() {
        //arrange
        List<Song> expectedResult
    }

    @Test
    void displaySongList() {
    }

    @Test
    void searchSongByLanguage() {
    }

    @Test
    void searchSongByGenre() {
    }

    @Test
    void searchSongByArtist() {
    }

    @Test
    void getSong() {
    }
}