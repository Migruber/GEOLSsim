public class RandomSolution {

	/**@brief RandomSolution
	 * @param Multivier int; Range of Random, zero to Multivier
	 * @param RaNo double; Variable for a Math.Random number 0 to 1
	 * @param Solution int; Variable for the Solution=RaNo*Multivier
	 * @return Solution int; to other classes \n
	 * 
	 * @brief This short code implements a Random Integer between Zero and the
	 * border of, here the Multivier. The Multivier will given from the parent class
	 * and this code Method returns the Solution
	 */
	public static int RandomSol(int Multivier){
		double RaNo;
		int Solution = 0;
		
		RaNo=Math.random();
		Solution=(int)(RaNo*(Multivier+1));
		//System.out.println("The Random Solution is: "+Solution);
		return Solution;
	}
	/**@brief RandomGenerator
	 * @author Michael Alexander Gruber - GeoLssim
	 * @date 201508 - Version 1.0
	 * 
	 * @param args void argument String
	 * @brief The Method Random Solution gives a Random Number return, the user
	 * can change the Range starting with zero to the variable Multivier+1 
	 */
	

}
