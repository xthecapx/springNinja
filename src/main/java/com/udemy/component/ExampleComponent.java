package com.udemy.component;

import com.udemy.controller.Example3Controller;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

@Component("exampleComponent")
public class ExampleComponent {
    private static final Log LOGGER = LogFactory.getLog(ExampleComponent.class);

    public void sayHellow() {
        LOGGER.info("HELLO FORM EXAMPLE COMPONENT");
    }
}
