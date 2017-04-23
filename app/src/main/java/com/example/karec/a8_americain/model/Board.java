package com.example.karec.a8_americain.model;

/**
 * Created by Karec on 21/04/2017.
 */



/**
 * Created by rrich on 19/04/2017.
 */

public class Board{

    public static void Board(){
        System.out.println("Initialisation du Board");
        new Deck();
        Deck.Deckbuilding();
        Deck.shuffleDeck();

        System.out.println("Deck ");
    }

    private String derniereCarteJouee;
    private String carteJouee;
    private boolean joueurActif;
    private String[] cartesValides;

    public boolean getJoueurActif(){
        return this.joueurActif;
    }

    public void debutPartie(){
        new Player();
        Deck.piocherMainDepart();

    }

    public void changerDeTour(){
        //if (isCarteValide() == true) {
        //}
    }

    /*
    public void jouerUneCarte(Player){
        Player.
    }
    */
    /*
    public boolean isCarteValide(){
        if(derniereCarteJouee == null){
            return true;
        }
        else if(derniereCarteJouee != null){
            if(derniereCarteJouee.couleurCarte = carteJouee.couleurCarte){
                return true;
            }
            else if(derniereCarteJouee.numeroCarte = carteJouee.numeroCarte){
                return true;
            }
            else if(carteJouee.numeroCarte == "8"){
                return true;
            }
            else{
                return false;
            }
        }
    }
    */

    /*
    public void cardEffect(){
        if(isCarteValide() == true && derniereCarteJouee.numeroCarte == "2"){
            joueurInactif.drawCard();
            joueurInactif.drawCard();
        }
        if(isCarteValide() == true && derniereCarteJouee.numeroCarte == "Valet"){
            changerDeTour();
        }
        changerDeTour();
    }
    */




}