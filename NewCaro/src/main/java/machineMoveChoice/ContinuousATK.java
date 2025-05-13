package machineMoveChoice;

import static calculateDistance.CalculateDistance.cal;
import static calculateDistance.Check.checkWin;
import static moveSet.Advance.checkSurround;


import moveSet.*;


import java.util.ArrayList;
import java.util.List;



public class ContinuousATK {
    public static List<Point> ContinuousATK = new ArrayList<>();
    public static void FinalATK(Point tmp, int[][] E, int a) {
        int x,y;
        boolean end = false;
        int t1;
        Point pO1 = new Point(0, 0);
        Point pX1 = new Point(0, 0);
        Point pO2 = new Point(0, 0);
        Point pX2 = new Point(0, 0);
        Point pO3 = new Point(0, 0);
        Point pX3 = new Point(0, 0);
        Point pO4 = new Point(0, 0);
        Point pX4 = new Point(0, 0);
        Point pO5 = new Point(0, 0);
        Point pX5 = new Point(0, 0);
        int check = 0;
        int b = 0;
        if(a == 2){
            b = 1;
        }
        int t = checkSurround(tmp,E,2);

        if(t == 5){
            pO1 = tmp;
            x = tmp.getX();
            y = tmp.getY();
            E[x][y] = 2;
            for(int i = x-3; i <=x +3;i++){
                for (int j = y-3; j <=y + 3;j++){
                    if(i >= 0 && j >= 0  && checkWin(i, j, E, 2) && E[i][j] == 0){
                        pX1 = new Point(i,j);
                        //System.out.println("check " + i + " " + j);
                    }
                }
            }
            t1 = checkSurround(pX2,E,1);
            if(t1 != 1 && t1 != 2 && t1 != 3 && t1 != 5){
                check = 1;
                ContinuousATK.add(pO1);
                ContinuousATK.add(pX1);
            }
            E[x][y] = 0;
        }

        if(check == 1){
            E[pX1.getX()][pX1.getY()] = 1;
            E[pO1.getX()][pO1.getY()] = 2;

            for(int i = pO1.getX()-3; i <=pO1.getX() + 3;i++){
                for (int j = pO1.getY()-3; j <=pO1.getY() + 3;j++){
                    Point tmp1 = new Point(i,j);
                    if(i >= 0 && j >= 0  && checkSurround(tmp1,E,2) == 5 && E[i][j] == 0){
                        pO2 = tmp1;
                    }
                    if(i >= 0 && j >= 0  && cal(tmp1,E,2) >= 30000 && E[i][j] == 0){
                        System.out.println(i + " " + j + " " + cal(tmp1,E,2));
                        end = true;
                        pO2 = tmp1;
                    }
                }
            }
            if(end){
                System.out.println("check");
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                ContinuousATK.add(pO2);
                return;
            }
            x = pO2.getX();
            y = pO2.getY();
            if(x == 0 && y == 0){
                ContinuousATK.clear();
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                return;
            }
            E[x][y] = 2;
            for (int i = pO2.getX()-3; i <=pO2.getX() + 3;i++){
                for (int j = pO2.getY()-3; j <=pO2.getY() + 3;j++){
                    if(i >= 0 && j >= 0  && checkWin(i, j, E, 2) && E[i][j] == 0){
                        pX2 = new Point(i,j);
                    }
                }
            }
            t1 = checkSurround(pX2,E,1);
            if(t1 != 1 && t1 != 2 && t1 != 3 && t1 != 5){
                check = 2;
                ContinuousATK.add(pO2);
                ContinuousATK.add(pX2);
            }
            E[x][y] = 0;
            E[pX1.getX()][pX1.getY()] = 0;
            E[pO1.getX()][pO1.getY()] = 0;
        }
        if(check == 2)
        {
            E[pX1.getX()][pX1.getY()] = 1;
            E[pO1.getX()][pO1.getY()] = 2;
            E[pX2.getX()][pX2.getY()] = 1;
            E[pO2.getX()][pO2.getY()] = 2;
            for(int i = pO2.getX()-3; i <=pO2.getX() + 3;i++){
                for (int j = pO2.getY()-3; j <=pO2.getY() + 3;j++){
                    Point tmp1 = new Point(i,j);
                    if(i >= 0 && j >= 0  && checkSurround(tmp1,E,2) == 5 && E[i][j] == 0){
                        pO3 = tmp1;
                    }
                    if(i >= 0 && j >= 0  && cal(tmp1,E,2) >= 30000 && E[i][j] == 0){
                        end = true;
                        pO3 = tmp1;
                    }
                }
            }
            if(end){
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                ContinuousATK.add(pO3);
                return;
            }
            x = pO3.getX();
            y = pO3.getY();
            if(x == 0 && y == 0){
                ContinuousATK.clear();
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                return;
            }
            E[x][y] = 2;
            for (int i = pO3.getX()-3; i <=pO3.getX() + 3;i++){
                for (int j = pO3.getY()-3; j <=pO3.getY() + 3;j++){
                    if(i >= 0 && j >= 0  && checkWin(i, j, E, 2) && E[i][j] == 0){
                        pX3 = new Point(i,j);
                    }
                }
            }
            t1 = checkSurround(pX2,E,1);
            if(t1 != 1 && t1 != 2 && t1 != 3 && t1 != 5){
                check = 3;
                ContinuousATK.add(pO3);
                ContinuousATK.add(pX3);
            }
            E[x][y] = 0;


            E[pX1.getX()][pX1.getY()] = 0;
            E[pO1.getX()][pO1.getY()] = 0;
            E[pX2.getX()][pX2.getY()] = 0;
            E[pO2.getX()][pO2.getY()] = 0;

        }
        if (check == 3){
            E[pX1.getX()][pX1.getY()] = 1;
            E[pO1.getX()][pO1.getY()] = 2;
            E[pX2.getX()][pX2.getY()] = 1;
            E[pO2.getX()][pO2.getY()] = 2;
            E[pX3.getX()][pX3.getY()] = 1;
            E[pO3.getX()][pO3.getY()] = 2;

            for(int i = pO3.getX()-3; i <=pO3.getX() + 3;i++){
                for (int j = pO3.getY()-3; j <=pO3.getY() + 3;j++){
                    Point tmp1 = new Point(i,j);
                    if(i >= 0 && j >= 0  && checkSurround(tmp1,E,2) == 5 && E[i][j] == 0){
                        pO4 = tmp1;
                    }
                    if(i >= 0 && j >= 0  && cal(tmp1,E,2) >= 30000 && E[i][j] == 0){
                        end = true;
                        pO4 = tmp1;
                    }
                }
            }
            if(end){
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                E[pX3.getX()][pX3.getY()] = 0;
                E[pO3.getX()][pO3.getY()] = 0;
                ContinuousATK.add(pO4);
                return;
            }
            x = pO4.getX();
            y = pO4.getY();
            if(x == 0 && y == 0){
                ContinuousATK.clear();
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                E[pX3.getX()][pX3.getY()] = 0;
                E[pO3.getX()][pO3.getY()] = 0;
                return;
            }
            E[x][y] = 2;
            for (int i = pO4.getX()-3; i <=pO4.getX() + 3;i++){
                for (int j = pO4.getY()-3; j <=pO4.getY() + 3;j++){
                    if(i >= 0 && j >= 0  && checkWin(i, j, E, 2) && E[i][j] == 0){
                        pX4 = new Point(i,j);
                    }
                }
            }
            t1 = checkSurround(pX2,E,1);
            if(t1 != 1 && t1 != 2 && t1 != 3 && t1 != 5){
                check = 4;
                ContinuousATK.add(pO4);
                ContinuousATK.add(pX4);
            }
            E[x][y] = 0;
            E[pX1.getX()][pX1.getY()] = 0;
            E[pO1.getX()][pO1.getY()] = 0;
            E[pX2.getX()][pX2.getY()] = 0;
            E[pO2.getX()][pO2.getY()] = 0;
            E[pX3.getX()][pX3.getY()] = 0;
            E[pO3.getX()][pO3.getY()] = 0;

        }
        if(check == 4){
            E[pX1.getX()][pX1.getY()] = 1;
            E[pO1.getX()][pO1.getY()] = 2;
            E[pX2.getX()][pX2.getY()] = 1;
            E[pO2.getX()][pO2.getY()] = 2;
            E[pX3.getX()][pX3.getY()] = 1;
            E[pO3.getX()][pO3.getY()] = 2;
            E[pX4.getX()][pX4.getY()] = 1;
            E[pO4.getX()][pO4.getY()] = 2;

            for(int i = pO4.getX()-3; i <=pO4.getX() + 3;i++){
                for (int j = pO4.getY()-3; j <=pO4.getY() + 3;j++){
                    Point tmp1 = new Point(i,j);
                    if(i >= 0 && j >= 0  && checkSurround(tmp1,E,2) == 5 && E[i][j] == 0){
                        pO5 = tmp1;
                    }
                    if(i >= 0 && j >= 0  && cal(tmp1,E,2) >= 30000 && E[i][j] == 0){
                        end = true;
                        pO5 = tmp1;
                    }
                }
            }
            if(end){
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                E[pX3.getX()][pX3.getY()] = 0;
                E[pO3.getX()][pO3.getY()] = 0;
                E[pX4.getX()][pX4.getY()] = 0;
                E[pO4.getX()][pO4.getY()] = 0;
                ContinuousATK.add(pO5);
                return;
            }
            x = pO5.getX();
            y = pO5.getY();
            if(x == 0 && y == 0){
                ContinuousATK.clear();
                E[pX1.getX()][pX1.getY()] = 0;
                E[pO1.getX()][pO1.getY()] = 0;
                E[pX2.getX()][pX2.getY()] = 0;
                E[pO2.getX()][pO2.getY()] = 0;
                E[pX3.getX()][pX3.getY()] = 0;
                E[pO3.getX()][pO3.getY()] = 0;
                E[pX4.getX()][pX4.getY()] = 0;
                E[pO4.getX()][pO4.getY()] = 0;
                return;
            }
            E[x][y] = 2;
            for (int i = pO5.getX()-3; i <=pO5.getX() + 3;i++){
                for (int j = pO5.getY()-3; j <=pO5.getY() + 3;j++){
                    if(i >= 0 && j >= 0  && checkWin(i, j, E, 2) && E[i][j] == 0){
                        pX5 = new Point(i,j);
                    }
                }
            }
            t1 = checkSurround(pX2,E,1);
            if(t1 != 1 && t1 != 2 && t1 != 3 && t1 != 5){
                check = 5;
                ContinuousATK.add(pO5);
                //ContinuousATK.add(pX5);
            }
            E[x][y] = 0;
            E[pX1.getX()][pX1.getY()] = 0;
            E[pO1.getX()][pO1.getY()] = 0;
            E[pX2.getX()][pX2.getY()] = 0;
            E[pO2.getX()][pO2.getY()] = 0;
            E[pX3.getX()][pX3.getY()] = 0;
            E[pO3.getX()][pO3.getY()] = 0;
            E[pX4.getX()][pX4.getY()] = 0;
            E[pO4.getX()][pO4.getY()] = 0;
        }


        ContinuousATK.clear();
        return;
    }
}

