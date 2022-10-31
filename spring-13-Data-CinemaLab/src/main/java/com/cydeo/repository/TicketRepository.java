package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    Integer countAllByUserAccountId(Long userId);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
    Integer countAllByMovieCinemaMovieName(String name);


    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findByDateTimeBetween(LocalDateTime dateTime1, LocalDateTime dateTime2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("Select t From Ticket t where t.userAccount.Id = ?1")
    List<Ticket> fetchAllTicketByUserAccount(@Param("userId") Long userId);

    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> getAllTicketsBetweenDates(@Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "Select count(*) From ticket where user_account_Id = ?1", nativeQuery = true)
    Integer countAllTicketByUserAccount(@Param("userId") Long userId);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(nativeQuery = true, value = "SELECT count(*) From ticket Where user_account_id = ?1 AND date_time BETWEEN ?2 and ?3")
    Integer countAllTicketByUserInDateRange(@Param("userId") Long userId, @Param("dateTime1") LocalDateTime dateTime1, @Param("dateTime2") LocalDateTime dateTime2);

    //Write a native query to distinct all tickets by movie name
    @Query(nativeQuery = true, value = "SELECT DISTINCT (m.name) From ticket t JOIN movie_cinema mc ON mc.id = t.movie_cinema_id" +
            " JOIN movie m ON m.id=mc.movie_id")
    List<String> retrieveAllDistinctMovieName();

    //Write a native query to find all tickets by user email
    @Query(nativeQuery = true, value = "SELECT * From ticket t Join user_account ua ON t.user_account_id = ua.id" +
            " Where ua.email = ?1")
    List<Ticket> findByUserEmail(String email);


    //Write a native query that returns all tickets
    @Query(nativeQuery = true, value = "SELECT * FROM ticket")
    List<Ticket> getAll();


    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(nativeQuery = true, value = "SELECT * From ticket t Join user_account ua ON t.user_account_id = ua.id" +
            " JOIN account_details ad ON ad.id = ua.account_details_id" +
            " JOIN movie_cinema mc ON mc.id = t.movie_cinema_id" +
            " JOIN movie m ON mc.movie_id = m.id " +
            " WHERE ua.username ILIKE concat('%',?1,'%')" +
            " OR ad.name ILIKE concat('%',?1,'%')" +
            "OR m.name ILIKE concat('%',?1,'%')")
    List<Ticket> retrieveAllBySearchCriteria(@Param("searchCriteria") String searchCriteria);
}
