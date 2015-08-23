package Objects_Geolssim;

public class HexClusterPoint {
	
	private Vector3D_Double middleAngle; //xy, xz, yz
	private Vector3D_Double inLeftAngle;
	private Vector3D_Double inMiddleAngle;
	private Vector3D_Double inRightAngle;
	private Vector3D_Double outLeftAngle;
	private Vector3D_Double outMiddleAngle;
	private Vector3D_Double outRightVector;
	
	private Vector3D_Double middleForce; //horizontal, vertical and hypotenuse 
	private double calcMiddleAngle; // angel for the normalized middleForce
	private Vector3D_Double inForce; //left, middle, right
	private Vector3D_Double outForce; //left, middle, right
	
	private double massHex;
	private double frictionalConstant;
	private double frictionalForce; //next calculation class for the cylinder modeling 
	private double g= 9.80665; 
	
	private boolean create; //bool set true if object is created, in and out are Null first
	private boolean inForceActive; // bool set true if in force is initial, set flase if calculation is done
	private boolean outForceActive; // set false if inForce is true, set true if calculation is done
	private boolean calculationDone; //set true after calculations
	private boolean fictionalForceActive;
	
	 public HexClusterPoint(double xAngle, double yAngle, double zAngle, double hypotenuseForce){
		 this.middleAngle.setXYZ(Math.toRadians(xAngle), Math.toRadians(yAngle), Math.toRadians(zAngle));
		 this.middleForce.setZ(hypotenuseForce);
		 this.calcMiddleAngle = ((middleAngle.getZ()+middleAngle.getY())/2);
		 calcMiddleForceInit();
		 
		 this.inLeftAngle.setXYZdefault();
		 this.inMiddleAngle.setXYZdefault();
		 this.inRightAngle.setXYZdefault();
		 this.outLeftAngle.setXYZdefault();
		 this.outMiddleAngle.setXYZdefault();
		 this.outRightVector.setXYZdefault();
		 
		 this.inForce.setXYZdefault();
		 this.outForce.setXYZdefault();
		 
		 this.massHex=middleForce.getX()/g;
		 this.frictionalConstant=0.0d;
		 this.frictionalForce=0.0d;
		 
		 this.create=true;
		 this.inForceActive=false;
		 this.outForceActive=false;
		 this.calculationDone= false;
		 this.fictionalForceActive=false;
	 }
	 
	 public void SetFrictionalForce(double frictionalConstant){
		 this.frictionalConstant=frictionalConstant;
		 this.frictionalForce=calcFrictionalForce();
	 }
	 
	 private void calcMiddleForceInit(){
		this.middleForce.setX((middleForce.getZ()*Math.sin(calcMiddleAngle)));
		this.middleAngle.setY((middleForce.getZ()*Math.cos(calcMiddleAngle)));
	 }
	 
	 private double calcFrictionalForce(){ //empty - calc failed - open task
		 double x=0;
		 return x;
	 }

}
