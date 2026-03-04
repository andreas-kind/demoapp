package de.demo.demoapp.demo1;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import de.demo.demoapp.services.Contact;
import de.demo.demoapp.services.ContactService;

@Route("/demo1/simpleView")
public class SimpleView extends VerticalLayout {

    public SimpleView(ContactService contactService) {
        this.add(new H1("Contacts"));

        Grid<Contact> grid = new Grid<>(Contact.class, false);
        grid.addColumn(Contact::getId).setHeader("ID").setSortable(true);
        grid.addColumn(Contact::getName).setHeader("Name").setSortable(true);
        grid.addColumn(Contact::getBirthdate).setHeader("Birthdate");
        grid.addColumn(Contact::getCompany).setHeader("Company");
        grid.setItems(contactService.getContacts());
        this.add(grid);
    }

}
