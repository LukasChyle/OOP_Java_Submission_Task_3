import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FifteenPuzzle extends JFrame implements ActionListener {

    private JButton[][] board = new JButton[4][4];
    private JButton restart = new JButton("Restart");
    private int[] checkUnique = new int[16];
    private String[][] winOrder = {{"1", "2", "3", "4"}, {"5", "6", "7", "8"}, {"9", "10", "11", "12"}, {"13", "14", "15", "0"}};

    private FifteenPuzzle() {

    }

/*
lägg in reset button i Jframe med Borderlayout.NORTH
lägg in mainPanel i Jframe med borderlayout.SOUTH
lägg in knapparna i mainPanel i rätt ordning.
*/

/*
getRandom:
skapa en random int 0-15 (0 = blank ruta),
itererar checkUnique för för att kontrollera om siffran redan används.
- om redan finns hämta en ny siffra
- om unik lägg till siffran i checkUnique och returnera siffran
*/

/*
setButtons:
Tilldelar alla buttons ett värde "setText()",
nested for-loop för att komma åt alla knapparna och getRandom för att tilldela.
*/

/*
checkOrder:
kontrollera om siffrorna ligger i rätt ordning på knapparna "getText()"
genom att iterera genom knapparna och gämföra mot motsvarande plats på winOrder
om man vunnit gör en popuppruta med vinst och kalla sen på newGame
/*

/*
newGame:
board = new JButton[4][4];
checkUnique = new int[16];
kalla på setButtons
ta bort markering från knapp (kanske inte behövs)
*/

/*
listener even:
Markera knappen om den är bredvid "0"
när man klickar på nästa knapp:
- om knappen inte är "0" men också ligger bredvid "0", flytta över markeringen till nya knappen.
- om knappen inte är "0" och inte ligger bredvid "0" släck markeringen på nuvarande.
- om knappen ligger bredvid "0" byt plats på talen(texterna) och släck markering.

kör checkOrder för att se om pusslet är klart.
------------------
om restart knappen trycks kalla på newGame
*/

// "0" knapp sätt setOpasity"false";

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        FifteenPuzzle game = new FifteenPuzzle();
    }
}
