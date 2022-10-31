package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    Optional<Cinema> getCinemaByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredNameContainingOrderBySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findByLocation_Country(String country);

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsorName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query("Select c.name From Cinema c where c.Id = ?1")
    String retrieveCinemaNameWithId(@Param("id") Long id);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(nativeQuery = true, value = "select * From cinema c  JOIN location l " +
            "ON l.id = c.location_id Where l.country = ?1")
    List<Cinema> retrieveCinemaByLocationCountry(@Param("locationCountry") String locationCountry);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(nativeQuery = true, value = "Select * FROM cinema WHERE name ILIKE concat('%',?1,'%')" +
            "OR sponsored_name ILIKE concat('%',?1,'%')")
    List<Cinema> retrieveCinemaWithSpecificPattern(@Param("pattern") String pattern);

    //Write a native query to sort all cinemas by name
    @Query(nativeQuery = true, value = "SELECT * FROM cinema ORDER BY name")
    List<Cinema> retrieveCinemaSorted();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(nativeQuery = true, value = "SELECT DISTINCT sponsored_name FROM cinema")
    List<String> retrieveDistinctCinemaBySponsored();

}
