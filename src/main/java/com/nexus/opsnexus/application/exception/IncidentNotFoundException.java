package com.nexus.opsnexus.application.exception;

public class IncidentNotFoundException extends RuntimeException {

    public IncidentNotFoundException(Long id) {
        super("Incident not found. ID: " + id);
    }
}
