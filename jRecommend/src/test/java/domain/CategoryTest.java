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
 * @see Category
 */
public class CategoryTest {

    private Category testCategory;

    public CategoryTest() {
    }

    @Before
    public void setUp() {
        this.testCategory = new Category(1L, "Example Category");
        this.testCategory.setDescription("Category used for examples");
    }

    @After
    public void tearDown() {
        this.testCategory = null;
    }

    @Test
    public void testGetId() {
        assertEquals(this.testCategory.getId(), 1L);
    }

    @Test
    public void testGetName() {
        assertEquals(this.testCategory.getName(), "Example Category");
    }

    @Test
    public void testSetName() {
        this.testCategory.setName("Test Me");

        assertEquals(this.testCategory.getName(), "Test Me");
    }

    @Test
    public void testGetDescription() {
        assertEquals(this.testCategory.getDescription(), "Category used for examples");
    }

    @Test
    public void testSetDescription() {
        this.testCategory.setDescription("Test Me");

        assertEquals(this.testCategory.getDescription(), "Test Me");
    }

    @Test
    public void testGetElements() {
        assertTrue(this.testCategory.getElements().isEmpty());
    }

    @Test
    public void testAddSingleElement() {
        Item item = new Item(1L, "Peruna");
        this.testCategory.addElement(item);

        assertTrue(this.testCategory.contains(item));
    }
    
    @Test
    public void testAddNullElement() {
        this.testCategory.addElement(null);
        assertFalse(this.testCategory.contains(null));
    }

    @Test
    public void testAddDifferentElementsOverridesPrevious() {
        Item item = new Item(1L, "Peruna");
        Quality quality = new Quality(1L, "Perunainen");

        this.testCategory.addElement(item);
        this.testCategory.addElement(quality);

        assertTrue(this.testCategory.contains(quality));
    }

    @Test
    public void testRemoveElement() {
        Item item = new Item(1L, "Peruna");
        Quality quality = new Quality(1L, "Perunainen");

        this.testCategory.addElement(item);
        this.testCategory.addElement(quality);
        this.testCategory.removeElement(item);

        assertTrue(
                this.testCategory.contains(item)==false
                &&this.testCategory.contains(quality)
        );
    }
    
    @Test
    public void testRemoveWrongElement() {
        Item item = new Item(1L, "Peruna");
        Quality quality = new Quality(1L, "Perunainen");

        this.testCategory.addElement(item);
        this.testCategory.removeElement(quality);

        assertTrue(
                this.testCategory.contains(item)==true
                &&this.testCategory.contains(quality)==false
        );
    }

    @Test
    public void testEquals() {
        Category otherCategory = new Category(1L, "Example Category");
        assertTrue(this.testCategory.equals(otherCategory));
    }
    
    @Test
    public void testNotEquals() {
        Category otherCategory = new Category(2L, "Other Category");
        assertFalse(this.testCategory.equals(otherCategory));
    }
    
    @Test
    public void testToString() {
        String toString = this.testCategory.toString();
        assertTrue(
                toString.contains(this.testCategory.getId() +":")
                &&toString.contains(this.testCategory.getName())
        );
    }

}
