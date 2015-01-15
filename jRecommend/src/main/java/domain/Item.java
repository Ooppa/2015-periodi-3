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
public class Item {

    private final long id;
    private String name, description;

    private ArrayList<Category> categories;
    private ArrayList<Quality> qualities;
    private ArrayList<Rating> ratings;

    /**
     * Creates a new Item.
     *
     * @param id   the unique id for the item
     * @param name the name for the item
     */
    public Item(long id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();
        this.qualities = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }

    /**
     * Returns items unique id
     *
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Returns the name of the item
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the item
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description of the item
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new description for the item
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
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
     * @param category
     *
     * @see Category
     */
    public void addCategory(Category category) {
        // TODO
    }

    /**
     * Remove the category given from the item
     *
     * @param category
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

    @Override
    public String toString() {
        if(!description.isEmpty()) {
            return id+": "+name+"("+description+")";
        } else {
            return id+": "+name;
        }
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71*hash+(int) (this.id^(this.id>>>32));
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
        final Item other = (Item) obj;
        if(this.id!=other.id) {
            return false;
        }
        return true;
    }

}
