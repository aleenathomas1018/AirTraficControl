package com.ac.model;

import com.ac.enums.AircraftType;
import com.ac.enums.AircraftSize;

/**
 * The Aircraft class represents an aircraft with a specific type and size.
 * It is used in the Aircraft Queue System for enqueueing and dequeuing operations.
 */
public class Aircraft {
    private final AircraftType type;
    private final AircraftSize size;

    /**
     * Constructs an Aircraft with the specified type and size.
     *
     * @param type The type of the aircraft (e.g., PASSENGER or CARGO).
     * @param size The size of the aircraft (e.g., LARGE or SMALL).
     */
    public Aircraft(AircraftType type, AircraftSize size) {
        this.type = type;
        this.size = size;
    }

    /**
     * Gets the type of the aircraft.
     *
     * @return The type of the aircraft.
     */
    public AircraftType getType() {
        return type;
    }

    /**
     * Gets the size of the aircraft.
     *
     * @return The size of the aircraft.
     */
    public AircraftSize getSize() {
        return size;
    }
}
