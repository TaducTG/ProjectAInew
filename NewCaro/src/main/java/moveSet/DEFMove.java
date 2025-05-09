package moveSet;

public class DEFMove {
    public static int checkSurround(Point tmp, int[][] E){
        int x = tmp.x;
        int y = tmp.y;
        int alert = 0;
        if(x >= 3 && E[x-1][y] == 1 && E[x-2][y] != 2 && E[x-3][y] != 2){
            alert +=1;
        }
        if(E[x+1][y] == 1 && E[x+2][y] != 2 && E[x+3][y] != 2){
            alert +=1;
        }
        if(y >= 3 && E[x][y-1] == 1 && E[x][y-2] != 2 && E[x][y-3] != 2){
            alert +=1;
        }
        if(E[x][y+1] == 1 && E[x][y+2] != 2&& E[x][y+3] != 2){
            alert +=1;
        }

        if(x >= 3 && y >= 3 && E[x-1][y-1] == 1 && E[x-2][y-2] != 2&& E[x-3][y-3] != 2){
            alert +=1;
        }
        if(E[x+1][y+1] == 1 && E[x+2][y+2] != 2 && E[x+3][y+3] != 2){
            alert +=1;
        }
        if(x >= 3 && E[x-1][y+1] == 1 && E[x-2][y+2] != 2 && E[x-3][y+3] != 2){
            alert +=1;
        }
        if(y >= 3 && E[x+1][y-1] == 1 && E[x+2][y-2] != 2 && E[x+3][y-3] != 2){
            alert +=1;
        }

        if(alert >= 3){
            return 1;
        }
        return 0;
    }
    public static int preventATK(Point tmp, int[][] E){
        int x = tmp.x;
        int y = tmp.y;
        int count = 0; //  đếm số nước 3 liên tiếp có thể tạo ra dược tại x,y
        int count3 = 0;//  đếm số nước 3 đang bị chặn 1 đầu
        int count2 = 0; // đếm số nước 3 hiện đang có

        // phòng thủ 3 quân liên tiếp chưa bị chặn
        if(x >= 2 && E[x+1][y] == 1 && E[x+2][y] == 1 &&E[x+3][y] == 0 &&E[x-1][y] == 1 && E[x-2][y] == 0){
            count2 += 1;
        }
        if(x >= 3 && E[x+1][y] == 1 && E[x+2][y] == 0 &&E[x-1][y] == 1 && E[x-2][y] == 1 && E[x-3][y]==0){
            count2 += 1;
        }
        if(y >= 2 && E[x][y+1] == 1 && E[x][y+2] == 1 &&E[x][y+3] == 0 &&E[x][y-1] == 1 && E[x][y-2] == 0){
            count2 += 1;
        }
        if(y >= 3 && E[x][y+1] == 1 && E[x][y+2] == 0 &&E[x][y-1] == 1 && E[x][y-2] == 1 && E[x][y-3]==0){
            count2 += 1;
        }
        if(x >= 2 && y >= 2 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 &&E[x+3][y+3] == 0 &&E[x-1][y-1] == 1 && E[x-2][y-2] == 0){
            count2 += 1;
        }
        if(x >= 3 && y >= 3 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0 &&E[x-1][y-1] == 1 && E[x-2][y-2] == 1 && E[x-3][y-3]==0){
            count2 += 1;
        }
        if(x >= 3 && y >= 2 && E[x-1][y+1] == 1 && E[x-2][y+2] == 1 &&E[x-3][y+3] == 0 &&E[x+1][y-1] == 1 && E[x+2][y-2] == 0){
            count2 += 1;
        }
        if(x >= 2 && y >= 3 && E[x-1][y+1] == 1 && E[x-2][y+2] == 0 &&E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3]==0){
            count2 += 1;
        }
        if(E[x+1][y] == 1 && E[x+2][y] == 1 &&E[x+3][y] == 1 &&E[x+4][y] == 0){
            count2 += 1;
        }
        if(x >= 4 && E[x-1][y] == 1 && E[x-2][y] == 1 &&E[x-3][y] == 1 &&E[x-4][y] == 0){
            count2 += 1;
        }
        if(E[x][y+1] == 1 && E[x][y+2] == 1 &&E[x][y+3] == 1 &&E[x][y+4] == 0){
            count2 += 1;
        }
        if(y >= 4 && E[x][y-1] == 1 && E[x][y-2] == 1 &&E[x][y-3] == 1 &&E[x][y-4] == 0){
            count2 += 1;
        }
        if(E[x+1][y+1] == 1 && E[x+2][y+2] == 1 &&E[x+3][y+3] == 1 &&E[x+4][y+4] == 0){
            count2 += 1;
        }
        if(x >= 4 && y >= 4 && E[x-1][y-1] == 1 && E[x-2][y-2] == 1 &&E[x-3][y-3] == 1 &&E[x-4][y-4] == 0){
            count2 += 1;
        }
        if(y >= 4 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 &&E[x+3][y-3] == 1 &&E[x+4][y-4] == 0){
            count2 += 1;
        }
        if(x >= 4 && E[x-1][y+1] == 1 && E[x-2][y+2] == 1 &&E[x-3][y+3] == 1 &&E[x-4][y+4] == 0){
            count2 += 1;
        }
        if(count2 >= 1){
            return 2;

        }

