/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rock_paper_scissors;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Kasper
 */
public class RockPaperScissors {

    /**
     * @param args the command line arguments
     */
    
    public final static String[] HANDS = new String[]{"Sten","Saks","Papir"};
    private String playerHand = "";
    private String opponentHand = "";
    private boolean isPlaying = true;

    public static void main(String[] args) {
        RockPaperScissors rps = new RockPaperScissors();
        Scanner sc = new Scanner(System.in);
        int choice;
        
        while(rps.isPlaying){
            System.out.println("[0]Sten, [1]Saks eller [2]Papir?");
            choice = sc.nextInt();
            if((choice < 0 || choice > 2)){
                System.out.println("Du skrev ikke et gyldigt tal.");
                rps.isPlaying = false;
            }
            rps.play(HANDS[choice]);
            System.out.println("Du har valgt: " + rps.getPlayerHand());
            System.out.println("Din modstander valgte: " + rps.getOpponentHand());
            System.out.println(rps.getWinner());
            rps.isPlaying = false;
        }
    }
    
    public void play(String playerHand){
              
        this.playerHand = playerHand;
        this.opponentHand = HANDS[new Random().nextInt(HANDS.length-1)];
        
    }
    
    public String getWinner(){
        
        String win = "You won this round!";
        String noWin = "Your opponent won this round!";
        String tie = "It was a tie!";
        
        if(playerHand == opponentHand){
            return tie;
        } else if(playerHand == HANDS[0] && opponentHand == HANDS[1]){
            return win;
        } else if(playerHand == HANDS[0] && opponentHand == HANDS[2]){
            return noWin;
        } else if(playerHand == HANDS[1] && opponentHand == HANDS[2]){
            return win;
        } else if(playerHand == HANDS[1] && opponentHand == HANDS[0]){
            return noWin;
        } else if(playerHand == HANDS[2] && opponentHand == HANDS[0]){
            return win;
        } else {
            return noWin;
        }
    }

    /**
     * @return the usersHand
     */
    public String getPlayerHand() {
        return playerHand;
    }

    /**
     * @return the opponentsHand
     */
    public String getOpponentHand() {
        return opponentHand;
    }
    
}
