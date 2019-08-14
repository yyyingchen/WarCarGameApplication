/**
 * SYST 17796 Project Summer 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

import java.util.ArrayList;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the code 
 * should remember to add themselves as a modifier.
 * 
 */
public abstract class Card 
{
    protected String suit;
    protected int rank;

    /**
     * Students should implement this method for their specific children classes 
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */


    @Override
    public abstract String toString();

}
