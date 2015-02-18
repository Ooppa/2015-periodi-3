/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package generators;

import static junit.framework.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author Ooppa
 */
@Ignore // Skipped for the time being
public class TestDataGeneratorTest {

    private static TestDataGenerator testGenerator;

    public TestDataGeneratorTest() {
    }

    /**
     * Create TestDataGenerator for the tests
     * Will take some time...
     */
    @BeforeClass
    public static void setUpClass() {
        testGenerator = new TestDataGenerator();
    }

    /**
     * Generated more users than the given scale value (default 1000)
     */
    @Test
    public void createsEnoughUsers() {
        assertTrue(testGenerator.getAmountOfUsers()>1000);
    }

    /**
     * Generated more items than the given scale value (default 1000)
     */
    @Test
    public void createsEnoughItems() {
        assertTrue(testGenerator.getAmountOfItems()>1000);
    }

    /**
     * Generated more users than items
     */
    @Test
    public void moreUsersThanItems() {
        assertTrue(testGenerator.getAmountOfUsers()>testGenerator.getAmountOfItems());
    }

    /**
     * Generated more qualities than the given scale value (default 1000)
     */
    @Test
    public void createsEnoughQualities() {
        assertTrue(testGenerator.getAmountOfQualities()>1000);
    }

    /**
     * Generated less categories than the given scale value (default 1000)
     */
    @Test
    public void createsFewCategories() {
        assertTrue(testGenerator.getAmountOfCategories()<1000);
    }

    /**
     * Generated more qualities than users
     */
    @Test
    public void createsMoreRatingsThanUsers() {
        assertTrue(testGenerator.getAmountOfRatings()>testGenerator.getAmountOfUsers());
    }

}
