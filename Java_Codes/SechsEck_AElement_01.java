// Porject Geo, Michael Gruber 1261139, Team Elmenreich; 20.07.2015
// Erstes Skript für 6Eck Kraft Berechnung

import java.util.Scanner;

public class SechsEck_AElement_01 {

	static Scanner in= new Scanner (System.in);
	/** On diesem Skript werden die Eckpunkte und der Mittelpunkt samt allen Kräften berechnet, die Ecken werden 2D berechnet
	 * der Mittelpunkt auf 3D Basis, dieser wird auch vermindert durch Abgabe in boden
	 eine händische Mitschrift zu diesem Skript samt Grafiken ist vorhanden, auch wurden dort array Positionen und Namen aufgelistet */
	
	// Ecken Knoten
	public static double[] e1= new double[4];
	public static double[] e2= new double[4];
	public static double[] m1= new double[4];
	public static double[] m2= new double[4];
	public static double[] a1= new double[4];
	public static double[] a2= new double[4];
	
	// Mittelpunkt
	public static double[] mi= new double[10];
	
	// GesamtMatrix, alle Werte
	public static double[][] Sa1= new double[4][10];
	
	// Neigung und Kraftgröße
	public static double Neigung;
	public static double[] Kraft= new double[3]; //[0] ist Eingabe - gerade; [1][2] rechter und linker Teil berechnet
	
	// Sinus und Cosinus Anteil der Neigung [0]sinus, [1]cosinus
	public static double SinCos[]= new double[2]; 
	public static double sin120= Math.sin(3.1415/180*120);
	public static double sin30=Math.sin(3.1415/180*30);
	public static double sin60=Math.sin(3.1415/180*60);
	
	
	// Methode zur einmaligen Berechnung des sinus und cosinus der geforderten Neigung
	public static double[] SinusCosinus(double Neigung){
		SinCos[0]=Math.sin(3.1415/180*Neigung);
		SinCos[1]=Math.cos(3.1415/180*Neigung);
		return SinCos;
	}
	
	// Methode rechnet einwirkende Kraft in rechts und links Anteil für Knoten um
	public static double[] Einwirkung(double[] Kraft){
		Kraft[1]=Kraft[0]/2; // einfach halbieren ohne aufteilung auf senkrecht und horizontal, man drückt eben im richtigen Winkel :)
		Kraft[2]=Kraft[0]/2;
		return Kraft;
	}
	
	
	// Methode berechnet, vergibt Ausgabnskräfte in Knoten [2][3]
	public static double[] KnotenEck(double[]Knoten){
		Knoten[2]=(Knoten[0]+Knoten[1])/2; // derweil wird Kraft noch geteilt , später direkt, jetzt kein Nachbar
		Knoten[3]=(Knoten[0]+Knoten[1])/2; // also Knoten[2]=Knoten[0];
		return Knoten;
	}
	
	public static double[] KnotenMiddle(double[] Knoten, double[] SinCos){
		Knoten[2]=sin60*Knoten[0]+sin60*Knoten[1];//Kraft gerade im Mittelpunkt
		Knoten[3]=0;//reserve
		Knoten[4]=SinCos[0]*Knoten[2];//Kraft vertikal in den Boden
		Knoten[5]=0;//Bodengegenkraft, Reibung, derweilen 0
		Knoten[6]=Knoten[2]-Knoten[4]-Knoten[5];// gerade Kraft Ausgang, minus Boden Vertikalkraft und Reibung
		Knoten[7]=((Knoten[6]/sin120)*sin30)/2;// Ausgangskraft links aus dem Mittelpunkt
		Knoten[8]=Knoten[7];// links ist gleich der rechten Ausgangskraft im Mittelpunkt
		Knoten[9]=0;//reserve
		return Knoten;
	}
	
	// Methode für Eingabe, Neigung und Kraft
	public static double[] Eingabe(){
		double[] ein= new double[2];
		System.out.println("Bitte geben Sie die Neigung ein, (0 bis 89°): ");
		ein[0]= in.nextDouble();
		System.out.println("Bitte geben Sie die einwirkende Kraft ein: ");
		ein[1]= in.nextDouble();
		return ein;
	}
	
