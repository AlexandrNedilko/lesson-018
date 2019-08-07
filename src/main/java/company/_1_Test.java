package company;

import java.io.*;

public class _1_Test {

    public static void main(String[] args) {
        String text1=null;
        try {
              text1=getTextFromFile(  "C:\\Java Developer\\lesson-018\\file.txt" );
            System.out.println( text1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String  text2= text1.replace("hello","1234");
        System.out.println(text2);
    }
    public static String getTextFromFile(String path) throws IOException {

        FileInputStream fis = new FileInputStream(path);

        byte[] buf = new byte[fis.available()];

            while (fis.read() != -1) {
                fis.read(buf, 0, buf.length);
            }

        String text = new String(buf);


        return text;



    }
}
