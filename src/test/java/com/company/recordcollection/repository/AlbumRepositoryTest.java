package com.company.recordcollection.repository;

import com.company.recordcollection.model.Album;
import com.company.recordcollection.model.Artist;
import com.company.recordcollection.model.Label;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class AlbumRepositoryTest {

    @Autowired
    TrackRepository trackRepository;
    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    LabelRepository labelRepository;
    @Autowired
    AlbumRepository albumRepository;

    //@Before runs before any of the tests are run.
    //WE need to delete everything that tests put in our database
    @Before
    public void setUp() throws Exception {
        trackRepository.deleteAll();
        albumRepository.deleteAll();
        labelRepository.deleteAll();
        artistRepository.deleteAll();
    }

    @Test
    public void addGetDeleteAlbum() {
        //Create all the objects needed to create an album using the foriegn key relationship
        //Arist and Label and use their id

        Label label = new Label();
        label.setName("A&M");
        label.setWebsite("www.fake.com");
        label = labelRepository.save(label);

        Artist artist = new Artist();
        artist.setName("Rock Start");
        artist.setInstagram("@RockStart");
        artist.setTwitter("@TheRockStar");
        artist = artistRepository.save(artist);

        Album album = new Album();
        album.setTitle("The Greatest Hits");
        album.setArtistId(artist.getId());
        album.setLabelId(label.getId());
        album.setReleaseData(LocalDate.of(2010,1,5));
        album.setListPrice(new BigDecimal("21.95"));

        album = albumRepository.save(album);
        //Checking  to see if you can get an album by album id
        Optional<Album> album1 = albumRepository.findById(album.getId());
        //Optional checks to see if the object is null

        //AssertEquals checking to make sure that the albums are equal.
        assertEquals(album1.get(), album);

        albumRepository.deleteById(album.getId());

        album1 = albumRepository.findById(album.getId());

        assertFalse(album1.isPresent());


    }
}