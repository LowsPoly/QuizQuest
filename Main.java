// 680510716

import core.Question;
import loader.QuestionLoader;

public class Main {
	public static void main(String[] args)
	{
		QuestionLoader loader = new QuestionLoader();
        
        Question[] result = loader.load("data/hard/computer_1.json");
        
        System.out.println("Checking data loading...");
        if (result.length > 0) {
            System.out.println("Success! Loaded " + result.length + " questions.");
			System.out.println("First Question: " + result[0].getText());
        } else {
            System.out.println("Failed! No data found or error occurred.");
        }
	}
}
