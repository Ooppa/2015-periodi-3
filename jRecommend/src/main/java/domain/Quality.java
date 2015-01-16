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
    
    // TODO JavaDoc

    private ArrayList<Category> categories;
    private Value importance;

    public Quality(long id, String name) {
        super(id, name);
        this.categories = new ArrayList<>();
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
    
}
