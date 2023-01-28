package com.project.testmovie.movies;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
    List<MovieEntity> findByUserId(int userId);
}
