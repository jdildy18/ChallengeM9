package com.company.recordcollection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "album")
public class Album implements Serializable {

    @Id
    @Column(name = "album_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //One to many, one album has many tracks

    /*
    orhpanremoval true = if you delete an album from the database, adding this will delete the associated tracks with the album
    fetchtype eager = when creating album class, we want to grab all the tracks associated with the album.
    Lazy won't load all the programs associated with the album, but will instead wait for you to get them.
     */

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "album_id")

    private Set<Track> tracks = new HashSet<>();

    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Track> getTracks() {
        return tracks;
    }

    public void setTracks(Set<Track> tracks) {
        this.tracks = tracks;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public LocalDate getReleaseData() {
        return releaseData;
    }

    public void setReleaseData(LocalDate releaseData) {
        this.releaseData = releaseData;
    }

    public int getLabelId() {
        return labelId;
    }

    public void setLabelId(int labelId) {
        this.labelId = labelId;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    private int artistId;
    private LocalDate releaseData;
    private int labelId;
    private BigDecimal listPrice;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Album)) return false;
        Album album = (Album) o;
        return id == album.id && artistId == album.artistId && labelId == album.labelId && Objects.equals(tracks, album.tracks) && Objects.equals(title, album.title) && Objects.equals(releaseData, album.releaseData) && Objects.equals(listPrice, album.listPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tracks, title, artistId, releaseData, labelId, listPrice);
    }


    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", tracks=" + tracks +
                ", title='" + title + '\'' +
                ", artistId=" + artistId +
                ", releaseData=" + releaseData +
                ", labelId=" + labelId +
                ", listPrice=" + listPrice +
                '}';
    }
}
