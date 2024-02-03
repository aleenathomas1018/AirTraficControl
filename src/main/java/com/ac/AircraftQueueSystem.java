package com.ac;

import com.ac.enums.AircraftSize;
import com.ac.enums.AircraftType;
import com.ac.enums.RequestType;
import com.ac.model.Aircraft;
import com.ac.model.Request;
import com.ac.service.AircraftQueueManager;

/**
 * The main class representing the Aircraft Queue System.
 * It demonstrates the usage of the AircraftQueueManager by performing system boot,
 * enqueueing aircraft, printing the enqueue aircraft list, and dequeuing aircraft.
 */
public class AircraftQueueSystem {
    /**
     * The main method illustrating the usage of the Aircraft Queue System.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args) {
        // Example usage
        AircraftQueueManager queueManager = new AircraftQueueManager();

        // System Boot
        aqm_request_process(queueManager, new Request(RequestType.SYSTEM_BOOT, null));

        // Enqueue Aircraft
        aqm_request_process(queueManager, new Request(RequestType.ENQUEUE_AIRCRAFT, new Aircraft(AircraftType.PASSENGER, AircraftSize.LARGE)));
        aqm_request_process(queueManager, new Request(RequestType.ENQUEUE_AIRCRAFT, new Aircraft(AircraftType.CARGO, AircraftSize.SMALL)));

        // Print ENQUEUE_AIRCRAFT list
        System.out.println("ENQUEUE_AIRCRAFT List:");
        for (Aircraft aircraft : queueManager.getAircraftQueue()) {
            System.out.println("Type - " + aircraft.getType() + ", Size - " + aircraft.getSize());
        }

        // Dequeue Aircraft
        Aircraft removedAircraft = aqm_request_process(queueManager, new Request(RequestType.DEQUEUE_AIRCRAFT, null));
        if (removedAircraft != null) {
            System.out.println("Dequeued Aircraft: Type - " + removedAircraft.getType() + ", Size - " + removedAircraft.getSize());
        }
    }

    /**
     * Process requests for the Aircraft Queue Manager.
     *
     * @param queueManager The AircraftQueueManager instance.
     * @param request      The request to be processed.
     * @return The dequeued aircraft if applicable; otherwise, null.
     */
    public static Aircraft aqm_request_process(AircraftQueueManager queueManager, Request request) {
        switch (request.getType()) {
            case SYSTEM_BOOT:
                // Perform system boot initialization if needed
                break;
            case ENQUEUE_AIRCRAFT:
                // Enqueue aircraft into the system
                queueManager.enqueueAircraft(request.getAircraft());
                break;
            case DEQUEUE_AIRCRAFT:
                // Dequeue aircraft based on removal precedence rules
                return queueManager.dequeueAircraft();
        }
        return null;
    }
}
