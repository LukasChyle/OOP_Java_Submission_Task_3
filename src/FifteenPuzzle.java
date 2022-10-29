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
    private  List<Integer> checkUnique;
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
        restart.addActionListener(this);
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

    private boolean checkNumber(int number) {
        for (int i : checkUnique) {
            if (i == number) {
                return false;
            }
        }
        return true;
    }

    private void setButtons() {
        checkUnique = new ArrayList<>();
        for (int i = 0; i < (board.length); i++) {
            for (int j = 0; j < board.length; j++) {
                board[i][j] = new JButton(String.valueOf(getRandom()));
                board[i][j].addActionListener(this);
                if (board[i][j].getText().equals("0")) {
                    setBlankButton(i, j);
                }
            }
        }
    }

    private void setBlankButton(int i, int j) {
        board[i][j].setBackground(new Color(255, 255, 255));
        board[i][j].setText("");
        board[i][j].setBorderPainted(false);
    }

    private boolean checkOrderWin() {
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
newGame:
board = new JButton[4][4];
checkUnique = new int[16];
kalla på setButtons
ta bort markering från knapp (kanske inte behövs)
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

    private void resetColors() {
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

        if (checkOrderWin()) {
            JOptionPane.showMessageDialog(null, "You solved it!");
        }

        if(e.getSource().equals(restart)){
            System.out.println(true);
            setButtons();
        }
    }

    public static void main(String[] args) {
        FifteenPuzzle game = new FifteenPuzzle();
    }

}