import java.util.Scanner;

/**
 * 
 * @brief This program implement a Matrix - Cluster and a Element Force Value. 
 * The Force can be changed with a Brush Function.
 * The user can handle this process very universal \n
 * Input Variables: Width, Length, Zero Force, Applied Force, Applied Force Position \n
 * After the Simulation the user is allowed to simulate a new Cluster, to simulate a new 
 * applied force with the new calculated values (current run) or a simple exit this tool.
 * 
 * Backbone is a 3D array, this can be implement as a hexagonal pattern too, as describe
 * in Sciddica
 *  
 * Next step - version 02: \n
 * A graphical representation with jgridmap of the individual Clusters by using colors
 * Make the code more universal - constantly
 * 
 * @author Michael Gruber Alexander
 * @date 201508 Version 01
 */
public class Brushfunction_01 {
	static Scanner in= new Scanner (System.in);
	
	
	/** @brief Gm
	 *  @brief Say Goodbye
	 */
	public static void Gm(){
		System.out.println("Thank's for using the Cluster Brush Tools");
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
	
	/** @brief InputForcePosition
	 * @param Pos int[2], [0] Force Position X, [1] Force Position Y
	 * @param MB int, Cluster Width
	 * @param ML int, Cluster Length
	 * @return Force Position int[]
	 */
	public static int [] InputForcePosition(int[] Pos, int MB, int ML){
		/**
		 * @brief simple loops, Position for Force X,Y input by user 
		 * @param i int, control variable
		 */
		int i=-1;
		while (i<0||i>=MB+1){
			System.out.println("Enter force column position, 1 to "+MB+": ");
			i=in.nextInt();
		}
		Pos[0]=i-1;
		i=-1;
		while (i<0||i>=ML+1){
			System.out.println("Enter force line position, 1 to "+ML+": ");
			i=in.nextInt();
		}
		Pos[1]=i-1;
		i=0;
		return Pos;
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
	
		int Repeatnew=0; 
		int Repeatold=0;
		int MatrixWidth;
		int MatrixLength;
		double MatrixZeroForce;
		int BrushSize=0;
		double MatrixForce;
		
		int [] ForcePosition= new int [2];
		
		while(Repeatnew==0){
			BrushSize=-1;
			System.out.print("Enter Cluster Width: ");
			MatrixWidth= in.nextInt();
			System.out.println("Enter Cluster Length: ");
			MatrixLength=in.nextInt();
			System.out.println("Enter Cluster Zero Force (Cluster Element equal distribution): ");
			MatrixZeroForce= in.nextInt();
			
			double[][] ForceMatrix= new double [MatrixWidth][MatrixLength];
			ForceMatrix=FillMatrix(ForceMatrix,MatrixWidth,MatrixLength,MatrixZeroForce);
			Repeatold=0;
			while(Repeatold==0){
				BrushSize=-1;
				System.out.println("The Cluster is: "+"\n");
				PrintMatrix(ForceMatrix,MatrixWidth,MatrixLength);
				
				while (BrushSize!=0&&BrushSize!=1&&BrushSize!=2&&BrushSize!=3&&BrushSize!=4){
					System.out.println("Enter Brush Radius:");
					System.out.println("0 = only point - force to position");
					System.out.println("1 = force to position and  to first neighbor");
					System.out.println("2 = force to position, first and second neighbor");
					System.out.println("3 = force to position, first, second and third neighbor");
					BrushSize=in.nextInt();
				}
				System.out.println("Enter applied force:");
				MatrixForce=in.nextInt();
				
				ForcePosition=InputForcePosition(ForcePosition,MatrixWidth,MatrixLength);
				
				switch(BrushSize){
				case 0:
					ForceMatrix=BrushPoint(ForceMatrix,MatrixWidth,MatrixLength,MatrixForce,ForcePosition);
					System.out.println("The new Cluster is:");
					PrintMatrix(ForceMatrix,MatrixWidth,MatrixLength);
					break;
				case 1:
					ForceMatrix=BrushSmall(ForceMatrix,MatrixWidth,MatrixLength,MatrixForce,ForcePosition);
					System.out.println("The new Cluster is:");
					PrintMatrix(ForceMatrix,MatrixWidth,MatrixLength);
					break;
				case 2:
					ForceMatrix=BrushMedium(ForceMatrix,MatrixWidth,MatrixLength,MatrixForce,ForcePosition);
					System.out.println("The new Cluster is:");
					PrintMatrix(ForceMatrix,MatrixWidth,MatrixLength);
					break;
				case 3:
					ForceMatrix=BrushTall(ForceMatrix,MatrixWidth,MatrixLength,MatrixForce,ForcePosition);
					System.out.println("The new Cluster is:");
					PrintMatrix(ForceMatrix,MatrixWidth,MatrixLength);
					break;
				/*case 4:
					ForceMatrix=BrushSmall(ForceMatrix,MatrixBreite,MatrixLaenge,MatrixForce,ForcePosition);
					System.out.println("Der fertige Force Cluster lautet, small Brush:");
					PrintMatrix(ForceMatrix,MatrixBreite,MatrixLaenge);
					ForceMatrix=BrushMedium(ForceMatrix,MatrixBreite,MatrixLaenge,MatrixForce,ForcePosition);
					System.out.println("Der fertige Force Cluster lautet, medium Brush:");
					PrintMatrix(ForceMatrix,MatrixBreite,MatrixLaenge);
					ForceMatrix=BrushTall(ForceMatrix,MatrixBreite,MatrixLaenge,MatrixForce,ForcePosition);
					System.out.println("Der fertige Force Cluster lautet, tall Bruch:");
					PrintMatrix(ForceMatrix,MatrixBreite,MatrixLaenge);
					break;*/
				default:
				}
				
				System.out.println("Enter 0 for Repeat, others for Exit:");
				Repeatnew=in.nextInt();
				if(Repeatnew==0){
					System.out.println("Enter 0 for Simulation with the old Cluster, others to init new Cluster:");
					Repeatold=in.nextInt();
				}else{
					Repeatold=5;
					
				}
		}
	}
	Gm();
	}
}
