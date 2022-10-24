package com.company.recordcollection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//
@Entity
//hibernate adds a lot of new properties to the classes, in order to avoid showing properties, you ignore them with jsonignore.
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
//instead of running the schema, when the program runs, it will create a database called Track
@Table(name = "track")
public class Track implements Serializable {
    @Id
    @Column(name = "track_id")
    //matching what is in the database
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //albumId is here because of the foreign key relationship between track and album

    private int albumId;
    private String title;
    private int runtime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Track)) return false;
        Track track = (Track) o;
        return getId() == track.getId() && getAlbumId() == track.getAlbumId() && getRuntime() == track.getRuntime() && Objects.equals(title, track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAlbumId(), getTitle(), getRuntime(), getRuntime());
    }
}
