/*
 * Aineopintojen harjoitustyö: Tietorakenteet ja algoritmit
 * Helsingin yliopisto Tietojenkäsittelytieteen laitos
 * Ooppa 2015 - GNU General Public License, version 3.
 */
package comparators;

import domain.User;
import java.util.Comparator;

/**
 *
 * @author Ooppa
 */
public class CompareUsersBasedOnAmountOfRatings implements Comparator<User> {

    @Override
    public int compare(User user, User otherUser) {
        if(user.getRatings().size()==otherUser.getRatings().size()){
            return 0;
        }
        
        if(user.getRatings().size()>otherUser.getRatings().size()){
            return -1;
        } else {
            return 1;
        }
    }
    
}
