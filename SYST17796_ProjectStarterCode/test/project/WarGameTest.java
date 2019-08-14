/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author CY
 */
public class WarGameTest {
    
    public WarGameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of setPlayers method, of class WarGame.
     */
    @Test
    public void testSetPlayersGood() {
        System.out.println("setPlayers");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.setPlayers(playerA, playerB);
        ArrayList<Player> players = instance.getPlayers();
        
        assertEquals(playerA, players.get(0));
        assertEquals(playerB, players.get(1));        
    }
    
    @Test
    public void testSetPlayersBad() {
        System.out.println("setPlayers");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.setPlayers(playerA, playerB);
        ArrayList<Player> players = instance.getPlayers();
        
        assertEquals(playerA, players.get(0));
        assertEquals(playerB, players.get(1));        
    }
    
    
    @Test
    public void testSetPlayersBoundary() {
        System.out.println("setPlayers");
        Player playerA = new WarPlayer("tester1");
        
        WarGame instance = new WarGame("war game");
        
        ArrayList<Player> playersList = new ArrayList<Player>();
        playersList.add(playerA);
        instance.setPlayers(playersList);
        ArrayList<Player> players = instance.getPlayers();
        
        assertEquals(playerA, players.get(0)); 
    }

    @Test 
    public void testConductWarGood() {
        System.out.println("ConductWar");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.setPlayers(playerA, playerB);
        instance.shuffleCards();
        instance.assignHandCard(playerA, playerB);
        
        instance.conductWar();
        
        boolean expResult = true;
        boolean result = playerA.getLeftCards() != playerB.getLeftCards();
        assertEquals(expResult, result);
    }
    
        @Test 
    public void testConductWarBad() {
        System.out.println("ConductWar");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.setPlayers(playerA, playerB);

        instance.assignHandCard(playerA, playerB);

        instance.conductWar();
        
        boolean expResult = true;
        boolean result = playerA.getLeftCards() == playerB.getLeftCards();
        assertEquals(expResult, result);
    }
    
        @Test 
    public void testConductWarBoundary() {
        System.out.println("ConductWar");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.setPlayers(playerA, playerB);
        instance.shuffleCards();
        instance.assignHandCard(playerA, playerB);
        
        instance.conductWar();
        
        boolean expResult = true;
        boolean result = playerA.getLeftCards() != playerB.getLeftCards();
        assertEquals(expResult, result);
    }
    /**
     * Test of assignHandCard method, of class WarGame.
     */
    @Test
    public void testAssignHandCardGood() {
        System.out.println("assignHandCard");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        instance.assignHandCard(playerA, playerB);
        
        boolean expResult = true;
        
        boolean result = playerA.getLeftCards() > 0 && playerB.getLeftCards() > 0;
        assertEquals(expResult, result);
    }

    @Test
    public void testAssignHandCardBad() {
        System.out.println("assignHandCard");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        WarGame instance = new WarGame("war game");
        
        boolean expResult = false;
        
        boolean result = playerA.getLeftCards()> 0 && playerB.getLeftCards() > 0;
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAssignHandCardBoundary() {
        System.out.println("assignHandCard");
        WarPlayer playerA = new WarPlayer("tester1");
        WarPlayer playerB = new WarPlayer("tester2");
        
        WarCard card = new WarCard(10, "Club");
        playerA.getHandCard(card);
        playerB.getHandCard(card);
        
        boolean expResult = true;
        
        boolean result = playerA.getLeftCards() == 1 && playerB.getLeftCards() == 1;
        assertEquals(expResult, result);
    }
    
    /**
     * Test of conductBattle method, of class WarGame.
     */
    @Test
    public void testConductBattleGood() {
        System.out.println("conductBattle for ");
        WarCard cardA = new WarCard(10, "Heart");
        WarCard cardB = new WarCard(5, "Club");
        WarGame instance = new WarGame("War Game");
        int expResult = 1;
        int result = instance.conductBattle(cardA, cardB);
        assertEquals(expResult, result);
    }
        @Test
    public void testConductBattleBad() {
        System.out.println("conductBattle");
        WarCard cardA = new WarCard(10, "Heart");
        WarCard cardB = new WarCard(10, "Club");
        WarGame instance = new WarGame("War Game");
        int expResult = 0;
        int result = instance.conductBattle(cardA, cardB);
        assertEquals(expResult, result);
    }
        @Test
    public void testConductBattleBoundary() {
        System.out.println("conductBattle");
        WarCard cardA = new WarCard(10, "Heart");
        WarCard cardB = new WarCard(10, "Heart");
        WarGame instance = new WarGame("War Game");
        int expResult = 0;
        int result = instance.conductBattle(cardA, cardB);
        assertEquals(expResult, result);
    }
}
