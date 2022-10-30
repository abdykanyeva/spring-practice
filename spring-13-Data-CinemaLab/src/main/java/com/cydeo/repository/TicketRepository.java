package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    int countTicketBy();


    //Write a derived query to list all tickets by specific email

    List<Ticket> findByUserAccount_Email(String email);

    //Write a derived query to count how many tickets are sold for a specific movie

    int countTicketsBy(Movie movie);

    //Write a derived query to list all tickets between a range of dates

    List<Ticket> findByDateTimeBetween(LocalDateTime d1, LocalDateTime d2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user


    //Write a JPQL query that returns all tickets between a range of dates


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought


    //Write a native query to count the number of tickets a user bought in a specific range of dates


    //Write a native query to distinct all tickets by movie name


    //Write a native query to find all tickets by user email


    //Write a native query that returns all tickets


    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name


}