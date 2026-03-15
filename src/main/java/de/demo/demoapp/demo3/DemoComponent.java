package de.demo.demoapp.demo3;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.littemplate.LitTemplate;

@Tag("demo-component")
@JsModule("./src/demo3/demo-component.ts")
public class DemoComponent extends LitTemplate {

    public DemoComponent(String content) {
        this.getElement().setProperty("content", content);
    }

}
