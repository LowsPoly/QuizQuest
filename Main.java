// 680510716

import core.*;
import java.util.List;
import loader.QuestionLoader;


/* * 1. โหลดคำถาม: 
 * QuestionLoader loader = new QuestionLoader();
 * Question[] questions = loader.load("path/to/file.json");
 * * 2. เริ่มเกม: 
 * QuizEngine engine = new QuizEngine(questions, "Difficulty");
 * Result result = engine.initialise();
 * * 3. บันทึกคะแนน: 
 * LeaderboardManager.saveResult(result);
 * * 4. ดึงตารางคะแนนมาโชว์: 
 * List<Result> scores = LeaderboardManager.loadResults();
 * * 5. เช็คคำตอบ:
 * question.checkAnswer(index); // คืนค่า true/false
 */


public class Main {

    public static void main(String[] args) {
        QuestionLoader loader = new QuestionLoader();
        Question[] questions = loader.load("data/hard/computer_1.json");
        
        if (questions.length > 0) {
            QuizEngine engine = new QuizEngine(questions, "Hard");
            Result gameResult = engine.initialise();
            
            LeaderboardManager.saveResult(gameResult);
        }

        System.out.println("\n===============================");
        System.out.println("          LEADERBOARD          ");
        System.out.println("===============================");
        System.out.printf("%-15s %-10s %-10s\n", "Player", "Score", "Difficulty");
        System.out.println("-------------------------------");

        List<Result> topScores = LeaderboardManager.loadResults();
        if (topScores.isEmpty()) {
            System.out.println("      No records found.        ");
        } else {
            for (Result r : topScores) {
                System.out.printf("%-15s %-10d %-10s\n", 
                    r.getPlayerName(), 
                    r.getScore(), 
                    r.getDifficultyLevel());
            }
        }
        System.out.println("===============================");
    }
}
