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
        this.startingTime = System.nanoTime();
        this.debug = debug;

        this.random = new Random();

        if(debug) {
            System.out.println(debugTimestamp()+"------------------------------");
        }

        populateUsers(Math.round(scale*250));
        populateItems(Math.round(scale*100));
        populateQualities((int) Math.round((double) scale*2.5));
        populateCategories((int) Math.round((double) scale/14));

        assingQualitiesToItems();
        assingCategoriesToItems();

        createRatings();

        printTotals();

        if(debug) {
            System.out.println(debugTimestamp()+"Creation process is now done."
                    +" Overall it took "+TimeUnit.SECONDS.convert(
                            (System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)
                    +" seconds.");
        }
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
        System.out.println("Created "+users.size()+" users.");
        System.out.println("Created "+items.size()+" items.");
        System.out.println("Created "+categories.size()+" categories.");
        System.out.println("Created "+qualities.size()+" qualities.");
        System.out.println("Created "+ratings.size()+" ratings.");
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
     * Gives out the amount of milliseconds elapsed from the start of the generation
     */
    private String debugTimestamp() {
        return TimeUnit.MILLISECONDS.convert((System.nanoTime()-startingTime), TimeUnit.NANOSECONDS)+"ms: ";
    }

}
