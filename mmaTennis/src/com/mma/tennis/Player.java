package com.mma.tennis;



public class Player {


   
    private enum pointsEn {
       love,
       fifteen,
       thirty,
       forty
    }   
    private int score;
    private String name;
  
    
    public int getScore() {
        return score;
    }
  
    public String getName() {
        return name;
    }

    public Player(String name) {
        this.name = name;
    }
    public void winBall() {
        this.score = this.score + 1;
    }

    public pointsEn getScoreDescriptionEnum(){
        return pointsEn.values()[score];
    }


}
