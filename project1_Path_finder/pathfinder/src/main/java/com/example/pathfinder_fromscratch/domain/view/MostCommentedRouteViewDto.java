package com.example.pathfinder_fromscratch.domain.view;

import com.example.pathfinder_fromscratch.domain.entities.Route;

import java.util.NoSuchElementException;

public class MostCommentedRouteViewDto {

    private Long id;
    private String name;
    private String description;
    private String imageUrl;


    public MostCommentedRouteViewDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MostCommentedRouteViewDto( Long id, String name, String description, String imageUrl) {
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public MostCommentedRouteViewDto setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MostCommentedRouteViewDto setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public MostCommentedRouteViewDto setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public static MostCommentedRouteViewDto fromRoute(Route route) {
        return new MostCommentedRouteViewDto(route.getId(), route.getName(),
                route.getDescription(),
                route.getPictures()
                        .stream()
                        .findFirst()
                        .orElseThrow(NoSuchElementException::new)
                        .getUrl());

    }

}
