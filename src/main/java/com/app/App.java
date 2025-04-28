package com.app;

import com.app.Model.Pet;
import com.app.Repository.PetRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Main application class for manual testing.
 * This main method provides basic manual testing for the repository methods.
 */
@SuppressWarnings("unused")
@SpringBootApplication
public class App {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(App.class);
        PetRepository petRepository = applicationContext.getBean(PetRepository.class);

        // Saving some example pets into the database
        Pet p1 = petRepository.save(new Pet("Tommy", "Cat", 4));
        Pet p2 = petRepository.save(new Pet("Fido", "Dog", 5));
        Pet p3 = petRepository.save(new Pet("Tommy", "Dog", 6));

        System.out.println("Here are all the pets being used for testing:");
        System.out.println(petRepository.findAll());

        System.out.println("Testing queries written using the @Query annotation.");

        System.out.println("Retrieving all pets named 'Tommy':");
        System.out.println(petRepository.example1("Tommy"));

        System.out.println("Retrieving all Cats named 'Tommy':");
        System.out.println(petRepository.example2("Tommy", "Cat"));

        System.out.println("Retrieving the age of the oldest pet:");
        System.out.println(petRepository.example3());

        System.out.println("Testing custom queries:");

        System.out.println("Retrieving all Dogs:");
        System.out.println(petRepository.lab1("Dog"));

        System.out.println("Retrieving pets named 'Fido' OR pets that are 4 years old:");
        System.out.println(petRepository.lab2("Fido", 4));

        System.out.println("Retrieving the average age of all pets (if the query is not yet written, an exception will be thrown):");
        System.out.println(petRepository.lab3());
    }
}