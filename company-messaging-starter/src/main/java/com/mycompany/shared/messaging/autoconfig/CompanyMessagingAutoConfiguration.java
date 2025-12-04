package com.mycompany.shared.messaging.autoconfig;

import com.mycompany.shared.messaging.properties.MessagingProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Simple auto-configuration for the example starter.
 *
 * It is conditional on presence of 'org.springframework.kafka.core.KafkaTemplate' (if kafka on classpath)
 * and on property 'company.messaging.enabled=true'.
 */
@Configuration
@ConditionalOnProperty(prefix = "company.messaging", name = "enabled", havingValue = "true", matchIfMissing = true)
@EnableConfigurationProperties(MessagingProperties.class)
@ConditionalOnClass(name = "org.springframework.kafka.core.KafkaTemplate")
public class CompanyMessagingAutoConfiguration {

    private final MessagingProperties properties;

    public CompanyMessagingAutoConfiguration(MessagingProperties properties) {
        this.properties = properties;
    }

    @Bean
    public ExampleMessagingBridge exampleMessagingBridge() {
        return new ExampleMessagingBridge(properties.isEnabled());
    }

    public static class ExampleMessagingBridge {
        private final boolean enabled;
        public ExampleMessagingBridge(boolean enabled) { this.enabled = enabled; }
        public boolean isEnabled() { return enabled; }
        public String ping() { return "company-messaging-starter:enabled=" + enabled; }
    }
}
