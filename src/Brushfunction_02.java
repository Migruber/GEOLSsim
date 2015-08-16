
import java.util.Scanner;

/**
 * 
 * @brief This program implement a Matrix - Cluster. The second version of the brush
 * function, here a random calculation is added.
 * The user enter the cluster size, number of applied forces. After a sequence of Clusters
 * will be given in the output, later this matrix should shown graphically.\n
 * 
 * Input Variables: Width, Length and Applied Force Sequence Size \n
 * 
 * Output: Cluster Matrix numerically and graphically, one per Force. 
 * 
 * Backbone is a 3D array, this can be implement as a hexagonal pattern too, as describe
 * in Sciddica
 *  
 * Next step - version 03: \n
 * 
 * 
 * @author Michael Gruber Alexander
 * @date 201508 Version 02
 */
public class Brushfunction_02 {
	static Scanner in= new Scanner (System.in);
	
	
	/** @brief Gm
	 *  @brief Say Goodbye
	 */
	public static void Gm(){
		System.out.println("Thank's for using the Random Cluster Brush Tools");
		System.out.println("copyright GM, GEOLSsim");
	}
	
	/** @brief PrintMatrix
	 * @brief Method to print a Cluster, element wise
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int,  Length
	 */
	public static void PrintMatrix(double[][] ForceMatrix, int MB, int ML){
		
		for (int i=0; i<ML;i++){
			for(int j=0;j<MB;j++){
				System.out.print(ForceMatrix[j][i]+" ");
			}
			System.out.println("");
		}
	}
	

	
	/** @brief FillMatrix
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int,  Length
	 * @param MZF double, Zero Force
	 * @return ForceMatrix double[][] \n
	 * @brief Fill Cluster Elements with Zero Force  
	 */
	public static double[][] FillMatrix (double[][] ForceMatrix, int MB, int ML, double MZF){
		for (int i=0; i<ML;i++){
			for(int j=0;j<MB;j++){
				ForceMatrix[j][i]=MZF;
			}
		}
		return ForceMatrix;
	}

	/** @brief BrushPoint
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int, Cluster Length
	 * @param Fo double, applied Force
	 * @param Pos int[], 2D array column[0] and line[1] position
	 * @return new Cluster \n
	 * @brief the acting force is added only to the central Element \n
		 * 0%.000%.0% \n
		 * 0%.100%.0% \n
		 * 0%.000%.0%
	 */
	public static double [][] BrushPoint(double [][] ForceMatrix, int MB, int ML, double Fo, int [] Pos ){
		
		ForceMatrix[Pos[0]][Pos[1]]=ForceMatrix[Pos[0]][Pos[1]]+(Fo);
		return ForceMatrix;
	}
	
