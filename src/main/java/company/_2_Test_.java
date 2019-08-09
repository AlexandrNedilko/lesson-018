//3. Написать программу для копирования всех файлов из одного каталога в другой.
package company;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class _2_Test_ {
    static ArrayList<File> scanDir(String dir, ArrayList<File> list) throws IOException {
        File f = new File(dir);
        File[] filesList = f.listFiles();

        if (filesList == null)
            return list;

        for (File file : filesList) {
            if (file.isFile()) {
                list.add(file);
            }
            if (file.isDirectory()) {
                list.add(file);
                scanDir(file.getCanonicalPath(), list);
            }
        }
        return list;
    }

    static void copyFile(String src, String dst) throws IOException {
        byte[] buff = new byte[1024];
        int r = 0;


            RandomAccessFile in = new RandomAccessFile(src, "r");
            RandomAccessFile out = new RandomAccessFile(dst, "rw");

            do {
                r = in.read(buff, 0, buff.length);
                if (r > 0) {
                    out.write(buff, 0, r);
                }
            } while (r > 0);


    }

    static void copyAllInDir(String src, String dst) throws IOException {
        ArrayList<File> list = new ArrayList<File>();
        StringBuilder sb = new StringBuilder();

        list = scanDir(src, list);

        for (File f : list) {
            sb.append(f.getCanonicalPath());
            sb.replace(0, src.length(), dst);

            if (f.isDirectory()) {
                new File(sb.toString()).mkdirs();
            }
            if (f.isFile()) {
                copyFile(f.getCanonicalPath(), sb.toString());
            }
            sb.delete(0, sb.length());
        }
    }

    public static void main(String[] args) {
        String src = "C:\\Java Developer\\lesson-018\\tepmsrc";
        String dst = "C:\\Java Developer\\lesson-018\\tepmdest";
        long start = System.currentTimeMillis();

        try {
            copyAllInDir(src, dst);
        } catch (IOException e) {
            System.out.println(e.getLocalizedMessage());
        }

        System.out.println((System.currentTimeMillis() - start) / 1000);
    }

}