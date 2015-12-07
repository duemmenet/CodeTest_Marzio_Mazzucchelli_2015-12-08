package com.mma.tennis;

public class Tennis {
	
	
	private Player player1;
    private Player player2;
    private String off;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	    System.out.println ("start---");
	    
	    Player player1 = new Player("player1");
        Player player2 = new Player("player2");
        Tennis game = new Tennis(player1, player2);
        
      
        player1.winBall();
        player1.winBall();
        
        String res = game.getScore();
        System.out.println ("----" + res + "----");
	            
	}

	

    public Tennis(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.setOff("");
      
    }

    public String getScore() {
        if (player1.getScore() >= 3 && player2.getScore() >= 3) {
            if (Math.abs(player2.getScore() - player1.getScore()) >= 2) {
            	this.setOff("x");
                return getLeadPlayer().getName() + " won";
            } else if (player1.getScore() == player2.getScore()) {
                return "deuce";
            } else {
                return "advantage " + getLeadPlayer().getName();
            }
        } 
        else if (player1.getScore() == 4 || player2.getScore() == 4) {
        	this.setOff("x");
            return getLeadPlayer().getName() + " won";
        	
        }
        else {
            return player1.getScoreDescriptionEnum() + ", " + player2.getScoreDescriptionEnum();
        }
		
    }

    
    public Player getLeadPlayer() {
        return (player1.getScore() > player2.getScore()) ? player1 : player2;
    }




	public String getOff() {
		return off;
	}




	public void setOff(String off) {
		this.off = off;
	}

}
