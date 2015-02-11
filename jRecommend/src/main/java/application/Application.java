/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package application;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The starting point for the application.
 * @author Ooppa
 */
public class Application {
    
    private static final Logger logger = Logger.getLogger(Application.class.getName());
    
    public static void main(String[] args) {
        try {
            logger.setLevel(Level.parse(args[0]));
        } catch ( IllegalArgumentException | ArrayIndexOutOfBoundsException exception ) {
            logger.setLevel(Level.OFF);
        }
        
        // TODO: Currently broken (java.lang.IndexOutOfBoundsException)
        // Will look into it a bit later...
        Example example = new Example();
        
    }
    
}
