package com.ac.enums;

/**
 * The RequestType enum represents the type of request in the Aircraft Queue System.
 * It can be SYSTEM_BOOT, ENQUEUE_AIRCRAFT, or DEQUEUE_AIRCRAFT.
 */
public enum RequestType {
    /**
     * Represents a system boot request.
     */
    SYSTEM_BOOT,

    /**
     * Represents an enqueue aircraft request.
     */
    ENQUEUE_AIRCRAFT,

    /**
     * Represents a dequeue aircraft request.
     */
    DEQUEUE_AIRCRAFT
}
