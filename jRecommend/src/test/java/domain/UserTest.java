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
 * @see User
 */
public class UserTest {

    private User testUser;

    public UserTest() {
    }

    @Before
    public void setUp() {
        testUser = new User(1L, "Test", "User");
    }

    @After
    public void tearDown() {
        testUser = null;
    }

    @Test
    public void testGetFirstName() {
        assertEquals(testUser.getFirstName(), "Test");
    }

    @Test
    public void testGetLastName() {
        assertEquals(testUser.getLastName(), "User");
    }

    @Test
    public void testGetRatingsWhenNone() {
        assertTrue(testUser.getRatings().isEmpty());
    }

    @Test
    public void testAddRatingWithOne() {
        Item item = new Item(1L, "Kukkaruukku");
        Rating rating = new Rating(testUser, item, Star.FIFE);
        
        testUser.addRating(rating);

        assertTrue(testUser.getRatings().contains(rating));
    }
    
    @Test
    public void testAddRatingDuplicates() {
        Item item = new Item(1L, "Kukkaruukku");
        Rating rating = new Rating(testUser, item, Star.FIFE);
        
        testUser.addRating(rating);
        testUser.addRating(rating);
        
        assertTrue(testUser.getRatings().contains(rating));
    }

    @Test
    public void testAddRatingWithMany() {
        Item item1 = new Item(1L, "Kukkaruukku");
        Item item2 = new Item(2L, "Ämpäri");
        
        Rating rating1 = new Rating(testUser, item1, Star.FIFE);
        Rating rating2 = new Rating(testUser, item2, Star.FIFE);
        
        testUser.addRating(rating1);
        testUser.addRating(rating2);

        assertEquals(testUser.getRatings().size(), 2);
    }

    @Test
    public void testRemoveRating() {
        Item item1 = new Item(1L, "Kukkaruukku");
        Item item2 = new Item(2L, "Ämpäri");
        
        Rating rating1 = new Rating(testUser, item1, Star.FIFE);
        Rating rating2 = new Rating(testUser, item2, Star.FIFE);
        
        testUser.addRating(rating1);
        testUser.addRating(rating2);
        testUser.removeRating(rating1);

        assertFalse(testUser.getRatings().contains(rating1));
    }

    @Test
    public void testToString() {
        String toString = testUser.toString();
        
        boolean containsId = toString.contains(testUser.getId()+"");
        boolean containsFirstName = toString.contains(testUser.getFirstName());
        boolean containsLastName = toString.contains(testUser.getLastName());
        
        assertTrue(containsId && containsFirstName && containsLastName);
    }

    @Test
    public void testEqualsWhenTrue() {
        assertTrue(testUser.equals(testUser));
    }

    @Test
    public void testEqualsWhenFalse() {
        User otherUser = new User(2L, "Barak", "Obama");
        
        assertFalse(testUser.equals(otherUser));
    }

}
