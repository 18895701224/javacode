package com.szxy.self;

import org.junit.Test;

import java.io.*;

/**
 * @author YKC
 * @create 2020-01-05 16:37
 */
public class ioTest {
    public static void main(String[] args) {
        //main方法下db.txt直接在项目下
        File file = new File("db.txt");
        String absolutePath = file.getAbsolutePath();
        System.out.println(absolutePath);//D:\MyWork\workSpace\javacode\db.txt
    }
    @Test
    /**
     * 将db.txt中内容读取输出到控制台
     */
    public void te(){
        //测试方法里db.txt在当前模块下
        File file = null;
    //    String absolutePath = file.getAbsolutePath();
      //  System.out.println(absolutePath);//D:\MyWork\workSpace\javacode\iotest\db.txt
        FileReader fr = null;
        try {
            file = new File("db.txt");
            fr = new FileReader(file);
            int read = fr.read();//所得read表示char类型 字母所对应的unicode码值 输出结果时需要转为char型
            while(read != -1){//通过循环一个一个的读取 如果为-1表示已到达结尾没有数据可读
                System.out.print((char)read);
                read = fr.read();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fr != null){
                try {
                    fr.close();//关闭流的操作
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 从内存中写出到硬盘的文件里
     * 说明写出的文件再次写出新的数据原有的数据会被覆盖
     */
    @Test
    public void test1(){
        //声明文件写入到的地方
        File file = null;
        FileWriter fw = null;
        //提供fileWriter的对象用于数据写出
        try {
            file = new File("hello.txt");
           fw = new FileWriter(file,true);//使用true在原有基础上添加，false覆盖添加
           //写出数据
           fw.write("I have a dream!"+"\n");
            fw.write("I have a dream, too!");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 数据的读入和写出
     */
    @Test
    public void testRandW(){
        //先声明读取的文件和写出到的地方
        FileReader fr = null;
        FileWriter fw =null;
        //提供读写操作的对象用于读入和写出
        try { File fileW = new File("hello1.txt");
           File fileR = new File("hello.txt");
//            File fileW = new File("61.jpeg");失败字符流不能用来处理图片
//            File fileR = new File("4.jpeg");
            fr = new FileReader(fileR);
            fw = new FileWriter(fileW);

            char[] sus = new char[5];//创建char型数组用于每次读取五个
            int len ;
            while((len = fr.read(sus))!= -1){
                fw.write(sus,0,len);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 复制图片
     */
    @Test
    public void opys(){

        FileInputStream fil = null;
        FileOutputStream fio = null;
        try {
            File file = new File("4.jpeg");
            File file1 = new File("5.jpeg");
            fil = new FileInputStream(file);
            fio = new FileOutputStream(file1);

            byte[] sss = new byte[5];
            int len;
            while((len = fil.read(sss)) != -1){
                fio.write(sss,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fio != null){
                try {
                    fio.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fil != null){
                try {
                    fil.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    /**
     * 指定路径下的文件的复制
     */
    public void copyFile(String srcPath,String destPath){
        FileInputStream fil = null;
        FileOutputStream fio = null;
        try {
            File file = new File(srcPath);
            File file1 = new File(destPath);
            fil = new FileInputStream(file);
            fio = new FileOutputStream(file1);

            byte[] sss = new byte[1024];
            int len;
            while((len = fil.read(sss)) != -1){
                fio.write(sss,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(fio != null){
                try {
                    fio.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fil != null){
                try {
                    fil.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    /**
     * 测试copy一个文件所花费的时间
     */
    @Test
    public void testTime(){
        long start = System.currentTimeMillis();
        copyFile("C:\\Users\\Administrator\\Desktop\\逆天邪神.txt","C:\\Users\\Administrator\\Desktop\\逆神.txt");
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}
