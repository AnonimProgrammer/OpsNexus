package com.nexus.opsnexus.application.mapper;

import com.nexus.opsnexus.application.dto.CreateIncidentCommand;
import com.nexus.opsnexus.application.dto.IncidentView;
import com.nexus.opsnexus.domain.model.Incident;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;

@Mapper(componentModel = "spring")
public interface IncidentMapper {

    IncidentView toView(Incident incident);

    @ObjectFactory
    default Incident toModel(CreateIncidentCommand command) {
        return Incident.open(
                command.type(),
                command.severity(),
                command.reason()
        );
    }

}
