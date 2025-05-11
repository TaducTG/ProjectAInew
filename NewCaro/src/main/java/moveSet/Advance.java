package moveSet;

import machineMoveChoice.SelectMove;
public class Advance {
    public static int checkSurround(Point tmp, int[][] E, int a){
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

        int absoluteWin = 0;
        int nearWin = 0;
        int pushATK_3 = 0;
        int pushATK_4 = 0;
        int close = 0;
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
        if(x-1>=0 && E[x-1][y] != 0 || E[x+1][y] != 0) {
            row = rowleft + rowright;
            if(row == 4){
                absoluteWin++;
                //9999
            }
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright == 3){
                close++;
                //9999*
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
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright == 3){
                close++;
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
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright == 3){
                close++;
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
            if(row == 3 && blockleft == 0 && blockright == 0 && spaceleft + spaceright == 3){
                close++;
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
            if(close >= 1){
                return 5;
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
                    if(pushATK_3 == 0){
                        return 6;
                    }
                    return 5;
                }
            }
        }
        return 0;
    }

    public static int findBestloc(Point tmp, int[][] E,int a){
        int x = tmp.x;
        int y = tmp.y;
        int range = 3;
        if(SelectMove.startMove > 5){
            range = 5;
        }
        int nearX = 0;
        int count_space = 0;
        int count_ally = 0;
        int count_enemy = 0;
        int lv1 = 0;
        int lv2 = 0;
        int lv3 = 0;
        int lv0 = 0;
        int b = 1;

        // ngang
        for (int i = 1; i < 4; i++) {
            if (x - i >= 0 && E[x - i][y] == b) {
                count_enemy += 1;
            }
            if (x - i >= 0 && E[x - i][y] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for (int i = 0; i < 4; i++) {
            if (E[x + i][y] == b) {
                count_enemy += 1;
            }
            if (E[x + i][y] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for(int i = 1; i < range; i++){
            if(x-i < 0){
                break;
            }
            if(E[x-i][y] == 0){
                count_space +=1;
            }
            if(E[x-i][y] == a){
                count_ally +=1;
            }
            if(E[x-i][y] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;
        for(int i = 1; i < range; i++){
            if(E[x+i][y] == 0){
                count_space +=1;
            }
            if(E[x+i][y] == a){
                count_ally +=1;
            }
            if(E[x+i][y] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;


        // doc
        for (int i = 1; i < 4; i++) {
            if (y - i >= 0 && E[x ][y - i] == b) {
                count_enemy += 1;
            }
            if (y - i >= 0 && E[x ][y - i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for (int i = 0; i < 4; i++) {
            if (E[x][y + i] == b) {
                count_enemy += 1;
            }
            if (E[x][y + i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for(int i = 1; i < range; i++){
            if(y-i < 0){
                break;
            }
            if(E[x][y-i] == 0){
                count_space +=1;
            }
            if(E[x][y-i] == a){
                count_ally +=1;
            }
            if(E[x][y-i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;
        for(int i = 1; i < range; i++){
            if(E[x][y+i] == 0){
                count_space +=1;
            }
            if(E[x][y+i] == a){
                count_ally +=1;
            }
            if(E[x][y+i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;

        // cheo chinh

        for (int i = 1; i < 4; i++) {
            if (x - i >= 0 && y - i >= 0 && E[x - i][y - i] == b) {
                count_enemy += 1;
            }
            if (x - i >= 0 && y - i >= 0 && E[x - i][y - i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for (int i = 0; i < 4; i++) {
            if (E[x + i][y+i] == b) {
                count_enemy += 1;
            }
            if (E[x + i][y+i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for(int i = 1; i < range; i++){
            if(x - i < 0 || y - i  < 0){
                break;
            }
            if(E[x-i][y-i] == 0){
                count_space +=1;
            }
            if(E[x-i][y-i] == a){
                count_ally +=1;
            }
            if(E[x-i][y-i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;
        for(int i = 1; i < range; i++){
            if(E[x+i][y+i] == 0){
                count_space +=1;
            }
            if(E[x+i][y+i] == a){
                count_ally +=1;
            }
            if(E[x+i][y+i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;

        // cheo phu

        for (int i = 1; i < 4; i++) {
            if (x - i >= 0 && E[x - i][y + i] == b) {
                count_enemy += 1;
            }
            if (x - i >= 0 && E[x - i][y + i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for (int i = 0; i < 4; i++) {
            if (y - i >= 0 && E[x + i][y-i] == b) {
                count_enemy += 1;
            }
            if (y - i >= 0 && E[x + i][y-i] == a) {
                break;
            }
        }
        if(count_enemy >= 2){
            nearX +=1;
        }
        for(int i = 1; i < range; i++){
            if(x - i < 0){
                break;
            }
            if(E[x-i][y+i] == 0){
                count_space +=1;
            }
            if(E[x-i][y+i] == a){
                count_ally +=1;
            }
            if(E[x-i][y+i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;
        for(int i = 1; i < range; i++){
            if(y - i < 0){
                break;
            }
            if(E[x+i][y-i] == 0){
                count_space +=1;
            }
            if(E[x+i][y-i] == a){
                count_ally +=1;
            }
            if(E[x+i][y-i] == b){
                count_enemy +=1;
                if(i<4){
                    lv0 +=1;
                }
                break;
            }
        }
        if(lv0 == 0){
            if(count_ally == 1){
                lv1 +=1;
            }
            if(count_ally == 2){
                lv2 +=1;
            }
            if(count_ally == 3 && count_enemy == 0){
                lv3 +=1;
            }
        }
        count_enemy = 0;
        count_space = 0;
        count_ally = 0;
        int score = 0;
        if(nearX == 2){
            score +=100;
        }
        if(nearX == 3){
            score +=200;
        }
        if(nearX == 4){
            score +=400;
        }
        if(lv1 >= 2){
            return 80*lv1 + score;
        }
        if(lv2 >= 2){
            return 200*lv2 + score;
        }
        if(lv3 >= 1 && (lv1 == 1 || lv2 == 1)){
            return 400*lv3 + 80*lv1 + 200*lv2 + score;
        }

        return 0;
    }
}
