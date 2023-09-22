package com.problemSolving.transactionalBehaviour;

import com.problemSolving.entity.Person;
import com.problemSolving.repository.PersonRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CountDownLatch;

public class Helper {
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
    public void updatePersonWithDefaultIsolation(PersonRepository personRepository) {
        Person person = personRepository.findById(41).get();
        person.setBalance(person.getBalance() + 10);
        person = personRepository.save(person);
        System.out.println("saved");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    public void updatePersonWithReadUnCommitted(PersonRepository personRepository) {
        Person person = personRepository.findById(41).get();
        person.setBalance(person.getBalance() + 10);
        person = personRepository.save(person);
        System.out.println("saved");
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public void updatePersonWithRepeatableRead(PersonRepository personRepository) {
        Person person = personRepository.findById(41).get();
        person.setBalance(person.getBalance() + 10);
        person = personRepository.save(person);
        System.out.println("saved");
    }

    //@Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void updatePersonWithSerializable(String threadName, CountDownLatch latch, PersonRepository personRepository, int i) {
        // Capture the start time
        long startTime = System.currentTimeMillis();

        try {
            // Wait for a short time to simulate some processing
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Person person = personRepository.findById(41).get();
        System.out.println("Previous : "+person.getBalance());
        person.setBalance(person.getBalance() + i);
        System.out.println("startTime: "+(startTime/1000));
        person = personRepository.save(person);
        // Capture the end time
        long endTime = System.currentTimeMillis();

        System.out.println("endTime: "+(endTime/1000));

        System.out.println("after update  : "+person.getBalance());



        // Calculate and print the wait time in milliseconds along with the thread name
        long waitTime = endTime - startTime;
        System.out.println("Thread: " + threadName + ", Wait time in ms: " + (waitTime / 100));

        // Release the latch to signal that this thread has completed
        latch.countDown();
    }
}
