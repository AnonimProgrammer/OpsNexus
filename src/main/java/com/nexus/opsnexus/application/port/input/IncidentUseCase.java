package com.nexus.opsnexus.application.port.input;

import com.nexus.opsnexus.application.dto.CreateIncidentCommand;
import com.nexus.opsnexus.application.dto.IncidentView;

public interface IncidentUseCase {

    IncidentView createIncident(CreateIncidentCommand command);

    void acknowledgeIncident(Long id);

    void resolveIncident(Long id);
}
