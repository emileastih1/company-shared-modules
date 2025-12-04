package com.mycompany.shared.messaging.autoconfig;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AutoConfigSmokeTest {

    @Test
    void exampleBridge_instantiates() {
        CompanyMessagingAutoConfiguration.ExampleMessagingBridge bridge =
            new CompanyMessagingAutoConfiguration.ExampleMessagingBridge(true);
        assertTrue(bridge.isEnabled());
        assertEquals("company-messaging-starter:enabled=true", bridge.ping());
    }
}
