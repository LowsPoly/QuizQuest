// 680510716
package core;

import packages.StringValidator;

public class Answer {
    // Attributes

    private String text;

    // Constructor
    public Answer(String text) {
        this.text = StringValidator.validateString(text, "Answer");
    }

    // Public Methods
    public String getText() {
        return this.text;
    }
}
