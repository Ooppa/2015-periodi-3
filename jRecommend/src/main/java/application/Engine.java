/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Recommendation algorithm used to recommend Items to Users
 *
 * @author Ooppa
 * @see Item
 * @see User
 */
public class Engine {

    /**
     * Creates a RecommendedItem list from a source item compared to items
     * given.
     *
     * @param source   Source Item to compare to
     * @param compares List of Item to compare to source
     *
     * @return Ordered list of RecommendedItems
     *
     * @see RecommendedItem
     * @see Item
     */
    public ArrayList<RecommendedItem> rateItemsBasedOnQualities(Item source, ArrayList<Item> compares) {
        ArrayList<RecommendedItem> recommends = new ArrayList<>(compares.size());
        ArrayList<Quality> sourceQualities = source.getQualities();

        // For each item in the compare list...
        for(Item compare : compares) {
            ArrayList<Quality> compareQualities = compare.getQualities();
            double recommendLevel = 0;

            // compare it's qualities to the source item...
            for(Quality sourceQuality : sourceQualities) {
                for(Quality compareQuality : compareQualities) {

                    // and if similar quality calculate the importance 
                    // level between those two items...
                    if(sourceQuality.equals(compareQuality)) {
                        recommendLevel
                                += sourceQuality.getImportance().getValueAsDouble()
                                *compareQuality.getImportance().getValueAsDouble();
                    }
                    // else ignore

                }
            }

            // after evaluation add to the final list
            recommends.add(new RecommendedItem(compare, recommendLevel));
        }

        // sort the RecommendedItem and return it
        Collections.sort(recommends, new RecommendedItem());

        return recommends;
    }

    /**
     * Creates a RecommendedItem list based on the average rating score given to
     * the item by users.
     *
     * @param items Items to count
     *
     * @return Ordered list of RecommendedItems
     *
     * @see RecommendedItem
     * @see Item
     */
    public ArrayList<RecommendedItem> rateItemsBasedOnQAverageRating(ArrayList<Item> items) {
        ArrayList<RecommendedItem> recommends = new ArrayList<>(items.size());

        // Count average rating for each item given
        for(Item item : items) {
            ArrayList<Rating> ratings = item.getRatings();

            int sum = 0;
            int amount = 0;

            // Count every rating given
            for(Rating rating : ratings) {
                sum += rating.getStarsGiven().getAmountAsInt();
                amount++;
            }

            double average = sum/amount;

            // after evaluation add to the final list
            recommends.add(new RecommendedItem(item, average));

        }

        // sort the RecommendedItem and return it
        Collections.sort(recommends, new RecommendedItem());

        return recommends;
    }

    /**
     * TODO HEADER
     *
     * @param user     User to give the recommendations to
     * @param users    Other users include in the recommendation
     * @param compares Items to rate
     *
     * @return Ordered list of RecommendedItems
     *
     * @see User
     * @see Item
     * @see RecommendedItem
     */
    public ArrayList<RecommendedItem> rateItemsBasedOnUserReviews(User user, ArrayList<User> users, ArrayList<Item> compares) {
        ArrayList<RecommendedItem> recommends = new ArrayList<>(compares.size());

        // Create a list of users who are not our original user
        ArrayList<User> otherUsers = new ArrayList<>(users);
        otherUsers.remove(user);

        // First we get the items that the user have not rated
        ArrayList<Item> itemsNotRatedByUser = getItemsNotRatedByUser(user, compares);

        // Then we get all the other users who have rated at least one of those
        // items that our user has not rated.
        ArrayList<User> usersWhoHaveRatedItemsNotRatedByUser = getUsersWhoHaveRated(otherUsers, itemsNotRatedByUser);

        // At this point we have items we want to recommend in "itemsNotRatedByUser"
        // and we have people who can tell us if we want to recommend in "usersWhoHaveRatedItemsNotRatedByUser"
        
        // TODO
        
        return recommends;
    }

    /*
     * Returns a list of items not rated by the given user
     */
    private ArrayList<Item> getItemsNotRatedByUser(User user, ArrayList<Item> otherItems) {

        ArrayList<Rating> ratings = user.getRatings();
        ArrayList<Item> ratedItems = user.getRatedItems();

        // Clone the given list of items so we don't modify the existing
        ArrayList<Item> notRated = new ArrayList<>(otherItems);

        // Remove all rated items, you are left with the items not rated
        notRated.removeAll(ratedItems);

        return notRated;
    }

    /*
     * Returns a list of users who have rated atleast one of the items given
     */
    private ArrayList<User> getUsersWhoHaveRated(ArrayList<User> users, ArrayList<Item> items) {
        ArrayList<User> usersWhoRated = new ArrayList<>();

        for(User user : users) {
            ArrayList<Item> ratedItems = user.getRatedItems();

            // If user has rated any of these items then return him
            if(containsAny(ratedItems, items)) {
                usersWhoRated.add(user);
            }
        }

        return usersWhoRated;
    }

    /*
     * If "items" contains any Item from the "otherItems" returns true
     *
     * @see Item
     */
    private boolean containsAny(ArrayList<Item> items, ArrayList<Item> otherItems) {
        for(Item item : items) {
            if(otherItems.contains(item)) {
                return true;
            }
        }

        return false;
    }

}
