package com.project.testmovie.movies;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.testmovie.users.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Movie")
public class MovieEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", nullable = false)
    private int id;
    @Column(name = "Title", nullable = false)
    private String title;
    @Column(name = "Genre", nullable = false)
    private String genre;
    @Column(name = "Rating", nullable = false)
    private double rating;
    @Column(name = "Release_Year", nullable = false)
    private int releaseYear;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}
