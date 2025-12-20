package com.nexus.opsnexus.application.dto;

import com.nexus.opsnexus.domain.model.IncidentStatus;
import com.nexus.opsnexus.domain.model.IncidentType;
import com.nexus.opsnexus.domain.model.Severity;

public record IncidentView(
        Long id,
        IncidentType type,
        Severity severity,
        String reason,
        IncidentStatus status
) {}
