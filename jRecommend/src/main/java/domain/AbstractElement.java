/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import java.util.Objects;

/**
 * Defines an element that has id, name and description
 *
 * @author Ooppa
 */
public abstract class AbstractElement {

    private final long id;
    private String name, description;

    /**
     * Creates a new AbstractElement
     *
     * @param id   Unique Id the of AbstractElement
     * @param name Name of the AbstractElement
     */
    public AbstractElement(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get unique id of the AbstractElement
     *
     * @return Unique id of the AbstractElement
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get the name of the AbstractElement
     *
     * @return Name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set new name for the AbstractElement
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the description of the AbstractElement
     *
     * @return Description
     */
    public String getDescription() {
        if(this.description==null) {
            return "No description";
        } else {
            return this.description;
        }
    }

    /**
     * Set new description for the AbstractElement
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return getName()+" ("+getDescription()+")";
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17*hash+(int) (this.id^(this.id>>>32));
        hash = 17*hash+Objects.hashCode(this.name);
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
        final AbstractElement other = (AbstractElement) obj;
        if(this.id!=other.id) {
            return false;
        }
        if(!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }

    

}
