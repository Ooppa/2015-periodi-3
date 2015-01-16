/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.ArrayList;

/**
 * Defines an item that can be recommended by the algorithm.
 *
 * @author Ooppa
 */
public class Item extends AbstractElement {

    private ArrayList<Category> categories;
    private ArrayList<Quality> qualities;
    private ArrayList<Rating> ratings;

    public Item(long id, String name) {
        super(id, name);
        this.categories = new ArrayList<>();
        this.qualities = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    /**
     * Returns a list of categories associated with the item
     *
     * @return categories a list of current ratings associated with the item
     *
     * @see Category
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Add a new category for the item
     *
     * @param category category to add
     *
     * @see Category
     */
    public void addCategory(Category category) {
        // TODO
    }

    /**
     * Remove the category given from the item
     *
     * @param category category to remove
     *
     * @see Category
     */
    public void removeCategory(Category category) {
        // TODO
    }

    /**
     * Returns a list of qualities associated with the item
     *
     * @return a list of current qualities associated with the item
     *
     * @see Quality
     */
    public ArrayList<Quality> getQualities() {
        return qualities;
    }

    /**
     * Add a new quality for the item
     *
     * @param quality Quality to add
     *
     * @see Quality
     */
    public void addQuality(Quality quality) {
        // TODO
    }

    /**
     * Remove the quality given from the item
     *
     * @param quality Quality to add
     *
     * @see Quality
     */
    public void removeQuality(Quality quality) {
        // TODO
    }

    /**
     * Returns a list of ratings associated with the item
     *
     * @return ratings a list of current ratings associated with the item
     *
     * @see Rating
     */
    public ArrayList<Rating> getRatings() {
        return ratings;
    }

    /**
     * Add a new rating for the item
     *
     * @param rating
     *
     * @see Rating
     */
    public void addRating(Rating rating) {
        // TODO
    }

    /**
     * Remove the rating given from the item
     *
     * @param rating
     *
     * @see Rating
     */
    public void removeRating(Rating rating) {
        // TODO
    }

}
