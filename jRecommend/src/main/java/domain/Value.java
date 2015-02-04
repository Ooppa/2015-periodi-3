/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

/**
 * Defines the importance of given quality, category or rating.
 * If the importance of the quality in item A is 1.25 and in
 * item B it's 0.75 the importance between those two is 1.25 * 0.75 = 0.9375
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
