package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static com.SnakesAndLadddersParams.botId;
import static com.SnakesAndLadddersParams.playerId;

public class SnakeAndLadder {

    public static int[] board=new int[2];
    private static Map<Integer,Integer> snakesPositions= new HashMap<>();
    private static Map<Integer,Integer> laddersPositions= new HashMap<>();

    static {
        snakesPositions.put(33,24);
        snakesPositions.put(72,55);
        snakesPositions.put(85,22);
        snakesPositions.put(91,70);

        laddersPositions.put(9,32);
        laddersPositions.put(31,80);
        laddersPositions.put(65,75);
        laddersPositions.put(76,99);
    }

    public static void main(String args[]){
        System.out.println("\t Welcome to Snake and Ladders");
        System.out.println("\t Positions of Snakes are"+ snakesPositions);
        System.out.println("\t Positions of Ladders are"+ laddersPositions);
        System.out.println("\t Let's play");

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

    public static boolean isWon(int playerId,int botId){
        if(board[playerId]==100 || board[botId]==100){
            return true;
        }
        return false;
    }

    public static boolean isBittenBySnake(int playerId){
        if(snakesPositions.containsKey(board[playerId])){
            return true;
        }
        return false;
    }
    public static boolean isOnLadder(int playerId){
        if(laddersPositions.containsKey(board[playerId])){
            return true;
        }
        return false;
    }
}
