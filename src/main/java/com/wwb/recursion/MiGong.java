package com.wwb.recursion;

public class MiGong {
    public static void main(String[] args) {
        //创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //上下全部置为1
        for (int i = 0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for (int i = 0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板，1表示
        map[3][1] = 1;
        map[3][2] = 1;
        for (int i = 0;i<8;i++){
            for (int j=0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        //使用递归回溯给小球找路
        //setWay(map, 1, 1);
        setWay(map, 1, 1);
    }
    //使用递归来给小球找路
    //说明
    //1. map 表示地图
    //2. i,j 表示从地图的哪个位置开始出发(1,1)
    //3. 如果小球能到 map[6][5] 位置，则说明桐庐找到
    //4. 约定： 当map[i][j] 为0 表示改点没有走过 当为1表示墙,2表示通路可以走;3表示该点已经走过，但是走不通
    //5. 走迷宫时，需要确定一个政策（方法）
    public static boolean setWay(int[][] map, int i, int j) {
        //  6  5是终点   2代表经过
        if(map[6][5] == 2) { // 通路已经找到ok
            return true;
        } else {
            if(map[i][j] == 0) { //如果当前这个点还没有走过
                //按照策略 下->右->上->左  走
                map[i][j] = 2; // 假定该点是可以走通.
                if(setWay(map, i+1, j)) {//向下走
                    return true;
                } else if (setWay(map, i, j+1)) { //向右走
                    return true;
                } else if (setWay(map, i-1, j)) { //向上
                    return true;
                } else if (setWay(map, i, j-1)){ // 向左走
                    return true;
                } else {
                    //上下左右都是false，说明该点是走不通，是死路，也就是旁边都是1或者2
                    map[i][j] = 3;
                    return false;
                }
            } else { // 如果map[i][j] != 0 , 可能是 1， 2， 3
                //不是0又不是2  说明是1或者3，此路不同，已经走到了不是0的点不规范
                return false;
            }
        }
    }




}
