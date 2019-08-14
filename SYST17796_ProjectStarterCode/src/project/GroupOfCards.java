/**
 * SYST 17796 Project Summer 2019 Base code.
 * Students can modify and extend to implement their game.
 * Add your name as a modifier and the date!
 */
package project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game.
 * HINT, you might want to subclass this more than once.
 * The group of cards has a maximum size attribute which is flexible for reuse.
 * 
 */
public class GroupOfCards 
{
   
    //The group of cards, stored in an ArrayList
    private ArrayList <WarCard> cards;
    private int size;//the size of the grouping
    
    public GroupOfCards(int givenSize) {

        size = givenSize;
        cards = new ArrayList<>();

        int[] ranks = {1, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2};
        String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};

        // Create one deck
        WarCard[] temp = new WarCard[52];
        int count = 0;
        for (int rank: ranks) {
            for (String suit: suits)
                temp[count++] = new WarCard(rank, suit);
        }

        //transfer into cards based on the given size
        for (int i = 0; i < givenSize; i++)
            Collections.addAll(cards, temp);
    }
    
    /**
     * A method that will get the group of cards as an ArrayList
     * @return the group of cards.
     */
    public ArrayList<WarCard> showCards()
    {
        return cards;
    }


    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param givenSize the max size for the group of cards
     */
    public void setSize(int givenSize) {
        size = givenSize;
    }
   
}//end class
