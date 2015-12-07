package com.mma.tennis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestTennis {

	Tennis game;
	Player player2;
	Player player1;

	
	
	@Before
	public void beforeGameTest() {
		player1 = new Player("player1");
		player2 = new Player("player2");
		game = new Tennis(player1,player2);
	}
	
	@Test
	public void testLoveLove() {
		String expectedScore = "love, love";
		assertEquals(expectedScore,game.getScore());
	}
	
	@Test
	public void test15Love() {
		String expectedScore = "fifteen, love";
		player1.winBall();
		assertEquals(expectedScore,game.getScore());
	}
	@Test
	public void test1540() {
		String expectedScore = "fifteen, forty";
		player1.winBall();
		for(int i= 1; i <= 3; i++) {
			player2.winBall();
        }   
		assertEquals(expectedScore,game.getScore());
	}
	
	@Test
	public void testPlayer1won() {
		String expectedScore = "player1 won";
		for(int i= 1; i <= 4; i++) {
			player1.winBall();
        }    
		assertEquals(expectedScore,game.getScore());
	}
	
	@Test
	public void testPlayer1wonOver() {
		String expectedScore = "player1 won";
		for(int i= 1; i <= 7; i++) {
			player1.winBall();
        }    
		for(int i= 1; i <= 5; i++) {
			player2.winBall();
        }  
		assertEquals(expectedScore,game.getScore());
	}
	
	@Test
	public void testDeuce() {
		String expectedScore = "deuce";
		for(int i= 1; i <= 4; i++) {
			player1.winBall();
        } 
		for(int i= 1; i <= 4; i++) {
			player2.winBall();
        }
		assertEquals(expectedScore,game.getScore());
		assertNotEquals("advantage player1",game.getScore());
		assertNotEquals("advantage player2",game.getScore());
	}
	
	@Test
	public void testAdvantage1() {
		String expectedScore = "advantage player1";
		for(int i= 1; i <= 4; i++) {
			player1.winBall();
        } 
		for(int i= 1; i <= 3; i++) {
			player2.winBall();
        }
		assertEquals(expectedScore,game.getScore());
		
	}
	
	
}
