package machineMoveChoice;

import static moveSet.Advance.checkSurround;

import moveSet.Point;
public class ContinuousATK {
    public static void FinalATK(Point tmp, int[][] E, int a) {
        int x = tmp.getX();
        int y = tmp.getY();
        Point pO,pX;

        int b = 0;
        if(a == 2){
            b = 1;
        }
        if(checkSurround(tmp,E,1) == 6){

        }


    }
}
