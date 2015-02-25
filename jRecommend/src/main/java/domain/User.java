/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

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
        this.ratings = new AbstractElementHashMap(100);
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
    public AbstractElementHashMap getRatedItems() {
        AbstractElementHashMap ratedItems = new AbstractElementHashMap(ratings.size());

        for(Map.Entry<Long, AbstractElement> entrySet : this.ratings.getAsHashMap().entrySet()) {
            Rating rating = (Rating) entrySet.getValue();
            ratedItems.add(rating.getItem());
        }

        return ratedItems;
    }

    /**
     * Returns the rating given to the item by this user
     *
     * @param item Item to search for
     *
     * @return Rating as Star
     */
    public Star getRatingForItem(Item item) {
        for(Map.Entry<Long, AbstractElement> entrySet : this.ratings.getAsHashMap().entrySet()) {
            Rating rating = (Rating) entrySet.getValue();

            if(rating.getItem().equals(item)) {
                return rating.getStarsGiven();
            }

        }

        return Star.ZERO;
    }

    @Override
    public String toString() {
        return super.toString()+" with "+this.getRatings().size()+" ratings.";
    }

}
