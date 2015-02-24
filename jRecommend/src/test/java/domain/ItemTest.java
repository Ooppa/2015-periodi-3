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
 * @see Item
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
    public void testGetCategoriesWhenNone() {
        assertTrue(testItem.getCategories().isEmpty());
    }

    @Test
    public void testGetCategoriesWhenSome() {
        Category category = new Category(1L, "Category");
        this.testItem.getCategories().add(category);

        assertTrue(testItem.getCategories().contains(category));
    }

    @Test
    public void testAddCategoryWhenNull() {
        this.testItem.getCategories().add(null);
        assertFalse(testItem.getCategories().contains(null));
    }

    @Test
    public void testAddCategoryWhenDuplicates() {
        Category category = new Category(1L, "Category");
        this.testItem.getCategories().add(category);
        this.testItem.getCategories().add(category);

        assertEquals(testItem.getCategories().size(), 1);
    }

    @Test
    public void testRemoveCategory() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");

        this.testItem.getCategories().add(category1);
        this.testItem.getCategories().add(category2);

        this.testItem.getCategories().remove(category1);

        assertTrue(this.testItem.getCategories().contains(category1)==false
                &&this.testItem.getCategories().contains(category2));
    }

    @Test
    public void testRemoveWrongCategory() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");

        this.testItem.getCategories().add(category1);

        this.testItem.getCategories().remove(category2);

        assertTrue(this.testItem.getCategories().contains(category1)==true
                &&this.testItem.getCategories().contains(category2)==false);
    }

    @Test
    public void testGetQualitiesWhenNone() {
        assertEquals(this.testItem.getQualities().size(), 0);
    }

    @Test
    public void testAddQualityWhenNull() {
        this.testItem.getQualities().add(null);
        assertEquals(this.testItem.getQualities().size(), 0);
    }

    @Test
    public void testGetQualitiesWhenSome() {
        this.testItem.getQualities().add(new Quality(1L, "Smooth"));
        this.testItem.getQualities().add(new Quality(2L, "Big"));

        assertEquals(this.testItem.getQualities().size(), 2);
    }

    @Test
    public void testGetQualitiesWhenDuplicates() {
        Quality smooth = new Quality(1L, "Smooth");
        Quality big = new Quality(2L, "Big");

        for(int i = 1; i<=10; i++) {
            if(i%2==0) {
                this.testItem.getQualities().add(smooth);
            } else {
                this.testItem.getQualities().add(big);
            }
        }

        assertEquals(this.testItem.getQualities().size(), 2);
    }

    @Test
    public void testRemoveQuality() {
        Quality smooth = new Quality(1L, "Smooth");
        Quality big = new Quality(2L, "Big");

        this.testItem.getQualities().add(smooth);
        this.testItem.getQualities().add(big);

        this.testItem.getQualities().remove(smooth);

        assertEquals(this.testItem.getQualities().contains(big), true);
    }

    @Test
    public void testRemoveWrongQuality() {
        Quality smooth = new Quality(1L, "Smooth");
        Quality big = new Quality(2L, "Big");

        this.testItem.getQualities().add(smooth);

        this.testItem.getQualities().remove(big);

        assertTrue(this.testItem.getQualities().contains(big)==false
                &&this.testItem.getQualities().contains(smooth)==true);
    }

    @Test
    public void testAddRating() {
        User negativeUser = new User(1L, "Natalie Negative");
        Rating negativeRating = new Rating(1L, negativeUser, this.testItem, Star.ONE);

        this.testItem.getRatings().add(negativeRating);

        assertEquals(this.testItem.getRatings().size(), 1);
    }

    @Test
    public void testGetRatings() {
        User negativeUser = new User(1L, "Natalie Negative");
        Rating negativeRating = new Rating(1L, negativeUser, this.testItem, Star.ONE);

        this.testItem.getRatings().add(negativeRating);

        assertTrue(this.testItem.getRatings().contains(negativeRating));
    }

    @Test
    public void testRemoveRating() {
        User negativeUser = new User(1L, "Natalie Negative");
        Rating negativeRating = new Rating(1L, negativeUser, this.testItem, Star.ONE);

        User positiveUser = new User(2L, "Peter Positive");
        Rating positiveRating = new Rating(2L, positiveUser, this.testItem, Star.FIFE);

        this.testItem.getRatings().add(negativeRating);
        this.testItem.getRatings().add(positiveRating);

        this.testItem.getRatings().remove(positiveRating);

        assertTrue(this.testItem.getRatings().contains(negativeRating)==true
                &&this.testItem.getRatings().contains(positiveRating)==false);
    }
    
    @Test
    public void testRemoveWrongRating() {
        User negativeUser = new User(1L, "Natalie Negative");
        Rating negativeRating = new Rating(1L, negativeUser, this.testItem, Star.ONE);

        User positiveUser = new User(2L, "Peter Positive");
        Rating positiveRating = new Rating(2L, positiveUser, this.testItem, Star.FIFE);

        this.testItem.getRatings().add(negativeRating);

        this.testItem.getRatings().remove(positiveRating);

        assertTrue(this.testItem.getRatings().contains(negativeRating)==true
                &&this.testItem.getRatings().contains(positiveRating)==false);
    }

    @Test
    public void testEquals() {
        Item compareItem = new Item(1L, "Example Item");
        assertTrue(testItem.equals(compareItem));
    }

    @Test
    public void testNotEquals() {
        Item compareItem = new Item(2L, "Example Item");
        assertFalse(testItem.equals(compareItem));
    }

}
