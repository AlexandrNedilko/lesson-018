/*4. Написать программу, которая создаст текстовый файл и запишет в него список файлов
        (путь, имя, дата создания) из заданного каталога.*/
package company;

import java.io.File;
import java.io.IOException;

import java.io.RandomAccessFile;
import java.util.ArrayList;

public class _3_Test_ {
    public static void main(String[] args) throws Exception {
        ArrayList<File> list = new ArrayList<File>();
        String str = "C:\\Java Developer\\lesson-018\\tepmsrc";

        list = scanDir(str, list);

        String text = getTextfromFilesDir(list);
         writeTextToFile("C:\\Java Developer\\lesson-018\\copyNameFilse.txt", text);
    }

    private static String getTextfromFilesDir(ArrayList<File> list) throws IOException {
        StringBuilder stringBuilder =new StringBuilder();
        String text;
          for (File f: list ) {
             stringBuilder.append(f.getCanonicalPath()+ "\r\n");
             stringBuilder.append( f.getName()+ "\r\n");
             stringBuilder.append( f.lastModified()+ "\r\n");
        }
        text= stringBuilder.toString();
        return  text;
    }

    static ArrayList<File> scanDir(String dir, ArrayList<File> arr) throws IOException {

        File f = new File(dir);
        File[] filesList = f.listFiles();

        if (filesList == null)
            return arr;

        for (File file : filesList) {
            if (file.isFile()) {
                arr.add(file);
            }
            if (file.isDirectory()) {
                arr.add(file);
                scanDir(file.getCanonicalPath(), arr);
            }
        }
        return arr;
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