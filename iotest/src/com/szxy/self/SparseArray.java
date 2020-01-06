package com.szxy.self;

/**
 * @author YKC
 * @create 2020-01-06 9:34
 */
//
//import java.awt.Desktop;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//
//public class SparseArray {
//
//    public static void main(String[] args) throws Exception {
//        // 先创建一个原始的二维数组 11 * 11
//        // 0: 表示没有棋子,1: 表示黑子 2: 表示白字
//        int chessArr1[][] = new int[11][11];
//        chessArr1[1][2] = 1;
//        chessArr1[2][3] = 2;
//        // 输出原始的二维数组
//        System.out.println("原始的二维数组~~");
//        for (int[] row : chessArr1) {
//            for (int data : row) {
//                System.out.printf("%d\t", data);
//            }
//            System.out.println();
//        }
//
//        // 将二维数组 转 稀疏数组
//        // 1. 先遍历二维数组 得到非0数据的个数
//        int sum = 0;
//        for (int i = 0; i < 11; i++) {
//            for (int j = 0; j < 11; j++) {
//                if (chessArr1[i][j] != 0) {
//                    sum++;
//                }
//            }
//        }
//
//        System.out.println("sum=" + sum);
//
//        // 2.创建对应的稀疏数组
//        int sparseArr[][] = new int[sum + 1][3];
//        // 给稀疏数组赋值 初始化
//        sparseArr[0][0] = 11;
//        sparseArr[0][1] = 11;
//        sparseArr[0][2] = sum;
//
//        // 遍历二维数组,将非0的值存放到 sparseArr中
//        int count = 0;// 用于记录是第几个非0的数据
//        for (int i = 0; i < 11; i++) {
//            for (int j = 0; j < 11; j++) {
//                if (chessArr1[i][j] != 0) {
//                    count++;
//                    sparseArr[count][0] = i;
//                    sparseArr[count][1] = j;
//                    sparseArr[count][2] = chessArr1[i][j];
//                }
//            }
//        }
//        // 保存稀疏数组
//        File file = new File("map.txt");
//        FileOutputStream fos = new FileOutputStream(file);
//
//        OutputStreamWriter write = new OutputStreamWriter(fos, "UTF-8");
//        // 输出稀疏数组的形式
//        System.out.println();
//        System.out.println("得到的稀疏数组为~~~");
//        for (int i = 0; i < sparseArr.length; i++) {
//            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
//
//            if (i == sparseArr.length - 1) {
//                write.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2]);
//            } else {
//                write.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + ",");
//            }
//        }
//
//        System.out.println("写入文件中...");
//        write.close();
//        fos.close();
//
//        System.out.println("打开文件中...");
//        Desktop.getDesktop().open(file);
//
//        System.out.println("------------------------------先读取_map.data");
//        // 创建 FileReader 对象
//        FileInputStream fis = new FileInputStream(file);
//
//        InputStreamReader reader = new InputStreamReader(fis, "UTF-8");
//        StringBuffer sb = new StringBuffer();
//        while (reader.ready()) {
//            sb.append((char) reader.read());// 转成char加到StringBuffer对象中
//        }
//
//        System.out.println(sb.toString());
//        reader.close();// 关闭读取流
//        fis.close();// 关闭输入流,释放系统资源
//
//        System.out.println("------------------------------恢复成稀疏数组_sparseArrHf");
//        // 2.创建对应的稀疏数组
//        String[] str = sb.toString().split(",");
//        int sparseArrHf[][] = new int[str.length / 3][3];
//        // 给稀疏数组赋值
//        int i = 0;
//        for (String s : str) {
//            sparseArrHf[(i - (i % 3)) / 3][i % 3] = Integer.parseInt(s);
//            i++;
//        }
//
//        System.out.println("------------------------------再恢复成二维数组_chessArr22");
//        // 将稀疏数组 -->恢复成 原始的二维数组
//        /*
//         * 1. 读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组,比如上面的 chessArr2 = int[11][11];
//         *
//         * 2. 在读取稀疏数组后几行的数据,并赋给 原始的二维数组 即可.
//         */
//
//        // 1. 读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
//        int chessArr22[][] = new int[sparseArrHf[0][0]][sparseArrHf[0][1]];
//
//        // 2. 在读取稀疏数组后几行的数据,并赋给 原始的二维数组 即可.
//        for (int i3 = 1; i3 < sparseArrHf.length; i3++) {
//            chessArr22[sparseArrHf[i3][0]][sparseArrHf[i3][1]] = sparseArrHf[i3][2];
//        }
//
//        // 输出恢复的二维数组
//        System.out.println();
//        for (int[] row : chessArr22) {
//            for (int data : row) {
//                System.out.printf("%d\t", data);
//            }
//            System.out.println();
//        }
//
//        System.out.println("--------------------------------------------------------恢复完成");
//
//        // 将稀疏数组 -->恢复成 原始的二维数组
//        /*
//         * 1. 读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组,比如上面的 chessArr2 = int[11][11];
//         *
//         * 2. 在读取稀疏数组后几行的数据,并赋给 原始的二维数组 即可.
//         */
//
//        // 1. 读取稀疏数组的第一行,根据第一行的数据,创建原始的二维数组
//        int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];
//
//        // 2. 在读取稀疏数组后几行的数据,并赋给 原始的二维数组 即可.
//        for (int i3 = 1; i3 < sparseArr.length; i3++) {
//            chessArr2[sparseArr[i3][0]][sparseArr[i3][1]] = sparseArr[i3][2];
//        }
//
//        // 输出恢复后的二维数组
//        System.out.println();
//        System.out.println("恢复后的二维数组");
//        for (int[] row : chessArr2) {
//            for (int data : row) {
//                System.out.printf("%d\t", data);
//            }
//            System.out.println();
//        }
//
//    }
//}
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class SparseArray {
    public static void main(String[] args) {

        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //创建一个原始的二维数组 11*11
        //0:表示没有棋子
        //1：表示黑子
        //2：表示白子


        for(int[] row: chessArr1) {
            for(int data: row) {
                System.out.print(data);
            }
            System.out.println("\n");
        }
        //遍历输出


        int sum = 0;
        for(int i =0; i < 11; i++) {
            for(int j =0; j < 11; j++) {
                if(chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        //遍历原始获得非0数的总数sum

        int[][] sparseArr = new int[sum+1][3];
        //行的数量是sum+1,因为第一行是保留原始数组的数据用的
        //列恒定为3

        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //初始化稀疏数组的第一行


        int count = 0;
        //count用来记录现在的值是第几个非零数据
        for(int i =0; i < 11; i++) {
            for(int j =0; j < 11; j++) {
                if(chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //遍历二维数组，将非0的值存放到稀疏数组中

        System.out.println();
        System.out.println("得到的稀疏数组为");
        for(int i =0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
            //格式化输出
        }
        //输出一下稀疏数组
        //稀疏数组写到文件中

        FileWriter writer = null;

        try {
            writer = new FileWriter("save1.data");
            for(int i =0; i < sparseArr.length; i++) {
                for(int j = 0; j < 3; j++) {
                    writer.write(sparseArr[i][j]);
                }
//				writer.write("\n");
//				写入的时候不需要换行！！我在这里摔倒了就不希望有人再在同一个地方摔倒。
//				如果你发现写入和读取的数字不对，第一件事情请看看你有没有把换行符之类的也写入了
//				导致reader把你的换行符也读取了。
            }

            writer.flush();
        } catch (IOException e) {

            e.printStackTrace();
        } finally {
            try {
                if(writer != null) {
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }


        FileReader reader = null;
        int[][] sparseArr2 = new int[sum+1][3];
        int getNum = 0;
        try {
            reader = new FileReader("Save1.data");

            for(int i =0; i < sparseArr2.length; i++) {
                for(int j =0; j < 3; j++) {
                    getNum = reader.read();
                    sparseArr2[i][j] = getNum;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        //利用IO流将save1文件读取成稀疏数组


        System.out.println();
        System.out.println("读取后稀疏数组为");
        for(int i =0; i < sparseArr2.length; i++) {
            System.out.printf("%d\t%d\t%d\n", sparseArr2[i][0],sparseArr2[i][1],sparseArr2[i][2]);
            //格式化输出
        }
        System.out.println();
        //输出一下的稀疏数组


        int[][] chessArr2 = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        //首先把二维数组构建出来，利用稀疏数组的第一行

        for(int i = 1; i < sparseArr2.length; i++) {
            //从稀疏数组的第二行开始
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }
        //将稀疏数组恢复成原始的二维数组


        for(int[] row: chessArr2) {
            for(int data: row) {
                System.out.print(data);
            }
            System.out.println();
        }
        //遍历输出恢复后的二维数组
    }
}
