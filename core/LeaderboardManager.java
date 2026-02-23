
package core;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import core.Result;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class LeaderboardManager{
    

    private static final String FILE_PATH = "data/leaderboard.json";

    public static List<Result> loadResults(){
        File file = new File(FILE_PATH);


        if (!file.exists()){return new ArrayList<>();}

        try (FileReader reader = new FileReader(file)){
            Gson gson = new Gson();
            java.lang.reflect.Type type = new TypeToken<ArrayList<Result>>(){}.getType();
            
            ArrayList<Result> list = gson.fromJson(reader, type);
            return (list == null) ? new ArrayList<>() : list;

        }catch (IOException e){
            System.out.println(e);
            return new ArrayList<>();
        }


    }

    public static void saveResult(Result newResult){

        List<Result> list = loadResults();
        list.add(newResult);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            gson.toJson(list, writer);
        } catch (IOException e) {
            System.out.println(e);
        }

    }

}