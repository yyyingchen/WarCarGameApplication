package project;

import java.util.ArrayList;
import java.util.Random;

public class ManualWarGameTest {



    public static boolean testShuffleCards() {
        WarGame warGameController = new WarGame("War Game");
        WarPlayer player1 = new WarPlayer("tester1");
        WarPlayer player2 = new WarPlayer("tester2");

        ArrayList<WarCard> newCards = new GroupOfCards(1).showCards();
        warGameController.shuffleCards();
        ArrayList<WarCard> shuffledCars = warGameController.getCards();

        Random rand = new Random();

        int count = 0;

        for (int i = 0; i< 5; i++) {
            int num = rand.nextInt(53);
            if (newCards.get(num) == shuffledCars.get(num))
                count++;
        }
        return count != 5;
    }

    public static boolean testCheckStatus() {
        WarGame warGameController = new WarGame("War Game");
        WarPlayer player1 = new WarPlayer("tester1");
        WarPlayer player2 = new WarPlayer("tester2");

        warGameController.setPlayers(player1, player2);
        warGameController.assignHandCard(player1, player2);
        for (int i = 26; i > 0; i++) {
            player1.flipTopCard();
        }

        boolean expResult = false;
        boolean result = warGameController.checkStatus();
        return expResult == result;
    }

    public static boolean testDeclarerWinner() {
        WarGame warGameController = new WarGame("War Game");
        WarPlayer player1 = new WarPlayer("tester1");
        WarPlayer player2 = new WarPlayer("tester2");

        warGameController.setPlayers(player1, player2);
        warGameController.shuffleCards();
        warGameController.assignHandCard(player1, player2);

        for (int i = 26; i > 0; i++) {
            player1.flipTopCard();
        }
        
        warGameController.declareWinner();
        return player1.getLeftCards() == 0;
    }

    public static void main(String[] args) {
        System.out.print("Test for ShuffleCards: ");
        if (testShuffleCards())
            System.out.println("passed");
        else
            System.out.println("Failed");

        System.out.print("Test for CheckStatus: ");
        if (testCheckStatus())
            System.out.println("passed");
        else
            System.out.println("Failed");

        System.out.print("Test for DeclarerWinner: ");
        if (testDeclarerWinner())
            System.out.println("passed");
        else
            System.out.println("Failed");
    }
}
