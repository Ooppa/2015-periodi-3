/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package generators;

import domain.*;
import java.util.ArrayList;
import java.util.Random;
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

    private ArrayList<User> users;
    private ArrayList<Item> items;
    private ArrayList<Category> categories;
    private ArrayList<Quality> qualities;
    private ArrayList<Rating> ratings;

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
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * Returns a list of generated items
     *
     * @return items
     *
     * @see Item
     */
    public ArrayList<Item> getItems() {
        return items;
    }

    /**
     * Returns a list of generated qualities
     *
     * @return qualities
     *
     * @see Quality
     */
    public ArrayList<Quality> getQualities() {
        return qualities;
    }

    /**
     * Returns a list of generated categories
     *
     * @return categories
     *
     * @see Category
     */
    public ArrayList<Category> getCategories() {
        return categories;
    }

    /**
     * Returns a list of generated ratings
     *
     * @return ratings
     *
     * @see Rating
     */
    public ArrayList<Rating> getRatings() {
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
        populateCategories((int) Math.round((double) scale/14));

        assingQualitiesToItems();
        assingCategoriesToItems();

        createRatings();

        printTotals();
    }

    /*
     * Populates the class field "users" with users
     */
    private void populateUsers(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" users.");
        }

        users = new ArrayList<>(amount);

        for(int i = 0; i<amount; i++) {
            users.add(new User(i, "Firstname "+i, "Lastname "+i));
        }

    }

    /*
     * Populates the class field "items" with items
     */
    private void populateItems(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" items.");
        }

        items = new ArrayList<>(amount);

        for(int i = 0; i<amount; i++) {
            items.add(new Item(i, "Item number: "+i));
        }
    }

    /*
     * Populates the class field "qualities" with qualities
     */
    private void populateQualities(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" qualities.");
        }

        qualities = new ArrayList<>(amount);

        for(int i = 0; i<amount; i++) {
            qualities.add(new Quality(i, "Qualitys number: "+i));
        }
    }

    /*
     * Populates the class field "categories" with categories
     */
    private void populateCategories(int amount) {
        if(debug) {
            System.out.println(debugTimestamp()+"Creating "+amount+" categories.");
        }

        categories = new ArrayList<>(amount);

        for(int i = 0; i<amount; i++) {
            categories.add(new Category(i, "Category number: "+i));
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

        for(Quality quality : qualities) {
            // Amount of items this category will be assigned to
            int toItems = randomInteger(upperScale/2, upperScale);

            // Assigning process
            for(int i = 0; i<toItems; i++) {
                // Random slot the quality will be added to
                int itemId = randomInteger(1, items.size()-1);
                // Duplicates should not be a problem
                Item item = items.get(itemId);
                item.addQuality(quality);
                quality.addItem(item);
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

        for(Item item : items) {
            int randomCategoryId = randomInteger(1, categories.size()-1);
            Category category = categories.get(randomCategoryId);

            item.addCategory(category);
            category.addElement(item);
        }
    }

    /*
     * Creates and assigns ratings to items and users
     */
    private void createRatings() {
        ratings = new ArrayList<>();
        int range = (int) Math.round(users.size()*0.01);

        if(debug) {
            System.out.println(debugTimestamp()+"Giving items ratings from users (with range "+range+").");
        }

        for(Item item : items) {
            int startingPoint = randomInteger(0, users.size()-range);
            for(int i = startingPoint; i<range; i++) {
                User user = users.get(i);
                Rating rating = new Rating(user, item, randomStar());
                item.addRating(rating);
                ratings.add(rating);
            }
        }

    }

    /*
     * Prints out the totals of the generated content to the console
     */
    private void printTotals() {
        System.out.println("Created "+getAmountOfUsers()+" users.");
        System.out.println("Created "+getAmountOfItems()+" items.");
        System.out.println("Created "+getAmountOfCategories()+" categories.");
        System.out.println("Created "+getAmountOfQualities()+" qualities.");
        System.out.println("Created "+getAmountOfRatings()+" ratsings.");
    }

    /*
     * Creates a random integer between min and max
     */
    private int randomInteger(int min, int max) {
        return random.nextInt((max-min)+1)+min;
    }

    /*
     * Provides random star for rating generation
     */
    private Star randomStar() {
        Star[] stars = new Star[] {Star.ZERO, Star.ONE, Star.TWO, Star.THREE, Star.FOUR, Star.FIFE};
        return stars[randomInteger(0, stars.length-1)];
    }

    /*
     * Gives out the amount of milliseconds elapsed from the start of the
     * generation
     */
    private String debugTimestamp() {
        return TimeUnit.MILLISECONDS.convert((System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)+"ms: ";
    }

}
