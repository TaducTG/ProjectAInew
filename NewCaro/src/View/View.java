package View;
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Test.*;

import static Test.Main.locx;
import static Test.Main.locy;

public class View extends JFrame implements ActionListener {
    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color y_cl = Color.blue;
    int column = 15, row = 15, count = 0;
    int xUndo[] = new int[column * row];
    int yUndo[] = new int[column * row];
    boolean tick[][] = new boolean[column + 2][row + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb;
    JButton newGame_bt, undo_bt;
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
                b[i][j].addActionListener(this);
                tick[i][j] = true;
            }
        for (int i = 0; i <= column; i++)
            for (int j = 0; j <= row; j++)
                pn.add(b[i][j]);
        lb = new JLabel("X Đánh Trước");
        newGame_bt = new JButton("New Game");
        undo_bt = new JButton("Undo");
        newGame_bt.addActionListener(this);
        undo_bt.addActionListener(this);
        cn.add(pn);
        pn2 = new JPanel();
        pn2.setLayout(new FlowLayout());
        pn2.add(lb);
        pn2.add(newGame_bt);
        pn2.add(undo_bt);
        cn.add(pn2, "North");
        this.setVisible(true);
        this.setSize(1400, 1000);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        undo_bt.setEnabled(false);
        if(Main.turn %2 == 1){
            b[7][7].setText("O");
            b[7][7].setForeground(y_cl);
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
        b[i][j].setText("X");
        b[i][j].setForeground(x_cl);
        tick[i][j] = false;
        lb.setText("Lượt Của O");
        Main.machineTurn();
        Main.E[locx][locy] = 2;
        b[locx][locy].setText("O");
        b[locx][locy].setForeground(y_cl);
        b[locx][locy].setBackground(null);
        tick[locx][locy] = false;


//        Main.Mark(locx, locy,2);
//        for(int i1 = 0; i1 <= column; i1++) {
//            for (int j1 = 0; j1 <= row; j1++) {
//                if (Main.E[i1][j1] == 2) {
//                    b[i1][j1].setText("O");
//                    b[i1][j1].setForeground(y_cl);
//                    tick[i1][j1] = false;
//                }
//            }
//        }
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
            Main.turn += 1;
            new View("GAME DEMO");
            this.dispose();
        } else if (e.getActionCommand() == "Exit") {
            System.exit(0);
            ;
        } else {
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
