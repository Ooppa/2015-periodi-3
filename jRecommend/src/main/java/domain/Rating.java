/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * User given rating to a certain item.
 * @author Ooppa
 */
public class Rating {
    
    // TODO JavaDoc
    
    private final long id;
    private final User creator;
    private final Item item;
    private Star starsGiven;

    public Rating(long id, User creator, Item item, Star starsGiven) {
        this.id = id;
        this.creator = creator;
        this.item = item;
        this.starsGiven = starsGiven;
    }

    public User getCreator() {
        return creator;
    }

    public Item getItem() {
        return item;
    }

    public Star getStarsGiven() {
        return starsGiven;
    }

    public void setStarsGiven(Star starsGiven) {
        this.starsGiven = starsGiven;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67*hash+(int) (this.id^(this.id>>>32));
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
        final Rating other = (Rating) obj;
        if(this.id!=other.id) {
            return false;
        }
        return true;
    }
    
    
    
    
}
