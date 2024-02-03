package com.ac.service;

import com.ac.enums.AircraftSize;
import com.ac.enums.AircraftType;
import com.ac.model.Aircraft;

import java.util.LinkedList;
import java.util.List;

/**
 * The AircraftQueueManager class represents a manager for an aircraft queue system.
 * It allows the enqueueing and dequeuing of aircraft based on removal precedence rules.
 */
public class AircraftQueueManager {

    private List<Aircraft> aircraftQueue; // Using List to utilize indexOf

    /**
     * Constructs an AircraftQueueManager with an empty aircraft queue.
     */
    public AircraftQueueManager() {
        aircraftQueue = new LinkedList<>();
    }

    /**
     * Enqueues an aircraft into the system.
     *
     * @param aircraft The aircraft to be enqueued.
     */
    public void enqueueAircraft(Aircraft aircraft) {
        aircraftQueue.add(aircraft);
    }

    /**
     * Dequeues an aircraft based on removal precedence rules.
     *
     * @return The dequeued aircraft, or null if the queue is empty.
     */
    public Aircraft dequeueAircraft() {
        if (!aircraftQueue.isEmpty()) {
            Aircraft removedAircraft = aircraftQueue.get(0);

            for (Aircraft currentAircraft : aircraftQueue) {
                if (shouldRemove(currentAircraft, removedAircraft)) {
                    removedAircraft = currentAircraft;
                }
            }

            aircraftQueue.remove(removedAircraft);
            return removedAircraft;
        }
        return null;
    }

    /**
     * Checks the removal precedence based on the defined rules.
     *
     * @param current   The current aircraft being considered.
     * @param candidate The candidate aircraft for removal.
     * @return True if the candidate should be removed; otherwise, false.
     */
    private boolean shouldRemove(Aircraft current, Aircraft candidate) {
        return (current.getType() == AircraftType.PASSENGER && candidate.getType() == AircraftType.CARGO) ||
                (current.getType() == candidate.getType() &&
                        ((current.getSize() == AircraftSize.LARGE && candidate.getSize() == AircraftSize.SMALL) ||
                                (current.getSize() == candidate.getSize() &&
                                        aircraftQueue.indexOf(current) < aircraftQueue.indexOf(candidate))));
    }

    /**
     * Retrieves the current state of the aircraft queue.
     *
     * @return A new List containing the current aircraft queue.
     */
    public List<Aircraft> getAircraftQueue() {
        return new LinkedList<>(aircraftQueue);
    }
}
