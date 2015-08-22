import java.util.Scanner;

public class Test_RandomSolution {

	static Scanner in= new Scanner (System.in);

	/**
	 * @author Michael Alexander Gruber - GEOLSsim
	 * @date 201508 -Version:1.0
	 * @brief Test Program, old versions under commend 
	 */
	public static void main(String[] args) {
	
		
		
		/**
		 * first Part, Random test
		 */
		int Solution;
		int Multivier;
		System.out.println("Enter Range of Random, Start: 0 to: ");
		Multivier=in.nextInt();
		for (int i=0; i<10;i++){
			Solution=RandomSolution.RandomSol(Multivier);
			System.out.println((i+1)+". Random Solution: "+Solution);
		}

	}

}
