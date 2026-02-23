// 680510716

/*
	Reading data from JSON
 */
package loader;

import core.Question;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class QuestionLoader {

    public Question[] load(String filePath) {
        // try read json file
        try (Reader reader = new FileReader(filePath)) {
            JsonArray jsonArray = JsonParser.parseReader(reader).getAsJsonArray();

            Question[] questions = new Question[jsonArray.size()];
            for (int i = 0; i < jsonArray.size(); i++) {
                JsonObject obj = jsonArray.get(i).getAsJsonObject();

                // quest and answer
                String text = obj.get("questionText").getAsString();
                byte ans = obj.get("answerIndex").getAsByte();

                // choices
                JsonArray JsChoices = obj.get("choices").getAsJsonArray();
                String[] choices = new String[JsChoices.size()];
                for (int j = 0; j < JsChoices.size(); j++) {
                    choices[j] = JsChoices.get(j).getAsString();
                }

                questions[i] = new Question(text, choices, ans);
            }
            return questions;

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return new Question[0];
        } catch (Exception e) {
            System.err.println("Error parsing JSON: " + e.getMessage());
            return new Question[0];
        }
    }
}
