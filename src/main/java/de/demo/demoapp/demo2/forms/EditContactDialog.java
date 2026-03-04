package de.demo.demoapp.demo2.forms;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.function.SerializableConsumer;

import de.demo.demoapp.services.Contact;

public class EditContactDialog extends Dialog{

    private final SerializableConsumer<Contact> onSaveCallback;
    private final ContactForm form;


    public EditContactDialog(Contact contact,  SerializableConsumer<Contact> onSaveCallback) {
        this.onSaveCallback = onSaveCallback;

        form = new ContactForm();
        form.setFormDataObject(contact);

        Button saveBtn = new Button("Save", event -> save());
        saveBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);

        Button cancelBtn = new Button("Cancel", event -> close());

        setHeaderTitle("Edit Contact");
        add(form);
        getFooter().add(cancelBtn, saveBtn);
    }

    private void save() {
        form.getFormDataObject().ifPresent(contact -> { 
            onSaveCallback.accept(contact); 
            close();
        });
    }
}
