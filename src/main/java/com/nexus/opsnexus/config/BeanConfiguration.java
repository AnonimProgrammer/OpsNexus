package com.nexus.opsnexus.config;

import com.nexus.opsnexus.application.mapper.IncidentMapper;
import com.nexus.opsnexus.application.port.output.IncidentRepositoryPort;
import com.nexus.opsnexus.application.port.output.NotifyAuthorityPort;
import com.nexus.opsnexus.application.service.IncidentService;
import com.nexus.opsnexus.domain.policy.NotificationPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    IncidentService incidentService(
            final IncidentRepositoryPort incidentRepositoryPort,
            final NotifyAuthorityPort notifyAuthorityPort,
            final NotificationPolicy notificationPolicy,
            final IncidentMapper incidentMapper
    ) {
        return new IncidentService(
                incidentRepositoryPort, notifyAuthorityPort, notificationPolicy, incidentMapper
        );
    }

    @Bean
    NotificationPolicy notificationPolicy() {
        return new NotificationPolicy();
    }

}
