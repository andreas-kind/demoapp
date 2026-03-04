package de.demo.demoapp.services;

import java.time.LocalDate;

public class Contact {

    private Long id;
   
    private String name;
    private LocalDate birthdate;
    private String company;

    public Contact() {
    }

    public Contact(String name, LocalDate birthdate, String company) {
        this.name = name;
        this.birthdate = birthdate;
        this.company = company;
    }

    Contact(Long id, String name, LocalDate birthdate, String company){
        this(name, birthdate, company);
        this.id=id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

}
