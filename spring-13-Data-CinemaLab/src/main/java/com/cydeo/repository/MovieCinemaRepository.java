package com.cydeo.repository;

import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional<MovieCinema> findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
    Integer countByCinemaId(Long id);

    //Write a derived query to count all movie cinemas with a specific movie id
    Integer countByMovieId(Long id);

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findAllByDateTimeAfter(LocalDateTime dateTime);

    //Write a derived query to find the top 3 expensive movies
    List<MovieCinema> findFirst3ByOrderByMoviePriceDesc();

    //Write a derived query to list all movie cinemas that contain a specific movie name
    List<MovieCinema> findByMovieNameContaining(String name);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinema_LocationName(String name);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date
    @Query("Select mc From MovieCinema mc Where mc.dateTime > ?1")
    List<MovieCinema> getAllCinemaHigherThan(@Param("dateTime") LocalDateTime dateTime);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id

    @Query(nativeQuery = true, value = "Select COUNT(*) From movie_cinema Where cinema_id = :id")
    Integer getNumberOfCinemaWithId(@Param("id") Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(nativeQuery = true, value = "Select * From movie_cinema mc JOIN cinema c ON c.id = mc.cinema_id" +
            "JOIN location l ON l.id = c.location_id Where l.name = ?1")
    List<MovieCinema> getCinemasWithLocationName(@Param("name") String name);

}