	// Methode zur Ausgabe, ggF. später speicher in txt
	public static void Ausgabe(double[][] aus){
		System.out.println("Die einwirkenden Kräfte, 1.Zeile, e1 und e2 je links rechts");
		System.out.println(aus[0][0]+", "+aus[0][1]+", "+aus[0][2]+", "+aus[0][3]+" -- "+aus[0][5]+", "+aus[0][6]+", "+aus[0][7]+", "+aus[0][8]);
		System.out.println("Die einwirkenden Kräfte, 2.Zeile, m1 und m2 je links rechts");
		System.out.println(aus[1][0]+", "+aus[1][1]+", "+aus[1][2]+", "+aus[1][3]+" -- "+aus[1][5]+", "+aus[1][6]+", "+aus[1][7]+", "+aus[1][8]);
		System.out.println("Die einwirkenden Kräfte, 3.Zeile, a1 und a2 je links rechts");
		System.out.println(aus[2][0]+", "+aus[2][1]+", "+aus[2][2]+", "+aus[2][3]+" -- "+aus[2][5]+", "+aus[2][6]+", "+aus[2][7]+", "+aus[2][8]);
		System.out.println("Die einwirkenden Kräfte, 4.Zeile, mi: liEin, reEin, geradeEin, reserve, Vertokalkraft(Boden), geradeBoden(Gegenkraft),");
		System.out.println("geradeAus, liAus, reAus");
		System.out.println(aus[3][0]+", "+aus[3][1]+", "+aus[3][2]+", "+aus[3][3]+", "+aus[3][4]+", "+aus[3][5]+", "+aus[3][6]+", "+aus[3][7]+", "+aus[3][8]+", "+aus[3][9]);
		
	}
	
	// Teil der S Matrix die Werte zu, ggF. später gleich in gesamt Matrix
	public static double[][] SMatrix(double[] e1, double[] e2, double[] m1, double[] m2, double[] a1, double[] a2, double[] mi ){
		double [][] SMatrix= new double[4][10];
		// Zeile1 Eingangsecken
		SMatrix[0][0]=e1[0];SMatrix[0][1]=e1[1];SMatrix[0][2]=e1[2];SMatrix[0][3]=e1[3];SMatrix[0][4]=0;
		SMatrix[0][5]=e2[0];SMatrix[0][6]=e2[1];SMatrix[0][7]=e2[2];SMatrix[0][8]=e2[3];SMatrix[0][9]=0;
		// Zeile2 Mittelknoten
		SMatrix[1][0]=m1[0];SMatrix[1][1]=m1[1];SMatrix[1][2]=m1[2];SMatrix[1][3]=m1[3];SMatrix[1][4]=0;
		SMatrix[1][5]=m2[0];SMatrix[1][6]=m2[1];SMatrix[1][7]=m2[2];SMatrix[1][8]=m2[3];SMatrix[1][9]=0;
		// Zeile3 Ausgangsknoten
		SMatrix[2][0]=a1[0];SMatrix[2][1]=a1[1];SMatrix[2][2]=a1[2];SMatrix[2][3]=a1[3];SMatrix[2][4]=0;
		SMatrix[2][5]=a2[0];SMatrix[2][6]=a2[1];SMatrix[2][7]=a2[2];SMatrix[2][8]=a2[3];SMatrix[2][9]=0;
		// Middle Werte
		SMatrix[3][0]=mi[0];SMatrix[3][1]=mi[1];SMatrix[3][2]=mi[2];SMatrix[3][3]=mi[3];SMatrix[3][4]=mi[4];
		SMatrix[3][5]=mi[5];SMatrix[3][6]=mi[6];SMatrix[3][7]=mi[7];SMatrix[3][8]=mi[8];SMatrix[3][9]=mi[9];
		
		return SMatrix;
	}
	
	public static void main(String[] args) {
		
		double[] ein=Eingabe();
		Neigung=ein[0];
		SinCos=SinusCosinus(Neigung);
		Kraft[0]=ein[1];
		Kraft=Einwirkung(Kraft);
		//Eingangsecken
		e1[1]=Kraft[1];
		e1[0]=0; //derweilen ohne NachbarMatrix
		e2[0]=Kraft[2];
		e2[1]=0;
		e1=KnotenEck(e1);
		e2=KnotenEck(e2);
		//Mittelecken
		m1[0]=0; // derweilen 0 keine SE Nachbar
		m1[1]=e1[2];
		m2[0]=e2[3];
		m2[1]=0;
		m1=KnotenEck(m1);
		m2=KnotenEck(m2);
		//Kräfte im Mittelpunkt
		mi[0]=e1[3];
		mi[1]=e2[2];
		mi=KnotenMiddle(mi,SinCos);
		//Ausgangsecken
		a1[0]=m1[2];
		a1[1]=mi[7];
		a2[0]=mi[8];
		a2[1]=m2[3];
		a1=KnotenEck(a1);
		a2=KnotenEck(a2);
		//umspeichern der Daten in gesamt Matrix, samt Ausgabe üner Sa1 Matrix 
		Sa1=SMatrix(e1,e2,m1,m2,a1,a2,mi);
		Ausgabe(Sa1);
		
	}
}
