package com;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeAndLadderTest {

    @BeforeAll
    static void init(){
        SnakeAndLadder.board[0]=100;
        SnakeAndLadder.board[1]=33;
    }

    @Test
    void isWon() {
        assertTrue(SnakeAndLadder.isWon(0,1));
    }

    @Test
    void isBittenBySnake() {
        assertTrue(SnakeAndLadder.isBittenBySnake(1));
    }

    @Test
    void isOnLadder() {
        assertFalse(SnakeAndLadder.isOnLadder(1));
    }
}