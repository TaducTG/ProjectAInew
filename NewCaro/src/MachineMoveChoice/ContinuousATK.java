package MachineMoveChoice;

import MoveSet.*;


import java.util.ArrayList;
import java.util.List;

import static Cal_Dis.Check.CheckWin;
import static MoveSet.Advance.CheckSurround;

public class ContinuousATK {
    public static List<Point> ContinuousATK = new ArrayList<>();
    public static void FinalATK(Point tmp, int[][] E, int a) {
        int x,y;
        Point pO1 = new Point(0, 0);
        Point pX1 = new Point(0, 0);
        Point pO2 = new Point(0, 0);
        Point pX2 = new Point(0, 0);
        Point pO3 = new Point(0, 0);
        Point pX3 = new Point(0, 0);
        int check = 0;
        int b = 0;
        if(a == 2){
            b = 1;
        }
        int t = CheckSurround(tmp,E,2);

        if(t == 5){
            pO1 = tmp;
            x = tmp.getX();
            y = tmp.getY();
            E[x][y] = 2;
            for(int i = x-3; i <=x +3;i++){
                for (int j = y-3; j <=y + 3;j++){
                    if(i >= 0 && j >= 0  && CheckWin(i, j, E, 2)){
                        pX1 = new Point(i,j);
                        //System.out.println("check " + i + " " + j);
                    }
                }
            }
            if(CheckSurround(pX1,E,1) == 0){
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
                    if(i >= 0 && j >= 0  && CheckSurround(tmp1,E,2) == 5){
                        pO2 = tmp1;
                    }
                }
            }
            x = pO2.getX();
            y = pO2.getY();
            E[x][y] = 2;
            for (int i = pO2.getX()-3; i <=pO2.getX() + 3;i++){
                for (int j = pO2.getY()-3; j <=pO2.getY() + 3;j++){
                    if(i >= 0 && j >= 0  && CheckWin(i, j, E, 2)){
                        pX2 = new Point(i,j);
                    }
                }
            }
            if(CheckSurround(pX2,E,1) == 0){
                check = 2;
            }
            E[x][y] = 0;
            E[pX1.getX()][pX1.getY()] = 0;
            E[pO1.getX()][pO1.getY()] = 0;
        }
        if(check == 2)
        {
            ContinuousATK.add(pO2);
            ContinuousATK.add(pX2);
            //System.out.println("check");
            return;
        }



        ContinuousATK.clear();
        return;
    }
}
