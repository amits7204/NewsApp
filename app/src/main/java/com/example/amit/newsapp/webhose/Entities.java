package com.example.amit.newsapp.webhose;

import java.util.List;

public class Entities {
    private List<Persons> persons;

    private List<Organizations> organizations;

    private List<Locations> locations;

    public void setPersons(List<Persons> persons){
        this.persons = persons;
    }
    public List<Persons> getPersons(){
        return this.persons;
    }
    public void setOrganizations(List<Organizations> organizations){
        this.organizations = organizations;
    }
    public List<Organizations> getOrganizations(){
        return this.organizations;
    }
    public void setLocations(List<Locations> locations){
        this.locations = locations;
    }
    public List<Locations> getLocations(){
        return this.locations;
    }
}
