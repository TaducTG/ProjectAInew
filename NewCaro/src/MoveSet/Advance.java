package MoveSet;
public class Advance {
    public static int CheckSurround(Point tmp, int[][] E, int a){
        int b = 0;
        int c = 0;
        if(a == 1){
            b = 2;
        }
        else if(a == 2){
            b = 1;
        }
        else if(a == 3){
            a = 1;
            b = 2;
            c = 3;
        }
        else if(a == 4){
            a = 2;
            b = 1;
            c = 4;
        }
        int x = tmp.x;
        int y = tmp.y;
        int row;
        int rowleft = 0;
        int rowright = 0;
        int blockleft = 0;
        int blockright = 0;
        int spaceleft = 0;
        int spaceright = 0;
        int blleft = 0;
        int blright = 0;

        int nearO = 0;
        int nearX = 0;




        int absoluteWin = 0;
        int nearWin = 0;
        int pushATK_3 = 0;
        int pushATK_4 = 0;
        //hang ngang

        for (int i = x - 1; i > x - 6; i--) {
            if (i >= 0) {
                if (E[i][y] == a) {
                    rowleft += 1;
                }
                if (E[i][y] == b) {
                    blockleft += 1;
                    break;
                }
                if (i-1 >=0 && E[i][y] == 0 && E[i -1][y] == b) {
                    blleft += 1;
                    break;
                }
                if (E[i][y] == 0) {
                    spaceleft += 1;
                }
                if (i-1 >=0 && E[i][y] == 0 && E[i - 1][y] == 0) {
                    break;
                }
            }
        }
        for (int i = x + 1; i < x + 6; i++) {
            if (i >= 0) {
                if (E[i][y] == a) {
                    rowright += 1;
                }
                if (E[i][y] == b) {
                    blockright += 1;
                    break;
                }
                if (E[i][y] == 0 && E[i + 1][y] == b) {
                    blright += 1;
                    break;
                }
                if (E[i][y] == 0) {
                    spaceright += 1;
                }
                if (E[i][y] == 0 && E[i + 1][y] == 0) {
                    break;
                }
            }
        }
        if(blockleft == 1){
            nearX +=1;
        }
        if(blockright == 1){
            nearX +=1;
        }
        if(rowleft >= 1){
            if(blockleft == 0 || blright <= 1){
                nearO += 1;
            }
        }
        if(rowright >= 1){
            if(blockright == 0 || blleft <= 1){
                nearO += 1;
            }
        }
        if(x-1>=0 && E[x-1][y] != 0 || E[x+1][y] != 0) {
            row = rowleft + rowright;
            if(row == 4){
                absoluteWin++;
                //9999
            }
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright <= 2){
                nearWin++;
                //9999*
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 0){
                nearWin++;
                //9999*
            }
            if(row <= 1 || (row == 2 && blockleft + blockright == 2)){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 1 && spaceleft + spaceright == 0){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 0 && spaceleft == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft == 0 && blockright == 1 && spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft + blockright == 1 && spaceright + spaceleft == 2){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 1){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 2 && spaceleft + spaceright <= 3 && (blockleft + blockright == 0 || blleft + blright == 1)){
                pushATK_3++;
                //(nuoc 3 lien tiep)
            }
        }
        else{
            if(rowright >= 2 || rowleft >= 2){
                if(rowright == 2){
                    if((blockright == 0 || (blright == 1 && spaceright == 1)) && spaceright <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 2){
                    if((blockleft == 0 || (blleft == 1 && spaceleft == 1)) && spaceleft <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 3 && blockleft == 1 && spaceleft == 1){
                    pushATK_4++;
                }
                if(rowright == 3 && blockright == 1 && spaceright == 1){
                    pushATK_4++;
                }
            }
        }
        rowright = 0;
        rowleft = 0;
        blockleft = 0;
        blockright = 0;
        spaceleft = 0;
        spaceright = 0;
        blleft = 0;
        blright = 0;
        //hang doc
        for (int i = y - 1; i > y - 6; i--) {
            if (i >= 0) {
                if (E[x][i] == a) {
                    rowleft += 1;
                }
                if (E[x][i] == b) {
                    blockleft += 1;
                    break;
                }
                if (i-1 >=0 && E[x][i] == 0 && E[x][i - 1] == b) {
                    blleft += 1;
                    break;
                }
                if (E[x][i] == 0) {
                    spaceleft += 1;
                }
                if (i-1 >=0 && E[x][i] == 0 && E[x][i - 1] == 0) {
                    break;
                }
            }
        }
        for (int i = y + 1; i < y + 6; i++) {
            if (i >= 0) {
                if (E[x][i] == a) {
                    rowright += 1;
                }
                if (E[x][i] == b) {
                    blockright += 1;
                    break;
                }
                if (E[x][i] == 0 && E[x][i + 1] == b) {
                    blright += 1;
                    break;
                }
                if (E[x][i] == 0) {
                    spaceright += 1;
                }
                if (E[x][i] == 0 && E[x][i + 1] == 0) {
                    break;
                }
            }
        }
        if(blockleft == 1){
            nearX +=1;
        }
        if(blockright == 1){
            nearX +=1;
        }
        if(rowleft >= 1){
            if(blockleft == 0 || blright <= 1){
                nearO += 1;
            }
        }
        if(rowright >= 1){
            if(blockright == 0 || blleft <= 1){
                nearO += 1;
            }
        }
        if (y-1>=0 &&E[x][y-1] != 0 || E[x][y+1] != 0) {
            row = rowleft + rowright;
            if(row == 4){
                absoluteWin++;
                //9999
            }
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright <= 2){
                nearWin++;
                //9999*
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 0){
                nearWin++;
                //9999*
            }
            if(row <= 1 || (row == 2 && blockleft + blockright == 2)){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 1 && spaceleft + spaceright == 0){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 0 && spaceleft == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft == 0 && blockright == 1 && spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft + blockright == 1 && spaceright + spaceleft == 2){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 1){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 1 && spaceleft + spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 2 && spaceleft + spaceright <= 3 && (blockleft + blockright == 0 || blleft + blright == 1)){
                pushATK_3++;
                //(nuoc 3 lien tiep)
            }
        }
        else{
            if(rowright >= 2 || rowleft >= 2){
                if(rowright == 2){
                    if((blockright == 0 || (blright == 1 && spaceright == 1)) && spaceright <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 2){
                    if((blockleft == 0 || (blleft == 1 && spaceleft == 1)) && spaceleft <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 3 && blockleft == 1 && spaceleft == 1){
                    pushATK_4++;
                }
                if(rowright == 3 && blockright == 1 && spaceright == 1){
                    pushATK_4++;
                }
            }
        }
        rowright = 0;
        rowleft = 0;
        blockleft = 0;
        blockright = 0;
        spaceleft = 0;
        spaceright = 0;
        blleft = 0;
        blright = 0;
        //cheo chinh
        for (int i = 1; i < 6; i++) {
            if (x - i >= 0 && y - i >= 0) {
                if (E[x - i][y - i] == a) {
                    rowleft += 1;
                }
                if (E[x - i][y - i] == b) {
                    blockleft += 1;
                    break;
                }
                if (x - i - 1 >= 0 && y - i - 1 >= 0 && E[x - i][y - i] == 0 && E[x - i - 1][y - i - 1] == b) {
                    blleft += 1;
                    break;
                }
                if (E[x - i][y - i] == 0) {
                    spaceleft += 1;
                }
                if (x - i - 1 >= 0 && y - i - 1 >= 0 && E[x - i][y - i] == 0 && E[x - i - 1][y - i - 1] == 0) {
                    break;
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            if (E[x + i][y + i] == a) {
                rowright += 1;
            }
            if (E[x + i][y + i] == b) {
                blockright += 1;
                break;
            }
            if (E[x + i][y + i] == 0 && E[x + i + 1][y + i + 1] == b) {
                blright += 1;
                break;
            }
            if (E[x + i][y + i] == 0) {
                spaceright += 1;
            }
            if (E[x + i][y + i] == 0 && E[x + i + 1][y + i + 1] == 0) {
                break;
            }
        }
        if(blockleft == 1){
            nearX +=1;
        }
        if(blockright == 1){
            nearX +=1;
        }
        if(rowleft >= 1){
            if(blockleft == 0 || blright <= 1){
                nearO += 1;
            }
        }
        if(rowright >= 1){
            if(blockright == 0 || blleft <= 1){
                nearO += 1;
            }
        }
        if (x-1>=0 &&y-1>=0 &&(E[x-1][y-1] != 0 || E[x+1][y+1] != 0)) {
            row = rowleft + rowright;
            if(row == 4){
                absoluteWin++;
                //9999
            }
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright <= 2){
                nearWin++;
                //9999*
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 0){
                nearWin++;
                //9999*
            }
            if(row <= 1 || (row == 2 && blockleft + blockright == 2)){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 1 && spaceleft + spaceright == 0){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 0 && spaceleft == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft == 0 && blockright == 1 && spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft + blockright == 1 && spaceright + spaceleft == 2){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 1){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 1 && spaceleft + spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 2 && spaceleft + spaceright <= 3 && (blockleft + blockright == 0 || blleft + blright == 1)){
                pushATK_3++;
                //(nuoc 3 lien tiep)
            }
        }
        else{
            if(rowright >= 2 || rowleft >= 2){
                if(rowright == 2){
                    if((blockright == 0 || (blright == 1 && spaceright == 1)) && spaceright <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 2){
                    if((blockleft == 0 || (blleft == 1 && spaceleft == 1)) && spaceleft <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 3 && blockleft == 1 && spaceleft == 1){
                    pushATK_4++;
                }
                if(rowright == 3 && blockright == 1 && spaceright == 1){
                    pushATK_4++;
                }
            }
        }
        rowright = 0;
        rowleft = 0;
        blockleft = 0;
        blockright = 0;
        spaceleft = 0;
        spaceright = 0;
        blleft = 0;
        blright = 0;
        //cheo phu
        for (int i = 1; i < 6; i++) {
            if (x - i >= 0) {
                if (E[x - i][y + i] == a) {
                    rowleft += 1;
                }
                if (E[x - i][y + i] == b) {
                    blockleft += 1;
                    break;
                }
                if (x - i - 1 >= 0 && E[x - i][y + i] == 0 && E[x - i - 1][y + i + 1] == b) {
                    blleft += 1;
                    break;
                }
                if (E[x - i][y + i] == 0) {
                    spaceleft += 1;
                }
                if (x - i - 1 >= 0 && E[x - i][y + i] == 0 && E[x - i - 1][y + i + 1] == 0) {
                    break;
                }
            }
        }
        for (int i = 1; i < 6; i++) {
            if (y - i >= 0) {
                if (E[x + i][y - i] == a) {
                    rowright += 1;
                }
                if (E[x + i][y - i] == b) {
                    blockright += 1;
                    break;
                }
                if (y - i - 1 >= 0 && E[x + i][y - i] == 0 && E[x + i + 1][y - i - 1] == b) {
                    blright += 1;
                    break;
                }
                if (E[x + i][y - i] == 0) {
                    spaceright += 1;
                }
                if (y - i - 1 >= 0 && E[x + i][y - i] == 0 && E[x + i + 1][y - i - 1] == 0) {
                    break;
                }
            }
        }
        if(blockleft == 1){
            nearX +=1;
        }
        if(blockright == 1){
            nearX +=1;
        }
        if(rowleft >= 1){
            if(blockleft == 0 || blright <= 1){
                nearO += 1;
            }
        }
        if(rowright >= 1){
            if(blockright == 0 || blleft <= 1){
                nearO += 1;
            }
        }
        if (x-1>=0 && y-1>=0 && (E[x+1][y-1] != 0 || E[x-1][y+1] != 0)) {
            row = rowleft + rowright;
            if(row == 4){
                absoluteWin++;
                //9999
            }
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright <= 2){
                nearWin++;
                //9999*
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 0){
                nearWin++;
                //9999*
            }
            if(row <= 1 || (row == 2 && blockleft + blockright == 2)){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 1 && spaceleft + spaceright == 0){
                //0
            }
            if(row == 3 && blockleft == 1 && blockright == 0 && spaceleft == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft == 0 && blockright == 1 && spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blockleft + blockright == 1 && spaceright + spaceleft == 2){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 2 && spaceleft + spaceright == 1){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 3 && blleft + blright == 1 && spaceleft + spaceright == 0){
                pushATK_4++;
                //Prep (nuoc 4 chan 1 dau)
            }
            if(row == 2 && spaceleft + spaceright <= 3 && (blockleft + blockright == 0 || blleft + blright == 1)){
                pushATK_3++;
                //(nuoc 3 lien tiep)
            }
        }
        else{
            if(rowright >= 2 || rowleft >= 2){
                if(rowright == 2){
                    if((blockright == 0 || (blright == 1 && spaceright == 1)) && spaceright <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 2){
                    if((blockleft == 0 || (blleft == 1 && spaceleft == 1)) && spaceleft <= 2){
                        pushATK_3++;
                    }
                }
                if(rowleft == 3 && blockleft == 1 && spaceleft == 1){
                    pushATK_4++;
                }
                if(rowright == 3 && blockright == 1 && spaceright == 1){
                    pushATK_4++;
                }
            }
        }


        // xét các TH
        if(c == 4){
            if(nearO >= 3 && nearX <= 1){
                return 1;
            }
            if(nearX >= 4){
                return 2;
            }
        }
        if(c == 3){
            if(nearWin == 1){
                return 1;
            }
            if(pushATK_4 == 2){
                return 2;
            }
            if(pushATK_4 == 1 && pushATK_3 >= 1){
                return 3;
            }
            if(pushATK_3 == 2){
                return 4;
            }

        }
        if(c == 0){
            if (absoluteWin >= 1) {
                return 1;
            }
            if (nearWin >= 1) {
                return 2;
            }
            if (pushATK_4 >= 1 && pushATK_3 >= 1) {
                return 3;
            }
            if (pushATK_4 == 0 && pushATK_3 >= 2) {
                return 4;
            }
            if(a == 2){
                if (pushATK_4 == 1 || pushATK_3 == 1) {
                    return 5;
                }
            }
        }
        return 0;
    }
}
