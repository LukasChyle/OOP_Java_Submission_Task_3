import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FifteenPuzzle extends JFrame implements ActionListener {

    private final JButton[][] board = new JButton[4][4];
    private final JButton restart = new JButton("Restart");
    private final List<Integer> checkUnique = new ArrayList<>();
    private final String[][] winOrder = {
            {"1", "2", "3", "4"},
            {"5", "6", "7", "8"},
            {"9", "10", "11", "12"},
            {"13", "14", "15", "0"}};
    private final JPanel mainPanel = new JPanel(new GridLayout(4, 4));

    private FifteenPuzzle() {

        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setButtons();
        setPanel();
        setLocationRelativeTo(null);
    }

    private void setPanel() {
        mainPanel.add(board[0][0]);
        mainPanel.add(board[0][1]);
        mainPanel.add(board[0][2]);
        mainPanel.add(board[0][3]);


        mainPanel.add(board[1][0]);
        mainPanel.add(board[1][1]);
        mainPanel.add(board[1][2]);
        mainPanel.add(board[1][3]);


        mainPanel.add(board[2][0]);
        mainPanel.add(board[2][1]);
        mainPanel.add(board[2][2]);
        mainPanel.add(board[2][3]);


        mainPanel.add(board[3][0]);
        mainPanel.add(board[3][1]);
        mainPanel.add(board[3][2]);
        mainPanel.add(board[3][3]);
    }


/*
lägg in reset button i Jframe med Borderlayout.NORTH
lägg in mainPanel i Jframe med borderlayout.SOUTH
lägg in knapparna i mainPanel i rätt ordning.
*/

    private int getRandom() {
        while (true) {
            Random random = new Random();
            int number = random.nextInt(16);

            if (checkNumber(number)) {
                checkUnique.add(number);
                return number;
            }
        }
    }

    private boolean checkNumber(int number){
        for (int i : checkUnique) {
            if (i == number) {
                return false;
            }
        }
        return true;
    }

    private void setButtons() {
        for (int i = 0; i < (board.length); i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new JButton(String.valueOf(getRandom()));
            }
        }
    }

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
