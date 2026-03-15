package de.demo.demoapp.demo2.frontend.views;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

@Route("/demo2/HomeView")
@Menu(title = "Home", icon = "vaadin:home", order = 1)
public class HomeView extends VerticalLayout {

    public HomeView() {
        this.add(new H1("Home"));
        this.add(new Text("Here could be cool content :-)"));
    }

}
