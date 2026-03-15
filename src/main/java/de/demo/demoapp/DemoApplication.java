package de.demo.demoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.theme.lumo.Lumo;

import de.demo.demoapp.demo2.frontend.Demo2Styles;

@SpringBootApplication
@StyleSheet(Lumo.STYLESHEET)
@StyleSheet(Demo2Styles.STYLE_SHEET)
public class DemoApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
