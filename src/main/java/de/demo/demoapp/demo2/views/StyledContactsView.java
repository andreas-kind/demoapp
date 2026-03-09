package de.demo.demoapp.demo2.views;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.Route;

import de.demo.demoapp.demo2.forms.EditContactDialog;
import de.demo.demoapp.services.Contact;
import de.demo.demoapp.services.ContactService;

@Route("/demo2/StyledContactsView")
@Menu(title = "Styled Contacts", icon = "vaadin:list", order = 3)
public class StyledContactsView extends VerticalLayout {

    public StyledContactsView(ContactService contactService) {
        this.setSizeFull();
        this.add(new H1("Styled Contacts"));

        Grid<Contact> grid = new Grid<>(Contact.class, false);
        grid.addColumn(Contact::getId).setHeader("ID").setSortable(true);
        grid.addColumn(Contact::getName).setHeader("Name").setSortable(true);
                        
        //cell styling
        grid.addColumn(Contact::getBirthdate).setHeader("Birthdate")
                .setPartNameGenerator(contact -> {
                    if (contact.getBirthdate().getYear() >= 2000)
                        return "very-young-customers-cell";
                    return null;
                });

        grid.addColumn(Contact::getCompany).setHeader("Company");
        grid.addColumn(new ComponentRenderer<>(contact -> {
            return new Button("Edit Contact", event -> {
                new EditContactDialog(contact, c -> {
                    Contact savedContact = contactService.saveContact(contact);
                    grid.getDataProvider().refreshAll();
                    grid.select(savedContact);
                }).open();
            });
        }));
        
        //row styling
        grid.setPartNameGenerator(contact -> {
            if (contact.getBirthdate().getYear() <= 1970)
                return "old-customers-row";
            if (contact.getBirthdate().getYear() > 1990)
                return "young-customers-row";
            return null;
        });

        grid.setItems(contactService.getContacts());
        this.add(grid);
    }

}
