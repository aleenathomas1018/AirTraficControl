package app;

import com.ac.enums.AircraftSize;
import com.ac.enums.AircraftType;
import com.ac.model.Aircraft;
import com.ac.service.AircraftQueueManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * JUnit test class for validating the functionality of the AircraftQueueManager.
 * It covers various scenarios of enqueuing and dequeuing aircraft, ensuring the
 * removal precedence rules are followed as specified in the requirements.
 *
 */
public class AircraftQueueManagerTest {
    /**
     * Test case for enqueuing and dequeuing aircraft based on removal precedence rules.
     * It validates that the AircraftQueueManager correctly manages the queue,
     * considering the type, size, and order of enqueued aircraft.
     */
    @Test
    void testEnqueueAndDequeue() {
        AircraftQueueManager queueManager = new AircraftQueueManager();

        // Enqueue Aircraft
        queueManager.enqueueAircraft(new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE));
        queueManager.enqueueAircraft(new Aircraft(AircraftType.CARGO, AircraftSize.SMALL));
        queueManager.enqueueAircraft(new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL));

        // Dequeue Aircraft
        Aircraft dequeuedAircraft1 = queueManager.dequeueAircraft();
        assertNotNull(dequeuedAircraft1);
        assertEquals(AircraftType.PASSENGER, dequeuedAircraft1.getType());
        assertEquals(AircraftSize.LARGE, dequeuedAircraft1.getSize());

        // Enqueue more Aircraft
        queueManager.enqueueAircraft(new Aircraft(AircraftType.CARGO, AircraftSize.LARGE));
        queueManager.enqueueAircraft(new Aircraft(AircraftType.PASSENGER, AircraftSize.SMALL));

        // Dequeue Aircraft
        Aircraft dequeuedAircraft2 = queueManager.dequeueAircraft();
        assertNotNull(dequeuedAircraft2);
        assertEquals(AircraftType.PASSENGER, dequeuedAircraft2.getType());
        assertEquals(AircraftSize.SMALL, dequeuedAircraft2.getSize());

        // Dequeue all remaining Aircraft
        Aircraft dequeuedAircraft3 = queueManager.dequeueAircraft();
        assertNotNull(dequeuedAircraft3);
        assertEquals(AircraftType.PASSENGER, dequeuedAircraft3.getType());
        assertEquals(AircraftSize.SMALL, dequeuedAircraft3.getSize());

        // Dequeue Aircraft
        Aircraft dequeuedAircraft4 = queueManager.dequeueAircraft();
        assertNotNull(dequeuedAircraft4);
        assertEquals(AircraftType.CARGO, dequeuedAircraft4.getType());
        assertEquals(AircraftSize.LARGE, dequeuedAircraft4.getSize());

        Aircraft dequeuedAircraft5 = queueManager.dequeueAircraft();
        assertNotNull(dequeuedAircraft5);
        assertEquals(AircraftType.CARGO, dequeuedAircraft5.getType());
        assertEquals(AircraftSize.SMALL, dequeuedAircraft5.getSize());

        // Dequeue from an empty queue
        Aircraft dequeuedAircraft6 = queueManager.dequeueAircraft();
        assertNull(dequeuedAircraft6);
    }
}
