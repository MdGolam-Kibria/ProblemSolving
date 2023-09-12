package com.problemSolving.transactionalBehaviour;

import com.problemSolving.entity.Person;
import com.problemSolving.repository.PersonRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public void updatePersonPersonWithSerializable(PersonRepository personRepository) {
        Person person = personRepository.findById(41).get();
        person.setBalance(person.getBalance() + 10);
        person = personRepository.save(person);
        System.out.println("saved");
    }
}
