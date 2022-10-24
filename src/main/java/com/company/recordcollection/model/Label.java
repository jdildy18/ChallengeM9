package com.company.recordcollection.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "label")
public class Label implements Serializable {

    @Id
    @Column(name = "label_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "labelId")
    private Set<Album> albums = new HashSet<>();

    private String name;
    private String website;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(Set<Album> albums) {
        this.albums = albums;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Label)) return false;
        Label label = (Label) o;
        return getId() == label.getId() && getAlbums().equals(label.getAlbums()) && getName().equals(label.getName()) && getWebsite().equals(label.getWebsite());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAlbums(), getName(), getWebsite());
    }

    @Override
    public String toString() {
        return "Label{" +
                "id=" + id +
                ", albums=" + albums +
                ", name='" + name + '\'' +
                ", website='" + website + '\'' +
                '}';
    }
}
