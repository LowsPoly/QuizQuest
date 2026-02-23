// 680510716
package core;

import java.util.Scanner;

public class QuizEngine {
    // Attributes
    private Question[] questions;
    private String difficulty;
    private int heart;

    // Constructor
    public QuizEngine(Question[] questions, String difficulty) {
        this.questions = questions;
        this.difficulty = difficulty;
    }

    public Result initialise() {

        Scanner input = new Scanner(System.in);
        int correctCount = 0;
        this.heart = 3;

        // input name user
        System.out.println("=== Welcome to QuizQuest ===");
        System.out.print("Enter your name: ");
        String playerName = input.next();

        for (int i = 0; i<this.questions.length; i++) {
            Question currQuestion = questions[i];

            // print question
            System.out.println("--------------------");
            System.out.println((i+1) + ") " + currQuestion.getText());
            System.out.println("--------------------");
            
            // print choices
            String[] choices = currQuestion.getChoices();
            for (int j=0; j<choices.length; j++){
                System.out.println((j+1) + ". " + choices[j]);
            }

            // input answer, print and count correct
            int userAns = input.nextInt();
            if (currQuestion.checkAnswer(userAns-1)){
                System.out.println("--------------------");
                System.out.println("Correct!! : +1 Point");
                System.out.println("--------------------");
                correctCount++;
            }else{
                heart -= 1;
                System.out.println("--------------------");
                System.out.println("Wrong!! : heart remaining " + this.heart );
                System.out.println("--------------------");

                if (heart <= 0){
                    System.out.println("--------------------");
                    System.out.println("      Game Over     ");
                    System.out.println("--------------------");
                    input.close();
                    break;
                }
            }
        }
        input.close();

        return new Result(playerName, questions.length, correctCount, difficulty);
    }
}
