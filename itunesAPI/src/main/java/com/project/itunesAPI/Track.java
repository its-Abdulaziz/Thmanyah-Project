package com.project.itunesAPI;

import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collation = "tracksPost")
public class Track {

    @Id
    private String trackId;
    private String artistName;
    private String collectionName;
    private String collectionViewUrl;
    private String artworkUrl600;

    public Track() {

    }

    public Track(String artistName, String collectionName, String trackId, String collectionViewUrl, String artworkUrl600) {
        this.artistName = artistName;
        this.collectionName = collectionName;
        this.trackId = trackId;
        this.collectionViewUrl = collectionViewUrl;
        this.artworkUrl600 = artworkUrl600;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getCollectionName() {
        return collectionName;
    }

    public void setCollectionName(String collectionName) {
        this.collectionName = collectionName;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getCollectionViewUrl() {
        return collectionViewUrl;
    }

    public void setCollectionViewUrl(String collectionViewUrl) {
        this.collectionViewUrl = collectionViewUrl;
    }

    public String getArtworkUrl600() {
        return artworkUrl600;
    }

    public void setArtworkUrl600(String artworkUrl600) {
        this.artworkUrl600 = artworkUrl600;
    }
}
