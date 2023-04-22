package com.example.pathfinder_fromscratch.domain.binding;

import com.example.pathfinder_fromscratch.domain.enums.CategoryEnum;
import com.example.pathfinder_fromscratch.domain.enums.LevelEnum;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public class RouteAddBindingModel {

//    @Min(value = 3, message = "Route name must be between 3 and 20 characters")
//    @Max(value = 20, message = "Route name must be between 3 and 20 characters")
    @Size(min = 3, max = 20)
    private String name;

//    @Min(value = 3)
    @Size(min = 3)
    private String description;

    //https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/multipart/MultipartFile.html
//NB! there is file size upload limit, specified in application.properties
    private MultipartFile gpxCoordinates;

    @NotNull
    private LevelEnum level;
    private String videoUrl;
    private Set<CategoryEnum> categories;


    public RouteAddBindingModel() {
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }

    //because here we will POST /upload multipart file, we need to
    //write this also in the html <form> about it, like this:
    //enctype="multipart/form-data">   - see the add-route.html in the <form> tag how it looks like
    public MultipartFile getGpxCoordinates() {
        return gpxCoordinates;
    }

    public void setGpxCoordinates(MultipartFile gpxCoordinates) {
        this.gpxCoordinates = gpxCoordinates;
    }

    public LevelEnum getLevel() {
        return level;
    }

    public void setLevel(LevelEnum level) {
        this.level = level;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public Set<CategoryEnum> getCategories() {
        return categories;
    }

    public void setCategories(Set<CategoryEnum> categories) {
        this.categories = categories;
    }
}
