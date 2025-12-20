package com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.mapper;

import com.nexus.opsnexus.domain.model.Incident;
import com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.entity.IncidentJpaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

@Mapper(componentModel = "spring")
public interface IncidentJpaMapper {

    @ObjectFactory
    default Incident toDomainModel(IncidentJpaEntity entity) {
        if (entity == null) return null;

        return Incident.reconstitute(
                entity.getId(),
                entity.getType(),
                entity.getSeverity(),
                entity.getReason(),
                entity.getStatus()
        );
    }

    IncidentJpaEntity toJpaEntity(Incident domainModel);
}
