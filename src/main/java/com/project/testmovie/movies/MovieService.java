package com.project.testmovie.movies;

import com.project.testmovie.users.UserRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private UserRepository userRepository;

    public MovieEntity createMovie(MovieEntity movie, int id){
        var user = userRepository.findById(id).orElse(null);
        if(user != null){
            movie.setUser(user);
            return movieRepository.save(movie);
        }else{
            throw new RuntimeException("User not found by user id: " + id);
        }
    }

    public List<MovieEntity> findAllMoviesByUserId(int userId){
        return movieRepository.findByUserId(userId);
    }

}
