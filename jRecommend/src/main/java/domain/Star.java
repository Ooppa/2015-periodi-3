/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Stars are given as ratings to items
 * The amount of stars varies between 0 and 5.
 *
 * @see Rating
 * @author Ooppa
 */
public enum Star {

    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIFE(5);

    private final int amount;

    private Star(int amount) {
        this.amount = amount;
    }

    /**
     * Get amount of stars given as integer
     *
     * @return amount amount of starts given
     */
    public int getAmountAsInt() {
        return amount;
    }

    @Override
    public String toString() {
        return this.amount+" / 5 Stars";
    }

}
