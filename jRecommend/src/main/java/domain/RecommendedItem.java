/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Comparator;

/**
 * Used to save Items recommendation level
 *
 * @author Ooppa
 */
public class RecommendedItem implements Comparator<RecommendedItem> {

    private Item item;
    private double rating;

    public RecommendedItem(Item item, double rating) {
        this.item = item;
        this.rating = rating;
    }

    public RecommendedItem() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return rating+": "+item.toString();
    }

    @Override
    public int compare(RecommendedItem item, RecommendedItem otherItem) {
        return Double.compare(item.getRating(), otherItem.getRating());
    }

}
