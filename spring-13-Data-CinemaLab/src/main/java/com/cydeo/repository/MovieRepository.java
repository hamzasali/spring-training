package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    Optional<Movie> findByName(String name);

    //Write a derived query to list all movies between a range of prices
    List<Movie> findByPriceBetween(BigDecimal price1, BigDecimal price2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
    List<Movie> findByDurationIn(List<Integer> durationList);

    //Write a derived query to list all movies with higher than a specific release date
    List<Movie> findAllByReleaseDateAfter(LocalDate releaseDate);

    //Write a derived query to list all movies with a specific state and type
    List<Movie> findAllByStateAndType(MovieState state, MovieType type);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices
    @Query("Select m From Movie m Where m.price between ?1 and ?2")
    List<Movie> getMovieBetweenPrice(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //Write a JPQL query that returns all movie names
    @Query("Select distinct m.name From Movie m")
    List<String> getAllMovieNames();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(nativeQuery = true, value = "SELECT * From movie Where name = ?1")
    List<Movie> getMovieByName(String name);

    //Write a native query that return the list of movies in a specific range of prices
    @Query(nativeQuery = true, value = "SELECT * From movie Where price BETWEEN ?1 and ?2")
    List<Movie> getAllMovieBetweenPriceRange(@Param("price1") BigDecimal price1, @Param("price2") BigDecimal price2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(nativeQuery = true, value = "SELECT * From movie Where duration In ?1")
    List<Movie> getMoviesInRangeOfDuration(List<Integer> duration);

    //Write a native query to list the top 5 most expensive movies
    @Query(nativeQuery = true,value = "SELECT * From movie Order By price desc Limit 5")
    List<Movie> getTop5ExpensiveMovies();


}
