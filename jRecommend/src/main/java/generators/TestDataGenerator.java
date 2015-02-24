/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package generators;

import domain.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates example data for testing out the algorithm.
 *
 * @author Ooppa
 */
public class TestDataGenerator {

    private final Random random;
    private final boolean debug;
    private final long startingTime;

    private HashMap<Long, User> users;
    private HashMap<Long, Item> items;
    private HashMap<Long, Category> categories;
    private HashMap<Long, Quality> qualities;
    private HashMap<Long, Rating> ratings;

    private static final Logger logger = Logger.getLogger(TestDataGenerator.class.getName());

    /**
     * Creates a new TestDataGenerator with no debug and scale of 1000.
     */
    public TestDataGenerator() {
        this(false, 1000);
    }

    /**
     * Creates a new TestDataGenerator
     *
     * @param debug print out debug messages while generating the data
     * @param scale scales the amount of test data generated (recommended 500->)
     */
    public TestDataGenerator(boolean debug, int scale) {

        // Scale should not be too small
        if(scale<300) {
            logger.log(Level.WARNING, "Scale for TestDataGenerator was too "
                    +"small, going to use the default value of 1000.");
            scale = 1000;
        }

        // Scale should not be too big
        if(scale>10000) {
            logger.log(Level.WARNING, "Scale for TestDataGenerator was too "
                    +"big, going to use the default value of 1000.");
            scale = 1000;
        }

        // Debugging fields
        this.startingTime = System.nanoTime();
        this.debug = debug;

        // Random() class used to randomize some testdata
        this.random = new Random();

        // Starting to populate the fields
        populateFields(scale);

        if(debug) {
            System.out.println(debugTimestamp()+"Creation process is now done."
                    +" Overall it took "+TimeUnit.SECONDS.convert(
                            (System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)
                    +" seconds.");
        }
    }

    /**
     * Returns a list of generated users
     *
     * @return users
     *
     * @see User
     */
    public HashMap<Long, User> getUsers() {
        return users;
    }

    /**
     * Returns a list of generated items
     *
     * @return items
     *
     * @see Item
     */
    public HashMap<Long, Item> getItems() {
        return items;
    }

    /**
     * Returns a list of generated qualities
     *
     * @return qualities
     *
     * @see Quality
     */
    public HashMap<Long, Quality> getQualities() {
        return qualities;
    }

    /**
     * Returns a list of generated categories
     *
     * @return categories
     *
     * @see Category
     */
    public HashMap<Long, Category> getCategories() {
        return categories;
    }

    /**
     * Returns a list of generated ratings
     *
     * @return ratings
     *
     * @see Rating
     */
    public HashMap<Long, Rating> getRatings() {
        return ratings;
    }

    /**
     * Returns the amount of users generated
     *
     * @return amount of users
     */
    public int getAmountOfUsers() {
        return users.size();
    }

    /**
     * Returns the amount of items generated
     *
     * @return amount of items
     */
    public int getAmountOfItems() {
        return items.size();
    }

    /**
     * Returns the amount of qualities generated
     *
     * @return amount of qualities
     */
    public int getAmountOfQualities() {
        return qualities.size();
    }

    /**
     * Returns the amount of categories generated
     *
     * @return amount of categories
     */
    public int getAmountOfCategories() {
        return categories.size();
    }

    /**
     * Returns the amount of ratings generated
     *
     * @return amount of ratings
     */
    public int getAmountOfRatings() {
        return ratings.size();
    }

    private void populateFields(int scale) {
        populateUsers(Math.round(scale*250));
        populateItems(Math.round(scale*100));
        populateQualities((int) Math.round((double) scale*2.5));
        populateCategories((int) Math.round((double) scale/12));

        assingQualitiesToItems();
        assingCategoriesToItems();

        createRatings(scale);
    }

    /*
     * Populates the class field "users" with users
     */
    private void populateUsers(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" users.");
        }

        users = new HashMap<>(amount);

