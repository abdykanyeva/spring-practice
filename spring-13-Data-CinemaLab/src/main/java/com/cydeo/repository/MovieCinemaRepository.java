package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import net.bytebuddy.asm.Advice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    List<MovieCinema> findAllBy(Long id);


    //Write a derived query to count all movie cinemas with a specific cinema id

    int countMovieCinemaByCinema(Cinema id);

    //Write a derived query to count all movie cinemas with a specific movie id

    int countMovieCinemaByMovie(Movie id);

    //Write a derived query to list all movie cinemas with higher than a specific date

    List<MovieCinema> findByDateTimeGreaterThan(LocalDateTime date);

    //Write a derived query to find the top 3 expensive movies

    List<MovieCinema> findDistinctTop3ByMovie(Movie movie);


    //Write a derived query to list all movie cinemas that contain a specific movie name

    List<MovieCinema> findByMovieName(String name);
    //Write a derived query to list all movie cinemas in a specific location name

    List<MovieCinema> findByCinemaName(String name);


    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date


    @Query("SELECT d FROM MovieCinema d WHERE d.dateTime > ?1")
    List<Movie> allMovieWithHigherThanSpecificDate(LocalDate date);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(value = "SELECT COUNT (cinema_id) FROM movie_cinema ", nativeQuery = true)
    int countByCinemaId();


    //Write a native query that returns all movie cinemas by location name


    @Query(value = "SELECT * FROM movie_cinema WHERE cinema_id = ?1", nativeQuery = true)
    List<MovieCinema> movieCinemaByName(String name);


}