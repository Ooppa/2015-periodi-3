/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package domain;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import org.junit.*;

/**
 *
 * @author Ooppa
 */
public class SimilarUserTest {

    private User user;
    private SimilarUser similarUser;

    public SimilarUserTest() {
    }

    @Before
    public void setUp() {
        user = new User(1L, "Testi Teemu");
        similarUser = new SimilarUser(user, 14.99);
    }

    @After
    public void tearDown() {
        user = null;
        similarUser = null;
    }

    @Test
    public void testGetUser() {
        assertTrue(similarUser.getUser().equals(user));
    }

    @Test
    public void testSetUser() {
        User secondUser = new User(2L, "Testi Teemo");

        similarUser.setUser(secondUser);

        assertTrue(similarUser.getUser().equals(secondUser));
    }

    /**
     * Test of getSimilarityLevel method, of class SimilarUser.
     */
    @Test
    public void testGetSimilarityLevel() {
        assertTrue(similarUser.getSimilarityLevel()==14.99);
    }

    @Test
    public void testSetSimilarityLevel() {
        similarUser.setSimilarityLevel(14.00);
        assertTrue(similarUser.getSimilarityLevel()==14.00);
    }

    @Test
    public void testToString() {
        assertTrue(
                similarUser.toString().contains("14.99")
                &&similarUser.toString().contains(similarUser.getUser().getName())
        );
    }

    @Test
    public void testHashCodeAlwaysSame() {
        assertTrue(similarUser.hashCode()==similarUser.hashCode());
    }
    
    @Test
    public void testHashCodeDifferent() {
        User teemo = new User(18L, "Teemo the Swift Scout");
        SimilarUser notSoSimilar = new SimilarUser(teemo, 0.1);
        assertTrue(similarUser.hashCode()!=notSoSimilar.hashCode());
    }

    @Test
    public void testEquals() {
        assertTrue(similarUser.equals(similarUser));
    }
    
    @Test
    public void testNotEquals() {
        User teemo = new User(18L, "Teemo the Swift Scout");
        SimilarUser notSoSimilar = new SimilarUser(teemo, 0.1);
        assertFalse(similarUser.equals(notSoSimilar));
    }
    
    @Test
    public void testEqualsWrongType() {
        User teemo = new User(18L, "Teemo the Swift Scout");
        assertFalse(similarUser.equals(teemo));
    }
    
    @Test
    public void testEqualsNull() {
        assertFalse(similarUser.equals(null));
    }

    @Test
    public void testCompare() {
        User teemo = new User(18L, "Teemo the Swift Scout");
        SimilarUser notSoSimilar = new SimilarUser(teemo, 0.1);
        
        assertTrue(similarUser.compare(similarUser, notSoSimilar)==-1);
    }

}
