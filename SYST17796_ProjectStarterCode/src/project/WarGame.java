package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WarGame extends Game {
    private WarPlayer playerA;
    private WarPlayer playerB;
    private ArrayList<WarCard> cards;
    
    // 1 if Player A win, -1 if player B win
    private int status = 0;

    // A temporary array to store cards placed by players
    private ArrayList<WarCard> cardPool;
    private Scanner scanner;

    public WarGame(String name) {
        super(name);
        cardPool = new ArrayList<>();
        cards = new GroupOfCards(1).showCards();

        scanner = new Scanner(System.in);
    }
    public void start() {

        int count = 1;
        String input;
        boolean flag = true;

        while (checkStatus()) {
            System.out.println("----------------------" + " Turn " + count++ + " -----------------------");
            play();
            cardPool.clear();

            //System.out.println("left cards " + playerA.getLeftCards() + " " + playerB.getLeftCards());
            if (flag) {
                System.out.print("enter 'e' to skip the process and display the result, enter others to continue next turn. ");

                input = scanner.next();
                if (input.equals("e") || input.equals("E")) {
                    flag = false;
                }
            }
        }
    }

    @Override
    public void play() {
        System.out.println("Flipped top card and placed to the card pool");
        WarCard cardA = playerA.flipTopCard();
        WarCard cardB = playerB.flipTopCard();

        System.out.printf("\t%-10s%s\n", playerA.getPlayerID(), cardA);
        System.out.printf("\t%-10s%s\n", playerB.getPlayerID(), cardB);

        cardPool.add(cardA);
        cardPool.add(cardB);

        int result = conductBattle(cardA, cardB);

        System.out.println("---------------------result---------------------");

        if (result == 1) {
            System.out.println(cardA.rank + " > " + cardB.rank);
            playerA.addToBottom(cardPool);
            System.out.println(playerA.getPlayerID() + " won " + cardPool.size() + " cards" + " from the card pool");
        }
        else if (result == -1) {
            System.out.println(cardA.rank + " < " + cardB.rank);
            playerB.addToBottom(cardPool);
            System.out.println(playerB.getPlayerID() + " won " + cardPool.size() + " cards" + " from the card pool");
        }

        else {
            System.out.println(cardA.rank + " = " + cardB.rank);
            System.out.println("-------War-------");
            System.out.println("Placed next 3 cards to the card pool ");
            System.out.println("--------------------------------------------");

            if (playerA.getLeftCards() <= 3) {
                status = -1;
                System.out.println(playerA.getPlayerID() + " runs out of cards during the war!");

            } else if (playerB.getLeftCards() <= 3) {
                status = 1;
                System.out.println(playerA.getPlayerID() + " runs out of cards during the war!");
            } else {
                conductWar();
            }

        }

    }
    public ArrayList<WarCard> getCards() {
        return cards;
    }
    
    public void setPlayers(WarPlayer playerA, WarPlayer playerB) {
        this.playerA = playerA;
        this.playerB = playerB;
        
        ArrayList<Player> players = new ArrayList<>();
        players.add(playerA);
        players.add(playerB);
        this.setPlayers(players);
    }
    
    public void shuffleCards() {
        Collections.shuffle(cards);
    }
    public void assignHandCard(WarPlayer playerA, WarPlayer playerB) {

        for (int i = 0; i < cards.size(); i++) {
            playerA.getHandCard(cards.get(i));
            playerB.getHandCard(cards.get(i + 1));
            i++;
        }
    }

    protected void conductWar() {
        for (int i = 0; i < 3; i++) {
            cardPool.add(playerA.flipTopCard());
            cardPool.add(playerB.flipTopCard());
        }
        play();
    }
    protected int conductBattle(WarCard cardA, WarCard cardB) {
        return Integer.compare(cardA.rank, cardB.rank);
    }

    protected boolean checkStatus(){
        return playerA.getLeftCards() > 0 && playerB.getLeftCards() > 0 && status == 0;
    }

    @Override
    public void declareWinner() {
        if (playerA.getLeftCards() > playerB.getLeftCards())
            System.out.println(playerB.getPlayerID() + " lost the game!");
        else
            System.out.println(playerA.getPlayerID() + " lost the game!");
    }

    public static void main(String[] args) {
        WarGame warGameController = new WarGame("War Game");
        System.out.println("-------------" + " welcome to War Card Game! " + "----------------");
        WarPlayer playerA = null;
        WarPlayer playerB = null;
        boolean isvalid = false;
        
        while (!isvalid) {
            try {
                System.out.print("How many players you want to register for the game? (1 or 2): ");

                Scanner scanner = new Scanner(System.in);
                String input = scanner.next();

                // Convert user's input into Integer, NumberFormatException will be threw if user enter something else.
                int status = Integer.valueOf(input);

                if (status != 1 && status != 2) {
                    throw new NumberFormatException();
                }

                // If user's input is 1, player will play with computer
                if (status == 1) {
                    System.out.print("Please enter your username: ");
                    String username = scanner.next();

                    playerA = new WarPlayer("playerA");
                    playerB = new WarPlayer(username);
                    
                    isvalid = true;
                }

                // If user's input is 2, player will play with another player.
                if (status == 2) {
                    System.out.print("Please enter first player's username: ");
                    String username = scanner.next();
                    playerA = new WarPlayer(username);

                    System.out.print("Please enter second player's username: ");
                    username = scanner.next();
                    playerB = new WarPlayer(username);
                    isvalid = true;
                }

            }catch (NumberFormatException e) {
                System.out.println("Wrong enter! Please enter 1 or 2! ");
            }
        }
 
        warGameController.setPlayers(playerA, playerB);
        warGameController.shuffleCards();
        warGameController.assignHandCard(playerA, playerB);

        warGameController.start();

        System.out.println("--------- Game Over ------------");
        warGameController.declareWinner();
    }
}
