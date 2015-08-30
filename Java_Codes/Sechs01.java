import java.util.Scanner;

public class Sechs01 {
//Michi
	static Scanner in= new Scanner (System.in);
	
	// Eingangskraftknoten oben
	public static double[] e1= new double[4]; 
	public static double[] e2= new double[4];
	// Ausgangsknoten unten
	public static double[] a1= new double[4]; 
	public static double[] a2= new double[4]; 
	// Mittelknoten
	public static double[] m1= new double[4]; 
	public static double[] m2= new double[4];
	// Matrix für alle Knotendaten, sieh händische Mitschrift
	public static double[][] points1= new double[6][5];
	
	// Mittelpnuktknoten, Neigung
	public static double[] middle1= new double[6]; 
	public static double neigung= 10;// Eingabe in Grad also umrechnen auf rad 
	// Einwirkende Kraft derweilen immer gerade von oben
	public static double []middle2= new double[6]; 
	
	public static double sin120=Math.sin(120);
	public static double sin30=Math.sin(30);
	
	public static double [] eingangskraft(double [] mittelkraft1){
		double gerade2d, rechts2d, links2d;
		mittelkraft1[1]=Math.cos(neigung)*mittelkraft1[0];
		gerade2d=Math.sin(neigung)*mittelkraft1[0];
		rechts2d=((sin30*(gerade2d/sin120))+0)/2;
		links2d=rechts2d+0;	//Nebenkräfte also plus eine Addition
		mittelkraft1[2]=0;
		mittelkraft1[3]=0;
		mittelkraft1[4]=links2d;
		mittelkraft1[5]=rechts2d;
		return mittelkraft1;
	}
	
	public static double[] knotenE(double[] knoten){
		knoten[2]=knoten[0]/2+knoten[1]/2;
		knoten[3]=knoten[0]/2+knoten[1]/2;
		return knoten;
	}
	
	public static double[] knotenM(double[] knoten){
		knoten[2]=knoten[0]/2+knoten[1]/2;
		knoten[3]=knoten[0]/2+knoten[1]/2;
		return knoten;
	}
	
	public static double[] knotenA(double[] knoten){
		knoten[2]=knoten[0]/2+knoten[1]/2;
		knoten[3]=knoten[0]/2+knoten[1]/2;
		return knoten;
	}
	
	public static double[] middle(double[] mpoint){
	
		mpoint[4]=mpoint[3];
		mpoint[5]=mpoint[2];
		mpoint[1]=((sin120*(mpoint[3]/sin30))/2)*((sin120*(mpoint[4]/sin30))/2);
		mpoint[0]=mpoint[1]/Math.cos(neigung);
		return mpoint;
	}
	
	
	public static void main(String[] args) {
		System.out.println("Bitte geben Sie Neigung an: ");
		neigung= in.nextDouble();
	
		System.out.println("Bitte geben Sie die einwirkende Kraft an: ");
		middle2[0]= in.nextDouble();
		
		middle2=eingangskraft(middle2);
		e1[0]=middle2[4];
		e1[1]=0;
		e2[0]=middle2[5];
		e2[1]=0;	// andere Nachbarbeziehungen derweilen 0
		e1=knotenE(e1);
		e2=knotenE(e2);
		
		
		m1[0]=0;
		m1[1]=e1[2];
		m2[0]=e2[3];
		m1=knotenM(m1);
		m2=knotenM(m1);
		
		middle1[2]=e1[3];
		middle1[3]=e2[2];
		middle1=middle(middle1);
		
		a1[0]=middle1[4];
		a2[1]=middle1[5];
		a1[1]=m1[3];
		a2[0]=m2[2];
		a1=knotenA(a1);
		a2=knotenA(a2);
		
		System.out.println("In Eingangsecke E1 wirken Eingang li: "+e1[0]+" Eingang re: "+e1[1]);
		System.out.println("Ausgang li: "+e1[2]+" Ausgang re: "+e1[3]);
		System.out.println("In Eingangsecke E2 wirken Eingang li: "+e2[0]+" Eingang re: "+e2[1]);
		System.out.println("Ausgang li: "+e2[2]+" Ausgang re: "+e2[3]);
		System.out.println("In Mittelecke M1 wirken Eingang li: "+m1[0]+" Eingang re: "+m1[1]);
		System.out.println("Ausgang li: "+m1[2]+" Ausgang re: "+m1[3]);
		System.out.println("In Mittelecke M2 wirken Eingang li: "+m2[0]+" Eingang re: "+m2[1]);
		System.out.println("Ausgang li: "+m2[2]+" Ausgang re: "+m2[3]);
		System.out.println("In Ausgangsecke A1 wirken Eingang li: "+a1[0]+" Eingang re: "+a2[1]);
		System.out.println("Ausgang li: "+a1[2]+" Ausgang re: "+a1[3]);
		System.out.println("In Ausgangsecke A2 wirken Eingang li: "+a2[0]+" Eingang re: "+a2[1]);
		System.out.println("Ausgang li: "+a2[2]+" Ausgang re: "+a2[3]);
		
		System.out.println("Im Mittelunkt wirken folgende Kräfte: ");
		
	}

}
