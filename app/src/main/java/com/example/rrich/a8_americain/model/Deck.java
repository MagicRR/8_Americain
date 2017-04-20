package com.example.rrich.a8_americain.model;

import java.util.Random;

/**
 * Created by rrich on 19/04/2017.
 */

public class Deck{


    public static Card deck[];
    private static Random randomNumbers;
    private static int currentCard;
    private static int NUMBER_OF_CARDS = 52;

    private static final Random GENERATOR = new Random();

    public static void Deckbuilding() {
        String[] numeroCarte = {"As", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi"};
        String[] couleurCarte = {"Pique", "Coeur", "Carreau", "Trefle"};

        deck = new Card[NUMBER_OF_CARDS];
        randomNumbers = new Random();

        for (int i = 1; i < deck.length; i++) {
            deck[i] = new Card(numeroCarte[i % 13], couleurCarte[i / 13], i);
        }
    }

    public static void shuffleDeck(){

        currentCard = 0;
        for (int first = 0; first < deck.length; first++){
            int second = randomNumbers.nextInt(NUMBER_OF_CARDS);

            Card temp = deck[first];
            deck[first] = deck [second];
            deck[second] = temp;
            //System.out.print("Deck First Test : " + temp + "\n");


        }
        System.out.print("Le gros shuffle\n");
    }

    public Card drawCard(){
        if(currentCard < deck.length){
            return deck[currentCard++];
        }
        else{
            return null;
        }
    }

    public String toString()
    {
        String s = "";
        int k;

        k = 0;
        for ( int i = 0; i < 4; i++ )
        {
            for ( int j = 1; j <= 13; j++ )
                s += ( deck[k++] + " " );

            s += "\n";
        }
        return ( s );
    }


    public static void piocherMainDepart(){

    }
}