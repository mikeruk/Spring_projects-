package com.example.pathfinder_fromscratch.domain.view;

import com.example.pathfinder_fromscratch.domain.entities.Picture;
import com.example.pathfinder_fromscratch.domain.entities.User;
import com.example.pathfinder_fromscratch.domain.enums.LevelEnum;

import java.util.Set;

public class RouteDetailsViewModel {

    private Long id;

    private String gpxCoordinates;
    private String description;
    private LevelEnum level;
    private String name;
    private String videoUrl;
    private User author;
    private Set<Picture> pictures;


    public RouteDetailsViewModel() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(String gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }
}
