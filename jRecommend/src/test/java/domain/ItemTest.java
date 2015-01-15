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
 * Tests for Item class.
 *
 * @author Ooppa
 */
public class ItemTest {

    private Item testItem;

    public ItemTest() {
    }

    @Before
    public void setUp() {
        this.testItem = new Item(1L, "Example Item");
        this.testItem.setDescription("Example Description");
    }

    @After
    public void tearDown() {
        this.testItem = null;
    }

    @Test
    public void testGetId() {
        assertEquals(testItem.getId(), 1L);
    }

    @Test
    public void testGetName() {
        assertEquals(testItem.getName(), "Example Item");
    }

    @Test
    public void testSetName() {
        this.testItem.setName("New Item Name");
        assertEquals(testItem.getName(), "New Item Name");
    }

    @Test
    public void testGetDescription() {
        assertEquals(testItem.getDescription(), "Example Description");
    }

    @Test
    public void testSetDescription() {
        this.testItem.setDescription("New Description");
        assertEquals(testItem.getDescription(), "New Description");
    }

    @Test
    public void testGetCategories() {
        // TODO
    }

    @Test
    public void testAddCategory() {
        // TODO
    }

    @Test
    public void testRemoveCategory() {
        // TODO
    }

    @Test
    public void testGetQualitiesWhenNone() {
        assertEquals(this.testItem.getQualities().size(), 0);
    }
    
    /**
     * Tests if the addQuality mistakes null for quality (should not)
     */
    @Test
    public void testAddQualityWhenNull() {
        this.testItem.addQuality(null);
        assertEquals(this.testItem.getQualities().size(), 0);
    }
    
    @Test
    public void testGetQualitiesWhenSome() {
        this.testItem.addQuality(new Quality(1L, "Smooth"));
        this.testItem.addQuality(new Quality(2L, "Big"));
        assertEquals(this.testItem.getQualities().size(), 2);
    }
    
    /**
     * Tests if addQuality accepts duplicates (should not)
     */
    @Test
    public void testGetQualitiesWhenDuplicates() {
        Quality smooth = new Quality(1L, "Smooth");
        Quality big = new Quality(2L, "Big");
        
        for(int i = 1; i<=10; i++) {
            if(i%2==0){
                this.testItem.addQuality(smooth);
            } else {
                this.testItem.addQuality(big);
            }
        }
        
        assertEquals(this.testItem.getQualities().size(), 2);
    }

    /**
     * Tests if the removeQuality removes the right quality
     */
    @Test
    public void testRemoveQuality() {
        Quality smooth = new Quality(1L, "Smooth");
        Quality big = new Quality(2L, "Big");
        
        this.testItem.addQuality(smooth);
        this.testItem.addQuality(big);
        
        this.testItem.removeQuality(smooth);
        
        assertEquals(this.testItem.getQualities().contains(big), true);
    }

    /**
     * Tests addRating method
     * @see Star
     * @see User
     * @see Rating
     */
    @Test
    public void testAddRating() {
        User negativeUser = new User(1L, "Natalie", "Negative");
        Rating negativeRating = new Rating(1L, negativeUser, this.testItem, Star.ONE);
        
        this.testItem.addRating(negativeRating);
        
        assertEquals(this.testItem.getRatings().size(), 1);
    }
    
    @Test
    public void testGetRatings() {
        
    }

    @Test
    public void testRemoveRating() {

    }

    @Test
    public void testToString() {

    }

    @Test
    public void testEquals() {
        Item compareItem = new Item(1L, "Compare Item");
        assertTrue(testItem.equals(compareItem));
    }

    @Test
    public void testNotEquals() {
        Item compareItem = new Item(2L, "Compare Item");
        assertFalse(testItem.equals(compareItem));
    }

}
