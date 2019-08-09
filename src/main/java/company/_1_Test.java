package company;

import java.io.*;

public class _1_Test {

    public static void main(String[] args) {
        String text1 = null;
        try {
            text1 = getTextFromFile(  "C:\\Java Developer\\lesson-018\\file.txt" );


            System.out.println( text1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String  text2 = text1.replace("hello","1234");
        try {
            writeTextToFile("C:\\Java Developer\\lesson-018\\file.txt", text2);
       } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(text2);
        try {
            String froF1= getTextFromFile("C:\\Java Developer\\lesson-018\\file.txt" );
            String froF2= getTextFromFile("C:\\Java Developer\\lesson-018\\file1.txt" );
            writeToFile("C:\\Java Developer\\lesson-018\\file2.txt", froF1, froF2);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void writeToFile(String path, String froF1, String froF2) throws IOException {
        FileOutputStream fos = new FileOutputStream(path, true);
        String text = froF1 + froF2;

            // перевод строки в байты
            byte[] buffer = text.getBytes();

            fos.write(buffer, 0, buffer.length);

        System.out.println("The file has been written");

    }

    public static String getTextFromFile(String path) throws IOException {

        FileInputStream fis = new FileInputStream(path);

        byte[] buf = new byte[fis.available()];

        int i;
        int h=0;
        while ((i=fis.read()) != -1) {

            //fis.read(buf, 0, buf.length);

            buf[h]= (byte) i;
            h++;

        }
        fis.close();
        String text = new String(buf);
        return text;
    }

    static void writeTextToFile(String file, String text) throws  IOException {
        RandomAccessFile f = new RandomAccessFile(file, "rw");
        try {
            f.setLength(0);
            byte[] buf = text.getBytes();
            f.write(buf);
        }finally {
            f.close();
        }
    }
}
