package project;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author CY
 */
public class WarPlayer extends Player {

    private ArrayList<WarCard> handCards;

    private int leftCards = 0;
    public WarPlayer(String name) {
        super(name);
        handCards = new ArrayList<>();
    }

    @Override
    public void play() {

    }

    protected int getLeftCards() {
        return leftCards;
    }
    public void getHandCard(WarCard card) {
        handCards.add(card);
        leftCards++;
    }

    public WarCard flipTopCard(){
        if (leftCards > 0) {
            WarCard card = handCards.remove(0);
            leftCards--;
            return card;
        }
        return null;

    }

    public void addToBottom(List<WarCard> earnedCards){
        handCards.addAll(earnedCards);
        leftCards += earnedCards.size();
    }
}
