package com;

import java.util.Scanner;

import static com.SnakesAndLadddersParams.*;
import static com.util.SnakeAndLadderRules.*;

public class SnakeAndLadder {


    public static void main(String args[]){
        System.out.println("\t Welcome to Snake and Ladders");
        System.out.println("\t Positions of Snakes are"+ snakesPositions);
        System.out.println("\t Positions of Ladders are"+ laddersPositions);
        System.out.println("\t Let's play");
        laddersPositions.put(2,49);
        SnakesAndLadddersParams snakesAndLadddersParams= new SnakesAndLadddersParams();
        snakesAndLadddersParams.initializeGame();
        playGame();
    }


    public static void playGame(){
        Scanner scanner= new Scanner(System.in);
        int diceValue=0;
        boolean botTurn=false;
        do{
            if(!botTurn){
                System.out.println("your turn \t Press enter key to throw dice");
                scanner.nextLine();

                diceValue=((int)(Math.random()*100))%SnakesAndLadddersParams.diceMaxValue+1;
                System.out.println("Dice value="+diceValue);
                if(board[playerId]+diceValue<=100)
                    board[playerId] += diceValue;
                if (isBittenBySnake(playerId)){
                    System.out.println("\t Ooops bitten ");
                    board[playerId]=snakesPositions.get(board[playerId]);
                }
                else if(isOnLadder(playerId)){
                    System.out.println("\t  Congrats up on ladder ");
                    board[playerId]=laddersPositions.get(board[playerId]);
                }

                botTurn=true;
            }else {
                diceValue=((int)(Math.random()*100))%SnakesAndLadddersParams.diceMaxValue+1;
                System.out.println("Dice value="+diceValue);
                if(board[botId]+diceValue<=100)
                    board[botId] += diceValue;
                if (isBittenBySnake(botId)){
                    System.out.println("\t Ooops bitten ");
                    board[botId]=snakesPositions.get(board[botId]);
                }
                else if(isOnLadder(botId)){
                    System.out.println("\t Congrats up on ladder ");
                    board[botId]=laddersPositions.get(board[botId]);
                }
                botTurn=false;
            }

            System.out.println("Current Position of Player: "+ board[playerId]);
            System.out.println("Current Position of BOt: "+ board[botId]);
        }while (!isWon(playerId,botId));

        System.out.println(botTurn?"You won":"Bot won");
    }


}
