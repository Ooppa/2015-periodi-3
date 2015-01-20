/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Date;
import java.util.Objects;

/**
 * User given rating to a certain item.
 *
 * @author Ooppa
 */
public class Rating {

    /*
     * Reason who gave the rating
     */
    private final User creator;

    /*
     * Item rated by the creator of the rating
     */
    private final Item item;

    /*
     * The rating given in Stars 0 - 5
     * @see Star
     */
    private Star starsGiven;

    /*
     * Timestamp for when the rating was given
     */
    private final long timestamp;

    /**
     *
     * @param id         the unique id for the given rating
     * @param creator    the creator of the rating
     * @param item       the item rated in the rating
     * @param starsGiven the star rating given in the rating
     *
     * @see User
     * @see Item
     * @see Star
     */
    public Rating(User creator, Item item, Star starsGiven) {
        this.creator = creator;
        this.item = item;
        this.starsGiven = starsGiven;
        this.timestamp = new Date().getTime();
    }

    /*
     * Returns the creator of the rating
     * @see User
     */
    public User getCreator() {
        return creator;
    }

    /*
     * Returns the Item that the rating is accosiated with
     * @see Item
     */
    public Item getItem() {
        return item;
    }

    /*
     * Returns the amount of starts given in the rating
     * @see Star
     */
    public Star getStarsGiven() {
        return starsGiven;
    }

    /*
     * Set a new amout of stars for the rating
     */
    public void setStarsGiven(Star starsGiven) {
        this.starsGiven = starsGiven;
    }

    @Override
    public String toString() {
        return "Rating: "+this.starsGiven.toString()+" by "+this.creator.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89*hash+Objects.hashCode(this.creator);
        hash = 89*hash+Objects.hashCode(this.item);
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
        final Rating other = (Rating) obj;
        if(!Objects.equals(this.creator, other.creator)) {
            return false;
        }
        if(!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

}
