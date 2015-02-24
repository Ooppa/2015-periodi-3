/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.HashMap;

/**
 * Wrapper class for saving AbstractElements
 *
 * @author Ooppa
 */
public class AbstractElementHashMap {

    private final HashMap<Long, AbstractElement> elements;

    /**
     * Creates a new AbstractElementHashMap
     */
    public AbstractElementHashMap() {
        this.elements = new HashMap<>();
    }

    /**
     * Creates a new AbstractElementHashMap with given size
     *
     * @param size Prefixed size for HashMap
     */
    public AbstractElementHashMap(int size) {
        this.elements = new HashMap<>(size);
    }

    /**
     * Clones a new AbstractElementHashMap
     *
     * @param elements HashMap to clone
     */
    public AbstractElementHashMap(HashMap<Long, AbstractElement> elements) {
        this.elements = new HashMap<>(elements);
    }

    /**
     * Checks if the given element is contained in AbstractElementHashMap
     *
     * @param element Element to look for
     *
     * @return boolean
     */
    public boolean contains(AbstractElement element) {
        return this.elements.containsValue(element);
    }

    /**
     * Get AbstractElement matching the id given
     *
     * @param id Id of the AbstractElement to get
     *
     * @return AbstractElement
     */
    public AbstractElement get(Long id) {
        return this.elements.get(id);
    }

    /**
     * Add new element to AbstractElementHashMap
     *
     * @param element Element to add
     */
    public void add(AbstractElement element) {
        if(element!=null) {
            this.elements.put(element.getId(), element);
        }
    }

    /**
     * Add all elements to AbstractElementHashMap
     *
     * @param elements Elements to add
     */
    public void addAll(HashMap<Long, AbstractElement> elements) {
        this.elements.putAll(elements);
    }

    /**
     * Removes element from AbstractElementHashMap
     *
     * @param element Element to remove
     */
    public void remove(AbstractElement element) {
        if(contains(element)) {
            this.elements.remove(element.getId());
        }
    }

    /**
     * Returns the HashMap contained in AbstractElementHashMap
     *
     * @return HashMap
     */
    public HashMap<Long, AbstractElement> getAsHashMap() {
        return elements;
    }

    /**
     * Returns the size of the AbstractElementHashMap
     *
     * @return Size as integer
     */
    public int size() {
        return this.elements.size();
    }

    /**
     * Returns true if the AbstractElementHashMap is empty
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return size()==0;
    }

}
