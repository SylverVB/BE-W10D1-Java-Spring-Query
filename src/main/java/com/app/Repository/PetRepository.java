package com.app.Repository;

import com.app.Model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * This interface demonstrates the process of writing custom queries in a JpaRepository using
 * Spring's query language, JPQL. JPQL abstracts away boilerplate logic by directly
 * mapping queries to ORM entities and remains vendor-agnostic, meaning that JPQL queries 
 * do not need to change between database systems such as PostgreSQL, Oracle, or MySQL.
 */
public interface PetRepository extends JpaRepository<Pet, Long> {

    /**
     * A query written using JPQL (Java Persistence Query Language).
     * The structure of the query resembles SQL statements, although the SELECT
     * keyword may be omitted. When SELECT is omitted, JPQL will map the ResultSet
     * rows directly into the associated entity class, in this case, Pet.
     * 
     * A List<Pet> is used as the return type to account for multiple pets sharing the same name, 
     * but a single Pet return type could also be used depending on the application requirements.
     *
     * The Pet entity is located in the Model package and defines the fields available for querying.
     *
     * @param name The name of the pet.
     * @return All pets matching the provided name.
     */
    @Query("FROM Pet WHERE name = :nameVar")
    List<Pet> example1(@Param("nameVar") String name);

    /**
     * This query demonstrates the use of SQL-like clauses in JPQL, such as WHERE, AND/OR, ORDER BY, 
     * GROUP BY, LIMIT, and subqueries.
     *
     * @param name The name of the pet.
     * @param species The species of the pet.
     * @return All pets matching the provided name and species.
     */
    @Query("FROM Pet WHERE name = :nameVar AND species = :speciesVar")
    List<Pet> example2(@Param("nameVar") String name, @Param("speciesVar") String species);

    /**
     * Including the SELECT statement allows retrieval of specific data from the table,
     * which in this case is useful for obtaining an aggregate value.
     *
     * @return the maximum age of all pets.
     */
    @Query("SELECT MAX(age) FROM Pet")
    Integer example3(); // Use Integer instead of int for queries that might return null.

    /**
     * Retrieves all pets by their species.
     *
     * @param species The species of the pet.
     * @return All pets matching the provided species.
     */
    @Query("FROM Pet WHERE species = :speciesVar")
    List<Pet> lab1(@Param("speciesVar") String species);

    /**
     * Retrieves all pets by either their name or their age.
     *
     * @param name The name of the pet.
     * @param age The age of the pet.
     * @return All pets matching the provided name or age.
     */
    @Query("FROM Pet WHERE name = :nameVar OR age = :ageVar")
    List<Pet> lab2(@Param("nameVar") String name, @Param("ageVar") int age);

    /**
     * Retrieves the average age of all pets.
     *
     * @return The average age of all pets.
     */
    @Query("SELECT AVG(age) FROM Pet")
    Integer lab3(); // Use Integer instead of int for queries that might return null.
}