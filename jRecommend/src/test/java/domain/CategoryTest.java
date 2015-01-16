/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import static junit.framework.Assert.assertEquals;
import org.junit.*;

/**
 *
 * @author Ooppa
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
        s
    }

    @Test
    public void testSetName() {

    }

    @Test
    public void testGetDescription() {

    }

    @Test
    public void testSetDescription() {

    }

    @Test
    public void testGetElements() {

    }

    @Test
    public void testAddElement() {

    }

    @Test
    public void testRemoveElement() {

    }

    @Test
    public void testToString() {

    }

    @Test
    public void testHashCode() {

    }

    @Test
    public void testEquals() {

    }
    
}
