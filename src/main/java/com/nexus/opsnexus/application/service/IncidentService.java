package com.nexus.opsnexus.application.service;

import com.nexus.opsnexus.application.dto.CreateIncidentCommand;
import com.nexus.opsnexus.application.dto.IncidentView;
import com.nexus.opsnexus.application.exception.IncidentNotFoundException;
import com.nexus.opsnexus.application.mapper.IncidentMapper;
import com.nexus.opsnexus.application.port.input.IncidentUseCase;
import com.nexus.opsnexus.application.port.output.IncidentRepositoryPort;
import com.nexus.opsnexus.domain.model.Incident;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class IncidentService implements IncidentUseCase {

    private final IncidentRepositoryPort incidentRepositoryPort;
    private final IncidentMapper incidentMapper;

    @Override
    public IncidentView createIncident(CreateIncidentCommand command) {
        log.info("Creating incident. Type: {}, Severity: {}, Reason: {}",
                command.type(), command.severity(), command.reason());

        Incident incident = incidentMapper.toModel(command);
        Incident saveIncident = incidentRepositoryPort.save(incident);

        log.info("Created incident. ID: {}", saveIncident.getId());
        return incidentMapper.toView(saveIncident);
    }

    @Override
    public void acknowledgeIncident(Long id) {
        log.info("Acknowledging incident. ID: {}", id);
        Incident incident = getByIdOrThrow(id);

        incident.acknowledge();
        incidentRepositoryPort.save(incident);

        log.info("Acknowledged incident. ID: {}", id);
    }

    @Override
    public void resolveIncident(Long id) {
        log.info("Resolving incident. ID: {}", id);
        Incident incident = getByIdOrThrow(id);

        incident.resolve();
        incidentRepositoryPort.save(incident);

        log.info("Resolved incident. ID: {}", id);
    }

    private Incident getByIdOrThrow(Long id) {
        return incidentRepositoryPort.findById(id)
                .orElseThrow(() -> new IncidentNotFoundException(id));
    }
}
