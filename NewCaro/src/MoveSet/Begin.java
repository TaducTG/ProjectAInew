package MoveSet;

import Test.Main;

public class Begin {
    public static int firstLoc_x = 0;
    public static int firstLoc_y = 0;
    public Point BeginMove(){
        Point tmp = new Point(0,0,0,0);
        double branch = 0.0;
        if(Main.startMove == 1 && Main.E[7][7] == 2){
            firstLoc_x = 7;
            firstLoc_y = 7;
            branch = 1.1;
            Point a = new Point();
        }
        return tmp;
    }
}
