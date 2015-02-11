/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Comparator;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Used to save Items recommendation level
 *
 * @author Ooppa
 * @see Item
 */
public class RecommendedItem implements Comparator<RecommendedItem> {

    private Item item;
    private double ratingLevel;

    private static final Logger logger = Logger.getLogger(RecommendedItem.class.getName());

    /**
     * Creates a new RecommendedItem
     *
     * @param item   Item to add
     * @param rating Rating to associate with the item
     *
     * @see Item
     */
    public RecommendedItem(Item item, double rating) {
        if(item==null) {
            logger.log(Level.WARNING, "Trying to create RecommendedItem with a null parameter.");
        }

        this.item = item;
        this.ratingLevel = rating;
    }

    /**
     * Creates a new but empty RecommendedItem, mainly used for Comparator
     */
    public RecommendedItem() {
    }

    /**
     * Returns the item recommended
     *
     * @return Item
     *
     * @see Item
     */
    public Item getItem() {
        return item;
    }

    /**
     * Set new item to be recommended
     *
     * @param item Item to set
     *
     * @see Item
     */
    public void setItem(Item item) {
        if(item!=null) {
            this.item = item;
        }
    }

    /**
     * Returns the rating level associated with the item
     *
     * @return Recommendation ratingLevel as double
     */
    public double getRatingLevel() {
        return ratingLevel;
    }

    /**
     * Set new rating level for the item associated with the item
     * Can't be negative, negative values are turned into positives
     *
     * @param rating Rating to set
     */
    public void setRatingLevel(double rating) {
        this.ratingLevel = Math.abs(rating);
    }

    @Override
    public String toString() {
        return ratingLevel+": "+item.toString();
    }

    @Override
    public int compare(RecommendedItem item, RecommendedItem otherItem) {
        return Double.compare(item.getRatingLevel(), otherItem.getRatingLevel());
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71*hash+Objects.hashCode(this.item);
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
        final RecommendedItem other = (RecommendedItem) obj;
        if(!Objects.equals(this.item, other.item)) {
            return false;
        }
        return true;
    }

}
