package Cluster;

import Objects.HexV1_Single;

/**@author GMVIDEO
 * @date 20150930
 * this class init a HexV1_Single Matrix:
 * inputs: 
 * nxm size
 * mass
 * angle
 * the angle will calculate random, so any element has different angles
 * the element ID is init in this class to
 * A=0; B=1; C=2; D=3; E=4; F=5; G=6; H=7; I=8; J=9; K=10; 
 */
public class Init_HexV1_Single_Cluster {
	
	public int ClusterColumn; 	//weight
	public int ClusterRaw;		//length
	public HexV1_Single[][] HexSingleCluster;
	public double middleAngle;
	private double randomAngle;
	
	public Init_HexV1_Single_Cluster(int w, int h, double mass,double angle){
		this.ClusterColumn=w;
		this.ClusterRaw=h;
		this.middleAngle=angle;
		HexV1_Single[][] Cluster= new HexV1_Single[h][w];
		for(int i=0;i<w;i++){
			for(int j=0;j<h;j++){
				RandomAngle();
				Cluster[i][j]=new HexV1_Single(randomAngle, mass, 5);
			}
		}
		
		// set the Cluster element ID
		this.HexSingleCluster=Cluster;
		this.HexSingleCluster[0][0].SetClusterElement(0);
		for (int i=0; i<w;i++){
			this.HexSingleCluster[1][i].SetClusterElement(1);
		}
		for(int i=1;i<(w-1);i++){
			this.HexSingleCluster[0][1].SetClusterElement(2);
		}
		this.HexSingleCluster[0][w-1].SetClusterElement(3);
		for(int i=2;i<(h-1);i+=2){
			this.HexSingleCluster[i][0].SetClusterElement(4);
		}
		for(int i=2;i<(h-1);i+=2){
			this.HexSingleCluster[i][w-1].SetClusterElement(6);
		}
		this.HexSingleCluster[h-2][0].SetClusterElement(7);
		for(int i=0;i<w;i++){
			this.HexSingleCluster[h-1][i].SetClusterElement(8);
		}
		for(int i=1;i<(w-1);i++){
			this.HexSingleCluster[h-2][i].SetClusterElement(9);
		}
		this.HexSingleCluster[h-1][w-1].SetClusterElement(10);
		for (int i=2;i<(h-1);i+=2){
			for(int j=1;j<w-1;j++){
				this.HexSingleCluster[i][j].SetClusterElement(11);
			}
		}
	}
	
	
	/**Random element angle +-10°
	 */
	public void RandomAngle(){
		randomAngle=middleAngle-10+((Math.random()*20));
		
	}
}
