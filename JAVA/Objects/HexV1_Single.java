package Objects;

public class HexV1_Single {

	/**Up Neighbor 012:
	 * The neighbor are defined as:
	 * first double forceFromNeighbor, as the input force from neighbor
	 * second double incommingAngle
	 * third double forceCorrected
	 * [0] 33 right(0), [1] 90 middle(1), [2] 33 left(2)
	 */
	public Vector3D_3Double[] VarInput= new Vector3D_3Double[3];
	
	/**Down Neighbor 345:
	 * first double forceOutput for neighbor 345
	 * second double angleOutput
	 * [0] 33 left(3), [1] 90 middle(4), [2] 33 right(5);
	 */
	public Vector2D_2Double[] VarOutput= new Vector2D_2Double[3];
	
	/**Angles this object:
	 * double - Angle90[2] for in and output 1st and 4th neighbor
	 * double - Angle33[2] alpha90/3 in and output angle for 0,2,3,5th neighbor
	 * in degree later calculate into radiant, 2nd Milestone new Var for the rad values
	 *AnglesRad is the radiant value for calculations
	 *[0] degree, [1] radiant
	 */
	public double[] Angle90= new double[2];
	public double[] Angle30= new double[2];
	
	/**Factor calculated from angle
	 * 0° 0, 90° 1
	 * 0° total force to ground; 90° total force to next element, Output
	 * Normal Ground Force addi to force ground
	 * Parallel Force new Output
	 */
	public double AngleFactor;
	
	/**InputForce=Groundforce+Outputforce
	 * Be Careful!!!!!!!!, NormalForce addi to ground force -> input>output - rectagle calculation
	 * [0] Input 33 Neighbor right(0) - Output Neighbor left(3)
	 * [1] Input 90 Neighbor middle(1) - Output Neighbor middle(4)
	 * [2] Input 33 Neighbor left(2) - Output Neighbor right(5)
	 */
	public double[] MiddleForces= new double [6];
	
	/**Ground Force - double:
	 * First an init value
	 * Second the Normal Force from the inputs
	 * ......later 2.Milestone - for the cylinder model - ground force mass......
	 * [0]force - newton, [1]mass - kilogram
	 */
	public double[] GroundForceMass= new double[2]; 
	
	/**Object Info:
	 * int[10] - ClusterElement	for the cluster element device, 0..upleft - 3 neighbors blind, see HexV1_Singlecluster.java
	 * boolean[3] InputActive neighbor 012
	 * boolean[3] OutputActive neighbor 456
	 */
	public int ClusterElement; //out of range get 1to10 by init cluster
	public boolean[] InputActive=new boolean[3];
	public boolean[] OutputActive=new boolean[3];
	public double g=9.80665;
	
	/** Constructor:
	 * first with the init values Angle and Mass of the Hex Object, others calculate or set NULL
	 * second - up to now blind - not in use, no init values all object infos to NULL
	 */
	public HexV1_Single(double HorizontalAngle, double GroundMass, int clusterEle){
		
		this.ClusterElement=clusterEle;
		this.Angle90[0]=HorizontalAngle;
		this.Angle90[1]=Math.toRadians(HorizontalAngle);
		this.Angle30[0]=HorizontalAngle/3;
		this.Angle30[1]=Math.toRadians(HorizontalAngle/3);
		this.AngleFactor=HorizontalAngle/90;
		
		this.GroundForceMass[1]=GroundMass;
		this.GroundForceMass[0]=GroundMass*g;
		
		for(int i=0;i<3;i++){
			this.VarInput[i]=new Vector3D_3Double();
			this.VarInput[i].setXYZdefault();
			this.VarOutput[i]=new Vector2D_2Double();
			this.VarOutput[i].setXdefault();
			this.InputActive[i]=false;
			this.OutputActive[i]=false;
		}
		this.VarOutput[0].setY(Angle30[0]); //radiant angle information for the neighbor, VarInput[1]neighbor - cluster class
		this.VarOutput[1].setY(Angle90[0]);
		this.VarOutput[2].setY(Angle30[0]);
		for(int i=0;i<6;i++){
			this.MiddleForces[i]=0.0d;
		}
	}
	public HexV1_Single(){
		
		this.Angle90[0]=0.0d;
		this.Angle90[1]=0.0d;
		this.Angle30[0]=0.0d;
		this.Angle30[1]=0.0d;
		this.AngleFactor=0.0d;
		
		this.GroundForceMass[1]=0.0d;
		this.GroundForceMass[0]=0.0d;
		
		for(int i=0;i<3;i++){
			this.VarInput[i]=new Vector3D_3Double();
			this.VarInput[i].setXYZdefault();
			this.VarOutput[i]=new Vector2D_2Double();
			this.VarOutput[i].setXdefault();
			this.InputActive[i]=false;
			this.OutputActive[i]=false;
		}
		for(int i=0;i<6;i++){
			this.MiddleForces[i]=0.0d;
		}
		
	}
	
