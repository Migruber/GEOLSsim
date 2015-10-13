package Tests;

import Objects.HexV1_Single;
/** @author GMVIDEO
 * @date 20150930
 * short class to test the HexV1Single object. Init 0,1,3 force and
 * print this values and the calculated outputs and middle forces.
 * Also the boolean vars can be control with this testbench.
 *
 */

public class SingelHexTest {


	public static void main(String[] args) {
		
		//HexV1_Single TestObject01 = new HexV1_Single();
		HexV1_Single TestObject02 = new HexV1_Single(45, 11000, 6);	

		
		TestObject02.PrintInForce1();
		System.out.println();
		TestObject02.PrintInForce2();
		System.out.println();
		TestObject02.PrintInForce3();
		System.out.println();
		TestObject02.PrintThisAngle();
		System.out.println();
		TestObject02.PrintNormalForce();
		System.out.println();
		TestObject02.PrintOutForce1();
		System.out.println();
		TestObject02.PrintOutForce2();
		System.out.println();
		TestObject02.PrintOutForce3();;
		System.out.println();
		
		TestObject02.SetInputForceHand(1, 1000, 15);
		TestObject02.CalculateForces();
		
		System.out.println();
		TestObject02.PrintInForce1();
		System.out.println();
		TestObject02.PrintInForce2();
		System.out.println();
		TestObject02.PrintInForce3();
		System.out.println();
		TestObject02.PrintThisAngle();
		System.out.println();
		TestObject02.PrintNormalForce();
		System.out.println();
		TestObject02.PrintOutForce1();
		System.out.println();
		TestObject02.PrintOutForce2();
		System.out.println();
		TestObject02.PrintOutForce3();
		System.out.println();
	}

}
