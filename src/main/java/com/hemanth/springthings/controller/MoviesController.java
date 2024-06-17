package com.hemanth.springthings.controller;

import com.hemanth.springthings.model.Movie;
import com.hemanth.springthings.repository.MovieRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/1.0/movies")
public class MoviesController {

    private final MovieRepository movieRepository;

    public MoviesController(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @GetMapping()
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
}
