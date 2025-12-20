package com.nexus.opsnexus.infrastructure.adapter.output.persistence;

import com.nexus.opsnexus.application.port.output.IncidentRepositoryPort;
import com.nexus.opsnexus.domain.model.Incident;
import com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.IncidentJpaRepository;
import com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.entity.IncidentJpaEntity;
import com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.mapper.IncidentJpaMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
@Primary
public class IncidentRepositoryAdapter implements IncidentRepositoryPort {

    private final IncidentJpaRepository incidentJpaRepository;
    private final IncidentJpaMapper incidentJpaMapper;

    @Override
    public Incident save(Incident incident) {
        IncidentJpaEntity entity = incidentJpaMapper.toJpaEntity(incident);
        IncidentJpaEntity savedEntity =  incidentJpaRepository.save(entity);
        return incidentJpaMapper.toDomainModel(savedEntity);
    }

    @Override
    public Optional<Incident> findById(Long id) {
        return incidentJpaRepository.findById(id)
                .map(incidentJpaMapper::toDomainModel);
    }
}
