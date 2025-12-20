package com.nexus.opsnexus.application.port.output;

import com.nexus.opsnexus.domain.model.Incident;

import java.util.Optional;

public interface IncidentRepositoryPort {

    Incident save(Incident incident);

    Optional<Incident> findById(Long id);
}
