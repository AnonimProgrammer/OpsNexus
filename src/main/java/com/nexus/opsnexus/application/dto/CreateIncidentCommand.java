package com.nexus.opsnexus.application.dto;

import com.nexus.opsnexus.domain.model.IncidentType;
import com.nexus.opsnexus.domain.model.Severity;

public record CreateIncidentCommand(
        IncidentType type,
        Severity severity,
        String reason
) {}
