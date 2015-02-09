/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.Item;
import domain.Quality;
import domain.RecommendedItem;
import domain.User;
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
     * @param source Source Item to compare to
     * @param compares List of Item to compare to source
     *
     * @return Ordered list of RecommendedItems
     *
     * @see RecommendedItem
     * @see Item
     */
    public ArrayList<RecommendedItem> rateItemsBasedOnQualities( Item source, ArrayList<Item> compares ) {
        ArrayList<RecommendedItem> recommends = new ArrayList<>(compares.size());
        ArrayList<Quality> sourceQualities = source.getQualities();

        // For each item in the compare list...
        for ( Item compare : compares ) {
            ArrayList<Quality> compareQualities = compare.getQualities();
            double recommendLevel = 0;

            // compare it's qualities to the source item...
            for ( Quality sourceQuality : sourceQualities ) {
                for ( Quality compareQuality : compareQualities ) {

                    // and if similar quality calculate the importance 
                    // level between those two items...
                    if ( sourceQuality.equals(compareQuality) ) {
                        recommendLevel
                                += sourceQuality.getImportance().getValueAsDouble()
                                * compareQuality.getImportance().getValueAsDouble();
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

    public ArrayList<RecommendedItem> rateItemsBasedOnUserReviews( User user, ArrayList<Item> compares ) {
        ArrayList<RecommendedItem> recommends = new ArrayList<>(compares.size());

        // TODO
        return recommends;
    }

}
