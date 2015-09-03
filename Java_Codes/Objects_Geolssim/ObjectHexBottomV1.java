package Objects_Geolssim;

public class ObjectHexBottomV1 {
	
	
	public Vector3D_2Double1Bool[] InPuts = new Vector3D_2Double1Bool [6]; // input Force Angle and Bool - aktiv
	private Vector2D_2Double[]inputsCalc= new Vector2D_2Double[6];
	public double [] ForceMass= new double [6];
	private Vector2D_2Double [] forceNn= new Vector2D_2Double[6];
	private Vector3D_2Double1Bool forceMi;
	private Vector3D_2Double1Bool[] outPuts= new Vector3D_2Double1Bool[6];
	private Vector2D_2Double[] forceWeighting = new Vector2D_2Double[6];
	private Vector3D_Double initMiddleCondi; //force, XZAngle front, YZAngle side
	private boolean isFilled;
	private double[] anglesForNeigbor=new double[6];
	
	private Vector3D_Double MassFictionalForce;
	
	private double cos30; 
	private double sin30;
	private double cos60;
	private double sin60;
	
	

	public ObjectHexBottomV1(double ForceMiddle, double AngleXZ, double AngleYZ ){
		this.InPuts=Vector3D_2Double1Bool.SetVector3D_2D1B_ArrayDefault(InPuts);
		this.inputsCalc=Vector2D_2Double.SetArrayDefault(inputsCalc);
		for(int i=0;i<6;i++){
			this.ForceMass[i]=0.0d;
		}
		this.forceNn=Vector2D_2Double.SetArrayDefault(forceNn);
		this.forceMi=Vector3D_2Double1Bool.SetVector3D_2D1B_LineDefaut(forceMi);
		this.outPuts=Vector3D_2Double1Bool.SetVector3D_2D1B_ArrayDefault(outPuts);
		this.forceWeighting=Vector2D_2Double.SetArrayDefault(forceWeighting);
		this.initMiddleCondi.setXYZ(ForceMiddle,AngleXZ,AngleYZ);
		this.isFilled=true;
		this.MassFictionalForce.setXYZdefault();
		calcFamouseAngles();
		calcAngelsForNeighbor();
	}
	//Method calculate the angles to the neighbors
	private void calcAngelsForNeighbor(){
		this.anglesForNeigbor[0]=(-1*(2/3)*initMiddleCondi.getY())+((1/3)*initMiddleCondi.getZ());
		this.anglesForNeigbor[1]=(initMiddleCondi.getZ());
		this.anglesForNeigbor[2]=((2/3)*initMiddleCondi.getY())+((1/3)*initMiddleCondi.getZ());
		this.anglesForNeigbor[3]=((2/3)*initMiddleCondi.getY())+(-1*(1/3)*initMiddleCondi.getZ());
		this.anglesForNeigbor[4]=(-1*initMiddleCondi.getZ());
		this.anglesForNeigbor[4]=(-1*(2/3)*initMiddleCondi.getY())+(-1*(1/3)*initMiddleCondi.getZ());
	}
	
	//call method to check neighbor activity
	private void StartCalculation(){
		int startit;
		for(int i=0;i<6;i++){
			startit=0;
			if(InPuts[i].getZ()==true){
				startit=i;
			}
			SetInCalc(InPuts[i],inputsCalc[i],startit);
		}
	}
	//method start first calculation step, outputs normal force and force for the middle (angle straightens)
	//Normal force case1 addi to this forceMi, case2 to neighbor forceMi, case3 no normal force
	private void SetInCalc(Vector3D_2Double1Bool input,Vector2D_2Double incalc,int arrayno){
		this.InPuts[arrayno].setZ(false);
		if(input.getY()>anglesForNeigbor[arrayno]){
			
		}
		if(input.getY()<anglesForNeigbor[arrayno]){
			
		}
		if(input.getY()==anglesForNeigbor[arrayno]){
			this.inputsCalc[arrayno].setX(input.getX());
			this.inputsCalc[arrayno].setY(0);
		}
		
	}
	
	private void calcFamouseAngles(){
		this.cos30=Math.cos(Math.toRadians(30));
		this.sin30=Math.sin(Math.toRadians(30));
		this.cos60=Math.cos(Math.toRadians(60));
		this.sin60=Math.sin(Math.toRadians(60));
		
	}
}
