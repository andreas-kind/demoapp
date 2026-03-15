package de.demo.demoapp.demo2.frontend.views.custom_dashboard_view;

import java.util.List;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dashboard.Dashboard;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("/demo2/CustomDashboardView")
@Menu(title = "Custom Dashboard", icon = "vaadin:dashboard", order = 2)
public class CustomDashboardView extends VerticalLayout {

    private DashboardStorage dashboardStorage;
    private Dashboard dashboard;

    private final List<WidgetConfig> defaultConfig = List.of(
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_1, 1, 1),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_2, 1, 1),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_3, 1, 1),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_4, 1, 2),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_5, 1, 1),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_6, 1, 1),
            new WidgetConfig(WidgetConfig.WidgetType.WIDGET_7, 2, 1));

    public CustomDashboardView(DashboardStorage dashboardStorage) {
        this.dashboardStorage = dashboardStorage;

        this.add(new H1("Custom Dashboard"));

        createEditButton();
        createDashboard();
    }

    private void createDashboard() {
        dashboard = new Dashboard();

        dashboard.setGap("20px");
        dashboard.setPadding("1px");
        dashboard.setMinimumColumnWidth("150px");
        dashboard.setMaximumColumnCount(3);

        // Load the dashboard configuration
        List<WidgetConfig> dashboardConfig = dashboardStorage.load();
        if (dashboardConfig == null) {
            dashboardConfig = defaultConfig;
        }
        applyConfiguration(dashboardConfig);
        add(dashboard);
    }

    private void applyConfiguration(List<WidgetConfig> dashboardConfig) {
        dashboard.removeAll();
        for (WidgetConfig config : dashboardConfig) {

            // Create widget & content
            CustomWidget widget = new CustomWidget(config.getType());
            widget.setColspan(config.getColspan());
            widget.setRowspan(config.getRowspan());
            widget.setContent(createPlaceholderComponent());

            dashboard.add(widget);
        }
    }

    private Component createPlaceholderComponent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.add(new Text(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."));
        return layout;
    }

    private void createEditButton() {
        Button editButton = new Button("Edit", VaadinIcon.EDIT.create());
        editButton.addClickListener(event -> {
            if (dashboard.isEditable()) {
                dashboard.setEditable(false);
                editButton.setText("Edit");
                saveConfiguration();
            } else {
                dashboard.setEditable(true);
                editButton.setText("Apply");
            }
        });
        add(editButton);
    }

    private void saveConfiguration() {
        List<WidgetConfig> dashboardConfig = dashboard.getWidgets().stream()
                .map(widget -> {
                    CustomWidget customWidget = (CustomWidget) widget;
                    return new WidgetConfig(customWidget.getType(),
                            widget.getColspan(), widget.getRowspan());
                }).toList();

        dashboardStorage.save(dashboardConfig);
    }
}
