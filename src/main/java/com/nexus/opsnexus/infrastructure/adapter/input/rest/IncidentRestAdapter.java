package com.nexus.opsnexus.infrastructure.adapter.input.rest;

import com.nexus.opsnexus.application.dto.CreateIncidentCommand;
import com.nexus.opsnexus.application.dto.IncidentView;
import com.nexus.opsnexus.application.port.input.IncidentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/incidents")
public class IncidentRestAdapter {

    private final IncidentUseCase incidentUseCase;

    @PostMapping
    public ResponseEntity<IncidentView> createIncident(
            @RequestBody CreateIncidentCommand command
    ) {
        IncidentView incidentView = incidentUseCase.createIncident(command);
        return ResponseEntity.status(HttpStatus.CREATED).body(incidentView);
    }

    @PatchMapping("/{id}/acknowledge")
    public ResponseEntity<Void> acknowledgeIncident(
            @PathVariable("id") Long id
    ) {
        incidentUseCase.acknowledgeIncident(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/resolve")
    public ResponseEntity<Void> resolveIncident(
            @PathVariable("id") Long id
    ) {
        incidentUseCase.resolveIncident(id);
        return ResponseEntity.ok().build();
    }
}
