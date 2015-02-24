/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import domain.Item;
import domain.Quality;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The starting point for the application.
 *
 * @author Ooppa
 */
public class Application {

    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        try {
            logger.setLevel(Level.parse(args[0]));
        } catch(IllegalArgumentException|ArrayIndexOutOfBoundsException exception) {
            logger.setLevel(Level.OFF);
        }
        
        Item item = new Item(1L, "Peruna");
        Quality quality = new Quality(1L, "Perunainen");
        
        System.out.println(item.getClass().toString());
        System.out.println(quality.getClass().toString());
        
        //Example example = new Example();

    }

}
