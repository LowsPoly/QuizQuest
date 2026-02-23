// 680510716
package core;

import packages.StringValidator;

public class Question {
    // Constants

    private static final byte MAX_CHOICES = 4;

    // Attributes
    private final String[] choices;
    private final String questionText;
    private final byte answerIndex;

    // Constructor
    public Question(String text, String[] choices, byte answerIndex) {
        this.questionText = StringValidator.validateString(text,
                "Question");
        this.choices = this.validateChoices(choices);
        this.answerIndex = this.validateAnswerIndex(answerIndex);
    }

    // Public Methods

    // Quest
    public String getText() {
        return this.questionText;
    }
    // Choice
    public String[] getChoices() {
        return this.choices;
    }
    // Answer
    public byte getAnswerIndex() {
        return this.answerIndex;
    }
    public boolean checkAnswer(int userChoiceIndex){
        return this.answerIndex == userChoiceIndex;
    }

    // Private Methods
    private byte validateAnswerIndex(byte index) {
        if (index < 0 || index >= this.choices.length) {
            throw new IllegalArgumentException("INVALID ANSWER INDEX");
        }

        return index;
    }

    private String[] validateChoices(String[] choices) {
        if (choices == null) {
            throw new IllegalArgumentException("CHOICES ARE NULL");
        }

        if (choices.length > MAX_CHOICES || choices.length < 1) {
            throw new IllegalArgumentException(
                    "INVALID CHOICE LENGTH"
            );
        }

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
