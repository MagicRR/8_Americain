package com.example.rrich.a8_americain;

import android.os.Bundle;

import com.example.rrich.a8_americain.model.Board;
import com.example.rrich.a8_americain.model.Card;
import com.example.rrich.a8_americain.model.Deck;

import org.junit.Test;

import static com.example.rrich.a8_americain.model.Deck.deck;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    public ExampleUnitTest(){
        new Board();
        Board.Board();

        System.out.println("Deck done");
    }

}