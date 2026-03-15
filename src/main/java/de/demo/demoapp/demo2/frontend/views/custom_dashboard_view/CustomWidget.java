package de.demo.demoapp.demo2.frontend.views.custom_dashboard_view;

import com.vaadin.flow.component.dashboard.DashboardWidget;

class CustomWidget extends DashboardWidget {
    private final WidgetConfig.WidgetType type;

    public CustomWidget(WidgetConfig.WidgetType type) {
        super(type.getLabel());
        this.type = type;
    }

    public WidgetConfig.WidgetType getType() {
        return type;
    }
}