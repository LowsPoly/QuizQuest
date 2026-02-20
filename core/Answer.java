// แทน 680510716

package core;

import packages.StringValidator; 

public class Answer {
	// Attributes
	private string text;

	// Constructor
	public Answer(String text)
	{
		this.text = StringValidator.validateString(text, "Answer");
	}

	// Public Methods
	public String getText() { return this.text; }
}
