package com.problemSolving.transactionalBehaviour;

import com.problemSolving.repository.PersonRepository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CountDownLatch;

@RestController
public class IolationTesting extends Helper {
    private final PersonRepository personRepository;

    public IolationTesting(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/updatePersonWithDefaultIsolation")
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.DEFAULT)
    public boolean updatePersonWithDefaultIsolation() {
        /**
         * This is the default isolation level used by your database system.
         * It typically corresponds to the default isolation level of your database management system.
         * It's a good choice if you want to rely on the default behavior.
         * For Isolation.DEFAULT the Isolation depend on database system as like shared below,
         * For MySql   : the Isolation.DEFAULT = Isolation.REPEATABLE_READ
         * For Oracle  : the Isolation.DEFAULT = Isolation.READ_COMMITTED
         */
        updatePersonWithDefaultIsolation(personRepository);
        return true;
    }

    @GetMapping("/updatePersonWithReadUnCommitted")
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_UNCOMMITTED)
    public boolean updatePersonWithReadUnCommitted() {


        /**
         * This is the default isolation level used by your database system.
         * It typically corresponds to the default isolation level of your database management system.
         * It's a good choice if you want to rely on the default behavior.
         * For Isolation.DEFAULT the Isolation depend on database system as like shared below,
         * For MySql   : the Isolation.DEFAULT = Isolation.REPEATABLE_READ
         * For Oracle  : the Isolation.DEFAULT = Isolation.READ_COMMITTED
         */

        updatePersonWithReadUnCommitted(personRepository);
        return true;
    }

    @GetMapping("/updatePersonWithRepeatedRead")
    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.REPEATABLE_READ)
    public boolean updatePersonWithRepeatableRead() {
           /*
        REPEATABLE_READ (Isolation.REPEATABLE_READ):
                        This isolation level prevents non-repeatable reads,
                         meaning that once a transaction reads a value,
                         it will always see the same value,
                         even if other transactions modify it. However, it may still allow phantom reads.


        it always read committed data when current transaction wanna access the data and within this process if another transaction
        change the data then if this transaction wanna again get data from same row it will show the previous data not the updated
        committed data which is updated and committed by another transaction
         */
        updatePersonWithRepeatableRead(personRepository);
        return true;
    }

    @GetMapping("/updatePersonPersonWithSerializable")
  //  @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.SERIALIZABLE)
    public boolean updatePersonPersonWithSerializable() {
        // Create a latch to synchronize the threads
        CountDownLatch latch = new CountDownLatch(2);

        // Simulate two services concurrently updating the same record
        Thread thread1 = new Thread(() -> updatePersonWithSerializable("thread1", latch,personRepository,10));
        Thread thread2 = new Thread(() -> updatePersonWithSerializable("thread2", latch, personRepository,20));
        thread1.start();
        thread2.start();

        try {
            // Wait for both threads to complete
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return true;
    }

}
