package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to get cinema with a specific name
    List<Cinema> findByName(String name);

    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> findTop3BySponsoredName(String sponsoredName);

    //Write a derived query to list all cinemas in a specific country
    List<Cinema> findAllByCountry(String country);//???

    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> findByNameOrSponsoredName(String name, String sponsoredName);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to read the cinema name with a specific id
    @Query(" select c from Cinema c where c.id=?1")
    List<Cinema> readCinemaById(Long id);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all cinemas by location country
    @Query(value = "read * from cinema where location=?1", nativeQuery = true)
    List<Cinema> readAllByLocation(String location);

    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern

    @Query(value = "read * from cinema where name or sponsored_name =?1", nativeQuery = true)
    List<Cinema> readAllByNameOrSponsoredName(String pattern);


    //Write a native query to sort all cinemas by name
    @Query(value = " select * from cinema order by name", nativeQuery = true)
    List<Cinema> cinemasSortedByName();

    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = " select * from cinema distinct by sponsored_name=?1", nativeQuery = true)
    List<Cinema> distinctAllCinemasBySponsoredName(String sponsoredName);
}
