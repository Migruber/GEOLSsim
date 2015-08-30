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
	private double ElementInformation12;
	private boolean ElementInformation3;

	public ObjectHexBottomV1(double ForceMiddle, double AngleXZ, double AngleYZ ){
		
		this.IsFilled=true;
		CalcFamouseAngles();
	}
	
	
	public Vector3D_2Double1Bool[] SetVector3D_2D1B_ArrayDefault(Vector3D_2Double1Bool[] hexfull){
		int length = hexfull.length;
		for (int i=0;i<length;i++){
			hexfull[i].setXYZ(0.0d,0.0d,false);
		}
		this.ArrayInformation=hexfull;
		return ArrayInformation;
	}
	public Vector3D_2Double1Bool[] SetVector3D_2D1B_Array(Vector3D_2Double1Bool[] hexfull){
		this.ArrayInformation=hexfull;
		return ArrayInformation;
	}
	public Vector3D_2Double1Bool[] GetVector3D_2D1B_Array(Vector3D_2Double1Bool[] hexfull){
		this.ArrayInformation=hexfull;
		return ArrayInformation;
	}
	public Vector3D_2Double1Bool[] SetVector3D_2D1B_LineDefaut(Vector3D_2Double1Bool[] hexfull, int line){
		hexfull[line-1].setXYZdefault();
		this.ArrayInformation=hexfull;
		this.LineInformation=hexfull[line-1];
		return hexfull;
	}
	public Vector3D_2Double1Bool[] SetVector3D_2D1B_Line(Vector3D_2Double1Bool[] hexfull, double x, double y, boolean z, int line){
		hexfull[line-1].setX(x);
		hexfull[line-1].setY(y);
		hexfull[line-1].setZ(z);
		this.LineInformation=hexfull[line-1];
		this.ArrayInformation=hexfull;
		return hexfull;
	}
	public Vector3D_2Double1Bool GetVector3D_2D1B_Line(Vector3D_2Double1Bool[] hexfull, int line){
		Vector3D_2Double1Bool hexfulline=hexfull[line-1];
		this.LineInformation=hexfulline;
		return hexfulline;
	}
	public Vector3D_2Double1Bool[] SetVector3D_2D1B_ElementDefault(Vector3D_2Double1Bool[] hexfull, int line, int element){
		switch (element){
		case 1:
			hexfull[line-1].setXdefault();
			this.ElementInformation12=hexfull[line-1].getX();
			break;
		case 2:
			hexfull[line-1].setYdefault();
			this.ElementInformation12=hexfull[line-1].getY();
			break;
		case 3:
			hexfull[line-1].setZdefault();
			this.ElementInformation3=hexfull[line-1].getZ();
			break;
		default:
			break;	
		}
		this.ArrayInformation=hexfull;
		return hexfull;
	}
	public Vector3D_2Double1Bool[] SetVector2D1B_Element12(Vector3D_2Double1Bool[] hexfull, int line, int element, double value){
		switch(element){
		case 1:
			hexfull[line-1].setX(value);
			this.ElementInformation12=hexfull[line-1].getX();
			break;
		case 2:
			hexfull[line-1].setY(value);
			this.ElementInformation12=hexfull[line-1].getY();
			break;
		default:
			break;
		}
		this.ArrayInformation=hexfull;
		return hexfull;
	}
	public Vector3D_2Double1Bool[] SetVecor3D_2D1B_Element3Bool(Vector3D_2Double1Bool[] hexfull, int line, boolean z){
		hexfull[line-1].setZ(z);
		this.ElementInformation3=z;
		this.ArrayInformation=hexfull;
		return hexfull;
	}
	public double GetVector3D_2D1B_Element12(Vector3D_2Double1Bool hexfull[], int line, int element ){
		double element12=0;
		switch(element){
		case 1:
			element12=hexfull[line-1].getX();
			break;
		case 2:
			element12=hexfull[line-1].getY();
		default:
			break;
		}
		this.ElementInformation12=element12;
		this.ArrayInformation=hexfull;
		return element12;
	}
	public boolean GetVector3D_2D1B_Element3(Vector3D_2Double1Bool hexfull[], int line){
		boolean z=hexfull[line-1].getZ();
		return z;
	}
	private void CalcFamouseAngles(){
		this.cos30=Math.cos(Math.toRadians(30));
		this.sin30=Math.sin(Math.toRadians(30));
		this.cos60=Math.cos(Math.toRadians(60));
		this.sin60=Math.sin(Math.toRadians(60));
		
	}
}
