package de.demo.demoapp.demo2.frontend.views.custom_dashboard_view;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@SessionScope
@Component
public class DashboardStorage {
    private List<WidgetConfig> config;

    public List<WidgetConfig> load() {
        return config;
    }

    public void save(List<WidgetConfig> config) {
        this.config = config;
    }
}
