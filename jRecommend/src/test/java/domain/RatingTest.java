/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author Ooppa
 */
public class RatingTest {

    private Rating testRating;

    public RatingTest() {
    }

    @Before
    public void setUp() {
        User creator = new User(1L, "Test", "User");
        Item item = new Item(1L, "Test Item");

        this.testRating = new Rating(creator, item, Star.THREE);
    }

    @After
    public void tearDown() {
        this.testRating = null;
    }

    @Test
    public void testGetRightCreator() {
        assertEquals(this.testRating.getCreator().getId(), 1L);
    }

    @Test
    public void testGetWrongCreator() {
        assertFalse(this.testRating.getCreator().getId()==2L);
    }

    @Test
    public void testGetRightItem() {
        assertEquals(this.testRating.getItem().getId(), 1L);
    }

    @Test
    public void testGetWrongItem() {
        assertFalse(this.testRating.getItem().getId()==2L);
    }

    @Test
    public void testGetStarsGiven() {
        assertEquals(this.testRating.getStarsGiven(), Star.THREE);
    }

    @Test
    public void testSetStarsGiven() {
        this.testRating.setStarsGiven(Star.ZERO);
        assertEquals(this.testRating.getStarsGiven(), Star.ZERO);
    }

    @Test
    public void testToString() {
        String toString = this.testRating.toString();

        System.out.println(toString);
        
        assertTrue(toString.contains("Test User")&&toString.contains(Star.THREE.toString()));
    }

    @Test
    public void testEquals() {
        User creator = new User(1L, "Test", "User");
        Item item = new Item(1L, "Test Item");

        Rating otherRating = new Rating(creator, item, Star.THREE);
        assertTrue(this.testRating.equals(otherRating));
    }
    
    @Test
    public void testNotEquals() {
        User creator = new User(2L, "Other", "User");
        Item item = new Item(2L, "Other Item");

        Rating otherRating = new Rating(creator, item, Star.THREE);
        assertFalse(this.testRating.equals(otherRating));
    }
    
    @Test
    public void testEqualsWhenNull() {
        assertFalse(this.testRating.equals(null));
    }
    
    @Test
    public void testEqualsWhenWrongClass() {
        Item item = new Item(1L, "Not a rating");
        assertFalse(this.testRating.equals(item));
    }
    
    @Test
    public void testHashCodeWithSame() {
        assertTrue(this.testRating.hashCode() == this.testRating.hashCode());
    }
    
    @Test
    public void testHashCodeWithDifferent() {
        User creator = new User(2L, "Other", "User");
        Item item = new Item(2L, "Other Item");

        Rating otherRating = new Rating(creator, item, Star.THREE);
        assertTrue(this.testRating.hashCode() != otherRating.hashCode());
    }

}
