package com.util;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.SnakesAndLadddersParams.board;
import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderRulesTest {

    @BeforeAll
    public static void init(){
        board[0]=33;
        board[1]=100;
    }

    @Test
    void isWon() {
        assertTrue(SnakeAndLadderRules.isWon(0,1));
    }

    @Test
    void isBittenBySnake() {
        assertFalse(SnakeAndLadderRules.isBittenBySnake(1));
    }


    @Test
    void isOnLadder() {
        assertFalse(SnakeAndLadderRules.isOnLadder(0));
    }
}