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
        assertNotEquals(8, actual.size(), "Check the code");
    }

    @Test
    void searchSongByLanguage() {
        //actual
        List<Song> actualResult = songRepository.searchSongByLanguage("English");
        //assert
        assertEquals(6, actualResult.size());
    }

    @Test
    void searchSongByLanguageFailure() {
        //actual
        List<Song> actualResult = songRepository.searchSongByLanguage("English");
        //assert
        assertNotEquals(7, actualResult.size(), "The count is incorrect");
    }

    @Test
    void searchSongByGenre() {
        //actual
        List<Song> actualResult = songRepository.searchSongByGenre("rock");
        //assert
        assertEquals(1, actualResult.size());
    }

    @Test
    void searchSongByGenreFailure() {
        //actual
        List<Song> actualResult = songRepository.searchSongByGenre("hip hop");
        //assert
        assertNotEquals(7, actualResult.size(), "The count is incorrect");
    }

    @Test
    void searchSongByArtist() {
        //actual
        List<Song> actualResult = songRepository.searchSongByArtist("BTS");
        //assert
        assertEquals(3, actualResult.size());
    }

    @Test
    void searchSongByArtistFailure() {
        //actual
        List<Song> actualResult = songRepository.searchSongByGenre("hip hop");
        //assert
        assertNotEquals(4, actualResult.size(), "The count is incorrect");
    }

//    @Test
//    void getSong() {
//        Song expectedResult = ;
//        //actual
//        Song actualResult = songRepository.getSong(112);
//        //assert
//        assertEquals();
//    }
}