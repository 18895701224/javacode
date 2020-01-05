package com.szxy.self;

import org.junit.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

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
    public void te() throws IOException {
        //测试方法里db.txt在当前模块下
        File file = new File("db.txt");
    //    String absolutePath = file.getAbsolutePath();
      //  System.out.println(absolutePath);//D:\MyWork\workSpace\javacode\iotest\db.txt
       FileReader fr = new FileReader(file);
        int read = fr.read();//所得read表示char类型 字母所对应的unicode码值 输出结果时需要转为char型
        while(read != -1){
            System.out.print((char)read);
            read = fr.read();
        }
        fr.close();
    }

}
