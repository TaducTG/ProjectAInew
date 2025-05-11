package View;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Cal_Dis.Check;
import MachineMoveChoice.ContinuousATK;
import MachineMoveChoice.SelectMove;

import static MachineMoveChoice.SelectMove.*;

public class View extends JFrame implements ActionListener {
    Color background_cl = Color.white;
    Color x_cl = Color.red;
    Color y_cl = Color.blue;
    int column = 18, row = 18, count = 0;
    int  Undo[][] = new int[column+2][row+2];
    boolean tick[][] = new boolean[column + 2][row + 2];
    int Size = 0;
    Container cn;
    JPanel pn, pn2;
    JLabel lb;
    JButton newGame_bt, undo_bt,show_bt;
    JFrame frame;
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

        if(SelectMove.turn %1 == 0){
//            b[7][7].setText("O");
//            b[7][7].setForeground(y_cl);
//            b[7][7].setFont(new Font("Arial", Font.BOLD, 24));
//            tick[7][7] = false;
//            SelectMove.E[7][7] = 2;
            // Đánh dấu các vị trí (7,4), (8,4), (9,4) là O và đánh số 2
            b[7][4].setText("O");
            b[7][4].setForeground(y_cl);  // y_cl là màu sắc cho O
            b[7][4].setFont(new Font("Arial", Font.BOLD, 24));
            tick[7][4] = false;
            SelectMove.E[7][4] = 2;
            b[11][1].setText("O");
            b[11][1].setForeground(y_cl);  // y_cl là màu sắc cho O
            b[11][1].setFont(new Font("Arial", Font.BOLD, 24));
            tick[11][1] = false;
            SelectMove.E[11][1] = 2;

            b[9][2].setText("O");
            b[9][2].setForeground(y_cl);
            b[9][2].setFont(new Font("Arial", Font.BOLD, 24));
            tick[9][2] = false;
            SelectMove.E[9][2] = 2;

            b[10][3].setText("O");
            b[10][3].setForeground(y_cl);
            b[10][3].setFont(new Font("Arial", Font.BOLD, 24));
            tick[10][3] = false;
            SelectMove.E[10][3] = 2;
            b[8][4].setText("O");
            b[8][4].setForeground(y_cl);  // y_cl là màu sắc cho O
            b[8][4].setFont(new Font("Arial", Font.BOLD, 24));
            tick[8][4] = false;
            SelectMove.E[8][4] = 2;

            b[9][4].setText("O");
            b[9][4].setForeground(y_cl);  // y_cl là màu sắc cho O
            b[9][4].setFont(new Font("Arial", Font.BOLD, 24));
            tick[9][4] = false;
            SelectMove.E[9][4] = 2;
//            b[11][5].setText("O");
//            b[11][5].setForeground(y_cl);  // y_cl là màu sắc cho O
//            b[11][5].setFont(new Font("Arial", Font.BOLD, 24));
//            tick[11][5] = false;
//            SelectMove.E[11][5] = 2;
// Đánh dấu các vị trí (6,4), (8,7), (9,7) là X và đánh số 1
            b[6][4].setText("X");
            b[6][4].setForeground(x_cl);  // x_cl là màu sắc cho X (có thể là màu khác với y_cl)
            b[6][4].setFont(new Font("Arial", Font.BOLD, 24));
            tick[6][4] = false;
            SelectMove.E[6][4] = 1;

            b[8][7].setText("X");
            b[8][7].setForeground(x_cl);  // x_cl là màu sắc cho X
            b[8][7].setFont(new Font("Arial", Font.BOLD, 24));
            tick[8][7] = false;
            SelectMove.E[8][7] = 1;

            b[9][7].setText("X");
            b[9][7].setForeground(x_cl);  // x_cl là màu sắc cho X
            b[9][7].setFont(new Font("Arial", Font.BOLD, 24));
            tick[9][7] = false;
            SelectMove.E[9][7] = 1;
            b[11][2].setText("X");
            b[11][2].setForeground(x_cl);  // x_cl là màu sắc cho X
            b[11][2].setFont(new Font("Arial", Font.BOLD, 24));
            tick[11][2] = false;
            SelectMove.E[11][2] = 1;
            b[8][1].setText("X");
            b[8][1].setForeground(x_cl);  // x_cl là màu sắc cho X
            b[8][1].setFont(new Font("Arial", Font.BOLD, 24));
            tick[8][1] = false;
            SelectMove.E[8][1] = 1;

            b[11][5].setText("X");
            b[11][5].setForeground(x_cl);
            b[11][5].setFont(new Font("Arial", Font.BOLD, 24));
            tick[11][5] = false;
            SelectMove.E[11][5] = 1;
            b[11][3].setText("X");
            b[11][3].setForeground(x_cl);  // x_cl là màu sắc cho X
            b[11][3].setFont(new Font("Arial", Font.BOLD, 24));
            tick[11][3] = false;
            SelectMove.E[11][3] = 1;

        }
    }
    public void addPoint(int i, int j) {

        b[locx][locy].setBackground(background_cl);
        if(SelectMove.E[i][j] != 0){ // chống đánh vào ô dã đánh
            return;
        }
        SelectMove.E[i][j] = 1;
        Undo[i][j] = SelectMove.startMove;
        b[i][j].setText("X");

        b[i][j].setForeground(x_cl);
        b[i][j].setFont(new Font("Arial", Font.BOLD, 24));
        tick[i][j] = false;

        if(Check.CheckWin(i,j,E,1)){
            System.out.println("check");
            JFrame frame = new JFrame();
            frame.setSize(300, 150);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null); // Hiển thị giữa màn hình
            frame.setVisible(true);
            // Thêm nhãn thông báo
            JLabel label = new JLabel("You Have Win!", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(label, BorderLayout.CENTER);

            // Tạo panel chứa 2 nút
            JPanel buttonPanel = new JPanel();
            JButton restartButton = new JButton("Restart");
            JButton quitButton = new JButton("Quit");
            restartButton.addActionListener(this);
            quitButton.addActionListener(this);
            buttonPanel.add(restartButton);
            buttonPanel.add(quitButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            for (int k = 0; k < 20; k++) {
                for (int l = 0; l < 20; l++) {
                    SelectMove.E[k][l] = 1;
                }
            }
        }

        lb.setText("Lượt Của O");
        lb.setFont(new Font("Arial", Font.BOLD, 24));
        SelectMove.machineTurn();
        SelectMove.E[locx][locy] = 2;
        Undo[locx][locy] = SelectMove.startMove;
        b[locx][locy].setText("O");
        b[locx][locy].setForeground(y_cl);
        b[locx][locy].setFont(new Font("Arial", Font.BOLD, 24));
        b[locx][locy].setBackground(null);
        tick[locx][locy] = false;
        lb.setText("Lượt Của X");
        if(Check.CheckWin(locx,locy,E,2)){
            System.out.println("check");
            frame = new JFrame();
            frame.setSize(300, 150);
            frame.setLayout(new BorderLayout());
            frame.setLocationRelativeTo(null); // Hiển thị giữa màn hình
            frame.setVisible(true);
            // Thêm nhãn thông báo
            JLabel label = new JLabel("You Have Lose!", SwingConstants.CENTER);
            label.setFont(new Font("Arial", Font.BOLD, 24));
            frame.add(label, BorderLayout.CENTER);

            // Tạo panel chứa 2 nút
            JPanel buttonPanel = new JPanel();
            JButton restartButton = new JButton("Restart");
            restartButton.addActionListener(this);
            JButton quitButton = new JButton("Quit");
            quitButton.addActionListener(this);
            buttonPanel.add(restartButton);

            buttonPanel.add(quitButton);
            frame.add(buttonPanel, BorderLayout.SOUTH);
            for (int k = 0; k < 20; k++) {
                for (int l = 0; l < 20; l++) {
                    SelectMove.E[k][l] = 1;
                }
            }
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "New Game"||   e.getActionCommand() == "Restart") {
            for (int i = 0; i < 23; i++) {
                for (int j = 0; j < 23; j++) {
                    SelectMove.E[i][j] = 0;
                }
            }
            ContinuousATK.ContinuousATK.clear();
            turn +=1;
            startMove = 0;
            if(frame != null){
                frame.setVisible(false);
            }
            new View("GAME DEMO");
            this.dispose();
        }  else if (e.getActionCommand() == "Exit" || e.getActionCommand() == "Quit") {
            System.exit(0);
        }
        else if(e.getActionCommand() == "Undo") {

            if(SelectMove.startMove == 0){
                return;
            }
            for (int i = 0; i < column+2; i++) {
                for (int j = 0; j < row +2; j++) {
                    if(Undo[i][j] == SelectMove.startMove || (Undo[i][j] == SelectMove.startMove - 1 && SelectMove.E[i][j] == 1)){
                        Undo[i][j] = 0;
                        SelectMove.E[i][j] = 0;
                        b[i][j].setText(i + " " + j);
                        b[i][j].setBackground(background_cl);
                        b[i][j].setForeground(Color.lightGray);
                        b[i][j].setFont(new Font("Arial", Font.BOLD, 18));
                        tick[i][j] = true;

                    }
                }
            }
            SelectMove.startMove -= 1;

        }
        else if(e.getActionCommand() == "Show") {
            for (int i = 0; i < column+2; i++) {
                for (int j = 0; j < row +2; j++) {
                    System.out.printf("%6.0f ",SelectMove.map[i][j]);
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
