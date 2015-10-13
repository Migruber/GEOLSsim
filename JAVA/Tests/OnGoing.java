package Tests;



public class OnGoing {

	public static void main(String[] args) {
		//double m=45;
		//double randomAngle=m-10+((Math.random()*20));
		
		//System.out.println(randomAngle);
		//Init_HexV1_Single_Cluster Test= new Init_HexV1_Single_Cluster(10, 10, 10000, 45);
		//HexV1_Single[][] Cluster=Test.HexSingleCluster;
		
		//Cluster[2][2].PrintThisAngle();
		
		double[][] clu=new double[8][8];
		double force=1.12;
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				clu[i][j]=force;
				force+=1.8;
			}
		}
		//PrintFirst8x8Elements michi= new PrintFirst8x8Elements(clu);
		//michi.printCluster();
		

	}

}