	/**@param HorizontalAngle, angle of this element
	 * @param GroundMass, zero mass of this element
	 * @param clusterEle, cluster element, first all the same, split by building the cluster with SetClusterElement
	 *if the matrix is init with default Hex elements this method init the three basic values for this.object
	 */
	public void SetBasics(double HorizontalAngle, double GroundMass, int clusterEle){
		this.ClusterElement=clusterEle;
		this.Angle90[0]=HorizontalAngle;
		this.Angle90[1]=Math.toRadians(HorizontalAngle);
		this.Angle30[0]=HorizontalAngle/3;
		this.Angle30[1]=Angle90[1]/3;
		this.AngleFactor=HorizontalAngle/90;
		
		this.GroundForceMass[1]=GroundMass;
		this.GroundForceMass[0]=GroundMass*g;
		
		for(int i=0;i<3;i++){
			this.VarInput[i].setXYZdefault();
			this.VarOutput[i].setXdefault();
			this.InputActive[i]=false;
			this.OutputActive[i]=false;
		}
		this.VarOutput[0].setY(Angle30[0]); //radiant angle information for the neighbor, VarInput[1]neighbor - cluster class
		this.VarOutput[1].setY(Angle90[0]);
		this.VarOutput[2].setY(Angle30[0]);
		for(int i=0;i<6;i++){
			this.MiddleForces[i]=0.0d;
		}
	}
	
	/**@param neighbor123, 1 force from right array[0]...
	 * @param forceIn, input force, first case init by user or init by clustercalc
	 * @param angleIn, angle of the neighbor
	 */
	public void SetInputForceHand(int neighbor123, double forceIn, double angleIn){
		if(neighbor123>0&&neighbor123<4){
			
			this.VarInput[neighbor123-1].setX(forceIn);
			this.VarInput[neighbor123-1].setY((angleIn));
			this.InputActive[neighbor123-1]=true;
		}
	}
	
	public void SetInputForceAuto(int neighbor123, double forceIn, double angleIn){
		if(neighbor123>0&&neighbor123<4){
			
			this.VarInput[neighbor123-1].setX(forceIn);
			this.VarInput[neighbor123-1].setY((angleIn));
			this.InputActive[neighbor123-1]=true;
		}
	}
	
	/**Calculation class
	 * @param forceIn, input force
	 * @param thisAngle, input angle
	 * @param neighbor123, number of neighbor 123 from right to left - array 012
	 * @return
	 * calculate the right inforce - input angle to own angle
	 * split input to normal and output force - with the this.angleFactor
	 * split absolute output (minus normal) into output forces 123
	 * splitfactor:
	 * input right - output left60%,middle30%,right10%
	 * input middle - output left20%,middle60%,right20%
	 * input left - output left10%,middle30%,right60%
	 */
	public void CalculateForces(){
		Vector3D_3Double forceIn[]=VarInput; 
		//init to zero every call time, in the method +=
		double forceInCalc=0;
		double normalForce=0;
		double outputForce0=0;
		double outputForce1=0;
		double outputForce2=0;
		double anglefac;
		
		if(InputActive[0]==true){
		
			if(forceIn[0].getX()>Angle30[1]){
				//forceInCalc=((forceIn[0].getX()/(Math.sin(Angle30[1])))*Math.sin((0.5*Math.PI+forceIn[0].getY())));
				anglefac=Angle30[0]/(forceIn[0].getY());
				forceInCalc=forceIn[0].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.6*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.1*(forceInCalc-normalForce);
			}
			if(forceIn[0].getX()==Angle30[1]){
				forceInCalc=forceIn[0].getX();
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.6*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.1*(forceInCalc-normalForce);
				}
			if(forceIn[0].getX()<Angle30[1]){
				//forceInCalc=((forceIn[0].getX()/(Math.sin((0.5*Math.PI+Angle30[1]))))*(Math.sin(forceIn[0].getY())));
				anglefac=Angle30[0]/(forceIn[0].getY());
				forceInCalc=forceIn[0].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.6*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.1*(forceInCalc-normalForce);
			}
		}
		
		if(InputActive[1]==true){
			if(forceIn[1].getX()>Angle90[1]){
				//forceInCalc=((forceIn[1].getX()/(Math.sin(Angle90[1])))*Math.sin((0.5*Math.PI+forceIn[1].getY())));
				anglefac=Angle90[0]/(forceIn[1].getY());
				forceInCalc=forceIn[1].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.2*(forceInCalc-normalForce);
				outputForce1+=0.6*(forceInCalc-normalForce);
				outputForce2+=0.2*(forceInCalc-normalForce);
			}
			if(forceIn[1].getX()==Angle90[1]){
				forceInCalc=forceIn[1].getX();
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.2*(forceInCalc-normalForce);
				outputForce1+=0.6*(forceInCalc-normalForce);
				outputForce2+=0.2*(forceInCalc-normalForce);
				}
			if(forceIn[1].getX()<Angle90[1]){
				//forceInCalc=((forceIn[1].getX()/(Math.sin((0.5*Math.PI+Angle90[1]))))*(Math.sin(forceIn[1].getY())));
				anglefac=Angle90[0]/(forceIn[1].getY());
				forceInCalc=forceIn[1].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.2*(forceInCalc-normalForce);
				outputForce1+=0.6*(forceInCalc-normalForce);
				outputForce2+=0.2*(forceInCalc-normalForce);
			}
		}
		
		if(InputActive[2]==true){
			if(forceIn[2].getX()>Angle30[1]){
				//forceInCalc=((forceIn[2].getX()/(Math.sin(Angle30[1])))*Math.sin((0.5*Math.PI+forceIn[2].getY())));
				anglefac=Angle30[0]/(forceIn[2].getY());
				forceInCalc=forceIn[2].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.1*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.6*(forceInCalc-normalForce);
			}
			if(forceIn[2].getX()==Angle30[1]){
				forceInCalc=forceIn[0].getX();
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.1*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.6*(forceInCalc-normalForce);
				}
			if(forceIn[2].getX()<Angle30[1]){
				//forceInCalc=((forceIn[2].getX()/(Math.sin((0.5*Math.PI+Angle30[1]))))*(Math.sin(forceIn[2].getY())));
				anglefac=Angle30[0]/(forceIn[2].getY());
				forceInCalc=forceIn[2].getX()*anglefac;
				normalForce+=forceInCalc*AngleFactor;
				outputForce0+=0.1*(forceInCalc-normalForce);
				outputForce1+=0.3*(forceInCalc-normalForce);
				outputForce2+=0.6*(forceInCalc-normalForce);
			}
		}
		
		//set object values
		this.GroundForceMass[0]+=normalForce;
		this.GroundForceMass[1]+=normalForce*g;
		this.VarOutput[0].setX(outputForce0);
		this.VarOutput[1].setX(outputForce1);
		this.VarOutput[2].setX(outputForce2);
		
		for (int i=0;i<3;i++){
			this.InputActive[i]=false;
			this.VarInput[i].setXYZdefault();
			this.OutputActive[i]=true;
		}
	}

