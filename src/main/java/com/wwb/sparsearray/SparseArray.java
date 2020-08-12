package com.wwb.sparsearray;
//稀疏数组   ：棋盘问题
// 第一行是                 数组x度 数组y长度 数据总数
// 后面所有行都是有的数据      x位置     y位置   数据内容
public class SparseArray {
    public static void main(String[] args) {
        //创建一个原始的而是认为数组11*11
        //0:表示没有棋子  1代表黑子  2代表白棋
        int chessArr1[][]=new int[11][11];//棋盘大小11*11
        chessArr1[1][2] = 1 ;//横轴为2纵轴为3有一个黑棋(java数组从0开始所以是1，2)
        chessArr1[2][3] = 2 ;//横轴为3纵轴为4有一个白棋(java数组从0开始所以是2，3)
        //输出源视的二维数组
        for (int[] row : chessArr1){//遍历出的是每一行数据
            for (int data: row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二位数组 转化为 稀疏数组
        //1. 先遍历二位数组 得到非0数据的个数
        int sum = 0;
        for (int i=0 ; i<11;i++){
            for (int j = 0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArr[][] = new int[sum+1][3];//每个数据一行+第一行的声明(行、列、不同数据数)
        //给稀疏数组赋值
        sparseArr[0][0]=11;
        sparseArr[0][1]=11;
        sparseArr[0][2]=sum;

        //遍历二位数组，将非0的值存放到sparseArr中
        int count = 0;//用于计数是第几个非0数据
        for (int i=0 ; i<11;i++){
            for (int j = 0;j<11;j++){
                if (chessArr1[i][j]!=0){
                    count++;//稀疏数组的非零数据从第二行开始
                    sparseArr[count][0] = i;//x位置
                    sparseArr[count][1] = j;//y位置
                    sparseArr[count][2] = chessArr1[i][j];//具体数据
                }
            }
        }
        //输出稀疏数组
        System.out.println();
        System.out.println("系数数组为-----------");
        for (int i=0 ; i<sparseArr.length;i++){
            System.out.printf("%d\t%d\t%d\t",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            System.out.println();
        }
        System.out.println();
        //稀疏数组 --》恢复成二维数组
        	/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

        //1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组
        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

        //2. 在读取稀疏数组后几行的数据(从第二行开始)，并赋给 原始的二维数组 即可

        for(int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }
}
