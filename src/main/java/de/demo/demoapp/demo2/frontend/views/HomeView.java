package de.demo.demoapp.demo2.frontend.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.dashboard.Dashboard;
import com.vaadin.flow.component.dashboard.DashboardWidget;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("/demo2/HomeView")
@Menu(title = "Home", icon = "vaadin:home", order = 1)
public class HomeView extends VerticalLayout {

    public HomeView() {
        this.setSizeFull();
        this.add(new H1("Home"));

        add(createDashboardComponent());
    }

    private Component createDashboardComponent() {
        Dashboard dashboard = new Dashboard();

        dashboard.setGap("20px");
        dashboard.setPadding("1px");
        dashboard.setMinimumColumnWidth("150px");
        dashboard.setMaximumColumnCount(3);

        DashboardWidget widget1 = new DashboardWidget("Widget 1");
        widget1.setContent(createPlaceholderComponent());
        dashboard.add(widget1);

        DashboardWidget widget2 = new DashboardWidget("Widget 2");
        widget2.setContent(createPlaceholderComponent());
        dashboard.add(widget2);

        DashboardWidget widget3 = new DashboardWidget("Widget 3");
        widget3.setContent(createPlaceholderComponent());
        dashboard.add(widget3);

        DashboardWidget widget4 = new DashboardWidget("Widget 4");
        widget4.setContent(createPlaceholderComponent());
        widget4.setRowspan(2);
        dashboard.add(widget4);

        DashboardWidget widget5 = new DashboardWidget("Widget 5");
        widget5.setContent(createPlaceholderComponent());
        dashboard.add(widget5);

        DashboardWidget widget6 = new DashboardWidget("Widget 6");
        widget6.setContent(createPlaceholderComponent());
        dashboard.add(widget6);

        DashboardWidget widget7 = new DashboardWidget("Widget 7");
        widget7.setContent(createPlaceholderComponent());
        widget7.setColspan(2);
        dashboard.add(widget7);

        return dashboard;
    }

    private Component createPlaceholderComponent() {
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.add(new Text(
                "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua."));
        return layout;
    }

}