        // phòng thủ các nước ba liên tiếp
        //ham 4
        //hang ngang
        if(x >= 5 && E[x-5][y] == 2 && E[x-4][y] == 1 && E[x-3][y] == 1 && E[x-2][y] == 0 && E[x-1][y] == 1){
            count3 +=1;
        }
        if(x >= 5 && E[x-5][y] == 2 && E[x-4][y] == 1 && E[x-3][y] == 0 && E[x-2][y] == 1 && E[x-1][y] == 1){
            count3 +=1;
        }
        if(x >= 4 && E[x-4][y] == 2 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 0 && E[x+1][y] == 1){
            count3 +=1;
        }
        if(x >= 4 && E[x-4][y] == 2 && E[x-3][y] == 1 && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 1){
            count3 +=1;
        }
        if(x >= 4 && E[x-4][y] == 1 && E[x-3][y] == 1 && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 2){
            count3 +=1;
        }
        if(x >= 3 && E[x-3][y] == 2 && E[x-2][y] == 1 && E[x-1][y] == 0 && E[x+1][y] == 1 && E[x+2][y] == 1){
            count3 +=1;
        }
        if(x >= 3 && E[x-3][y] == 2 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 0 && E[x+2][y] == 1){
            count3 +=1;
        }
        if(x >= 3 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 0 && E[x+1][y] == 1 && E[x+2][y] == 2){
            count3 +=1;
        }
        if(x >= 2 && E[x-2][y] == 2 && E[x-1][y] == 1 && E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 1){
            count3 +=1;
        }
        if(x >= 2 && E[x-2][y] == 2 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 0 && E[x+3][y] == 1){
            count3 +=1;
        }
        if(x >= 2 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 2){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 2 && E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 1 && E[x+4][y] == 1){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 2 && E[x+1][y] == 1 && E[x+2][y] == 0 && E[x+3][y] == 1 && E[x+4][y] == 1){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 2 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 0 && E[x+4][y] == 1){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 1 && E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 1 && E[x+4][y] == 2){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 0 && E[x+3][y] == 1 && E[x+4][y] == 2){
            count3 +=1;
        }
        if(E[x+1][y] == 1 && E[x+2][y] == 0 && E[x+3][y] == 1 && E[x+4][y] == 1 && E[x+5][y] == 2){
            count3 +=1;
        }
        if(E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 0 && E[x+4][y] == 1 && E[x+5][y] == 2){
            count3 +=1;
        }








        if(x >= 5 && E[x-5][y] == 2 && E[x-4][y] == 1 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 0){
            count3 +=1;
        }
        if(x >= 4 && E[x-4][y] == 2 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 0){
            count3 +=1;
        }
        if(x >= 4 && E[x-4][y] == 0 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 2){
            count3 +=1;
        }
        if(x >= 3 && E[x-3][y] == 0 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 2){
            count3 +=1;
        }
        if(x >= 3 && E[x-3][y] == 2 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 0){
            count3 +=1;
        }

