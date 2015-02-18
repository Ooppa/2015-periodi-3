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
public class RecommendedItemTest {

    private RecommendedItem recommendedItem;
    private Item testItem;

    public RecommendedItemTest() {
    }

    @Before
    public void setUp() {
        testItem = new Item(1L, "Can Opener EXTREME");
        recommendedItem = new RecommendedItem(testItem, 222.2);
    }

    @After
    public void tearDown() {
        recommendedItem = null;
    }

    @Test
    public void testGetItem() {
        assertEquals(testItem, recommendedItem.getItem());
    }

    @Test
    public void testSetItem() {
        Item other = new Item(5L, "Other item");
        recommendedItem.setItem(other);
        assertTrue(recommendedItem.getItem().equals(other)
                &&recommendedItem.getItem().equals(testItem)==false);
    }

    @Test
    public void testSetNullItem() {
        recommendedItem.setItem(null);
        assertTrue(recommendedItem.getItem().equals(testItem)
                &&recommendedItem.getItem().equals(null)==false);
    }

    @Test
    public void testGetRatingLevel() {
        assertEquals(recommendedItem.getRatingLevel(), 222.2);
    }

    @Test
    public void testSetRatingLevel() {
        long newLevel = Long.MAX_VALUE/2;
        recommendedItem.setRatingLevel(newLevel);
        assertTrue(recommendedItem.getRatingLevel()==newLevel);
    }

    @Test
    public void testSetRatingLevelNegative() {
        long newLevel = -1L;
        recommendedItem.setRatingLevel(newLevel);
        assertTrue(recommendedItem.getRatingLevel()==Math.abs(newLevel));
    }

    @Test
    public void testToString() {
        String toString = recommendedItem.toString();
        assertTrue(toString.contains(recommendedItem.getItem().getName())
                &&toString.contains(recommendedItem.getRatingLevel()+""));
    }

    @Test
    public void testCompare() {
        Item otherItem = new Item(2L, "Can Of Whoopass");
        RecommendedItem otherRecommendedItem = new RecommendedItem(otherItem, 111.1);
        assertEquals(
                new RecommendedItem().compare(recommendedItem, otherRecommendedItem),
                -1
        );
    }

    @Test
    public void testHashCodeWhenEqual() {
        assertEquals(recommendedItem.hashCode(), recommendedItem.hashCode());
    }

    @Test
    public void testHashCodeWhenNotEqual() {
        Item otherItem = new Item(2L, "Can Of Whoopass");
        RecommendedItem otherRecommendedItem = new RecommendedItem(otherItem, 111.1);
        assertTrue(recommendedItem.hashCode()!=otherRecommendedItem.hashCode());
    }

    @Test
    public void testEqualsWhenNull() {
        assertFalse(recommendedItem.equals(null));
    }

    @Test
    public void testEqualsWhenWrongClass() {
        Item otherItem = new Item(2L, "Can Of Whoopass");
        assertFalse(recommendedItem.equals(otherItem));
    }

    @Test
    public void testEqualsWhenEquals() {
        assertTrue(recommendedItem.equals(recommendedItem));
    }

    @Test
    public void testEqualsWhenNotEquals() {
        Item otherItem = new Item(2L, "Can Of Whoopass");
        RecommendedItem otherRecommendedItem = new RecommendedItem(otherItem, 111.1);
        assertFalse(recommendedItem.equals(otherRecommendedItem));
    }

}
