package com.company.recordcollection.repository;

import com.company.recordcollection.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends JpaRepository<Track, Integer> {
    //Find all tracks by id
    List<Track> findAllTracksByAlbumId(int albumId);
    //Find track by title
    List<Track> findByTitle(String trackTitle);
}
