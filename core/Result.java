// 680510716
package core;

public class Result {
    // Attributes
    private String playerName;
    private int total;
    private int score;
    private String difficultyLevel;

    // Construcotr
    public Result(String name, int total, int score, String difficultyLevel) {
        this.playerName = name;
        this.total = total;
        this.score = score;
        this.difficultyLevel = difficultyLevel;
    }

    // Get
    public String getPlayerName(){return playerName;}
    public int getScore(){return score;}
    public String getDifficultyLevel(){return difficultyLevel;}

    // cal percentage
    public double computePercentage() {
        return (this.total == 0) ? 0 : (this.score * 100.0) / this.total;
    }

}
