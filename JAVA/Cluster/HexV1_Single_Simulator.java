package Cluster;
import java.util.Scanner;
import Objects.HexV1_Single;

public class HexV1_Single_Simulator {
	
	static Scanner in = new Scanner(System.in);
	
	public static void PrintClusterFirst8x8(HexV1_Single[][] Cluster){
			for (int i=0;i<8;i++){
				//Cluster[2][2].PrintThisAngle();
					System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX(),0.0);
					System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX(),0.0);
					System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX(),0.0);
					System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0],0.0);
					System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
					//System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX(),0.0);
					//System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX(),0.0);
					//System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX(),0.0);
					System.out.println("");
					i++;
					System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX());
					System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX());
					System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX());
					System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0]);
					System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
					//System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX());
					//System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX());
					//System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX());
					System.out.println("");
				}
		}

	public static void PrintClusterForces(HexV1_Single[][] Cluster){
		for (int i=0;i<8;i++){
			//Cluster[2][2].PrintThisAngle();
				//System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX(),0.0);
				//System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX(),0.0);
				//System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX(),0.0);
				//System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0],0.0);
				System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
				//System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX(),0.0);
				//System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX(),0.0);
				//System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX(),0.0);
				System.out.println("");
				i++;
				//System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX());
				//System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX());
				//System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX());
				//System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0]);
				System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
				//System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX());
				//System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX());
				//System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX());
				System.out.println("");
			}
	}
		
		public static void main(String[] args) {
			int MinForceBorder=1;
			int Raw=8;
			int Column=8;
			Init_HexV1_Single_Cluster Test= new Init_HexV1_Single_Cluster(Raw, Column, (1000/9.80665), 45);
			HexV1_Single[][] Cluster=Test.HexSingleCluster;
			Cluster[2][4].SetInputForceHand(1, 20000, 15);
			PrintClusterFirst8x8(Cluster);
			System.out.print("Any number for continue: ");
			in.nextInt();
			System.out.println(" \n");
			
			//Cluster[0][2].VarInput[0].setX(1000.0);
			//Cluster[0][2].VarInput[2].setY(45);
			//Cluster[0][4].SetInputForceHand(1, 20000, 45);
			
			int controll=0;
			
			while(controll==0){
				
				for(int i=0;i<Raw;i++){
					for(int j=0;j<Column;j++){
						
						for (int k=0;k<3;k++){
							Cluster[i][j].VarOutput[k].setXYdefault();
						}
						
						if(Cluster[i][j].InputActive[0]==true||Cluster[i][j].InputActive[1]==true||Cluster[i][j].InputActive[2]==true){
							Cluster[i][j].CalculateForces();
							int ID=Cluster[i][j].ClusterElement;
							
							switch(ID){
							case 0:{
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][0].VarInput[1].setX((Cluster[i+2][0].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][0].VarInput[1].setY((Cluster[i][j].Angle90[0]));
									Cluster[i+2][0].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][0].VarInput[2].setX((Cluster[i+1][2].VarInput[1].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][0].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][0].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
							
							case 1:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[0].setX((Cluster[i+1][j].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j+1].VarInput[2].setX((Cluster[i+1][j+1].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j+1].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j+1].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
								
							case 2:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j-1].VarInput[0].setX((Cluster[i+1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[2].setX((Cluster[i+1][j].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
								
							case 3:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[1][j-1].VarInput[0].setX((Cluster[1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[2][j].VarInput[1].setX((Cluster[2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								break;}
								
							case 4:{
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY((Cluster[i][j].Angle90[0]));
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[2].setX((Cluster[i+1][j].VarInput[1].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
								
							case 5:{
								if(j<7){
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[0].setX((Cluster[i+1][j].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j+1].VarInput[2].setX((Cluster[i+1][j+1].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j+1].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j+1].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}}
								break;}
								
							case 6:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j-1].VarInput[0].setX((Cluster[i+1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}
								break;}
								
							case 7:{
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][0].VarInput[2].setX((Cluster[i+1][0].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][0].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][0].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
								
							case 8:{
								break;}
								
							case 9:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j-1].VarInput[0].setX((Cluster[i+1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[2].setX((Cluster[i+1][j].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}
								break;}
								
							case 10:{
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j-1].VarInput[0].setX((Cluster[i+1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								break;}
							case 11:{
								if(j<7&&i<7){
								if(Cluster[i][j].VarOutput[0].getX()>MinForceBorder){
									Cluster[i+1][j-1].VarInput[0].setX((Cluster[i+1][j-1].VarInput[0].getX()+Cluster[i][j].VarOutput[0].getX()));
									Cluster[i+1][j-1].VarInput[0].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j-1].InputActive[0]=true;
									Cluster[i][j].VarOutput[0].setXYdefault();
									Cluster[i][j].InputActive[0]=false;
								}
								if(i<6){
								if(Cluster[i][j].VarOutput[1].getX()>MinForceBorder){
									Cluster[i+2][j].VarInput[1].setX((Cluster[i+2][j].VarInput[1].getX()+Cluster[i][j].VarOutput[1].getX()));
									Cluster[i+2][j].VarInput[1].setY(Cluster[i][j].Angle90[0]);
									Cluster[i+2][j].InputActive[1]=true;
									Cluster[i][j].VarOutput[1].setXYdefault();
									Cluster[i][j].InputActive[1]=false;
								}}
								if(Cluster[i][j].VarOutput[2].getX()>MinForceBorder){
									Cluster[i+1][j].VarInput[2].setX((Cluster[i+1][j].VarInput[2].getX()+Cluster[i][j].VarOutput[2].getX()));
									Cluster[i+1][j].VarInput[2].setY(Cluster[i][j].Angle30[0]);
									Cluster[i+1][j].InputActive[2]=true;
									Cluster[i][j].VarOutput[2].setXYdefault();
									Cluster[i][j].InputActive[2]=false;
								}}
								break;}
								
							default:
								break;
							}
							
							for (int k=0;k<3;k++){
								Cluster[i][j].VarInput[k].setXYZdefault();
							}
						
						}
					}
				}
				
				
				PrintClusterForces(Cluster);
				//System.out.print("0 for continue, other number for exit: ");
				//controll=in.nextInt();
				//System.out.println(" \n");
				controll=1;
			}
			
			System.out.println(" ");
			System.out.println("Thanks, copyright GEOLSsim; MG,WE");
			
		}

}