        if(x >= 2 && E[x-2][y] == 2 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 0){
            count3 +=1;
        }
        if(x >= 2 && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 2){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 0 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 1 && E[x+4][y] == 2){
            count3 +=1;
        }
        if(x >= 1 && E[x-1][y] == 2 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 1 && E[x+4][y] == 0){
            count3 +=1;
        }
        if(E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 1 && E[x+4][y] == 1 && E[x+5][y] == 2){
            count3 +=1;
        }
        //hang doc
        if (y >= 5 && E[x][y-5] == 2 && E[x][y-4] == 1 && E[x][y-3] == 1 && E[x][y-2] == 0 && E[x][y-1] == 1) {
            count3 += 1;
        }
        if (y >= 5 && E[x][y-5] == 2 && E[x][y-4] == 1 && E[x][y-3] == 0 && E[x][y-2] == 1 && E[x][y-1] == 1) {
            count3 += 1;
        }
        if (y >= 4 && E[x][y-4] == 2 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 0 && E[x][y+1] == 1) {
            count3 += 1;
        }
        if (y >= 4 && E[x][y-4] == 2 && E[x][y-3] == 1 && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 1) {
            count3 += 1;
        }
        if (y >= 4 && E[x][y-4] == 1 && E[x][y-3] == 1 && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 2) {
            count3 += 1;
        }
        if (y >= 3 && E[x][y-3] == 2 && E[x][y-2] == 1 && E[x][y-1] == 0 && E[x][y+1] == 1 && E[x][y+2] == 1) {
            count3 += 1;
        }
        if (y >= 3 && E[x][y-3] == 2 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 0 && E[x][y+2] == 1) {
            count3 += 1;
        }
        if (y >= 3 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 0 && E[x][y+1] == 1 && E[x][y+2] == 2) {
            count3 += 1;
        }
        if (y >= 2 && E[x][y-2] == 2 && E[x][y-1] == 1 && E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 1) {
            count3 += 1;
        }
        if (y >= 2 && E[x][y-2] == 2 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 0 && E[x][y+3] == 1) {
            count3 += 1;
        }
        if (y >= 2 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 2) {
            count3 += 1;
        }
        if (y >= 1 && E[x][y-1] == 2 && E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 1 && E[x][y+4] == 1) {
            count3 += 1;
        }
        if (y >= 1 && E[x][y-1] == 2 && E[x][y+1] == 1 && E[x][y+2] == 0 && E[x][y+3] == 1 && E[x][y+4] == 1) {
            count3 += 1;
        }
        if (y >= 1 && E[x][y-1] == 2 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 0 && E[x][y+4] == 1) {
            count3 += 1;
        }
        if (y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 1 && E[x][y+4] == 2) {
            count3 += 1;
        }
        if (y >= 1 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 0 && E[x][y+3] == 1 && E[x][y+4] == 2) {
            count3 += 1;
        }
        if (E[x][y+1] == 1 && E[x][y+2] == 0 && E[x][y+3] == 1 && E[x][y+4] == 1 && E[x][y+5] == 2) {
            count3 += 1;
        }
        if (E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 0 && E[x][y+4] == 1 && E[x][y+5] == 2) {
            count3 += 1;
        }






        if(y >= 5 && E[x][y-5] == 2 && E[x][y-4] == 1 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 0){
            count3 +=1;
        }
        if(y >= 4 && E[x][y-4] == 2 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 0){
            count3 +=1;
        }
        if(y >= 4 && E[x][y-4] == 0 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 2){
            count3 +=1;
        }
        if(y >= 3 && E[x][y-3] == 0 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 2){
            count3 +=1;
        }
        if(y >= 3 && E[x][y-3] == 2 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 0){
            count3 +=1;
        }

