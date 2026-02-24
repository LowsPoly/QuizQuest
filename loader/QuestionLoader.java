package loader;

import core.Question;

import org.json.JSONArray;
import org.json.JSONObject;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.charset.StandardCharsets;
import java.io.IOException;

public Question[] load(String filePath)
{
	try {
		// Read entire file as UTF-8 string
		String content = Files.readString(Paths.get(filePath),
		                                  StandardCharsets.UTF_8);

		// Parse JSON array
		JSONArray jsonArray = new JSONArray(content);

		// Allocate memory for questions array
		Question[] questions = new Question[jsonArray.length()];

		// Read each question
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject obj = jsonArray.getJSONObject(i);

			String text = obj.getString("questionText");
			int answerIndex = obj.getInt("answerIndex");

			// Read choices
			JSONArray jsChoices = obj.getJSONArray("choices");
			String[] choices = new String[jsChoices.length()];

			for (int j = 0; j < jsChoices.length(); j++) {
				choices[j] = jsChoices.getString(j);
			}

			questions[i] = new Question(text, choices, answerIndex);
		}

		return questions;

	} catch (IOException e) {
		e.printStackTrace();
		return new Question[0];
	} catch (Exception e) {
		e.printStackTrace();
		return new Question[0];
	}
}