	/** @brief BrushSmall
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int, Cluster Length
	 * @param Fo double, applied Force
	 * @param Pos int[], 2D array column[0] and line[1] position
	 * @return new Cluster \n
	 * @brief The action force is added to the central Element and the first neighbor \n
	 	* 000% 000% 000% 000% 000% \n
	 	* 000% 050% 050% 050% 000% \n
	 	* 000% 050% 100% 050% 000% \n
	 	* 000% 050% 050% 050% 000% \n
	 	* 000% 000% 000% 000% 000%
	 */
	public static double [][] BrushSmall(double [][] ForceMatrix, int MB, int ML, double Fo, int [] Pos ){
		double damping=0.5;
		ForceMatrix[Pos[0]][Pos[1]]=ForceMatrix[Pos[0]][Pos[1]]+(Fo);
		
		if((Pos[1]-1)>=0){
			for(int i=(Pos[0]-1);i<(Pos[0]+2);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-1]=ForceMatrix[i][Pos[1]-1]+(Fo*damping);
				}
			}
		}
		
		if((Pos[0]-1>=0))
			ForceMatrix[Pos[0]-1][Pos[1]]=ForceMatrix[Pos[0]-1][Pos[1]]+(Fo*damping);
		if((Pos[0]+1<MB))
			ForceMatrix[Pos[0]+1][Pos[1]]=ForceMatrix[Pos[0]+1][Pos[1]]+(Fo*damping);
		
		if((Pos[1]+1)<ML){
			for(int i=Pos[0]-1;i<Pos[0]+2;i++){
				if(i>=0&&i<MB)
					ForceMatrix[i][Pos[1]+1]=ForceMatrix[i][Pos[1]+1]+(Fo*damping);
			}
		}
		
		return ForceMatrix;
	
	}
	
	/** @brief BrushMedium
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int, Cluster Length
	 * @param Fo double, applied Force
	 * @param Pos int[], 2D array column[0] and line[1] position
	 * @return new Cluster \n
	 * @brief The action force is added to the central Element, first and second neighbor \n
	 	* 000% 000% 000% 000% 000% 000% 000% \n
	 	* 000% 035% 035% 035% 035% 035% 000% \n
	 	* 000% 035% 065% 065% 065% 035% 000% \n
	 	* 000% 035% 065% 100% 065% 035% 000% \n
	 	* 000% 035% 065% 065% 065% 035% 000% \n
	 	* 000% 035% 035% 035% 035% 035% 000% \n
	 	* 000% 000% 000% 000% 000% 000% 000% \n
	 */
	public static double [][] BrushMedium(double [][] ForceMatrix, int MB, int ML, double Fo, int [] Pos ){
		double damping=0.6;
		double damping1=0.3;
		ForceMatrix[Pos[0]][Pos[1]]=ForceMatrix[Pos[0]][Pos[1]]+(Fo);
		
		if((Pos[1]-2)>=0){
			for(int i=(Pos[0]-2);i<(Pos[0]+3);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-2]=ForceMatrix[i][Pos[1]-2]+(Fo*damping1);
				}
			}
		}
		
		if((Pos[1]-1)>=0){
			for(int i=(Pos[0]-1);i<(Pos[0]+2);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-1]=ForceMatrix[i][Pos[1]-1]+(Fo*damping);
				}
			}
			if(Pos[0]-2>=0)
				ForceMatrix[Pos[0]-2][Pos[1]-1]=ForceMatrix[Pos[0]-2][Pos[1]-1]+(Fo*damping1);
			if(Pos[0]+2<MB)
				ForceMatrix[Pos[0]+2][Pos[1]-1]=ForceMatrix[Pos[0]+2][Pos[1]-1]+(Fo*damping1);
			
		}
		
		if((Pos[0]-1>=0))
			ForceMatrix[Pos[0]-1][Pos[1]]=ForceMatrix[Pos[0]-1][Pos[1]]+(Fo*damping);
		if((Pos[0]+1<MB))
			ForceMatrix[Pos[0]+1][Pos[1]]=ForceMatrix[Pos[0]+1][Pos[1]]+(Fo*damping);
		if(Pos[0]-2>=0)
			ForceMatrix[Pos[0]-2][Pos[1]]=ForceMatrix[Pos[0]-2][Pos[1]]+(Fo*damping1);
		if(Pos[0]-2<MB)
			ForceMatrix[Pos[0]+2][Pos[1]]=ForceMatrix[Pos[0]+2][Pos[1]]+(Fo*damping1);
		
		if((Pos[1]+1)<ML){
			for(int i=Pos[0]-1;i<Pos[0]+2;i++){
				if(i>=0&&i<MB)
					ForceMatrix[i][Pos[1]+1]=ForceMatrix[i][Pos[1]+1]+(Fo*damping);
			}
			if(Pos[0]-2>=0)
				ForceMatrix[Pos[0]-2][Pos[1]+1]=ForceMatrix[Pos[0]-2][Pos[1]+1]+(Fo*damping1);
			if(Pos[0]+2<MB)
				ForceMatrix[Pos[0]+2][Pos[1]+1]=ForceMatrix[Pos[0]+2][Pos[1]+1]+(Fo*damping1);
		}
		
		if((Pos[1]+2)<ML){
			for(int i=(Pos[0]-2);i<(Pos[0]+3);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]+2]=ForceMatrix[i][Pos[1]+2]+(Fo*damping1);
				}
			}
		}
		return ForceMatrix;
	}
	
	/** @brief BrushTall
	 * @param ForceMatrix double[][], Cluster to print
	 * @param MB int, Cluster Width
	 * @param ML int, Cluster Length
	 * @param Fo double, applied Force
	 * @param Pos int[], 2D array column[0] and line[1] position
	 * @return new Cluster \n
	 * @brief The action force is added to the central Element, first and second neighbor \n
	 	* 000% 000% 000% 000% 000% 000% 000% 000% 000% \n
	 	* 000% 025% 025% 025% 025% 025% 025% 025% 000% \n
	 	* 000% 025% 050% 050% 050% 050% 050% 025% 000% \n
	 	* 000% 025% 050% 075% 075% 075% 050% 025% 000% \n
	 	* 000% 025% 050% 075% 100% 075% 050% 025% 000% \n
	 	* 000% 025% 050% 075% 075% 075% 050% 025% 000% \n
	 	* 000% 025% 050% 050% 050% 050% 050% 025% 000% \n
	 	* 000% 025% 025% 025% 025% 025% 025% 025% 000% \n
	 	* 000% 000% 000% 000% 000% 000% 000% 000% 000% \n
	 */
	public static double [][] BrushTall(double [][] ForceMatrix, int MB, int ML, double Fo, int [] Pos ){
		double damping=0.75;
		double damping1=0.5;
		double damping2=0.25;
		ForceMatrix[Pos[0]][Pos[1]]=ForceMatrix[Pos[0]][Pos[1]]+(Fo);
		// a new commend for GIT
		if((Pos[1]-3)>=0){
			for(int i=(Pos[0]-3);i<(Pos[0]+4);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-3]=ForceMatrix[i][Pos[1]-3]+(Fo*damping2);
				}
			}
		}
		
		if((Pos[1]-2)>=0){
			for(int i=(Pos[0]-2);i<(Pos[0]+3);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-2]=ForceMatrix[i][Pos[1]-2]+(Fo*damping1);
				}
			}
			if(Pos[0]-3>=0)
				ForceMatrix[Pos[0]-3][Pos[1]-2]=ForceMatrix[Pos[0]-3][Pos[1]-2]+(Fo*damping2);
			if(Pos[0]+3<MB)
				ForceMatrix[Pos[0]+3][Pos[1]-2]=ForceMatrix[Pos[0]+3][Pos[1]-2]+(Fo*damping2);
		}
		
		if((Pos[1]-1)>=0){
			for(int i=(Pos[0]-1);i<(Pos[0]+2);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]-1]=ForceMatrix[i][Pos[1]-1]+(Fo*damping);
				}
			}
			if(Pos[0]-2>=0)
				ForceMatrix[Pos[0]-2][Pos[1]-1]=ForceMatrix[Pos[0]-2][Pos[1]-1]+(Fo*damping1);
			if(Pos[0]+2<MB)
				ForceMatrix[Pos[0]+2][Pos[1]-1]=ForceMatrix[Pos[0]+2][Pos[1]-1]+(Fo*damping1);
			if(Pos[0]-3>=0)
				ForceMatrix[Pos[0]-3][Pos[1]-1]=ForceMatrix[Pos[0]-3][Pos[1]-1]+(Fo*damping2);
			if(Pos[0]+3<MB)
				ForceMatrix[Pos[0]+3][Pos[1]-1]=ForceMatrix[Pos[0]+3][Pos[1]-1]+(Fo*damping2);
		}
		
		if((Pos[0]-1>=0))
			ForceMatrix[Pos[0]-1][Pos[1]]=ForceMatrix[Pos[0]-1][Pos[1]]+(Fo*damping);
		if((Pos[0]+1<MB))
			ForceMatrix[Pos[0]+1][Pos[1]]=ForceMatrix[Pos[0]+1][Pos[1]]+(Fo*damping);
		if(Pos[0]-2>=0)
			ForceMatrix[Pos[0]-2][Pos[1]]=ForceMatrix[Pos[0]-2][Pos[1]]+(Fo*damping1);
		if(Pos[0]+2<MB)
			ForceMatrix[Pos[0]+2][Pos[1]]=ForceMatrix[Pos[0]+2][Pos[1]]+(Fo*damping1);
		if(Pos[0]-3>=0)
			ForceMatrix[Pos[0]-3][Pos[1]]=ForceMatrix[Pos[0]-3][Pos[1]]+(Fo*damping2);
		if(Pos[0]+3<MB)
			ForceMatrix[Pos[0]+3][Pos[1]]=ForceMatrix[Pos[0]+3][Pos[1]]+(Fo*damping2);
		
		if((Pos[1]+1)<ML){
			for(int i=Pos[0]-1;i<Pos[0]+2;i++){
				if(i>=0&&i<MB)
					ForceMatrix[i][Pos[1]+1]=ForceMatrix[i][Pos[1]+1]+(Fo*damping);
			}
			if(Pos[0]-2>=0)
				ForceMatrix[Pos[0]-2][Pos[1]+1]=ForceMatrix[Pos[0]-2][Pos[1]+1]+(Fo*damping1);
			if(Pos[0]+2<MB)
				ForceMatrix[Pos[0]+2][Pos[1]+1]=ForceMatrix[Pos[0]+2][Pos[1]+1]+(Fo*damping1);
			if(Pos[0]-3>=0)
				ForceMatrix[Pos[0]-3][Pos[1]+1]=ForceMatrix[Pos[0]-3][Pos[1]+1]+(Fo*damping2);
			if(Pos[0]+3<MB)
				ForceMatrix[Pos[0]+3][Pos[1]+1]=ForceMatrix[Pos[0]+3][Pos[1]+1]+(Fo*damping2);
		}
		
		if((Pos[1]+2)<ML){
			for(int i=(Pos[0]-2);i<(Pos[0]+3);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]+2]=ForceMatrix[i][Pos[1]+2]+(Fo*damping1);
				}
			}
			if(Pos[0]-3>=0)
				ForceMatrix[Pos[0]-3][Pos[1]+2]=ForceMatrix[Pos[0]-3][Pos[1]+2]+(Fo*damping2);
			if(Pos[0]+3<MB)
				ForceMatrix[Pos[0]+3][Pos[1]+2]=ForceMatrix[Pos[0]+3][Pos[1]+2]+(Fo*damping2);
		}
		
		if((Pos[1]+3)<ML){
			for(int i=(Pos[0]-3);i<(Pos[0]+4);i++){
				if(i>=0&&i<MB){
					ForceMatrix[i][Pos[1]+3]=ForceMatrix[i][Pos[1]+3]+(Fo*damping2);
				}
			}
		}
		return ForceMatrix;
	}
	
	
	/**
	 * @brief main class.
	 * 1. init all variables
	 * 2. outer loop to repeat a simulation with a new cluster \n
	 * 2.1 Input Width, Length and zero force of the Matrix \n
	 * 2.2 Init a new Matrix with user Length, Width and zero force with Method FillMatrix \n
	 * 3. inner loop to repeat with the old simulated values and the same matrix - Cluster
	 * 3.1 Output of the Matrix \n
	 * 3.2 Input Brush Width \n
	 * 3.3 input applied force \n
	 * 3.4 Case Loop brush width \n
	 * 3.4.1 Call Method: BrushPoint or BrushSmall or BrushMedium or BrushTall \n
	 * 3.4.2 Print Method: print new calculated Matrix \n
	 * 3.5 request: exit, new Matrix, simulate again with this calculated Matrix 
	 * 4. Exit, close program with Method GM()
	 *
	 * @param Reapetnew int variable for outer loop - for simulate a new cluster - init new matrix
	 * @param Repeatold int variable for inner loop - for simulate with the old cluster values 
	 * @param MatrixWidth int variable for the width of the cluster
	 * @param MatrixLength int variable for the length of the cluster
	 * @param MatrixZeroForce double variable for the first force to Matrix elements
	 * for all elements the same, init start value
	 * @param BrushSize int variable for brush size: 0 just a point; 1 point and first neighbor;
	 * 2 point, first and second neighbor; 3 point, first second and third neighbor
	 * @param MatrixForce double variable for applied force
	 * @param ForcePosition int[2] array for [0]=column; [1]=line
	 * @param ForceMatrix double[MatrixWidth][MatrixLength] 3D array, the Cluster the Matrix
	 */
	public static void main(String[] args) {
	
		int ClusterWeidth;
		int ClusterLength;
		int Passages;
		int BrushSize;
		int ForceMax;
		
		System.out.println("Welcome, Cluster - Matrix Filler, Random Generator");
		System.out.println("Please enter Cluster Width: ");
		ClusterWeidth= in.nextInt();
		System.out.println("Please enter Cluster Length: ");
		ClusterLength= in.nextInt();
		
		double [][] Cluster= new double [ClusterWeidth][ClusterLength];
		Cluster= FillMatrix(Cluster,ClusterWeidth,ClusterLength,0);
		
		System.out.println("How many passages (single force effects) you want to run?" );
		Passages= in.nextInt();
		System.out.println("Please enter the max. single Force: ");
		ForceMax= in.nextInt();
		
		System.out.println("Your Parameters and the Zero Cluster: ");
		PrintMatrix(Cluster, ClusterWeidth, ClusterLength);
		System.out.println(" ");
				
		int Force;
		int ForcePosition[]= new int[2];
		
		for(int i=0;i<Passages;i++){
			BrushSize=RandomSolution.RandomSol(3);
			Force=RandomSolution.RandomSol(ForceMax-1);
			ForcePosition[0]=RandomSolution.RandomSol(ClusterWeidth-1);
			ForcePosition[1]=RandomSolution.RandomSol(ClusterLength-1);
			int ExitValue=0;
			
			switch (BrushSize){
			
			case 0: 
				Cluster=BrushPoint(Cluster, ClusterWeidth, ClusterLength, Force, ForcePosition);
				System.out.println("Cluster after "+(i+1)+" Passage: ");
				PrintMatrix(Cluster, ClusterWeidth, ClusterLength);
				System.out.println("Central Force: "+Force+"; The Central Position (Weidth/Length): "+(ForcePosition[0]+1)+" / "+(ForcePosition[1]+1));
				System.out.println("Function: Brush Point (100%), only Point Force");
				System.out.println("Exit enter 1, any other Button -> next Force");
				ExitValue= in.nextInt();
				break;				
			case 1:
				Cluster=BrushSmall(Cluster, ClusterWeidth, ClusterLength, Force, ForcePosition);
				System.out.println("Cluster after "+(i+1)+" Passage: ");
				PrintMatrix(Cluster, ClusterWeidth, ClusterLength);
				System.out.println("Central Force: "+Force+"; The Central Position (Weidth/Length): "+(ForcePosition[0]+1)+" / "+(ForcePosition[1]+1));
				System.out.println("Function: Brush Small (50% 100% 50%), Point Force and Neighbor");
				System.out.println("Exit enter 1, any other Button -> next Force");
				ExitValue= in.nextInt();
				break;	
			case 2:
				Cluster=BrushMedium(Cluster, ClusterWeidth, ClusterLength, Force, ForcePosition);
				System.out.println("Cluster after "+(i+1)+" Passage: ");
				PrintMatrix(Cluster, ClusterWeidth, ClusterLength);
				System.out.println("Central Force: "+Force+"; The Central Position (Weidth/Length): "+(ForcePosition[0]+1)+" / "+(ForcePosition[1]+1));
				System.out.println("Function: Brush Medium (33% 66% 100% 66% 33%, Point Force, Neighbor and Neighbor of the Neighbor");
				System.out.println("Exit enter 1, any other Button -> next Force");
				ExitValue= in.nextInt();
			case 3:
				Cluster=BrushTall(Cluster, ClusterWeidth, ClusterLength, Force, ForcePosition);
				System.out.println("Cluster after "+(i+1)+" Passage: ");
				PrintMatrix(Cluster, ClusterWeidth, ClusterLength);
				System.out.println("Central Force: "+Force+"; The Central Position (Weidth/Length): "+(ForcePosition[0]+1)+" / "+(ForcePosition[1]+1));
				System.out.println("Function: Brush Tall (25% 50% 75% 100% 75% 50% 25%, Point Force, Neighbor, Neighbor of the Neighbor and Neighbor of the Neighbor of the Neighbor");
				System.out.println("Exit enter 1, any other Button -> next Force");
				ExitValue= in.nextInt();
			default:
				break;
			}
			if (ExitValue==1){
				i=Passages+1;
			}
		}
	Gm();
	}
}


