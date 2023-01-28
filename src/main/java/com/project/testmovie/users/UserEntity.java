package com.project.testmovie.users;

import com.project.testmovie.movies.MovieEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id", unique = true, nullable = false)
    private int id;
    @Column(name = "Username", nullable = false, unique = true)
    private String username;
    @Column(name = "Email", nullable = false, unique = true)
    private String email;
    @Column(name = "Password", nullable = false, unique = true)
    private String password;

    @OneToMany(targetEntity = MovieEntity.class,  cascade = CascadeType.ALL,
            mappedBy = "user")
    private List<MovieEntity> movies;
}
