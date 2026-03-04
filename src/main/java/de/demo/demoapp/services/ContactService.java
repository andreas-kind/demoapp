package de.demo.demoapp.services;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import net.datafaker.Faker;

@Service
public class ContactService {

    //This is only Fakedata generated once. In real-world Apps this comes from a DB
    private Map<Long, Contact> contacts = new HashMap<>();
    public ContactService(){
        Faker faker = new Faker();
        for (long a = 0; a < 10000 ; a++) {
            Contact contact = new Contact(a, faker.name().fullName(), faker.timeAndDate().birthday(),faker.company().name());
            contacts.put(contact.getId(), contact);
        }
    }

    public List<Contact> getContacts(){
        return new LinkedList<>(contacts.values());
    }

    public Contact saveContact(Contact contact){
        if (contact.getId()==null) {
            Long max = Collections.max(contacts.keySet());
            contact = new Contact(max+1, contact.getName(), contact.getBirthdate(), contact.getCompany());
        }
        contacts.put(contact.getId(), contact);
        return contact;
    }

}
