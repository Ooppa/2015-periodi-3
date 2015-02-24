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
    public void testGetItemsWhenEmpty() {
        assertEquals(this.testQuality.getItems().size(), 0);
    }

    @Test
    public void testGetItemsWhenSome() {
        Item pizzaItem = new Item(69L, "Pizza");
        Item kebabItem = new Item(42L, "Kebab");
        this.testQuality.getItems().add(pizzaItem);
        this.testQuality.getItems().add(kebabItem);

        assertEquals(this.testQuality.getItems().size(), 2);
    }

    @Test
    public void testAddItem() {
        Item item = new Item(1L, "Item");
        this.testQuality.getItems().add(item);

        assertTrue(this.testQuality.getItems().contains(item));
    }

    @Test
    public void testAddDuplicateItem() {
        Item item = new Item(1L, "Item");
        this.testQuality.getItems().add(item);
        this.testQuality.getItems().add(item);

        assertTrue(this.testQuality.getItems().contains(item)
                &&this.testQuality.getItems().size()==1);
    }

    @Test
    public void testAddNullItem() {
        this.testQuality.getItems().add(null);

        assertTrue(this.testQuality.getItems().contains(null)==false
                &&this.testQuality.getItems().size()==0);
    }

    @Test
    public void testRemoveItem() {
        Item pizzaItem = new Item(69L, "Pizza");
        Item kebabItem = new Item(42L, "Kebab");
        this.testQuality.getItems().add(pizzaItem);
        this.testQuality.getItems().add(kebabItem);

        this.testQuality.getItems().remove(kebabItem);

        assertTrue(this.testQuality.getItems().contains(pizzaItem)==true
                &&this.testQuality.getItems().contains(kebabItem)==false);
    }

    @Test
    public void testRemoveWrongItem() {
        Item pizzaItem = new Item(69L, "Pizza");
        Item kebabItem = new Item(42L, "Kebab");
        this.testQuality.getItems().add(pizzaItem);

        this.testQuality.getItems().remove(kebabItem);

        assertTrue(this.testQuality.getItems().contains(pizzaItem)==true
                &&this.testQuality.getItems().contains(kebabItem)==false);
    }

    @Test
    public void testAddCategory() {
        Category category = new Category(1L, "Category One");
        this.testQuality.getCategories().add(category);

        assertTrue(this.testQuality.getCategories().contains(category));
    }

    @Test
    public void testAddCategoryDuplicates() {
        Category category = new Category(1L, "Category One");

        this.testQuality.getCategories().add(category);
        this.testQuality.getCategories().add(category);

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

        this.testQuality.getCategories().add(category1);
        this.testQuality.getCategories().add(category2);

        assertEquals(this.testQuality.getCategories().size(), 2);
    }

    @Test
    public void testRemoveCategory() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");

        this.testQuality.getCategories().add(category1);
        this.testQuality.getCategories().add(category2);
        this.testQuality.getCategories().remove(category1);

        assertTrue(
                this.testQuality.getCategories().contains(category1)==false
                &&this.testQuality.getCategories().contains(category2)
        );
    }

    @Test
    public void testRemoveWrongCategory() {
        Category category1 = new Category(1L, "Category One");
        Category category2 = new Category(2L, "Category Two");

        this.testQuality.getCategories().add(category1);
        this.testQuality.getCategories().remove(category2);

        assertTrue(
                this.testQuality.getCategories().contains(category1)==true
                &&this.testQuality.getCategories().contains(category2)==false
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
