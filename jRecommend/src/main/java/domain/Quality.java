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
public class Quality {
    
    // TODO JavaDoc

    private final long id;
    private String name, description;
    private ArrayList<Category> categories;
    private Value importance;

    /**
     * Creates a new quality
     *
     * @param id   the unique id for the item
     * @param name the name for the item
     */
    public Quality(long id, String name) {
        this.id = id;
        this.name = name;
        this.categories = new ArrayList<>();
        this.importance = Value.NORMAL;
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
     * Returns the name of the quality
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new name for the quality
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the description for the quality
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new description for the quality
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     *
     * @param category
     */
    public void addCategory(Category category) {
        this.categories = categories;
    }
    
    /**
     *
     * @param category
     */
    public void removeCategory(Category category) {
        this.categories = categories;
    }

    /**
     *
     * @return
     */
    public Value getImportance() {
        return importance;
    }

    /**
     *
     * @param importance
     */
    public void setImportance(Value importance) {
        this.importance = importance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47*hash+(int) (this.id^(this.id>>>32));
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
        final Quality other = (Quality) obj;
        if(this.id!=other.id) {
            return false;
        }
        return true;
    }

}
