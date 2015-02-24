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
        testUser = new User(1L, "Test User");
    }

    @After
    public void tearDown() {
        testUser = null;
    }

    @Test
    public void testGetName() {
        assertEquals(testUser.getName(), "Test User");
    }

    @Test
    public void testGetRatingsWhenNone() {
        assertTrue(testUser.getRatings().isEmpty());
    }

    @Test
    public void testAddRatingWithOne() {
        Item item = new Item(1L, "Kukkaruukku");
        Rating rating = new Rating(2L, testUser, item, Star.FIFE);

        testUser.getRatings().add(rating);

        assertTrue(testUser.getRatings().contains(rating));
    }

    @Test
    public void testAddRatingDuplicates() {
        Item item = new Item(1L, "Kukkaruukku");
        Rating rating = new Rating(2L, testUser, item, Star.FIFE);

        testUser.getRatings().add(rating);
        testUser.getRatings().add(rating);

        assertTrue(testUser.getRatings().contains(rating));
    }

    @Test
    public void testAddRatingWithMany() {
        Item item1 = new Item(1L, "Kukkaruukku");
        Item item2 = new Item(2L, "Ämpäri");

        Rating rating1 = new Rating(2L, testUser, item1, Star.FIFE);
        Rating rating2 = new Rating(3L, testUser, item2, Star.FIFE);

        testUser.getRatings().add(rating1);
        testUser.getRatings().add(rating2);

        assertEquals(testUser.getRatings().size(), 2);
    }

    @Test
    public void testRemoveRating() {
        Item item1 = new Item(1L, "Kukkaruukku");
        Item item2 = new Item(2L, "Ämpäri");

        Rating rating1 = new Rating(2L, testUser, item1, Star.FIFE);
        Rating rating2 = new Rating(3L, testUser, item2, Star.FIFE);

        testUser.getRatings().add(rating1);
        testUser.getRatings().add(rating2);
        testUser.getRatings().remove(rating1);

        assertFalse(testUser.getRatings().contains(rating1));
    }

    @Test
    public void testRemoveRatingThatDoesntExist() {
        Item item1 = new Item(1L, "Kukkaruukku");
        Item item2 = new Item(2L, "Ämpäri");

        Rating rating1 = new Rating(2L, testUser, item1, Star.FIFE);
        Rating rating2 = new Rating(3L, testUser, item2, Star.FIFE);

        testUser.getRatings().add(rating1);

        testUser.getRatings().remove(rating2);

        assertTrue(testUser.getRatings().contains(rating1)==true
                &&testUser.getRatings().contains(rating2)==false);
    }

    @Test
    public void testToString() {
        assertTrue(testUser.toString().contains(testUser.getName()));
    }
    
    @Test
    public void testHashCodeWithSame() {
        assertTrue(testUser.hashCode() == testUser.hashCode());
    }
    
    @Test
    public void testHashCodeWithDifferent() {
        User other = new User(2L, "Other User");
        assertTrue(testUser.hashCode() != other.hashCode());
    }

    @Test
    public void testEqualsWhenTrue() {
        assertTrue(testUser.equals(testUser));
    }

    @Test
    public void testEqualsWhenFalse() {
        User otherUser = new User(2L, "Barak Obama");

        assertFalse(testUser.equals(otherUser));
    }
    
    @Test
    public void testEqualsWhenNull() {
        assertFalse(testUser.equals(null));
    }

    @Test
    public void testEqualsWhenWrongObject() {
        Item item = new Item(1L, "Kukkaruukku");
        assertFalse(testUser.equals(item));
    }

}
