package com.nexus.opsnexus.infrastructure.adapter.output.persistence.jpa.entity;

import com.nexus.opsnexus.domain.model.IncidentStatus;
import com.nexus.opsnexus.domain.model.IncidentType;
import com.nexus.opsnexus.domain.model.Severity;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "incidents")
public class IncidentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private IncidentType type;

    @Enumerated(EnumType.STRING)
    private Severity severity;

    private String reason;

    @Enumerated(EnumType.STRING)
    private IncidentStatus status;
}
