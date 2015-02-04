/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.ArrayList;

/**
 * Defines what special qualities (features) are in certain item.
 *
 * @author Ooppa
 */
public class Quality extends AbstractElement {

    /*
     * Categories this Quality belongs to
     */
    private final ArrayList<Category> categories;

    /*
     * Items this quality is accociated with
     */
    private final ArrayList<Item> items;

    /*
     * The Value of this Quality for the item associated
     */
    private Value importance;

    /**
     * Creates a new quality
     *
     * @param id   the unique id for the quality
     * @param name the name for the quality
     *
     * @see AbstractElement
     * @see Category
     */
    public Quality(long id, String name) {
        super(id, name);
        this.categories = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    /**
     * Returns a list of categories this Quality belongs to
     *
     * @see Category
     * @return a list of categories
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Add a new category for this quality
     *
     * @see Category
     * @param category category to add
     */
    public void addCategory(Category category) {
        if(this.categories.contains(category)==false) {
            this.categories.add(category);
        }
    }

    /**
     * Remove a category from this quality
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
     * Returns a list of items this Quality belongs to
     *
     * @see Item
     * @return a list of items
     */
    public ArrayList<Item> getItems() {
        return items;
    }
    

    /**
     * Add a new item associated with this quality
     *
     * @param Item item to add
     *
     * @see Item
     */
    public void addItem(Item item) {
        if(this.items.contains(item)==false&&item != null) {
            this.items.add(item);
        }
    }

    /**
     * Remove a item associated with this quality
     *
     * @param item item to remove
     *
     * @see Item
     */
    public void removeItem(Item item) {
        if(this.items.contains(item)) {
            this.items.remove(item);
        }
    }

    /**
     * Returns the importance level of this quality
     *
     * @return importance of the Quality
     *
     * @see Value
     */
    public Value getImportance() {
        return importance;
    }

    /**
     * Set a new importance level for this quality
     *
     * @param importance
     *
     * @see Value
     */
    public void setImportance(Value importance) {
        this.importance = importance;
    }

}
