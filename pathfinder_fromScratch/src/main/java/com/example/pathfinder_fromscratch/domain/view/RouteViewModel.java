package com.example.pathfinder_fromscratch.domain.view;

import com.example.pathfinder_fromscratch.domain.entities.Category;
import com.example.pathfinder_fromscratch.domain.entities.Comments;
import com.example.pathfinder_fromscratch.domain.entities.Picture;
import com.example.pathfinder_fromscratch.domain.entities.User;
import com.example.pathfinder_fromscratch.domain.enums.LevelEnum;

import java.util.Set;

public class RouteViewModel {

    private Long id;

    private String gpxCoordinates;
    private LevelEnum level;
    private String name;
    private User author;
    private String video;
    private String description;

    private Set<Comments> comments;

    private String pictureUrl;

    private Set<Picture> pictures;

    private Set<Category> categories;

    public RouteViewModel() {
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Comments> getComments() {
        return comments;
    }

    public void setComments(Set<Comments> comments) {
        this.comments = comments;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Set<Picture> getPictures() {
        return pictures;
    }

    public void setPictures(Set<Picture> pictures) {
        this.pictures = pictures;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
