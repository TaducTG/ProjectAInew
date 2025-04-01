package MoveSet;

public class ATKMove {

    // Method to check the surrounding cells
    public static int surround(Point tmp, int[][] E) {
        int x = tmp.x;
        int y = tmp.y;
        int countO = 0;
        int countX = 0;
        if(x < 1 || y < 1){
            return 0;
        }
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if (E[i][j] == 2) {
                    countO += 1;
                }
                if (E[i][j] == 1) {
                    countX += 1;
                }
            }
        }
        if(countX + countO > 5){
            return 0;
        }
        if(countO >= 3){
            return 1;
        }
        return countO;
    }

    // Method to determine if an attack is necessary on a given point
    public static int necessaryATK(Point tmp, int[][] E) {
        int x = tmp.x;
        int y = tmp.y;
        int count = surround(tmp, E);
        if(count == 0){
            return 0;
        }
        if(count == 1){
            return 1;
        }
        if(count >= 2){
            if (x >= 4 && E[x - 4][y] == 1 && E[x - 3][y] == 2 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && count <= 2) {
                return 0;
            }
            if (x >= 3 && E[x - 3][y] == 1 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && count <= 3) {
                return 0;
            }
            if (x >= 3 && E[x - 3][y] == 2 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && E[x + 1][y] == 1 && count <= 3) {
                return 0;
            }
            if (x >= 2 && E[x - 2][y] == 1 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && E[x + 2][y] == 2 && count <= 3) {
                return 0;
            }
            if (x >= 2 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && E[x + 2][y] == 1 && count <= 3) {
                return 0;
            }
            if (x >= 1 && E[x - 1][y] == 1 && E[x + 1][y] == 2 && E[x + 2][y] == 2 && E[x + 3][y] == 2 && count <= 3) {
                return 0;
            }
            if (x >= 1 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && E[x + 2][y] == 2 && E[x + 3][y] == 1 && count <= 3) {
                return 0;
            }
            if (E[x + 1][y] == 2 && E[x + 2][y] == 2 && E[x + 3][y] == 2 && E[x + 4][y] == 1 && count <= 2) {
                return 0;
            }
            if (y >= 4 && E[x][y - 4] == 1 && E[x][y - 3] == 2 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && count <= 2) {
                return 0;
            }
            if (y >= 3 && E[x][y - 3] == 1 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && count <= 3) {
                return 0;
            }
            if (y >= 3 && E[x][y - 3] == 2 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && E[x][y + 1] == 1 && count <= 3) {
                return 0;
            }
            if (y >= 2 && E[x][y - 2] == 1 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && E[x][y + 2] == 2 && count <= 3) {
                return 0;
            }
            if (y >= 2 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && E[x][y + 2] == 1 && count <= 3) {
                return 0;
            }
            if (y >= 1 && E[x][y - 1] == 1 && E[x][y + 1] == 2 && E[x][y + 2] == 2 && E[x][y + 3] == 2 && count <= 3) {
                return 0;
            }
            if (y >= 1 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && E[x][y + 2] == 2 && E[x][y + 3] == 1 && count <= 3) {
                return 0;
            }
            if (E[x][y + 1] == 2 && E[x][y + 2] == 2 && E[x][y + 3] == 2 && E[x][y + 4] == 1 && count <= 2) {
                return 0;
            }
            return 1;
        }
        return 1;
    }

    // Method to calculate the attack alert level based on the surrounding points
    public static double PrepATK(Point tmp, int[][] E) {
        int x = tmp.x;
        int y = tmp.y;
        double alert = 0;

        if (x >= 2 && E[x - 1][y] == 2 && E[x - 2][y] != 1) {
            if (x >= 3 && E[x - 3][y] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (E[x + 1][y] == 2 && E[x + 2][y] != 1) {
            if (E[x + 3][y] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (y >= 2 && E[x][y - 1] == 2 && E[x][y - 2] != 1) {
            if (y >= 3 && E[x][y - 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (E[x][y + 1] == 2 && E[x][y + 2] != 1) {
            if (E[x][y + 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }

        if (y >= 2 && x >= 2 && E[x - 1][y - 1] == 2 && E[x - 2][y - 2] != 1) {
            if (y >= 3 && x >= 3 && E[x - 3][y - 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (E[x + 1][y + 1] == 2 && E[x + 2][y + 2] != 1) {
            if (E[x + 3][y + 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (x >= 2 && E[x - 1][y + 1] == 2 && E[x - 2][y + 2] != 1) {
            if (x >= 3 && E[x - 3][y + 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }
        if (y >= 2 && E[x + 1][y - 1] == 2 && E[x + 2][y - 2] != 1) {
            if (y >= 3 && E[x + 3][y - 3] != 1) {
                alert += 0.5;
            }
            alert += 0.75;
        }

        double minus_alert = 0;
        if (x >= 2 && E[x - 1][y] == 2 && E[x - 2][y] == 1) {
            minus_alert += 0.55;
        }
        if (E[x + 1][y] == 2 && E[x + 2][y] == 1) {
            minus_alert += 0.55;
        }
        if (y >= 2 && E[x][y - 1] == 2 && E[x][y - 2] == 1) {
            minus_alert += 0.55;
        }
        if (E[x][y + 1] == 2 && E[x][y + 2] == 1) {
            minus_alert += 0.55;
        }

        if (x >= 2 && y >= 2 && E[x - 1][y - 1] == 2 && E[x - 2][y - 2] == 1) {
            minus_alert += 0.55;
        }
        if (E[x + 1][y + 1] == 2 && E[x + 2][y + 2] == 1) {
            minus_alert += 0.55;
        }
        if (x >= 2 && E[x - 1][y + 1] == 2 && E[x - 2][y + 2] == 1) {
            minus_alert += 0.55;
        }
        if (y >= 2 && E[x + 1][y - 1] == 2 && E[x + 2][y - 2] == 1) {
            minus_alert += 0.55;
        }

        for (int i = x - 1; i < x + 2 && i >= 0; i++) {
            for (int j = y - 1; j < y + 2 && j >= 0; j++) {
                if (E[i][j] == 1) {
                    minus_alert += 0.55;
                }
            }
        }

        if (alert - minus_alert >= 2.5) {
            return alert - minus_alert;
        }
        return 0;
    }
    // Function to check for a potential win if there are 3 consecutive points not blocked at both ends
    public static int AbsoluteWin(Point tmp, int[][] E) {
        int x = tmp.x;
        int y = tmp.y;
        int absoluteWin = 0;

        // Check horizontal lines
        if (x >= 4 && E[x - 4][y] == 0 && E[x - 3][y] == 2 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && E[x + 1][y] == 0) {
            absoluteWin = 1;
        }
        if (x >= 3 && E[x - 3][y] == 0 && E[x - 2][y] == 2 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && E[x + 2][y] == 0) {
            absoluteWin = 1;
        }
        if (x >= 2 && E[x - 2][y] == 0 && E[x - 1][y] == 2 && E[x + 1][y] == 2 && E[x + 2][y] == 2 && E[x + 3][y] == 0) {
            absoluteWin = 1;
        }
        if (x >= 1 && E[x - 1][y] == 0 && E[x + 1][y] == 2 && E[x + 2][y] == 2 && E[x + 3][y] == 2 && E[x + 4][y] == 0) {
            absoluteWin = 1;
        }

        // Check vertical lines
        if (y >= 1 && E[x][y - 1] == 0 && E[x][y + 1] == 2 && E[x][y + 2] == 2 && E[x][y + 3] == 2 && E[x][y + 4] == 0) {
            absoluteWin = 1;
        }
        if (y >= 4 && E[x][y - 4] == 0 && E[x][y - 3] == 2 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && E[x][y + 1] == 0) {
            absoluteWin = 1;
        }
        if (y >= 3 && E[x][y - 3] == 0 && E[x][y - 2] == 2 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && E[x][y + 2] == 0) {
            absoluteWin = 1;
        }
        if (y >= 2 && E[x][y - 2] == 0 && E[x][y - 1] == 2 && E[x][y + 1] == 2 && E[x][y + 2] == 2 && E[x][y + 3] == 0) {
            absoluteWin = 1;
        }

        // Check diagonal lines (top-left to bottom-right)
        if (x >= 4 && y >= 4 && E[x - 4][y - 4] == 0 && E[x - 3][y - 3] == 2 && E[x - 2][y - 2] == 2 && E[x - 1][y - 1] == 2 && E[x + 1][y + 1] == 0) {
            absoluteWin = 1;
        }
        if (x >= 3 && y >= 3 && E[x - 3][y - 3] == 0 && E[x - 2][y - 2] == 2 && E[x - 1][y - 1] == 2 && E[x + 1][y + 1] == 2 && E[x + 2][y + 2] == 0) {
            absoluteWin = 1;
        }
        if (x >= 2 && y >= 2 && E[x - 2][y - 2] == 0 && E[x - 1][y - 1] == 2 && E[x + 1][y + 1] == 2 && E[x + 2][y + 2] == 2 && E[x + 3][y + 3] == 0) {
            absoluteWin = 1;
        }
        if (x >= 1 && y >= 1 && E[x - 1][y - 1] == 0 && E[x + 1][y + 1] == 2 && E[x + 2][y + 2] == 2 && E[x + 3][y + 3] == 2 && E[x + 4][y + 4] == 0) {
            absoluteWin = 1;
        }

        // Check diagonal lines (top-right to bottom-left)
        if (x >= 4 && y >= 1 && E[x + 1][y - 1] == 0 && E[x - 1][y + 1] == 2 && E[x - 2][y + 2] == 2 && E[x - 3][y + 3] == 2 && E[x - 4][y + 4] == 0) {
            absoluteWin = 1;
        }
        if (x >= 1 && y >= 4 && E[x + 4][y - 4] == 0 && E[x + 3][y - 3] == 2 && E[x + 2][y - 2] == 2 && E[x + 1][y - 1] == 2 && E[x - 1][y + 1] == 0) {
            absoluteWin = 1;
        }
        if (x >= 2 && y >= 3 && E[x + 3][y - 3] == 0 && E[x + 2][y - 2] == 2 && E[x + 1][y - 1] == 2 && E[x - 1][y + 1] == 2 && E[x - 2][y + 2] == 0) {
            absoluteWin = 1;
        }
        if (x >= 2 && y >= 3 && E[x + 2][y - 2] == 0 && E[x + 1][y - 1] == 2 && E[x - 1][y + 1] == 2 && E[x - 2][y + 2] == 2 && E[x - 3][y + 3] == 0) {
            absoluteWin = 1;
        }

        return absoluteWin;
    }
    public static int PushATK(Point tmp, int[][] E){
        // Cần thêm các nước 4 dạng XO_OO_
        // Cần thêm các nước 4 dạng X000__
        int x = tmp.x;
        int y = tmp.y;
        int count = 0;
        // ham 3 + 4
        //ham 4
        //hang ngang
        if(x >= 4 && E[x-4][y] == 1 && E[x-3][y] == 2 && E[x-2][y] == 2 && E[x-1][y]==2 && E[x+1][y] == 0){
            count +=1;
        }
        if(x >= 4 && E[x-4][y] == 0 && E[x-3][y] == 2 && E[x-2][y] == 2 && E[x-1][y]==2 && E[x+1][y] == 1){
            count +=1;
        }
        if(x >= 3 && E[x-3][y] == 0 && E[x-2][y] == 2 && E[x-1][y]== 2 && E[x+1][y] == 2 && E[x+2][y] == 1){
            count +=1;
        }
        if(x >= 3 && E[x-3][y] == 1 && E[x-2][y] == 2 && E[x-1][y]==2  && E[x+1][y] == 2 && E[x+2][y] == 0){
            count +=1;
        }

        if(x >= 2 && E[x-2][y] == 1 && E[x-1][y] == 2 && E[x+1][y] == 2 && E[x+2][y]==2 && E[x+3][y] == 0){
            count +=1;
        }
        if(x >= 2 && E[x-2][y] == 0 && E[x-1][y] == 2 && E[x+1][y] == 2 && E[x+2][y]==2 && E[x+3][y] == 1){
            count +=1;
        }
        if(x >= 1 && E[x-1][y] == 0 && E[x+1][y] == 2 && E[x+2][y]==2 && E[x+3][y] == 2 && E[x+4][y] == 1){
            count +=1;
        }
        if(x >= 1 && E[x-1][y] == 1 && E[x+1][y] == 2 && E[x+2][y]== 2 && E[x+3][y] == 2 && E[x+4][y] == 0){
            count +=1;
        }
        //hang doc
        if(y >= 4 && E[x][y-4] == 1 && E[x][y-3] == 2 && E[x][y-2] == 2 && E[x][y-1]== 2 && E[x][y+1] == 0){
            count +=1;
        }
        if(y >= 4 && E[x][y-4] == 0 && E[x][y-3] == 2 && E[x][y-2] == 2 && E[x][y-1]== 2 && E[x][y+1] == 1){
            count +=1;
        }
        if(y >= 3 && E[x][y-3] == 0 && E[x][y-2] == 2 && E[x][y-1]==2 && E[x][y+1] == 2 && E[x][y+2] == 1){
            count +=1;
        }
        if(y >= 3 && E[x][y-3] == 1 && E[x][y-2] == 2 && E[x][y-1]==2 && E[x][y+1] == 2 && E[x][y+2] == 0){
            count +=1;
        }

        if(y >= 2 && E[x][y-2] == 1 && E[x][y-1] == 2 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 0){
            count +=1;
        }
        if(y >= 2 && E[x][y-2] == 0 && E[x][y-1] == 2 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 1){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 2 && E[x][y+4] == 1){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 2 && E[x][y+4] == 0){
            count +=1;
        }

        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 2 && E[x][y+2]== 0 && E[x][y+3] == 2 && E[x][y+4] ==  2 && E[x][y+5] == 1){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 2 && E[x][y+2]== 0 && E[x][y+3] == 2 && E[x][y+4] ==  2 && E[x][y+5] == 2){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 0 && E[x][y+4] ==  2 && E[x][y+5] == 1){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 0 && E[x][y+4] ==  2 && E[x][y+5] == 2){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 2 && E[x][y+4] ==  0 && E[x][y+5] == 1){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 2 && E[x][y+2]== 2 && E[x][y+3] == 2 && E[x][y+4] ==  0 && E[x][y+5] == 2){
            count +=1;
        }
        //cheo chinh
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 1 && E[x-3][y-3] == 2 && E[x-2][y-2] == 2 && E[x-1][y-1] == 2 && E[x+1][y+1] == 0){
            count +=1;
        }
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 0 && E[x-3][y-3] == 2 && E[x-2][y-2] == 2 && E[x-1][y-1] == 2 && E[x+1][y+1] == 1){
            count +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 0 && E[x-2][y-2] == 2 && E[x-1][y-1] == 2 && E[x+1][y+1] == 2 && E[x+2][y+2] == 1){
            count +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 1 && E[x-2][y-2] == 2 && E[x-1][y-1] ==2 && E[x+1][y+1] == 2 && E[x+2][y+2] == 0){
            count +=1;
        }

        if(x >= 2 && y >= 2 && E[x-2][y-2] == 1 && E[x-1][y-1] == 2 && E[x+1][y+1] == 2 && E[x+2][y+2]== 2 && E[x+3][y+3] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 0 && E[x-1][y-1] == 2 && E[x+1][y+1] == 2 && E[x+2][y+2]== 2 && E[x+3][y+3] == 1){
            count +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 2 && E[x+2][y+2]== 2 && E[x+3][y+3] == 2 && E[x+4][y+4] == 1){
            count +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 2 && E[x+2][y+2]== 2 && E[x+3][y+3] == 2 && E[x+4][y+4] == 0){
            count +=1;
        }
        //cheo phu
        if(x >= 4 && y >= 1 && E[x-4][y+4] == 1 && E[x-3][y+3] == 2 && E[x-2][y+2] == 2 && E[x-1][y+1] == 2 && E[x+1][y-1] == 0){
            count +=1;
        }
        if(x >= 4 && y >= 1 && E[x-4][y+4] == 0 && E[x-3][y+3] == 2 && E[x-2][y+2] == 2 && E[x-1][y+1] == 2 && E[x+1][y-1] == 1){
            count +=1;
        }
        if(x >= 3 && y >= 2 && E[x-3][y+3] == 0 && E[x-2][y+2] == 2 && E[x-1][y+1] == 2 && E[x+1][y-1] == 2 && E[x+2][y-2] == 1){
            count +=1;
        }
        if(x >= 3 && y >= 2 && E[x-3][y+3] == 1 && E[x-2][y+2] == 2 && E[x-1][y+1] == 2 && E[x+1][y-1] == 2 && E[x+2][y-2] == 0){
            count +=1;
        }

        if(x >= 2 && y >= 3 && E[x-2][y+2] == 1 && E[x-1][y+1] == 2 && E[x+1][y-1] == 2 && E[x+2][y-2]== 2 && E[x+3][y-3] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 3 && E[x-2][y+2] == 0 && E[x-1][y+1] == 2 && E[x+1][y-1] == 2 && E[x+2][y-2]== 2 && E[x+3][y-3] == 1){
            count +=1;
        }
        if(x >= 1 && y >= 4 && E[x-1][y+1] == 0 && E[x+1][y-1] == 2 && E[x+2][y-2]==2 && E[x+3][y-3] == 2 && E[x+4][y-4] == 1){
            count +=1;
        }
        if(x >= 1 && y >= 4 && E[x-1][y+1] == 1 && E[x+1][y-1] == 2 && E[x+2][y-2]==2 && E[x+3][y-3] == 2 && E[x+4][y-4] == 0){
            count +=1;
        }
        // Nước 3
        if(x >= 3 && E[x-3][y] == 0 && E[x-2][y] == 2 && E[x-1][y]==2 && E[x+1][y] == 0){
            count +=1;
        }
        if(x >= 2 && E[x-2][y] == 0 && E[x-1][y] == 2 && E[x+1][y]==2 && E[x+2][y] == 0){
            count +=1;
        }
        if(x >= 1 && E[x-1][y] == 0 && E[x+1][y] == 2 && E[x+2][y]==2 && E[x+3][y] == 0){
            count +=1;
        }
        if(y >= 3 && E[x][y-3] == 0 && E[x][y-2] == 2 && E[x][y-1]==2 && E[x][y+1] == 0){
            count +=1;
        }
        if(y >= 2 && E[x][y-2] == 0 && E[x][y-1] == 2 && E[x][y+1]==2 && E[x][y+2] == 0){
            count +=1;
        }
        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 2 && E[x][y+2]==2 && E[x][y+3] == 0){
            count +=1;
        }

        if(x >= 3 && y >= 3 && E[x-3][y-3] == 0 && E[x-2][y-2] == 2 && E[x-1][y-1]==2 && E[x+1][y+1] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 0 && E[x-1][y-1] == 2 && E[x+1][y+1]==2 && E[x+2][y+2] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 2 && E[x+2][y+2]==2 && E[x+3][y+3] == 0){
            count +=1;
        }

        if(x >= 3 && y >= 1 && E[x-3][y+3] == 0 && E[x-2][y+2] == 2 && E[x-1][y+1]==2 && E[x+1][y-1] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y+2] == 0 && E[x-1][y+1] == 2 && E[x+1][y-1]==2 && E[x+2][y-2] == 0){
            count +=1;
        }

        if(x >= 1 && y >= 3 && E[x-1][y+1] == 0 && E[x+1][y-1] == 2 && E[x+2][y-2]==2 && E[x+3][y-3] == 0){
            count +=1;
        }
        if(count >=2){
            return 1;
        }
        else{
            return 0;
        }
    }
}
