/*1. Написать программу, которая считает текстовый файл, заменит в нем все слова “Hello” на “1234” и запишет изменения в тот-же файл.
2. Написать программу, которая скопирует несколько файлов в один.
3. Написать программу для копирования всех файлов из одного каталога в другой.
4. Написать программу, которая создаст текстовый файл и запишет в него список файлов
 (путь, имя, дата создания) из заданного каталога.*/

package company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class _0_Test {
    public static void main(String[] args) {
        String path = "C:\\Java Developer\\lesson-018\\file1.txt";
        String hello = "Dom";
        String world = "Sweet";
        String _1234 = "1234";
        try {
            File file = new File(path);
                if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter writer = new FileWriter(path,true);
            for (int i = 1; i < 101; i++) {
                writer.write(hello);
                writer.write(world);
                if (i % 10 == 0) {
                    writer.write("\r\n");
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
