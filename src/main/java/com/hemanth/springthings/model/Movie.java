package com.hemanth.springthings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Entity
@Table(name = "movie")
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String headline;
    private String thumbnail;
    private String language;
    private String region;

    @Enumerated(EnumType.STRING)
    private ContentRating rating;

    @ManyToMany
    Set<Actor> actors;
}
