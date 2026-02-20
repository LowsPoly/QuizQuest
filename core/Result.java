// 680510716

package core;

public class Result {
	// Attributes
	private int total;
	private int correct;

	// Construcotr
	public Result(int total, int correct)
	{
		this.total = total;
		this.correct = correct;
	}

	// Public Methods
	public double computePercentage()
	{
		return (this.correct * 100.0) / this.total;
	}
}
