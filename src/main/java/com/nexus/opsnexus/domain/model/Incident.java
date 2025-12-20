package com.nexus.opsnexus.domain.model;

import com.nexus.opsnexus.domain.exception.InvalidIncidentStateException;
import lombok.Getter;

import java.util.Objects;

@Getter
public class Incident {

    private final Long id;
    private final IncidentType type;
    private final Severity severity;
    private final String reason;
    private IncidentStatus status;

    private Incident(
            Long id,
            IncidentType type,
            Severity severity,
            String reason,
            IncidentStatus status
    ) {
        this.id = id;
        this.type = Objects.requireNonNull(type);
        this.severity = Objects.requireNonNull(severity);
        this.reason = Objects.requireNonNull(reason);
        this.status = Objects.requireNonNull(status);
    }

    public static Incident open(
            IncidentType type,
            Severity severity,
            String reason
    ) {
        return new Incident(null, type, severity, reason, IncidentStatus.OPEN);
    }

    public static Incident reconstitute(
            Long id,
            IncidentType type,
            Severity severity,
            String reason,
            IncidentStatus status
    ) {
        return new Incident(id, type, severity, reason, status);
    }

    public void acknowledge() {
        if (!isOpen()) {
            throw new InvalidIncidentStateException(
                    "Only OPEN incidents can be acknowledged."
            );
        }
        this.status = IncidentStatus.ACKNOWLEDGED;
    }

    public void resolve() {
        if (!isAcknowledged()) {
            throw new InvalidIncidentStateException(
                    "Only ACKNOWLEDGED incidents can be resolved."
            );
        }
        this.status = IncidentStatus.RESOLVED;
    }

    public boolean isOpen() {
        return status == IncidentStatus.OPEN;
    }

    public boolean isAcknowledged() {
        return status == IncidentStatus.ACKNOWLEDGED;
    }

    public boolean isResolved() {
        return status == IncidentStatus.RESOLVED;
    }

}
