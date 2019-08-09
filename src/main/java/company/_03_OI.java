package company;

import java.io.RandomAccessFile;

public class _03_OI {
    String text;

    public String reader(String path) {
        try {
            RandomAccessFile file = new RandomAccessFile(path, "r");
            text = file.readLine();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return text;
    }
}