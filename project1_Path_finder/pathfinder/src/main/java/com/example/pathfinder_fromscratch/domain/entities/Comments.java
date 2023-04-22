package com.example.pathfinder_fromscratch.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
public class Comments extends BaseEntity {


    @Column(nullable = false)
    private boolean approved;

    @Column(name = "created", nullable = false)
    private LocalDateTime created;
//· created - Accepts Date and Time values
//    o The values should not be future dates

    @Column(columnDefinition = "TEXT")
    private String textContent;
//· text content - Accepts very long text values


    @ManyToOne
    private User author;
//· author - Accepts User Entities as values


    @ManyToOne
    private Route route;
//· route - Accepts Route Entities as values


    public Comments() {
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}
