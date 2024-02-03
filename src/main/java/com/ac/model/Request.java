package com.ac.model;

import com.ac.enums.RequestType;

/**
 * The Request class represents a request in the Aircraft Queue System.
 * It encapsulates a request type and an optional associated aircraft.
 */
public class Request {
    private final RequestType type;
    private final Aircraft aircraft;

    /**
     * Constructs a Request with the specified type and associated aircraft.
     *
     * @param type     The type of the request (e.g., SYSTEM_BOOT, ENQUEUE_AIRCRAFT, or DEQUEUE_AIRCRAFT).
     * @param aircraft The associated aircraft, or null if the request does not involve an aircraft.
     */
    public Request(RequestType type, Aircraft aircraft) {
        this.type = type;
        this.aircraft = aircraft;
    }

    /**
     * Gets the type of the request.
     *
     * @return The type of the request.
     */
    public RequestType getType() {
        return type;
    }

    /**
     * Gets the associated aircraft, if any.
     *
     * @return The associated aircraft, or null if the request does not involve an aircraft.
     */
    public Aircraft getAircraft() {
        return aircraft;
    }
}
