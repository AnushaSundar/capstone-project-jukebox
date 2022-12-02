package com.niit.jdp.repository;

import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
        //actual
        List<Song> actual = songRepository.getAllSongs();
        //assert
        assertEquals(9, actual.size());
    }

    @Test
    void getAllSongsFail() {
        //actual
        List<Song> actual = songRepository.getAllSongs();
        //assert
        assertNotEquals(8, actual.size());
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