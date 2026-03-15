package de.demo.demoapp.services;

import org.springframework.stereotype.Service;

@Service
public class ContactCategotyService {

    public enum ContactCategory {
        YOUNG, OLD, OTHER
    }

    public ContactCategory getContactCategory(Contact contact) {
        if (contact.getBirthdate().getYear() <= 1970)
            return ContactCategory.OLD;
        if (contact.getBirthdate().getYear() > 1990)
            return ContactCategory.YOUNG;
        return ContactCategory.OTHER;
    }   

}