        if(y >= 2 && E[x][y-2] == 2 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 0){
            count3 +=1;
        }
        if(y >= 2 && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 2){
            count3 +=1;
        }
        if(y >= 1 && E[x][y-1] == 0 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 1 && E[x][y+4] == 2){
            count3 +=1;
        }
        if(y >= 1 && E[x][y-1] == 2 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 1 && E[x][y+4] == 0){
            count3 +=1;
        }
        if(E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 1 && E[x][y+4] == 1 && E[x][y+5] == 2){
            count3 +=1;
        }
        //cheo chinh
        if (x >= 5 && y >= 5 && E[x-5][y-5] == 2 && E[x-4][y-4] == 1 && E[x-3][y-3] == 1 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1) {
            count3 += 1;
        }
        if (x >= 5 && y >= 5 && E[x-5][y-5] == 2 && E[x-4][y-4] == 1 && E[x-3][y-3] == 0 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1) {
            count3 += 1;
        }
        if (x >= 4 && y >= 4 && E[x-4][y-4] == 2 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1) {
            count3 += 1;
        }
        if (x >= 4 && y >= 4 && E[x-4][y-4] == 2 && E[x-3][y-3] == 1 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1) {
            count3 += 1;
        }
        if (x >= 4 && y >= 4 && E[x-4][y-4] == 1 && E[x-3][y-3] == 1 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 2) {
            count3 += 1;
        }
        if (x >= 3 && y >= 3 && E[x-3][y-3] == 2 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1) {
            count3 += 1;
        }
        if (x >= 3 && y >= 3 && E[x-3][y-3] == 2 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1) {
            count3 += 1;
        }
        if (x >= 3 && y >= 3 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1 && E[x+2][y+2] == 2) {
            count3 += 1;
        }
        if (x >= 2 && y >= 2 && E[x-2][y-2] == 2 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1) {
            count3 += 1;
        }
        if (x >= 2 && y >= 2 && E[x-2][y-2] == 2 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0 && E[x+3][y+3] == 1) {
            count3 += 1;
        }
        if (x >= 2 && y >= 2 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 2) {
            count3 += 1;
        }
        if (x >= 1 && y >= 1 && E[x-1][y-1] == 2 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1 && E[x+4][y+4] == 1) {
            count3 += 1;
        }
        if (x >= 1 && y >= 1 && E[x-1][y-1] == 2 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0 && E[x+3][y+3] == 1 && E[x+4][y+4] == 1) {
            count3 += 1;
        }
        if (x >= 1 && y >= 1 && E[x-1][y-1] == 2 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 0 && E[x+4][y+4] == 1) {
            count3 += 1;
        }
        if (x >= 1 && y >= 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1 && E[x+4][y+4] == 2) {
            count3 += 1;
        }
        if (x >= 1 && y >= 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0 && E[x+3][y+3] == 1 && E[x+4][y+4] == 2) {
            count3 += 1;
        }
        if (E[x+1][y+1] == 1 && E[x+2][y+2] == 0 && E[x+3][y+3] == 1 && E[x+4][y+4] == 1 && E[x+5][y+5] == 2) {
            count3 += 1;
        }
        if (E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 0 && E[x+4][y+4] == 1 && E[x+5][y+5] == 2) {
            count3 += 1;
        }





        if(x >= 5 && y >= 5 && E[x-5][y-5] == 2 && E[x-4][y-4] == 1 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0){
            count3 +=1;
        }
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 2 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0){
            count3 +=1;
        }
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 0 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 2){
            count3 +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 0 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 2){
            count3 +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 2 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0){
            count3 +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 2 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 0){
            count3 +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 2){
            count3 +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1 && E[x+4][y+4] == 2){
            count3 +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 2 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1 && E[x+4][y+4] == 0){
            count3 +=1;
        }
        if(E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 1 && E[x+4][y+4] == 1 && E[x+5][y+5] == 2){
            count3 +=1;
        }
        //cheo phu
