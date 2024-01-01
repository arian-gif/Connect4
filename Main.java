/*
Name: Arian khan & Eshan Khan
Program Creation Date: 2022-04-23
Program Name: Connect 4
Program Description: Connect 4
Last Edit date:2022-04-23
*/
import java.util.*;
// Test class to demonstrate our Connect Four Model
public class Main{
    public static void main( String[] args ) {
        int column = 0;
        Scanner in = new Scanner( System.in );
        
        ConnectFourGame game = new ConnectFourGame();
        
        do {
            System.out.println( game );
            System.out.println( "What Column?" );
            column = in.nextInt();
            while( game.drop( column ) == -1 ) {
                System.out.println( "\nCan't drop in column " + column );
                System.out.println( "Please Try Again..\n" );
                System.out.println( "What Column?" );
                column = in.nextInt();
            } 
        } while ( !game.hasWon() && ConnectFourGame.turn <48);
        
        System.out.println( game );
        if(game.getCurrentPlayer()==1&&game.hasWon()){
           System.out.println("Player 2 has won");
        }
        else if(game.getCurrentPlayer()==2&&game.hasWon()){
          System.out.println("Player 1 has won");
        }
      else{
        System.out.println("Tie game");
      }
       
        System.out.println( "*** GAME OVER ***" );
    }   
}

