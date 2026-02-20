// 680510716

package core;

import core.Question;
import java.util.Scanner;

public class QuizEngine {
	// Attributes
	private Question[] questions;

	// Constructor
	public QuizEngine(Question[] questions)
	{
		this.questions = questions;
	}

	public Result initialise()
	{
		Scanner input = new Scanner(System.in);
		int correctCount = 0;

		for (Question question : this.questions) {
			// TODO:
		}

		return new Result(this.questions.length, correctCount);
	}
}
