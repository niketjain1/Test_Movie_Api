package com.project.testmovie.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/{id}/movies")
    public ResponseEntity<MovieEntity> createMovie(@RequestBody MovieEntity movie, @PathVariable("id") int id){
        var savedMovie = movieService.createMovie(movie, id);
        return ResponseEntity.created(URI.create("/users/" + savedMovie.getId() +"/movie/")).body(savedMovie);
    }
}
