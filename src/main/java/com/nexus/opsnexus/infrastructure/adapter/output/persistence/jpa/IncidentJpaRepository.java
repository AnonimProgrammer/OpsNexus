package com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa;

import com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.entity.IncidentJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentJpaRepository extends JpaRepository<IncidentJpaEntity, Long> {

}