        for(int i = 0; i<amount; i++) {
            User user = new User(i, "Firstname Lastname "+i);
            users.put(new Long(i), user);
        }

    }

    /*
     * Populates the class field "items" with items
     */
    private void populateItems(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" items.");
        }

        items = new HashMap<>(amount);

        for(int i = 0; i<amount; i++) {
            Item item = new Item(i, "Item number: "+i);
            item.setDescription(getUUID());
            items.put(new Long(i), item);
        }
    }

    /*
     * Populates the class field "qualities" with qualities
     */
    private void populateQualities(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" qualities.");
        }

        qualities = new HashMap<>(amount);

        for(int i = 0; i<amount; i++) {
            Quality quality = new Quality(i, "Qualitys number: "+i);
            quality.setImportance(randomImportanceValue());
            quality.setDescription(getUUID());
            qualities.put(new Long(i), quality);
        }
    }

    /*
     * Populates the class field "categories" with categories
     */
    private void populateCategories(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" categories.");
        }

        categories = new HashMap<>(amount);

        for(int i = 0; i<amount; i++) {
            Category category = new Category(i, "Category number: "+i);
            category.setDescription(getUUID());
            categories.put(new Long(i), category);
        }
    }

    /*
     * Assingns qualities to items
     */
    private void assingQualitiesToItems() {
        int upperScale = (int) Math.round((double) items.size()*0.02);

        if(debug) {
            System.out.println(debugTimestamp()+"Giving items (with maximum of "+upperScale+" items with one quality) their qualities.");
        }

        for(Map.Entry<Long, Quality> entrySet : qualities.entrySet()) {
            Long key = entrySet.getKey();
            Quality quality = entrySet.getValue();

            int toItems = randomInteger(upperScale/2, upperScale);

            // Assigning process
            for(int i = 0; i<toItems; i++) {
                // Random slot the quality will be added to
                int itemId = randomInteger(1, items.size()-1);
                // Duplicates should not be a problem
                Item item = items.get((long) itemId);
                item.getQualities().add(quality);

            }

        }

    }

    /*
     * Assings categories to items
     */
    private void assingCategoriesToItems() {
        if(debug) {
            System.out.println(debugTimestamp()+"Giving items (every item has a category) their categories.");
        }

        for(Map.Entry<Long, Item> entrySet : items.entrySet()) {
            Long key = entrySet.getKey();
            Item item = entrySet.getValue();

            int randomCategoryId = randomInteger(1, categories.size()-1);
            Category category = categories.get((long) randomCategoryId);

            item.getCategories().add(category);
            category.addElement(item);
        }

    }

    /*
     * Creates and assigns ratings to items and users
     */
    private void createRatings(int scale) {
        ratings = new HashMap<>();
        
        int ratingId = 0;

        if(debug) {
            System.out.println(debugTimestamp()+"Giving items ratings from users.");
        }

        for(Map.Entry<Long, User> entrySet : users.entrySet()) {
            Long key = entrySet.getKey();
            User user = entrySet.getValue();

            int amountToRate = this.randomInteger(0, 80);
            for(int i = 0; i<amountToRate; i++) {
                // We pull random integer to state the index of the rated item
                int indexOfItemToRate = this.randomInteger(0, items.size()-1);

                Item item = items.get((long) indexOfItemToRate);
                Rating rating = new Rating(ratingId,  user, item, randomStar());

                // If item has already been rated by this user it will not be added
                item.getRatings().add(rating);
                user.getRatings().add(rating);
                ratings.put(rating.getId(), rating);
   
                ratingId++;
            }

        }

    }
    
    /*
     * Creates a random integer between min and max
     */
    private int randomInteger(int min, int max) {
        return random.nextInt((max-min)+1)+min;
    }

    /*
     * Provides a random importance value for quality generation
     */
    private Value randomImportanceValue() {
        Value[] values = Value.values();
        return values[randomInteger(0, values.length-1)];
    }

    /*
     * Provides random star for rating generation
     */
    private Star randomStar() {
        Star[] stars = Star.values();
        return stars[randomInteger(0, stars.length-1)];
    }

    /*
     * Provides a random boolean
     */
    private boolean randomBoolean() {
        return this.random.nextBoolean();
    }

    /*
     * Returns a UUID as a String for filler content in examples
     */
    private String getUUID() {
        return UUID.randomUUID().toString();
    }

    /*
     * Gives out the amount of milliseconds elapsed from the start of the
     * generation
     */
    private String debugTimestamp() {
        return TimeUnit.MILLISECONDS.convert((System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)+"ms: ";
    }

}
