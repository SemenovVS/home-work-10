package module10;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TaskTwo {

    public List<User> readFile(String fileName) {
        List<User> users = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int age;
            while ((line = br.readLine()) != null) {
                String[] res = line.split(" ");
                try{
                    age = Integer.parseInt(res[1]);
                }
                catch (NumberFormatException ex){
                    continue;
                }
                users.add(new User(res[0], age));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return users;
    }

    public String toJson(List<User> users) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUser = gson.toJson(users);
        return jsonUser;

    }

    public void writeJsonFile(String json) {
        try(FileWriter fw=new FileWriter("user.json")){
            fw.write(json);
            fw.flush();
        }catch(Exception e){System.out.println(e);}
        System.out.println("Success...");

    }

    public String readJsonFile() throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader("user.json"));) {
            String line;
            while ((line = br.readLine()) != null) {
                stringBuilder.append(line);
            }
        }
        return stringBuilder.toString();
    }

    public ArrayList<User> deserJsonFile(String json) throws JsonProcessingException {
        Type listType = new TypeToken<ArrayList<User>>() {}.getType();
        ArrayList<User> users1 = new Gson().fromJson(json, listType);
        return users1;
    }



    public static void main(String[] args) throws IOException {
        TaskTwo taskTwo = new TaskTwo();
        List<User> users = new ArrayList<>();
        users = taskTwo.readFile("C:\\Users\\Бублик\\IdeaProjects\\untitled4\\src\\main\\resources\\file2.txt");
        String userJson = taskTwo.toJson(users);

        System.out.println(users.toString());
        System.out.println(userJson);
        taskTwo.writeJsonFile(userJson);
        String json = taskTwo.readJsonFile();
        System.out.println(json);
        System.out.println(taskTwo.deserJsonFile(json));
    }
}