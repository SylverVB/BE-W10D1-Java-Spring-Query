package com.app;

import com.app.Model.Pet;
import com.app.Repository.PetRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * Integration tests for the PetRepository methods.
 * Each test sets up its own data and verifies the correct behavior of the custom queries.
 */
@SpringBootTest(classes = App.class)
public class PetRepositoryTest {
    @Autowired
    PetRepository petRepository;

    /**
     * Clears the database before each test to ensure test isolation.
     */
    @BeforeEach
    public void setUp(){
        petRepository.deleteAll();
    }

    /**
     * Verifies that retrieving all pets by species 'Cat' returns Tommy and Whiskers, but not Fido.
     */
    @Test
    public void lab1test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 3));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        List<Pet> actual = petRepository.lab1("Cat");
        Assertions.assertTrue(actual.contains(p1));
        Assertions.assertTrue(actual.contains(p3));
        Assertions.assertFalse(actual.contains(p2));
    }

    /**
     * Verifies that retrieving pets named 'Fido' or pets aged 3 returns Tommy and Fido.
     */
    @Test
    public void lab2test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 3));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        List<Pet> actual = petRepository.lab2("Fido", 3);
        Assertions.assertTrue(actual.contains(p1));
        Assertions.assertTrue(actual.contains(p2));
        Assertions.assertFalse(actual.contains(p3));
    }

    /**
     * Verifies that retrieving the average age of all pets returns 9.0 within a margin of 0.0001
     * (to account for floating-point precision).
     */
    @SuppressWarnings("unused")
    @Test
    public void lab3test(){
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 4));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 3));
        Pet p3 = petRepository.save(new Pet("Whiskers", "Cat", 20));
        double actual = petRepository.lab3();
        Assertions.assertEquals(9, actual, .0001);
    }
}