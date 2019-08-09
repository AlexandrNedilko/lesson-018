package company;
import java.io.IOException;

public class _01_OI {
    private String newtext;

    public String changeText(String oldtext, String oldword, String newword){
        try{
            if (oldtext.contains("Hello")){
                oldtext = oldtext.replace(oldword,newword);
                newtext = oldtext;
            }
            else {
                System.out.println("Text for changing not found");

            }
        } catch (NullPointerException e){
            System.out.println("File is empty!");

        }
        return newtext;
    }
}