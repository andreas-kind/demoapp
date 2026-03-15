package de.demo.demoapp.demo3;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route("/demo3/viewWithCustomComponent")
public class ViewWithCustomComponent extends VerticalLayout {

    Logger logger = LoggerFactory.getLogger(ViewWithCustomComponent.class);

    public ViewWithCustomComponent() {
        Date now = new Date();
        logger.info("Current date and time: {}", now);

        this.add(new DemoComponent("Contetnt from the custom component! Current date and time: " + now));
    }

}
