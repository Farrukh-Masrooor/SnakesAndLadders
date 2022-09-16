package com.util;


import static com.SnakesAndLadddersParams.*;

public class SnakeAndLadderRules {

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
