/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.ArrayList;

/**
 * Used to separate certain items from each other.
 *
 * @author Ooppa
 * @param <E>
 */
public class Category<E> extends AbstractElement {

    private ArrayList<E> elements;

    public Category(long id, String name) {
        super(id, name);
    }
    
    /**
     * Returns a list of categories associated with the category
     *
     * @return elements a list of elements currently in this category
     */
    public ArrayList<E> getElements() {
        return elements;
    }

    /**
     * Add a new element to this category
     *
     * @param element element to add
     */
    public void addElement(E element) {
        // TODO
    }

    /**
     * Remove the element given from the category
     *
     * @param element element to remove
     */
    public void removeElement(E element) {
        // TODO
    }

}
