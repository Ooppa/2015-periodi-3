/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Defines the importance of given quality, category or rating.
 *
 * @author Ooppa
 */
public enum Value {

    VERY_HIGH(1.5),
    HIGH(1.25),
    NORMAL(1.0),
    LOW(0.75),
    VERY_LOW(0.5),
    IGNORE(0.0);

    private final double value;

    private Value(double value) {
        this.value = value;
    }

    /**
     * Get value as double
     *
     * @return value returns the value as double
     */
    public double getValueAsDouble() {
        return this.value;
    }

}
