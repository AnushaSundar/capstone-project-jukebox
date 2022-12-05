package com.niit.jdp.repository;

import com.niit.jdp.model.Playlist;
import com.niit.jdp.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class PlaylistRepositoryTest {
    PlaylistRepository playlistRepository;
    Playlist playlist;

    @BeforeEach
    void setUp() throws SQLException {
        playlistRepository = new PlaylistRepository();
        playlist = new Playlist();
    }

    @AfterEach
    void tearDown() {
        playlistRepository = null;
        playlist = null;
    }

    @Test
    void getAllSongsFromPlaylist() {
        //actual
        List<Song> songsFromPlaylist = playlistRepository.getAllSongsFromPlaylist(214);
        //assert
        assertEquals(3, songsFromPlaylist.size());
    }

    @Test
    void getAllSongsFromPlaylistFailure() {
        //actual
        List<Song> songsFromPlaylist = playlistRepository.getAllSongsFromPlaylist(214);
        //assert
        assertNotEquals(4, songsFromPlaylist.size());
    }

    @Test
    void getASongFromPlaylist() {
        //actual
        Song actualResult = playlistRepository.getASongFromPlaylist(111, 214);
        //assert
        assertEquals(111, actualResult.getSongId());
    }

    @Test
    void getASongFromPlaylistFailure() {
        //actual
        Song actualResult = playlistRepository.getASongFromPlaylist(111, 214);
        //assert
        assertNotEquals(4, actualResult.getSongId());
    }

    @Test
    void addSongsToPlaylist() {
        //actual
        boolean actual = playlistRepository.addSongsToPlaylist("118", 217);
        //assert
        assertEquals(true, actual);
    }

    @Test
    void addSongsToPlaylistFailure() {
        //actual
        boolean actual = playlistRepository.addSongsToPlaylist("101", 20);
        //assert
        assertEquals(false, actual);
    }

    @Test
    void deletePlaylist() {
        //actual
        boolean actual = playlistRepository.deletePlaylist(217);
        //assert
        assertEquals(true, actual);
    }
}