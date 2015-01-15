/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.ArrayList;

/**
 * Defines the user which gives ratings for items
 *
 * @author Ooppa
 */
public class User {

    // TODO JavaDoc
    private final long id;
    private String firstName, surName;
    private ArrayList<Rating> ratings;

    public User(long id, String firstName, String surName) {
        this.id = id;
        this.firstName = firstName;
        this.surName = surName;
        this.ratings = new ArrayList<>();
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(ArrayList<Rating> ratings) {
        this.ratings = ratings;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23*hash+(int) (this.id^(this.id>>>32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(getClass()!=obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if(this.id!=other.id) {
            return false;
        }
        return true;
    }

}
