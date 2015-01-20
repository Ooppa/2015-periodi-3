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
 *
 * @author Ooppa
 * @see Quality
 */
public class QualityTest {
    
    private Quality testQuality;
    
    public QualityTest() {
    }
    
    @Before
    public void setUp() {
        this.testQuality = new Quality(1L, "Smooth");
        this.testQuality.setImportance(Value.LOW);
    }
    
    @After
    public void tearDown() {
        this.testQuality = null;
    }
    
    @Test
    public void testAddCategory() {
        Category category = new Category(1L, "Category One");
        this.testQuality.addCategory(category);
        
        assertTrue(this.testQuality.getCategories().contains(category));
    }
    
    @Test
    public void testAddCategoryDuplicates() {
        Category category = new Category(1L, "Category One");
        
        this.testQuality.addCategory(category);
        this.testQuality.addCategory(category);
        
        assertTrue(this.testQuality.getCategories().contains(category));
    }

    @Test
    public void testGetCategoriesWhenNone() {
        assertEquals(this.testQuality.getCategories().size(), 0);
    }
    
    @Test
    public void testGetCategoriesWhenSome() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");
        
        this.testQuality.addCategory(category1);
        this.testQuality.addCategory(category2);
        
        assertEquals(this.testQuality.getCategories().size(), 2);
    }

    @Test
    public void testRemoveCategory() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");
        
        this.testQuality.addCategory(category1);
        this.testQuality.addCategory(category2);
        this.testQuality.removeCategory(category1);
        
        assertTrue(
                this.testQuality.getCategories().contains(category1) == false
                &&this.testQuality.getCategories().contains(category2)
        );
    }
    
    @Test
    public void testGetImportance() {
        assertEquals(this.testQuality.getImportance(), Value.LOW);
    }
    
    @Test
    public void testSetImportance() {
        this.testQuality.setImportance(Value.HIGH);
        
        assertEquals(this.testQuality.getImportance(), Value.HIGH);
    }

    

    
    
}
