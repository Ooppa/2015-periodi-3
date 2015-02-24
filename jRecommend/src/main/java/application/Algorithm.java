/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 *
 * @author Ooppa
 */
public class Algorithm {

    private final long startingTime;

    private static final Logger logger = Logger.getLogger(Algorithm.class.getName());

    public Algorithm() {
        startingTime = System.nanoTime();
    }

    public ArrayList<RecommendedItem> racommendItems(User user, HashMap<Long, User> otherUsers, HashMap<Long, Item> items) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();

        // Get Categories seen in the users reviews
        AbstractElementHashMap categoriesSeenInUserRatings = getCategoriesSeenInUserRatings(user);
        debugMessage("Categories seen in user ratings: "+categoriesSeenInUserRatings.size());

        // Get Items from the Categories seen in the User Ratings
        AbstractElementHashMap interestingItems = getItemsInCategories(categoriesSeenInUserRatings);
        debugMessage("Integersting items found: "+interestingItems.size());

        // Get Items not rated by user in Categories seen in the User Ratings
        AbstractElementHashMap interestingItemsNotRatedByUser = getItemsNotRatedByUser(user, interestingItems);
        debugMessage("Iteresting items not rated by user: "+interestingItemsNotRatedByUser.size());

        // Get Users who rated items that were not rated by user in Categories seen in User Ratings
        AbstractElementHashMap usersWhoRatedItemsNotRatedByUser = getUsersWhoRatedItems(interestingItemsNotRatedByUser);
        debugMessage("Iteresting users found: "+usersWhoRatedItemsNotRatedByUser.size());

        // Get other Users who have rated atleast one same Item as User
        
        // Define similarity
        
        // Take top 10%? from the most similar
        
        // Rate items
        
        // Sort items
        
        return recommendedItems;
    }

    private AbstractElementHashMap getCategoriesSeenInUserRatings(User user) {
        AbstractElementHashMap categoriesSeenInUserRatings = new AbstractElementHashMap();

        AbstractElementHashMap ratings = user.getRatings();

        for(Map.Entry<Long, AbstractElement> entrySet : ratings.getAsHashMap().entrySet()) {
            Rating rating = (Rating) entrySet.getValue();
            categoriesSeenInUserRatings.addAll(rating.getItem().getCategories().getAsHashMap());

        }

        return categoriesSeenInUserRatings;
    }

    private AbstractElementHashMap getItemsInCategories(AbstractElementHashMap categories) {
        AbstractElementHashMap itemsInCategories = new AbstractElementHashMap();

        for(Map.Entry<Long, AbstractElement> entrySet : categories.getAsHashMap().entrySet()) {
            Category category = (Category) entrySet.getValue();

            // TODO: Presumes every object in category is Item()
            itemsInCategories.addAll(category.getElements());
        }

        return itemsInCategories;
    }

    private AbstractElementHashMap getItemsNotRatedByUser(User user, AbstractElementHashMap interestingItems) {
        AbstractElementHashMap itemsNotRatedByUser = new AbstractElementHashMap();

        for(Map.Entry<Long, AbstractElement> entrySet : interestingItems.getAsHashMap().entrySet()) {
            Item item = (Item) entrySet.getValue();

            if(!item.isRatedBy(user)) {
                itemsNotRatedByUser.add(item);
            }

        }

        return itemsNotRatedByUser;
    }

    private AbstractElementHashMap getUsersWhoRatedItems(AbstractElementHashMap interestingItemsNotRatedByUser) {
        AbstractElementHashMap usersWhoRatedItems = new AbstractElementHashMap(interestingItemsNotRatedByUser.size());

        for(Map.Entry<Long, AbstractElement> itemEntrySet : interestingItemsNotRatedByUser.getAsHashMap().entrySet()) {
            Item item = (Item) itemEntrySet.getValue();
            HashMap<Long, AbstractElement> usersWhoRated = item.getUsersWhoRated();
            usersWhoRatedItems.addAll(item.getUsersWhoRated());
        }

        return usersWhoRatedItems;
    }

    /*
     * Gives out the amount of milliseconds elapsed from the start of the
     * algorithm
     */
    private void debugMessage(String message) {
        System.out.println(TimeUnit.MILLISECONDS.convert((System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)+"ms: "+message);
    }

}
