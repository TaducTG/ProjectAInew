package View;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Test.*;

import static Test.Main.*;

public class View extends JFrame implements ActionListener {
    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color y_cl = Color.blue;
    int column = 15, row = 15, count = 0;
    int  Undo[][] = new int[column+2][row+2];
    boolean tick[][] = new boolean[column + 2][row + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb;
    JButton newGame_bt, undo_bt,show_bt;
    private JButton b[][] = new JButton[column + 2][row + 2];

    public View(String gameDemo) {

        cn = this.getContentPane();
        pn = new JPanel();
        pn.setLayout(new GridLayout(column+1, row+1));
        for (int i = 0; i <= column + 1; i++)
            for (int j = 0; j <= row + 1; j++) {
                b[i][j] = new JButton(i +" " + j);
                b[i][j].setActionCommand(i + " " + j);
                b[i][j].setBackground(background_cl);
                b[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                b[i][j].setForeground(Color.lightGray);
                b[i][j].addActionListener(this);
                tick[i][j] = true;
            }
        for (int i = 0; i <= column; i++)
            for (int j = 0; j <= row; j++)
                pn.add(b[i][j]);
        lb = new JLabel("X Đánh Trước");
        lb.setFont(new Font("Arial", Font.BOLD, 24));
        newGame_bt = new JButton("New Game");
        undo_bt = new JButton("Undo");
        show_bt = new JButton("Show");
        newGame_bt.addActionListener(this);
        undo_bt.addActionListener(this);
        show_bt.addActionListener(this);
        cn.add(pn);
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(lb);
        pn2.add(newGame_bt);
        pn2.add(undo_bt);
        pn2.add(show_bt);
        cn.add(pn2, "North");
        this.setVisible(true);
        this.setSize(1400, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        undo_bt.setEnabled(true);

        if(Main.turn %1 == 0){
            b[7][7].setText("O");
            b[7][7].setForeground(y_cl);
            b[7][7].setFont(new Font("Arial", Font.BOLD, 24));
            tick[7][7] = false;
            Main.E[7][7] = 2;
        }
    }
    public void addPoint(int i, int j) {

        b[locx][locy].setBackground(background_cl);
        if(Main.E[i][j] != 0){ // chống đánh vào ô dã đánh
            return;
        }
        Main.E[i][j] = 1;
        Undo[i][j] = Main.startMove;
        b[i][j].setText("X");

        b[i][j].setForeground(x_cl);
        b[i][j].setFont(new Font("Arial", Font.BOLD, 24));
        tick[i][j] = false;
        lb.setText("Lượt Của O");
        lb.setFont(new Font("Arial", Font.BOLD, 24));
        Main.machineTurn();
        Main.E[locx][locy] = 2;
        Undo[locx][locy] = Main.startMove;
        b[locx][locy].setText("O");
        b[locx][locy].setForeground(y_cl);
        b[locx][locy].setFont(new Font("Arial", Font.BOLD, 24));
        b[locx][locy].setBackground(null);
        tick[locx][locy] = false;
        lb.setText("Lượt Của X");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New Game") {
            for (int i = 0; i < 20; i++) {
                for (int j = 0; j < 20; j++) {
                    Main.E[i][j] = 0;
                }
            }
            Main.startMove = 0;
            new View("GAME DEMO");
            this.dispose();
        } else if (e.getActionCommand() == "Exit") {
            System.exit(0);
        }
        else if(e.getActionCommand() == "Undo") {

            if(Main.startMove == 0){
                return;
            }
            for (int i = 0; i < column+2; i++) {
                for (int j = 0; j < row +2; j++) {
                    if(Undo[i][j] == Main.startMove || (Undo[i][j] == Main.startMove - 1 && Main.E[i][j] == 1)){
                        Undo[i][j] = 0;
                        Main.E[i][j] = 0;
                        b[i][j].setText(i + " " + j);
                        b[i][j].setBackground(background_cl);
                        b[i][j].setForeground(Color.lightGray);
                        b[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                        tick[i][j] = true;

                    }
                }
            }
            Main.startMove -= 1;

        }
        else if(e.getActionCommand() == "Show") {
            for (int i = 0; i < column+2; i++) {
                for (int j = 0; j < row +2; j++) {
                    System.out.printf("%6.0f ",Main.map[i][j]);
                }
                System.out.println();
            }
        }
        else {
            String s = e.getActionCommand();
            int k = s.indexOf(32); // lấy vị trí ký tự cách
            int i = Integer.parseInt(s.substring(0, k)); // lấy số đầu tiên trước cách
            int j = Integer.parseInt(s.substring(k + 1, s.length())); // lấy số sau cách
            if (tick[i][j]) {
                addPoint(i, j);
            }
        }
    }
}
