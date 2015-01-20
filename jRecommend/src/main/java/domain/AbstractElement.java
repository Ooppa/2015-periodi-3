/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Defines an element that has id, name and description
 *
 * @author Ooppa
 */
public abstract class AbstractElement {

    private final long id;
    private String name, description;

    /**
     *
     * @param id
     * @param name
     */
    public AbstractElement(long id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get unique id of the AbstractElement
     *
     * @return
     */
    public long getId() {
        return this.id;
    }

    /**
     * Get the name of the AbstractElement
     *
     * @return
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
     * @return
     */
    public String getDescription() {
        return this.description;
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
    public int hashCode() {
        int hash = 5;
        hash = 79*hash+(int) (this.id^(this.id>>>32));
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
        return true;
    }

}
