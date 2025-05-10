package MachineMoveChoice;

import MoveSet.Advance;
import MoveSet.Point;

import java.util.ArrayList;
import java.util.Vector;

import static MoveSet.Advance.CheckSurround;

public class ContinuousATK {
    public static void FinalATK(Point tmp, int[][] E, int a) {
        int x = tmp.getX();
        int y = tmp.getY();
        Point pO,pX;

        int b = 0;
        if(a == 2){
            b = 1;
        }
        if(CheckSurround(tmp,E,1) == 6){

        }


    }
}
