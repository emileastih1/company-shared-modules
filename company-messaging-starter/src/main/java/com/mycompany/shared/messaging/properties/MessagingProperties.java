package com.mycompany.shared.messaging.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "company.messaging")
public class MessagingProperties {

    /**
     * Example property to enable/disable the starter behavior.
     */
    private boolean enabled = true;

    public boolean isEnabled() { return enabled; }
    public void setEnabled(boolean enabled) { this.enabled = enabled; }
}
