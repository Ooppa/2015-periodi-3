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

    /*
     * Categories this Quality belongs to
     */
    private ArrayList<Category> categories;

    /*
     * Qualities this item is accoiated with
     */
    private ArrayList<Quality> qualities;

    /*
     * Ratings given to this item
     */
    private ArrayList<Rating> ratings;

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
        if(this.categories.contains(category)==false&&category!=null) {
            this.categories.add(category);
        }
    }

    /**
     * Remove the category given from the item
     *
     * @param category category to remove
     *
     * @see Category
     */
    public void removeCategory(Category category) {
        if(this.categories.contains(category)) {
            this.categories.remove(category);
        }
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
        if(this.qualities.contains(quality)==false&&quality!=null) {
            this.qualities.add(quality);
        }
    }

    /**
     * Remove the quality given from the item
     *
     * @param quality Quality to add
     *
     * @see Quality
     */
    public void removeQuality(Quality quality) {
        if(this.qualities.contains(quality)) {
            this.qualities.remove(quality);
        }
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
        if(this.ratings.contains(rating)==false) {
            this.ratings.add(rating);
        }
    }

    /**
     * Remove the rating given from the item
     *
     * @param rating
     *
     * @see Rating
     */
    public void removeRating(Rating rating) {
        if(this.ratings.contains(rating)) {
            this.ratings.remove(rating);
        }
    }

    /**
     * Get given Users rating for this item. Returns Zero stars if the user
     * haven't rated this item.
     *
     * @param user User to get the rating from
     *
     * @return Stars given to this Item from given User
     *
     * @see User
     * @see Star
     */
    public Star getUsersRating(User user) {
        for(Rating rating : ratings) {
            if(rating.getCreator().equals(user)) {
                return rating.getStarsGiven();
            }
        }

        // Havn't given any rating to that item
        return Star.ZERO;
    }

}
