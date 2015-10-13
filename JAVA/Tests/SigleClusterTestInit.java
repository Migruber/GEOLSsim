package Tests;

import Cluster.Init_HexV1_Single_Cluster;
import Objects.HexV1_Single;

public class SigleClusterTestInit {

	 public static void PrintClusterFirst8x8(HexV1_Single[][] Cluster){
		for (int i=0;i<8;i++){
			//Cluster[2][2].PrintThisAngle();
				System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX(),0.0);
				System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX(),0.0);
				System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX(),0.0);
				System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0],0.0);
				System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
				System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX(),0.0);
				System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX(),0.0);
				System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX(),0.0);
				System.out.println("");
				i++;
				System.out.printf("IR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[0].getX(),0.0,Cluster[i][2].VarInput[0].getX(),0.0,Cluster[i][3].VarInput[0].getX(),0.0,Cluster[i][4].VarInput[0].getX(),0.0,Cluster[i][5].VarInput[0].getX(),0.0,Cluster[i][6].VarInput[0].getX(),0.0,Cluster[i][7].VarInput[0].getX());
				System.out.printf("IM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[1].getX(),0.0,Cluster[i][1].VarInput[1].getX(),0.0,Cluster[i][2].VarInput[1].getX(),0.0,Cluster[i][3].VarInput[1].getX(),0.0,Cluster[i][4].VarInput[1].getX(),0.0,Cluster[i][5].VarInput[1].getX(),0.0,Cluster[i][6].VarInput[1].getX(),0.0,Cluster[i][7].VarInput[1].getX());
				System.out.printf("IL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarInput[0].getX(),0.0,Cluster[i][1].VarInput[2].getX(),0.0,Cluster[i][2].VarInput[2].getX(),0.0,Cluster[i][3].VarInput[2].getX(),0.0,Cluster[i][4].VarInput[2].getX(),0.0,Cluster[i][5].VarInput[2].getX(),0.0,Cluster[i][6].VarInput[2].getX(),0.0,Cluster[i][7].VarInput[2].getX());
				System.out.printf("An: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].Angle90[0],0.0,Cluster[i][1].Angle90[0],0.0,Cluster[i][2].Angle90[0],0.0,Cluster[i][3].Angle90[0],0.0,Cluster[i][4].Angle90[0],0.0,Cluster[i][5].Angle90[0],0.0,Cluster[i][6].Angle90[0],0.0,Cluster[i][7].Angle90[0]);
				System.out.printf("Nf: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].GroundForceMass[0],0.0,Cluster[i][1].GroundForceMass[0],0.0,Cluster[i][2].GroundForceMass[0],0.0,Cluster[i][3].GroundForceMass[0],0.0,Cluster[i][4].GroundForceMass[0],0.0,Cluster[i][5].GroundForceMass[0],0.0,Cluster[i][6].GroundForceMass[0],0.0,Cluster[i][7].GroundForceMass[0],0.0);
				System.out.printf("OL: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[0].getX(),0.0,Cluster[i][1].VarOutput[0].getX(),0.0,Cluster[i][2].VarOutput[0].getX(),0.0,Cluster[i][3].VarOutput[0].getX(),0.0,Cluster[i][4].VarOutput[0].getX(),0.0,Cluster[i][5].VarOutput[0].getX(),0.0,Cluster[i][6].VarOutput[0].getX(),0.0,Cluster[i][7].VarOutput[0].getX());
				System.out.printf("OM: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[1].getX(),0.0,Cluster[i][1].VarOutput[1].getX(),0.0,Cluster[i][2].VarOutput[1].getX(),0.0,Cluster[i][3].VarOutput[1].getX(),0.0,Cluster[i][4].VarOutput[1].getX(),0.0,Cluster[i][5].VarOutput[1].getX(),0.0,Cluster[i][6].VarOutput[1].getX(),0.0,Cluster[i][7].VarOutput[1].getX());
				System.out.printf("OR: %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f %10.3f\n",0.0,Cluster[i][0].VarOutput[2].getX(),0.0,Cluster[i][1].VarOutput[2].getX(),0.0,Cluster[i][2].VarOutput[2].getX(),0.0,Cluster[i][3].VarOutput[2].getX(),0.0,Cluster[i][4].VarOutput[2].getX(),0.0,Cluster[i][5].VarOutput[2].getX(),0.0,Cluster[i][6].VarOutput[2].getX(),0.0,Cluster[i][7].VarOutput[2].getX());
				System.out.println("");
			}
	}

	
	public static void main(String[] args) {
		Init_HexV1_Single_Cluster Test= new Init_HexV1_Single_Cluster(8, 8, 500, 45);
		HexV1_Single[][] Cluster=Test.HexSingleCluster;
		PrintClusterFirst8x8(Cluster);
		
		
	}
	
	
}
