
import java.util.Scanner;
import Objects_Geolssim.Vector3D_Double;
import Objects_Geolssim_OldClasses_NotUsedClasses.Vector3D_Int;
import Objects_Geolssim_OldClasses_NotUsedClasses.Vector3D_String;

public class Test_newObjects {
	static Scanner in= new Scanner (System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vector3D_Double testdouble= new Vector3D_Double(1, 2, 3);
		testdouble.printVector();
		double i =testdouble.getX();
		System.out.println(i);
		testdouble.setX(5);
		testdouble.printVector();
		
		Vector3D_Int testint = new Vector3D_Int(1, 1, 1);
		testint.printVector();
		int j =testint.getZ();
		System.out.println(j);
		testint.setY(3);
		testint.printVector();
		
		Vector3D_String testString= new Vector3D_String("Ich ", "bin nur ein ", "Test!");
		testString.printVector();
		String k=testString.getZ();
		System.out.println(k);
		testString.setZ("TestTestTest");
		testString.printVector();

	}

}
