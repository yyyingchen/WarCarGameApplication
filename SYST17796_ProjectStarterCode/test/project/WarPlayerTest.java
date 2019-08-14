/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
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
public class WarPlayerTest {
    
    public WarPlayerTest() {
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
     * Test of getHandCard method, of class WarPlayer.
     */ 
    @Test
    public void testGetHandCardGood() {
        System.out.println("getHandCard for Good Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        WarCard card2 = new WarCard(2, "Club");
        WarCard card3 = new WarCard(5, "Heart");
        WarPlayer player = new WarPlayer("player");
        
        player.getHandCard(card1);
        player.getHandCard(card2);
        player.getHandCard(card3);

        WarCard reuslt = player.flipTopCard();
            assertEquals(card1, reuslt);

    }
    
    @Test
    public void testGetHandCardBad() {
        WarPlayer player = new WarPlayer("player for Bad Test Case");
               
        WarCard reuslt = player.flipTopCard();
        assertEquals(null, reuslt);
    }

    /**
     * Test of flipTopCard method, of class WarPlayer.
     */
    @Test
    public void testGetHandBoundary() {
        System.out.println("getHandCard for Boundary Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        WarPlayer player = new WarPlayer("player");
        
        player.getHandCard(card1);

        WarCard reuslt = player.flipTopCard();
            assertEquals(card1, reuslt);
    }
    
    /**
     * Test of flipTopCard method, of class WarPlayer.
     */
    @Test
    public void testFlipTopCardGood() {       
        System.out.println("FlipTopCard for Boundary Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        WarCard card2 = new WarCard(2, "Club");
        WarCard card3 = new WarCard(5, "Heart");
        
        WarPlayer player = new WarPlayer("player");
        
        player.getHandCard(card1);
        player.getHandCard(card2);
        player.getHandCard(card3);

        WarCard reuslt = player.flipTopCard();
        assertEquals(card1, reuslt);

    }
    @Test
    public void testFlipTopCardBad() {       
        System.out.println("FlipTopCard for Bad Test Case");
     
        WarPlayer player = new WarPlayer("player");


        WarCard reuslt = player.flipTopCard();
        assertEquals(null, reuslt);

    }
    
    @Test
    public void testFlipTopCardBoundary() {       
        System.out.println("FlipTopCard for Boundary Test Case");
        WarCard card1 = new WarCard(10, "Heart");
      
        WarPlayer player = new WarPlayer("player");
        
        player.getHandCard(card1);

        WarCard reuslt = player.flipTopCard();
        assertEquals(card1, reuslt);
    }
    

    /**
     * Test of addToBottom method, of class WarPlayer.
     */
    @Test
    public void testAddToBottomGood() {
        System.out.println("addToBottom  for Good Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        WarCard card2 = new WarCard(4, "Heart");
        WarCard card3 = new WarCard(5, "Heart");
        WarCard card4 = new WarCard(5, "Club");
        
        List<WarCard> earnedCards = Arrays.asList(card3, card4);
        
        WarPlayer player = new WarPlayer("tester");
        player.getHandCard(card1);
        player.getHandCard(card2);
        player.addToBottom(earnedCards);
        
        player.flipTopCard();
        player.flipTopCard();
        player.flipTopCard();
        
        assertEquals(player.flipTopCard(), card4);
    }
    @Test
    public void testAddToBottomBad() {
        System.out.println("addToBottom for Bad Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        WarCard card2 = new WarCard(4, "Heart");
        WarCard card3 = new WarCard(5, "Heart");
        List<WarCard> earnedCards = Arrays.asList(card1, card2, card3);
        
        WarPlayer player = new WarPlayer("tester");
        player.addToBottom(earnedCards);
        
        assertEquals(player.flipTopCard(), card1);
    }
        @Test
    public void testAddToBottomBoundary() {
        System.out.println("addToBottom for Boundary Test Case");
        WarCard card1 = new WarCard(10, "Heart");
        List<WarCard> earnedCards = Arrays.asList(card1);
        
        WarPlayer player = new WarPlayer("tester");
        player.addToBottom(earnedCards);
        
        assertEquals(player.flipTopCard(), card1);
    }
    
    
}
