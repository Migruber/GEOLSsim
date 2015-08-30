package Objects_Geolssim;

public class ObjectHexBottomV1 {
	
	
	private Vector3D_2Double1Bool[] InPuts = new Vector3D_2Double1Bool [6]; // input Force Angle and Bool - aktiv
	private Vector2D_2Double[]InputsClac= new Vector2D_2Double[6];
	private double [] ForceMass= new double [6];
	private Vector2D_2Double [] ForceNn= new Vector2D_2Double[6];
	private Vector3D_2Double1Bool ForceMiddle;
	private Vector3D_2Double1Bool[] OutPuts= new Vector3D_2Double1Bool[6];
	private Vector2D_2Double[] ForceWeighting = new Vector2D_2Double[6];
	private Vector3D_Double InitMiddleCondi;
	private boolean IsFilled;
	
	private Vector3D_Double MassFictionalForce;
	
	private double cos30; 
	private double sin30;
	private double cos60;
	private double sin60;
	
	private Vector3D_2Double1Bool LineInformation;
	private Vector3D_2Double1Bool[] ArrayInformation;
	private double ElementInformation;

	public ObjectHexBottomV1(double ForceMiddle, double AngleXZ, double AngleYZ ){
		
		CalcFamouseAngles();
	}
	
	
	
	private void CalcFamouseAngles(){
		this.cos30=Math.cos(Math.toRadians(30));
		this.sin30=Math.sin(Math.toRadians(30));
		this.cos60=Math.cos(Math.toRadians(60));
		this.sin60=Math.sin(Math.toRadians(60));
		
	}
}
