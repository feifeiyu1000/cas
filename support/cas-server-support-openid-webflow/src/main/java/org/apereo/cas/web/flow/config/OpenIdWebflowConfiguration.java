package org.apereo.cas.web.flow.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.web.flow.CasWebflowConfigurer;
import org.apereo.cas.web.flow.OpenIdWebflowConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.webflow.definition.registry.FlowDefinitionRegistry;
import org.springframework.webflow.engine.builder.support.FlowBuilderServices;

/**
 * This is {@link OpenIdWebflowConfiguration}.
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@Configuration("openIdWebflowConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class OpenIdWebflowConfiguration {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private CasConfigurationProperties casProperties;
    
    @Autowired
    @Qualifier("loginFlowRegistry")
    private FlowDefinitionRegistry loginFlowDefinitionRegistry;

    @Autowired
    private FlowBuilderServices flowBuilderServices;

    @ConditionalOnMissingBean(name = "openidWebflowConfigurer")
    @Bean
    public CasWebflowConfigurer openidWebflowConfigurer() {
        final CasWebflowConfigurer w = new OpenIdWebflowConfigurer(flowBuilderServices, loginFlowDefinitionRegistry, 
                applicationContext, casProperties);
        w.initialize();
        return w;
    }
}
