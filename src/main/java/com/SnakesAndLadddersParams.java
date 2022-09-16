package com;

import java.util.HashMap;
import java.util.Map;

public class SnakesAndLadddersParams {



    public static final Map<Integer,Integer> snakesPositions= new HashMap<>();
    public static final Map<Integer,Integer> laddersPositions= new HashMap<>();
    public static final int playerId=0;
    public static final int botId=1;

    public static int[] board=new int[2];
    public static final int diceMaxValue=15;

    public void initializeGame(){
        snakesPositions.put(33,24);
        snakesPositions.put(72,55);
        snakesPositions.put(85,22);
        snakesPositions.put(91,70);

        laddersPositions.put(9,32);
        laddersPositions.put(31,80);
        laddersPositions.put(65,75);
        laddersPositions.put(76,99);
    }
}
