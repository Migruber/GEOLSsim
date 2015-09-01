package Objects_Geolssim;

public class ObjectHexBottomV1 {
	
	
	private Vector3D_2Double1Bool[] InPuts = new Vector3D_2Double1Bool [6]; // input Force Angle and Bool - aktiv
	private Vector2D_2Double[]InputsClac= new Vector2D_2Double[6];
	private double [] ForceMass= new double [6];
	private Vector2D_2Double [] ForceNn= new Vector2D_2Double[6];
	private Vector3D_2Double1Bool ForceMi;
	private Vector3D_2Double1Bool[] OutPuts= new Vector3D_2Double1Bool[6];
	private Vector2D_2Double[] ForceWeighting = new Vector2D_2Double[6];
	private Vector3D_Double InitMiddleCondi;
	private boolean IsFilled;
	
	private Vector3D_Double MassFictionalForce;
	
	private double cos30; 
	private double sin30;
	private double cos60;
	private double sin60;
	
	

	public ObjectHexBottomV1(double ForceMiddle, double AngleXZ, double AngleYZ ){
		this.InPuts=Vector3D_2Double1Bool.SetVector3D_2D1B_ArrayDefault(InPuts);
		this.InputsClac=Vector2D_2Double.SetArrayDefault(InputsClac);
		for(int i=0;i<6;i++){
			this.ForceMass[i]=0.0d;
		}
		this.ForceNn=Vector2D_2Double.SetArrayDefault(ForceNn);
		this.ForceMi=Vector3D_2Double1Bool.SetVector3D_2D1B_LineDefaut(ForceMi);
		this.OutPuts=Vector3D_2Double1Bool.SetVector3D_2D1B_ArrayDefault(OutPuts);
		this.ForceWeighting=Vector2D_2Double.SetArrayDefault(ForceWeighting);
		this.InitMiddleCondi.setXYZ(ForceMiddle,AngleXZ,AngleYZ);
		this.IsFilled=true;
		this.MassFictionalForce.setXYZdefault();
		CalcFamouseAngles();
	}
	
	private void CalcFamouseAngles(){
		this.cos30=Math.cos(Math.toRadians(30));
		this.sin30=Math.sin(Math.toRadians(30));
		this.cos60=Math.cos(Math.toRadians(60));
		this.sin60=Math.sin(Math.toRadians(60));
		
	}
}
