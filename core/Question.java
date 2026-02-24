// 680510716

package core;

import packages.StringValidator;
import core.Answer;

public class Question {
	// Constants
	private static final int MAX_CHOICES = 4;

	// Attributes
	private String[] choices;
	private String questionText;
	private in answerIndex;
	private Answer answer;
	private int score;

	// Constructor
	public Question(String text, String[] choices, int answerIndex)
	{
		this.questionText = StringValidator.validateString(text, "Question");
		this.choices = this.validateChoices(choices);
		this.answerIndex = this.validateAnswerIndex(answerIndex);
		this.answer = Answer.new(this.choices[this.answerIndex]);
	}

	// Public Methods
	public String getText()
	{
		return this.questionText;
	}

	public String[] getChoices()
	{
		return this.choices;
	}
	
	public Answer getAnswer()
	{
		return this.answer;
	}

	public int getAnswerIndex()
	{
		return this.answerIndex;
	}

	// Private Methods
	private int validateAnswerIndex(int index)
	{
		if (index < 0 || index >= this.choices.length)
			throw new IllegalArgumentException("INVALID ANSWER INDEX");

		return index;
	}

	private String[] validateChoices(String[] choices)
	{
		if (choices == null)
			throw new IllegalArgumentException("CHOICES ARE NULL");

		if (choices.length > MAX_CHOICES || choices.length < 1)
			throw new IllegalArgumentException(
				"INVALID CHOICE LENGTH"
			);

		String[] copy = new String[choices.length];

		// Copy & Ensure non-blank choices
		for (int i = 0; i < choices.length; i++) {
			copy[i] = StringValidator.validateString(
				choices[i],
				"Choice at index " + i
			);
		}

		return copy;
	}
}
