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

    private final long id;
    private String firstName, lastName;

    /*
     * Ratings given by the user
     */
    private ArrayList<Rating> ratings;

    /**
     * Creates a new user
     *
     * @param id        the unique id for the user
     * @param firstName user's first name
     * @param lastName  user's last name
     * @see Rating
     */
    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ratings = new ArrayList<>();
    }

    /**
     * Returns users unique id
     *
     * @return id users id
     */
    public long getId() {
        return this.id;
    }

    /**
     * Returns users first name
     *
     * @return firstName users first name
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Returns users last name
     *
     * @return lastName users last name
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Returns a list of ratings given by the user
     *
     * @see Rating
     * @return ratings ratings given by the user
     */
    public ArrayList<Rating> getRatings() {
        return this.ratings;
    }

    /**
     * Add a new rating to this user
     *
     * @see Rating
     * @param rating rating to add
     */
    public void addRating(Rating rating) {
        if(!this.ratings.contains(rating)) {
            this.ratings.add(rating);
        }
    }

    /**
     * Remove the rating given from the user
     *
     * @param rating rating to remove
     */
    public void removeRating(Rating rating) {
        if(this.ratings.contains(rating)) {
            this.ratings.remove(rating);
        }
    }

    @Override
    public String toString() {
        return this.id+": "+this.firstName+" "+this.lastName;
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