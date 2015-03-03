/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Ooppa
 */
public class Algorithm {

    /*
     * Tracks the time the algorithm takes to run
     */
    private final long startingTime;

    /**
     * Creates a new instance of Algorithm
     */
    public Algorithm() {
        startingTime = System.nanoTime();
    }

    /**
     * Returns a list of RecommendedItems based on ratings given by similar
     * users and if the user doesn't have enough ratings this will return a list
     * of items sorted based on the average rating.
     *
     * @param user       Source user
     * @param otherUsers Other users
     * @param items      Other items
     *
     * @return An ordered list of recommended items
     */
    public ArrayList<RecommendedItem> recommendItems(User user, HashMap<Long, User> otherUsers, HashMap<Long, Item> items) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();

        // if the user has less than 3 ratings, return highest average ratings list
        if(user.getRatings().size()<3) {
            return highestRatedItems(items);
        }

        // Users who rated atleast 1 same item as our user did
        AbstractElementHashMap usersWhoRatedItems = getUsersWhoRatedItems(user.getRatedItems());
        debugMessage("Interesting users found: "+usersWhoRatedItems.size());

        // Items rated by interesting users
        AbstractElementHashMap itemsRatedByUsers = getItemsRatedByUsers(usersWhoRatedItems);
        debugMessage("Interesting items found: "+itemsRatedByUsers.size());

        // Define similarity between our user and interesting users
        ArrayList<SimilarUser> similarUsers = rateSimilarUsers(user, usersWhoRatedItems);
        debugMessage("Similarity between "+similarUsers.size()+" users defined.");

        // Take the top 10% most similar users
        ArrayList<SimilarUser> mostSimilarUsers = getMostSimilarUsers(0.1, similarUsers);
        debugMessage(mostSimilarUsers.size()+" most similar users users were chosen.");

        // Recommend items based on similar user reviews
        recommendedItems = getRecommendedItems(mostSimilarUsers);

