package company;

import java.io.FileWriter;

public class _04_OI {
    public void writer(String path, String newtext){
        try {
            FileWriter file = new FileWriter(path, false);
            file.write(newtext);
            file.close();
        } catch (Exception e) {
            System.out.println("Data to write doesn`t exist!");;
        }

    }

}
