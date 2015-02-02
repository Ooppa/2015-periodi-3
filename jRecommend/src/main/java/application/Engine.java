/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.Item;
import domain.Quality;
import domain.RecommendedItem;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Ooppa
 */
public class Engine {
    
    public ArrayList<RecommendedItem> rateItemsBasedOnQualities(Item source, ArrayList<Item> compares){
        ArrayList<RecommendedItem> recommends = new ArrayList<>(compares.size());
        ArrayList<Quality> sourceQualities = source.getQualities();
        
        for(Item compare : compares) {
            ArrayList<Quality> compareQualities = compare.getQualities();
            double recommendLevel = 0;
            
            for(Quality sourceQuality : sourceQualities) {
                for(Quality compareQuality : compareQualities) {
                    recommendLevel += 
                            sourceQuality.getImportance().getValueAsDouble()
                            *compareQuality.getImportance().getValueAsDouble();
                }
            }
            
            recommends.add(new RecommendedItem(compare, recommendLevel));
        }
        
        Collections.sort(recommends, new RecommendedItem());
        
        return recommends;
    }
    
}
