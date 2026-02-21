// 680510716

/*
	Reading data from JSON
*/

package loader;

import core.Question;

import com.google.gson.*;
import java.io.IOException;
import java.io.FileReader;
import java.io.Reader;

public class QuestionLoader {
	public Question load(String filePath){
		Gson gson = new Gson();
		Reader reader = new FileReader(filePath);
		return gson.fromJson(reader, Question.class);
	}

	// Utility Methods
	private static JsonObject readJson(String filePath){
		try (Reader reader = new FileReader(filePath)) {
			return JsonParser.parseReader(reader).getJsonObject();
		}
	}

	private static Question parseQuestion(JsonObject json){
		
	}
}
