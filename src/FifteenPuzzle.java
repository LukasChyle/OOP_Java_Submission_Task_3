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
    private final Color clickColor = new Color(33, 182, 168);

    private FifteenPuzzle() {
        add(mainPanel, BorderLayout.CENTER);
        add(restart, BorderLayout.NORTH);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setButtons();
        setPanel();
        setLocationRelativeTo(null);
        setSize(500, 500);
    }

    private void setPanel() {
        for (JButton[] jButtons : board) {
            for (int j = 0; j < board.length; j++) {
                mainPanel.add(jButtons[j]);
            }
        }
    }


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
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setBackground(new Color(255, 255, 255));
                    board[i][j].addActionListener(this);
                if (board[i][j].getText().equals("0")) {
                    board[i][j].setBackground(Color.white);
                    board[i][j].setText("");
                    board[i][j].setBorderPainted(false);
                }
            }
        }
    }


    private boolean checkOrderWin(List<Integer> checkUnique, String[][] winOrder) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (!board[i][j].getText().equals(winOrder[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

/*
checkOrder:
kontrollera om siffrorna ligger i rätt ordning på knapparna "getText()"
genom att iterera genom knapparna och jämföra mot motsvarande plats på winOrder
om man vunnit gör en pop up ruta med vinst och kalla sen på newGame
/*

/*
newGame:
board = new JButton[4][4];
checkUnique = new int[16];
kalla på setButtons
ta bort markering från knapp (kanske inte behövs)
*/

/*
Listener even:
Markera knappen om den är bredvid "0"
när man klickar på nästa knapp:
- om knappen inte är "0" men också ligger bredvid "0", flytta över markeringen till nya knappen.
- om knappen inte är "0" och inte ligger bredvid "0" släck markeringen på nuvarande.
- om knappen ligger bredvid "0" byt plats på talen(texterna) och släck markering.

Kör checkOrder för att se om pusslet är klart.
------------------
om restart knappen trycks kalla på newGame
*/

    private int[] getPosition(String text) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j].getText().equals(text)) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    private void resetColors(){
        for (JButton[] jButtons : board) {
            for (int j = 0; j < board.length; j++) {
                if (!jButtons[j].getText().equals("")) {
                    jButtons[j].setBackground(null);
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        resetColors();
        int[] blank = getPosition("");
        int[] clicked = getPosition(e.getActionCommand());

        if ((blank[0] == clicked[0] && (blank[1] == (clicked[1] - 1) || blank[1] == (clicked[1] + 1))) ||
        (blank[1] == clicked[1] && (blank[0] == (clicked[0] - 1) || blank[0] == (clicked[0] + 1)))) {
            board[clicked[0]][clicked[1]].setBackground(clickColor);
        }




        if(checkOrderWin(checkUnique, winOrder)){
            JOptionPane.showMessageDialog(null, "You solved it!");
        }
    }

    public static void main(String[] args) {
        FifteenPuzzle game = new FifteenPuzzle();
    }

}
