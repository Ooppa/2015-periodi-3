/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import static junit.framework.Assert.assertEquals;
import org.junit.*;

/**
 * Tests the Star enumeration
 *
 * @author Ooppa
 * @see Star
 */
public class StarTest {

    public StarTest() {
    }

    @Test
    public void testGetAmountAsIntForOneStars() {
        Star star = Star.ONE;
        assertEquals(star.getAmountAsInt(), 1);
    }
    
    @Test
    public void testGetAmountAsIntForTwoStars() {
        Star star = Star.TWO;
        assertEquals(star.getAmountAsInt(), 2);
    }
    
    @Test
    public void testGetAmountAsIntForThreeStars() {
        Star star = Star.THREE;
        assertEquals(star.getAmountAsInt(), 3);
    }
    
    @Test
    public void testGetAmountAsIntForFourStars() {
        Star star = Star.FOUR;
        assertEquals(star.getAmountAsInt(), 4);
    }
    
    @Test
    public void testGetAmountAsIntForFifeStars() {
        Star star = Star.FIFE;
        assertEquals(star.getAmountAsInt(), 5);
    }
    
    @Test
    public void testGetAmountAsIntForZeroStars() {
        Star star = Star.ZERO;
        assertEquals(star.getAmountAsInt(), 0);
    }

    @Test
    public void testValueOfOne() {
        assertEquals(Star.valueOf("ONE"), Star.ONE);
    }

    @Test
    public void testValueOfTwo() {
        assertEquals(Star.valueOf("TWO"), Star.TWO);
    }
    
    @Test
    public void testValueOfThree() {
        assertEquals(Star.valueOf("THREE"), Star.THREE);
    }
    
    @Test
    public void testValueOfFour() {
        assertEquals(Star.valueOf("FOUR"), Star.FOUR);
    }
    
    @Test
    public void testValueOfFife() {
        assertEquals(Star.valueOf("FIFE"), Star.FIFE);
    }
    
    @Test
    public void testValueOfZero() {
        assertEquals(Star.valueOf("ZERO"), Star.ZERO);
    }
    

}
