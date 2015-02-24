/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.HashMap;
import java.util.Map;

/**
 * Defines the user which gives ratings for items
 *
 * @author Ooppa
 */
public class User extends AbstractElement {

    /*
     * Ratings given by the user
     */
    private AbstractElementHashMap ratings;

    /**
     * Creates a new user
     *
     * @param id   the unique id for the user
     * @param name name of the user
     *
     * @see Rating
     */
    public User(long id, String name) {
        super(id, name);
        this.ratings = new AbstractElementHashMap();
    }

    /**
     * @return the ratings made by User
     */
    public AbstractElementHashMap getRatings() {
        return ratings;
    }

    /**
     * Returns a list of Items rated by this user
     *
     * @return A list of Items rated by this user
     *
     * @see Item
     */
    public HashMap<Long, Item> getRatedItems() {
        HashMap<Long, Item> itemsRated = new HashMap<>();

        for(Map.Entry<Long, Item> entrySet : itemsRated.entrySet()) {
            Long key = entrySet.getKey();
            Item itemRated = entrySet.getValue();

            itemsRated.put(itemRated.getId(), itemRated);
        }

        return itemsRated;
    }

    @Override
    public String toString() {
        return super.toString()+" with "+this.getRatings().size()+" ratings.";
    }

}
