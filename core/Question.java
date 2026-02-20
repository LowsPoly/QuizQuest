// แทน 680510716

package core;

import packages.StringValidator;

public class Question {
	// Constants
	private final byte MAX_CHOICES = 4;

	// Attributes
	private final String[] choices;
	private final String questionText;
	private final byte answerIndex;

	// Constructor
	public Question(String text, String[] choices, byte answerIndex)
	{
		this.questionText = StringValidator.validateString(text,
								   "Question");
		this.choices = Question.validateChoices(choices);
		this.answerIndex = Question.validateAnswerIndex(answerIndex);
	}

	// Public Methods
	public String getText() { return this.questionText; }
	public String[] getChoices() { return this.choices; }
	public boolean isCorrect(byte selectedIndex)
	{
		if (selectedIndex < 0 || selectedIndex >= MAX_CHOICES)
			throw new IllegalArgumentException("INVALID INDEX");

		return selectedIndex == this.answerIndex;
	}

	// Utility Methods
	private static String[] validateChoices(String[] choices)
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
			)
		}

		return copy;
	}

	private static byte validateAnswerIndex(byte index)
	{
		if (index < 0 || index >= MAX_CHOICES)
			throw new IllegalArgumentException(
				"ANSWER INDEX OUT OF RANGE"
			);

		return index;
	}
}