//        if(x >= 1 && y >= 5 && E[x-5][y-5] == 2 && E[x-4][y+4] == 1 && E[x-3][y+3] == 1 && E[x-2][y+2] == 1 && E[x-1][y+1] == 0){
//            count3 +=1;
//        }
        if(x >= 4 && y >= 1 && E[x-4][y+4] == 2 && E[x-3][y+3] == 1 && E[x-2][y+2] == 1 && E[x-1][y+1] == 1 && E[x+1][y-1] == 0){
            count3 +=1;
        }
        if(x >= 4 && y >= 1 && E[x-4][y+4] == 0 && E[x-3][y+3] == 1 && E[x-2][y+2] == 1 && E[x-1][y+1] == 1 && E[x+1][y-1] == 2){
            count3 +=1;
        }
        if(x >= 3 && y >= 2 && E[x-3][y+3] == 0 && E[x-2][y+2] == 1 && E[x-1][y+1] == 1 && E[x+1][y-1] == 1 && E[x+2][y-2] == 2){
            count3 +=1;
        }
        if(x >= 3 && y >= 2 && E[x-3][y+3] == 2 && E[x-2][y+2] == 1 && E[x-1][y+1] == 1 && E[x+1][y-1] == 1 && E[x+2][y-2] == 0){
            count3 +=1;
        }

        if(x >= 2 && y >= 3 && E[x-2][y+2] == 2 && E[x-1][y+1] == 1 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3] == 0){
            count3 +=1;
        }
        if(x >= 2 && y >= 3 && E[x-2][y+2] == 0 && E[x-1][y+1] == 1 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3] == 2){
            count3 +=1;
        }
        if(x >= 1 && y >= 4 && E[x-1][y+1] == 0 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3] == 1 && E[x+4][y-4] == 2){
            count3 +=1;
        }
        if(x >= 1 && y >= 4 && E[x-1][y+1] == 2 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3] == 1 && E[x+4][y-4] == 0){
            count3 +=1;
        }
        if(x >= 5 && y >= 4 && E[x+1][y-1] == 0 && E[x+2][y-2] == 1 && E[x+3][y-3] == 1 && E[x+4][y-4] == 1 && E[x-5][y+5] == 2){
            count3 +=1;
        }



        // ham 3
        if(x >= 1 && E[x+4][y] == 0 && E[x+3][y] == 1 && E[x+2][y] == 1 && E[x+1][y] == 0&& E[x-1][y] == 0){
            count +=1;
        }
        if(x >= 4 && E[x-4][y] == 0 && E[x-3][y] == 1 && E[x-2][y] == 1 && E[x-1][y] == 0){
            count +=1;
        }
        if(x >= 3  && E[x-3][y] == 0 && E[x-2][y] == 1 && E[x-1][y] == 1 && E[x+1][y] == 0){
            count +=1;
        }
        if(x >= 2  && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 1 && E[x+2][y] == 0){
            count +=1;
        }
        if(x >= 1  && E[x-1][y] == 0 && E[x+1][y] == 1 && E[x+2][y] == 1 && E[x+3][y] == 0){
            count +=1;
        }
        if(x >= 4  && E[x-4][y] == 0 && E[x-3][y] == 1 && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 0){
            count +=1;
        }
        if(x >= 3  && E[x-3][y] == 0 && E[x-2][y] == 1 && E[x-1][y] == 0 && E[x+1][y] == 1 && E[x+2][y] == 0){
            count +=1;
        }
        if(x >= 2  && E[x-2][y] == 0 && E[x-1][y] == 1 && E[x+1][y] == 0 && E[x+2][y] == 1 && E[x+3][y] == 0){
            count +=1;
        }



        if(y >= 1 && E[x][y+4] == 0 && E[x][y+3] == 1 && E[x][y+2] == 1 && E[x][y+1] == 0 && E[x][y-1] == 0){
            count +=1;
        }
        if(y >= 4 && E[x][y-4] == 0 && E[x][y-3] == 1 && E[x][y-2] == 1 && E[x][y-1] == 0){
            count +=1;
        }
        if(y >= 3  && E[x][y-3] == 0 && E[x][y-2] == 1 && E[x][y-1] == 1 && E[x][y+1] == 0){
            count +=1;
        }
        if(y >= 2  && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 1 && E[x][y+2] == 0){
            count +=1;
        }
        if(y >= 1  && E[x][y-1] == 0 && E[x][y+1] == 1 && E[x][y+2] == 1 && E[x][y+3] == 0){
            count +=1;
        }
        if(y >= 4  && E[x][y-4] == 0 && E[x][y-3] == 1 && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 0){
            count +=1;
        }
        if(y >= 3  && E[x][y-3] == 0 && E[x][y-2] == 1 && E[x][y-1] == 0 && E[x][y+1] == 1 && E[x][y+2] == 0){
            count +=1;
        }
        if(y >= 2  && E[x][y-2] == 0 && E[x][y-1] == 1 && E[x][y+1] == 0 && E[x][y+2] == 1 && E[x][y+3] == 0){
            count +=1;
        }



        if(x >= 1 && y >= 1 && E[x+4][y+4] == 0 && E[x+3][y+3] == 1 && E[x+2][y+2] == 0 && E[x+1][y+1] == 1 && E[x-1][y-1] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 1 && E[x+4][y+4] == 0 && E[x+3][y+3] == 1 && E[x+2][y+2] == 1 && E[x+1][y+1] == 0 && E[x-1][y-1] == 0){
            count +=1;
        }
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 0 && E[x-3][y-3] == 1 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0){
            count +=1;
        }
        if(x >= 4 && y >= 4 && E[x-4][y-4] == 0 && E[x-3][y-3] == 1 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 0){
            count +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 0 && E[x-2][y-2] == 1 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1 && E[x+2][y+2] == 1 && E[x+3][y+3] == 0){
            count +=1;
        }
        if(x >= 3 && y >= 3 && E[x-3][y-3] == 0 && E[x-2][y-2] == 1 && E[x-1][y-1] == 0 && E[x+1][y+1] == 1 && E[x+2][y+2] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y-2] == 0 && E[x-1][y-1] == 1 && E[x+1][y+1] == 0 && E[x+2][y+2] == 1 && E[x+3][y+3] == 0){
            count +=1;
        }





        if(x >= 4 && y >= 1 && E[x-4][y+4] == 0 && E[x-3][y+3] == 1 && E[x-2][y+2] == 0 && E[x-1][y+1] == 1 && E[x+1][y-1] == 0){
            count +=1;
        }
        if(x >= 4 && y >= 1 && E[x-4][y+4] == 0 && E[x-3][y+3] == 1 && E[x-2][y+2] == 1 && E[x-1][y+1] == 0 && E[x+1][y-1] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 4 && E[x+4][y-4] == 0 && E[x+3][y-3] == 1 && E[x+2][y-2] == 0 && E[x+1][y-1] == 1 && E[x-1][y+1] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 4 && E[x+4][y-4] == 0 && E[x+3][y-3] == 1 && E[x+2][y-2] == 1 && E[x+1][y-1] == 0 && E[x-1][y+1] == 0){
            count +=1;
        }
        if(x >= 3 && y >= 1 && E[x-3][y+3] == 0 && E[x-2][y+2] == 1 && E[x-1][y+1] == 1 && E[x+1][y-1] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 2 && E[x-2][y+2] == 0 && E[x-1][y+1] == 1 && E[x+1][y-1] == 1 && E[x+2][y-2] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 3 && E[x-1][y+1] == 0 && E[x+1][y-1] == 1 && E[x+2][y-2] == 1 && E[x+3][y-3] == 0){
            count +=1;
        }
        if(x >= 1 && y >= 4 && E[x+4][y-4] == 0 && E[x+3][y-3] == 1 && E[x+2][y-2] == 0 && E[x+1][y-1] == 1 && E[x-1][y+1] == 0){
            count +=1;
        }
        if(x >= 2 && y >= 3 && E[x+3][y-3] == 0 && E[x+2][y-2] == 1 && E[x+1][y-1] == 0 && E[x-1][y+1] == 1 && E[x-2][y+2] == 0){
            count +=1;
        }
        if(x >= 3 && y >= 2 && E[x+2][y-2] == 0 && E[x+1][y-1] == 1 && E[x-1][y+1] == 0 && E[x-2][y+2] == 1 && E[x-3][y+3] == 0){
            count +=1;
        }
        if(count3 >=2 || count + count3 >= 2){
            return 2;
        }
        if(count >=2){
            return 1;
        }
        else {
            return 0;
        }
    }
}
