/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Defines what special qualities (features) are in certain item.
 *
 * @author Ooppa
 */
public class Quality extends AbstractElement {

    /*
     * Categories this Quality belongs to
     */
    private AbstractElementHashMap categories;

    /*
     * Items this quality is accociated with
     */
    private AbstractElementHashMap items;

    /*
     * The Value of this Quality for the item associated
     */
    private Value importance;

    /**
     * Creates a new quality
     *
     * @param id   the unique id for the Quality
     * @param name the name for the Quality
     *
     * @see AbstractElement
     * @see Category
     */
    public Quality(long id, String name) {
        super(id, name);
        this.categories = new AbstractElementHashMap();
        this.items = new AbstractElementHashMap();
    }

    /**
     * @return the categories associated with the Quality
     */
    public AbstractElementHashMap getCategories() {
        return categories;
    }

    /**
     * @return the items associated with the Quality
     */
    public AbstractElementHashMap getItems() {
        return items;
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
     * @param importance importance of the Quality
     *
     * @see Value
     */
    public void setImportance(Value importance) {
        this.importance = importance;
    }

    @Override
    public String toString() {
        return "Quality: "+super.toString()+" for "+this.getItems().size()+" items.";
    }

}
