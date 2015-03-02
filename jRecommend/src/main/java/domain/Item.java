/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Map;

/**
 * Defines an item that can be recommended by the algorithm.
 *
 * @author Ooppa
 */
public class Item extends AbstractElement {

    /*
     * Categories this Quality belongs to
     */
    private AbstractElementHashMap categories;

    /*
     * Qualities this item is accoiated with
     */
    private AbstractElementHashMap qualities;

    /*
     * Ratings given to this item
     */
    private AbstractElementHashMap ratings;

    /**
     * Creates a new Item
     *
     * @param id
     * @param name
     *
     * @see AbstractElement
     * @see Category, Quality, Rating
     */
    public Item(long id, String name) {
        super(id, name);
        this.categories = new AbstractElementHashMap();
        this.qualities = new AbstractElementHashMap();
        this.ratings = new AbstractElementHashMap();
    }

    /**
     * @return the categories associated with the Item
     */
    public AbstractElementHashMap getCategories() {
        return categories;
    }

    /**
     * @return the qualities associated with the Item
     */
    public AbstractElementHashMap getQualities() {
        return qualities;
    }

    /**
     * @return the ratings associated with the Item
     */
    public AbstractElementHashMap getRatings() {
        return ratings;
    }

    /**
     * Returns true if this item is rated by given user
     *
     * @param user User to search for
     *
     * @return True if rated by given user
     */
    public boolean isRatedBy(User user) {
        // If creator and item are same, then rating is same
        Rating tempRating = new Rating(0L, user, this, Star.ZERO);

        return ratings.contains(tempRating);
    }

    public AbstractElementHashMap getUsersWhoRated() {
        AbstractElementHashMap usersWhoRated = new AbstractElementHashMap(ratings.size());

        for(Map.Entry<Long, AbstractElement> entrySet : this.ratings.getAsHashMap().entrySet()) {
            Rating rating = (Rating) entrySet.getValue();

            usersWhoRated.add(rating.getCreator());
        }

        return usersWhoRated;
    }

    @Override
    public String toString() {
        return super.toString()
                +" Q:"+qualities.size()
                +" R:"+ratings.size()
                +" C:"+categories.size();
    }

}
