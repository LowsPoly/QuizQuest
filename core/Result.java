// 680510716

package core;

public class Result {
	// Attributes
	private int total;
	private int score;

	// Construcotr
	public Result(int total, int score)
	{
		this.total = total;
		this.score = score;
	}
	
	public int getScore()
	{
		return this.score;
	}

	// Public Methods
	public double computePercentage()
	{
		return (this.score * 100.0) / this.total;
	}
}