	/**overload - init ClusterElementID for an easier handling
	 */
	public void SetClusterElement(int ElementID){
		this.ClusterElement=ElementID;
	}
	
	
	/**Get methods - to get some special values, for an easier handling
	 */
	public double GetOutPutForce(int element){
		double outp=this.VarOutput[element].getY();
		return outp;
	}
	public double GetGroundForce(int element){
		double outp=this.GroundForceMass[0];
		return outp;
	}
	public double GetGroundMass(int element){
		double outp=this.GroundForceMass[1];
		return outp;
	}
	
	/**some methods to print values of this object, for testing - correct?
	 * idea: zeroForce 100000, input about 1000, cast to int angle cast to double 00.000 so a clear output in the console will be given
	 */
	public void PrintInForce1(){
		if(VarInput[0].getX()==0){
			System.out.print("IR: 000000");
		}
		if(VarInput[0].getX()!=0){
			System.out.print("IR: "+(int)VarInput[0].getX());
		}
	}
	public void PrintInForce2(){
		if(VarInput[1].getX()==0){
			System.out.print("IM: 000000");
		}
		if(VarInput[1].getX()!=0){
			System.out.print("IM: "+(int)VarInput[1].getX());
		}
	}
	public void PrintInForce3(){
		if(VarInput[2].getX()==0){
			System.out.print("IL: 000000");
		}
		if(VarInput[2].getX()!=0){
			System.out.print("IL: "+(int)VarInput[2].getX());
		}
	}
	public void PrintNormalForce(){
		if(GroundForceMass[0]==0){
			System.out.print("GF: 000000");
		}
		if(GroundForceMass[0]!=0){
			System.out.print("GF: "+(int)GroundForceMass[0]);
		}
	}
	public void PrintThisAngle(){
		System.out.print("TA:     "+(int)Angle90[0]);
	}
	public void PrintOutForce1(){
		if(VarOutput[0].getX()==0){
			System.out.print("OL: 000000");
		}
		if(VarOutput[0].getX()!=0){
			System.out.print("OL: "+(int)VarOutput[0].getX());
		}
	}
	public void PrintOutForce2(){
		if(VarOutput[1].getX()==0){
			System.out.print("OM: 000000");
		}
		if(VarOutput[1].getX()!=0){
			System.out.print("OM: "+(int)VarOutput[1].getX());
		}
	}
	public void PrintOutForce3(){
		if(VarOutput[2].getX()==0){
			System.out.print("OR: 000000");
		}
		if(VarOutput[2].getX()!=0){
			System.out.print("OR: "+(int)VarOutput[2].getX());
		}
	}
}
