/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import org.junit.*;

/**
 * Tests the Value enumeration
 *
 * @author Ooppa
 * @see Value
 */
public class ValueTest {

    public ValueTest() {
    }

    @Test
    public void testGetValueAsDoubleForVERY_HIGH() {
        Value value = Value.VERY_HIGH;
        assertEquals(value.getValueAsDouble(), 1.5);
    }

    @Test
    public void testGetValueAsDoubleForHIGH() {
        Value value = Value.HIGH;
        assertEquals(value.getValueAsDouble(), 1.25);
    }

    @Test
    public void testGetValueAsDoubleForNORMAL() {
        Value value = Value.NORMAL;
        assertEquals(value.getValueAsDouble(), 1.0);
    }

    @Test
    public void testGetValueAsDoubleForLOW() {
        Value value = Value.LOW;
        assertEquals(value.getValueAsDouble(), 0.75);
    }

    @Test
    public void testGetValueAsDoubleForVERY_LOW() {
        Value value = Value.VERY_LOW;
        assertEquals(value.getValueAsDouble(), 0.5);
    }

    @Test
    public void testGetValueAsDoubleForIGNORE() {
        Value value = Value.IGNORE;
        assertEquals(value.getValueAsDouble(), 0.0);
    }

    @Test
    public void testValueOfVERY_HIGH() {
        assertEquals(Value.valueOf("VERY_HIGH"), Value.VERY_HIGH);
    }

    @Test
    public void testValueOfHIGH() {
        assertEquals(Value.valueOf("HIGH"), Value.HIGH);
    }

    @Test
    public void testValueOfNORMAL() {
        assertEquals(Value.valueOf("NORMAL"), Value.NORMAL);
    }

    @Test
    public void testValueOfLOW() {
        assertEquals(Value.valueOf("LOW"), Value.LOW);
    }

    @Test
    public void testValueOfVERY_LOW() {
        assertEquals(Value.valueOf("VERY_LOW"), Value.VERY_LOW);
    }

    @Test
    public void testValueOfIGNORE() {
        assertEquals(Value.valueOf("IGNORE"), Value.IGNORE);
    }

    @Test
    public void testEffectOnValueCanBeSeen() {
        Value high = Value.HIGH;
        Value veryLow = Value.VERY_LOW;
        double example = 15864684.4;
        assertTrue((example*high.getValueAsDouble())
                >(example*veryLow.getValueAsDouble()));
    }

}
