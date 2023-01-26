package module10;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumbersOfWords {
    public static void main(String[] args) throws Exception{
        File file = new File("C:\\Users\\Бублик\\IdeaProjects\\untitled1\\src\\main\\resources\\words.txt");
        Map<String, Integer> map = new HashMap<>();
        Scanner in = new Scanner(file);
        String [] arr = new String[20];
        int count1 = 1;
        for (int i = 0; i < arr.length; i++) {
            if (in.hasNext()) {
                arr[i] = in.next();
            }
        }
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] == null){
                break;
            }
            if (map.containsKey(arr[i])){
                String test = arr[i];
                int testcount = 0;
                for (int j = 0; j < arr.length; j++) {
                    if (test.equals(arr[j])){
                        testcount++;
                    }
                    else {
                    }
                }
                map.put(arr[i],testcount);
            }
            else{
                map.put(arr[i],count1);
            }
        }
        for (Map.Entry entry : map.entrySet()) {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }
}
