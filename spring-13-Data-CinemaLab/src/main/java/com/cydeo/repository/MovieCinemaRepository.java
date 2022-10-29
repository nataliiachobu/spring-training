package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    List<MovieCinema> readMovieCinemaById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    List<MovieCinema> countById(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    List<MovieCinema> countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter(LocalDateTime dateTime);


    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findDistinctTopByMovie_Price(BigDecimal moviePrice);

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findMovieCinemasByMovieContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findAllByCinemaLocationName(String locationName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query(" select m from MovieCinema m where m.dateTime>?1")
    List<MovieCinema> moviesWithHigherThanSpecificDate(LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count (*) from movie_cinema where cinema_id=?1 ", nativeQuery = true)
    List<MovieCinema> retrieveByCinemaId(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value =" select * from movie_cinema where location_name=?1 ",nativeQuery = true)

    List<MovieCinema> retrieveMovieCinemaByLocation(String location);
}
