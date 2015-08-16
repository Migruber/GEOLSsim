/**
 * 
 */
/**
 * @author Michael
 *
 */
package RandomMulti;

public class RandomMulti{
	
	private double RandomZero;
	private int Multipi;
	private int RandomSolution;
	
	public RandomMulti(int Multipli){
		this.RandomZero=Math.random();
		
	}
	
	public int GetRandom(int Multipli){
		this.Multipi=Multipli;
		double i=RandomZero*Multipli;
		this.RandomSolution=(int) i;
		return this.RandomSolution;
	}
}