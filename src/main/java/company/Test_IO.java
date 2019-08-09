package company;

import java.io.*;

public class Test_IO {
    public static void replaseF(String path,String var, String varRepl) throws IOException {
        StringBuilder sb = new StringBuilder();
        File file = new File(path);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
        try{
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try{
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            }finally {
                in.close();
            }
        }
        catch (IOException e){
            throw new RuntimeException();
        }
        String sd = sb.toString();
        sd = sd.replace(var, varRepl);
        System.out.println(sb.toString());
        System.out.println(sd);
        try{
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            try {
                //Записываем текст у файл
                out.print(sd);
            } finally {
                //После чего мы должны закрыть файл
                //Иначе файл не запишется
                out.close();
            }
        }
        catch (IOException e){
            throw new RuntimeException();
        }
    }
    public static void main(String[] args) throws IOException {
        replaseF("C:\\Java Developer\\lesson-018\\file_test.txt","Hello", "1234");
    }
}