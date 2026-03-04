package de.demo.demoapp.demo2.forms;

import java.util.Optional;

import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.StringLengthValidator;

import de.demo.demoapp.services.Contact;
import jakarta.annotation.Nullable;

public class ContactForm extends Composite<FormLayout> {

    private final Binder<Contact> binder;
    private @Nullable Contact formDataObject;

    public ContactForm() {

        TextField nameField = new TextField("Name");
        DatePicker birthdateField = new DatePicker("Birthdate");
        TextField companyField = new TextField("Company");

        FormLayout formLayout = getContent();
        formLayout.add(nameField);
        formLayout.add(birthdateField);
        formLayout.add(companyField);

        binder = new Binder<>();
        binder.forField(nameField)
                .asRequired()
                .withValidator(new StringLengthValidator(
                        "Name must be between 5 and 100 characters", 5, 100))
                .bind(Contact::getName, Contact::setName);
        binder.forField(birthdateField).bind(Contact::getBirthdate, Contact::setBirthdate);
        binder.forField(companyField).bind(Contact::getCompany, Contact::setCompany);
    }

    public void setFormDataObject(@Nullable Contact formDataObject) {
        this.formDataObject = formDataObject;
        if (formDataObject != null) {
            binder.readBean(formDataObject);
        } else {
            binder.refreshFields();
        }
    }

    public Optional<Contact> getFormDataObject() {
        if (formDataObject == null) {
            formDataObject = new Contact();
        }
        if (binder.writeBeanIfValid(formDataObject)) {
            return Optional.of(formDataObject);
        } else {
            return Optional.empty();
        }
    }

}
