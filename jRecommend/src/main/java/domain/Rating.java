/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Date;

/**
 * User given rating to a certain item.
 *
 * @author Ooppa
 */
public class Rating {

    /*
     * Unique ID for the rating, used to identify the rating
     */
    private final long id;

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
    public Rating(long id, User creator, Item item, Star starsGiven) {
        this.id = id;
        this.creator = creator;
        this.item = item;
        this.starsGiven = starsGiven;
        this.timestamp = new Date().getTime();
    }

    // TODO JavaDoc
    public User getCreator() {
        return creator;
    }

    public Item getItem() {
        return item;
    }

    public Star getStarsGiven() {
        return starsGiven;
    }

    public void setStarsGiven(Star starsGiven) {
        this.starsGiven = starsGiven;
    }

    @Override
    public String toString() {
        return id+": Rating: "+this.starsGiven.toString()+" by "+this.creator.toString();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67*hash+(int) (this.id^(this.id>>>32));
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
        if(this.id!=other.id) {
            return false;
        }
        return true;
    }

}
