package domain;

/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */

import domain.User;
import java.util.Comparator;
import java.util.Objects;

/**
 * Used to save Users similarity level
 *
 * @author Ooppa
 * @see User
 */
public class SimilarUser implements Comparator<SimilarUser> {

    private User user;
    private double similarityLevel;

    /**
     * Creates a new SimilarUser
     *
     * @param user            User to add
     * @param similarityLevel Similarity to associate with the item
     */
    public SimilarUser(User user, double similarityLevel) {
        this.user = user;
        this.similarityLevel = similarityLevel;
    }

    /**
     * Creates a new but empty SimilarUser, mainly used for Comparator
     */
    public SimilarUser() {
    }

    /**
     * Returns the User
     *
     * @return the user
     *
     * @see User
     */
    public User getUser() {
        return user;
    }

    /**
     * Set new User
     *
     * @param user the user to set
     *
     * @see User
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get the similarity level associated with the user
     *
     * @return the similarityLevel
     */
    public double getSimilarityLevel() {
        return similarityLevel;
    }

    /**
     * Sew new similarity level for the user
     *
     * @param similarityLevel the similarityLevel to set
     */
    public void setSimilarityLevel(double similarityLevel) {
        this.similarityLevel = similarityLevel;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17*hash+Objects.hashCode(this.user);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj==null) {
            return false;
        }
        if(getClass()!=obj.getClass()) {
            return false;
        }
        final SimilarUser other = (SimilarUser) obj;
        if(!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public int compare(SimilarUser user, SimilarUser otherUser) {
        return Double.compare(user.getSimilarityLevel(), otherUser.getSimilarityLevel());
    }

}