        return recommendedItems;
    }

    /**
     * Returns a list of RecommendedItems based on similarity between items
     * based on common qualities.
     *
     * @param item       Source item
     * @param otherItems Other items to compare source item to
     *
     * @return An ordered list of recommended items
     */
    public ArrayList<RecommendedItem> similarItems(Item item, HashMap<Long, Item> otherItems) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();

        // For every other item
        for(Map.Entry<Long, Item> entrySet : otherItems.entrySet()) {
            Item otherItem = entrySet.getValue();
            double recommendationLevel = 0;

            // For every quality find
            for(Map.Entry<Long, AbstractElement> entrySet1 : otherItem.getQualities().getAsHashMap().entrySet()) {
                Quality otherItemsQuality = (Quality) entrySet1.getValue();

                // If the source item and the other item share that quality
                if(item.getQualities().contains(otherItemsQuality)) {
                    Quality sourceItemsQuality = (Quality) item.getQualities().get(otherItemsQuality.getId());

                    // Count the average Importance value of the items
                    double averageImportance = (otherItemsQuality.getImportance().getValueAsDouble()
                            +sourceItemsQuality.getImportance().getValueAsDouble())/2;

                    // Scale 1 point given from "contains same quality" with the importance of the qualities
                    recommendationLevel = +(averageImportance*1);
                } else {
                    // Not being similar lowers the score
                    recommendationLevel = -otherItemsQuality.getImportance().getValueAsDouble();
                }

            }

            recommendedItems.add(new RecommendedItem(otherItem, recommendationLevel));

        }

        Collections.sort(recommendedItems, new RecommendedItem());

        return recommendedItems;
    }

    /**
     * Returns a list of RecommendedItems based on average rating.
     *
     * @param items Items to evaluate
     *
     * @return An ordered list of recommended items
     */
    public ArrayList<RecommendedItem> highestRatedItems(HashMap<Long, Item> items) {
        ArrayList<RecommendedItem> recommendedItems = new ArrayList<>();

        for(Map.Entry<Long, Item> entrySet : items.entrySet()) {
            Item item = entrySet.getValue();
            double sumOfRatings = 0;

            for(Map.Entry<Long, AbstractElement> entrySet1 : item.getRatings().getAsHashMap().entrySet()) {
                Rating rating = (Rating) entrySet1.getValue();

                sumOfRatings = +rating.getStarsGiven().getAmountAsInt();
            }

            double averageRating = 0;

            try {
                averageRating = sumOfRatings/item.getRatings().size();
            } catch(ArithmeticException ex) {
                // Divided by zero
            }

            recommendedItems.add(new RecommendedItem(item, averageRating));
        }

        return recommendedItems;
    }

    /*
     * Returns a AbstractElementHashMap<Item> containing all users who rated
     * items found in given AbstractElementHashMap
     */
    private AbstractElementHashMap getUsersWhoRatedItems(AbstractElementHashMap itemsRatedByOurUser) {
        AbstractElementHashMap usersWhoRatedItems = new AbstractElementHashMap(itemsRatedByOurUser.size());

        for(Map.Entry<Long, AbstractElement> entrySet : itemsRatedByOurUser.getAsHashMap().entrySet()) {
            Item item = (Item) entrySet.getValue();

            usersWhoRatedItems.addAll(item.getUsersWhoRated().getAsHashMap());
        }

        return usersWhoRatedItems;
    }

    /*
     * Returns a list of items rated by the given user
     */
    private AbstractElementHashMap getItemsRatedByUsers(AbstractElementHashMap users) {
        AbstractElementHashMap itemsRatedByUsers = new AbstractElementHashMap(users.size());

        for(Map.Entry<Long, AbstractElement> entrySet : users.getAsHashMap().entrySet()) {
            User user = (User) entrySet.getValue();
            itemsRatedByUsers.addAll(user.getRatedItems().getAsHashMap());
        }

        return itemsRatedByUsers;
    }

    /*
     * Defines the similary between source user and other given users
     */
    private ArrayList<SimilarUser> rateSimilarUsers(User user, AbstractElementHashMap otherUsers) {
        ArrayList<SimilarUser> similarUsers = new ArrayList<>(otherUsers.size());

        for(Map.Entry<Long, AbstractElement> entrySet : otherUsers.getAsHashMap().entrySet()) {
            User otherUser = (User) entrySet.getValue();

            // Now we have user, and other user
            double similarityLevel = getSimilarityBetween(user, otherUser);
            similarUsers.add(new SimilarUser(otherUser, similarityLevel));
        }

        Collections.sort(similarUsers, new SimilarUser());

        return similarUsers;
    }

    /*
     * Returns the similarity between source user and other user
     */
    private double getSimilarityBetween(User user, User otherUser) {
        double similarity = 0;
        AbstractElementHashMap ratingsByOtherUser = otherUser.getRatings();

        // For each otherUsersRating done by other user
        for(Map.Entry<Long, AbstractElement> entrySet : ratingsByOtherUser.getAsHashMap().entrySet()) {
            Rating otherUsersRating = (Rating) entrySet.getValue();
            // If this user and the other user has rated same item
            if(otherUsersRating.getItem().isRatedBy(user)) {
                int otherUserRatingAsInt = otherUsersRating.getStarsGiven().getAmountAsInt();
                int userRatingAsInt = user.getRatingForItem(otherUsersRating.getItem()).getAmountAsInt();
                similarity = +5-Math.abs(userRatingAsInt-otherUserRatingAsInt);
            }
        }

        return similarity;
    }

    /*
     * Returns the percentage of the most similar users
     */
    private ArrayList<SimilarUser> getMostSimilarUsers(double percentage, ArrayList<SimilarUser> similarUsers) {
        int amount = (int) Math.round(similarUsers.size()*percentage);
        ArrayList<SimilarUser> mostSimilarUsers = new ArrayList<>(amount+1);

        for(SimilarUser similarUser : similarUsers) {
            mostSimilarUsers.add(similarUser);

            if(mostSimilarUsers.size()>amount) {
                break;
            }
        }

        return mostSimilarUsers;
    }

    /*
     * Returns the RecommendedItems in Arraylist based on similary of users and
     * their reviews
     */
    private ArrayList<RecommendedItem> getRecommendedItems(ArrayList<SimilarUser> similarUsers) {
        HashMap<Item, Double> recommendedItemsMap = new HashMap<>();

        // For each similar user 
        for(SimilarUser similarUser : similarUsers) {
            AbstractElementHashMap ratingsBySimilarUser = similarUser.getUser().getRatings();

            // Rate every item they rated and add to hashmap
            for(Map.Entry<Long, AbstractElement> entrySet : ratingsBySimilarUser.getAsHashMap().entrySet()) {
                Rating rating = (Rating) entrySet.getValue();

                double itemRecommendationlevel = rating.getStarsGiven().getAmountAsInt()+similarUser.getSimilarityLevel();

                if(recommendedItemsMap.containsKey(rating.getItem())) {
                    double currentRating = recommendedItemsMap.get(rating.getItem());
                    recommendedItemsMap.put(rating.getItem(), (currentRating+itemRecommendationlevel));
                } else {
                    recommendedItemsMap.put(rating.getItem(), itemRecommendationlevel);
                }

            }
        }

        ArrayList<RecommendedItem> recommendItemsArray = new ArrayList<>();

        for(Map.Entry<Item, Double> entrySet : recommendedItemsMap.entrySet()) {
            Item item = entrySet.getKey();
            Double recommendationLevel = entrySet.getValue();

            recommendItemsArray.add(new RecommendedItem(item, recommendationLevel));
        }

        Collections.sort(recommendItemsArray, new RecommendedItem());

        return recommendItemsArray;
    }

    /*
     * Gives out the amount of milliseconds elapsed from the start of the
     * algorithm, used to see how fast the algorithm is
     */
    private void debugMessage(String message) {
        System.out.println(TimeUnit.MILLISECONDS.convert((System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)+"ms: "+message);
    }

}
