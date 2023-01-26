package module10;

import java.io.File;
import java.util.Scanner;

public class PhoneNumber {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Бублик\\IdeaProjects\\untitled4\\src\\main\\resources\\file.txt");
        Scanner in = new Scanner(file);
        int countValid = 0;
        int countNotValid = 0;
        while(in.hasNextLine()){
            String number = in.nextLine();

            if (number.length() == 14 && number.startsWith("(")
                    && number.indexOf(')') == 4 && number.indexOf(' ') == 5
                    && number.indexOf('-') == 9 ) {
                System.out.println(number);
                countValid++;
            }

            else if (number.length() == 12 && number.indexOf('-') == 3){
                System.out.println(number);
                countValid++;
            }
            else {
                countNotValid++;
            }
        }
        System.out.println("Number of Valid phone numbers : " +countValid);
        System.out.println("Number of NotValid phone numbers : " +countNotValid);
        in.close();
    }
}