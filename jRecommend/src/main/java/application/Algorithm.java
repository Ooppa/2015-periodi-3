/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.*;
import java.util.ArrayList;
import java.util.logging.Logger;

/**
 *
 * @author Ooppa
 */
public class Algorithm {

    private static final Logger logger = Logger.getLogger(Algorithm.class.getName());

    public Algorithm() {
    }

    public ArrayList<RecommendedItem> racommendItems(User user, ArrayList<User> otherUsers, ArrayList<Item> items) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();

        // Ratings given by the user
        AbstractElementHashMap userRatings = user.getRatings();

        // Get Categories seen in the users reviews
        AbstractElementHashMap categoriesSeenInUserRatings = getCategoriesSeenInUserRatings(user, userRatings);

        // Get Items from the Categories seen in the User Ratings
        AbstractElementHashMap interestingItems = getItemsInCategories(categoriesSeenInUserRatings);

        // Get Items not rated by user in Categories seen in the User Ratings
        AbstractElementHashMap interestingItemsNotRatedByUser = getItemsNotRatedByUser(user, interestingItems);

        // Get Users who rated items that were not rated by user in Categories seen in User Ratings
        AbstractElementHashMap usersWhoRatedItemsNotRatedByUser = getUsersWhoRatedItems(interestingItemsNotRatedByUser);

        // FOR EACH LOOP
        // Collections.sort();
        return recommendedItems;
    }

    private AbstractElementHashMap getCategoriesSeenInUserRatings(User user, AbstractElementHashMap userRatings) {
        AbstractElementHashMap categoriesSeenInUserRatings = new AbstractElementHashMap();

        // TODO LOGIC
        return categoriesSeenInUserRatings;
    }

    private AbstractElementHashMap getItemsInCategories(AbstractElementHashMap categories) {
        AbstractElementHashMap itemsInCategories = new AbstractElementHashMap();

        // TODO LOGIC
        return itemsInCategories;
    }

    private AbstractElementHashMap getItemsNotRatedByUser(User user, AbstractElementHashMap interestingItems) {
        AbstractElementHashMap itemsNotRatedByUser = new AbstractElementHashMap();

        // TODO LOGIC
        return itemsNotRatedByUser;
    }

    private AbstractElementHashMap getUsersWhoRatedItems(AbstractElementHashMap interestingItemsNotRatedByUser) {
        AbstractElementHashMap usersWhoRatedItems = new AbstractElementHashMap();

        // TODO LOGIC
        return usersWhoRatedItems;
    }

}
