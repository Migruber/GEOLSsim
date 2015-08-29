package Objects_Geolssim;

public class ObjectHexBottomV1 {
	
	
	private Vector3D_2Double1Bool[] InPuts = new Vector3D_2Double1Bool [6]; // input Force Angle and Bool - aktiv
	private Vector2D_2Double[]InputsClac= new Vector2D_2Double[6];
	private double [] ForceMass= new double [6];
	private Vector2D_2Double [] ForceNn= new Vector2D_2Double[6];
	private Vector3D_2Double1Bool ForceMiddle;
	private Vector3D_2Double1Bool[] UtPuts= new Vector3D_2Double1Bool[6];
	private Vector2D_2Double[] ForceWeighting = new Vector2D_2Double[6];
	private Vector3D_Double InitMiddleCondi;
	
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
	
	public void SetVector3D_2Double1BoolArrayDefaultFull(Vector3D_2Double1Bool[] vector){
		//this.ArrayInformation=0.0d;
	}
	public void SetVector3D_2Double1BoolArrayFull(Vector3D_2Double1Bool[] vector){
		this.ArrayInformation=vector;
	}
	public Vector3D_2Double1Bool[] GetVector3D_2Double1BoolArrayFull(Vector3D_2Double1Bool[] vector){
		Vector3D_2Double1Bool[] vectorArray=vector;
		return vectorArray;
	}
	
	public void SetVector3D_2Double1BoolArrayDefaultLine(Vector3D_2Double1Bool vector, int Line){
		switch(Line){
			case 1:
				
				break;
			case 2 :
				
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			default:
				break;
		}
		
	}
	public void SetVector3D_2Double1BoolArrayLine(Vector3D_2Double1Bool[] vector, int Line){
		this.LineInformation=vector[Line-1];
		
	}
	public Vector3D_2Double1Bool GetVector3D_2Double1BoolArrayLine(Vector3D_2Double1Bool[] vector, int Line){
		Vector3D_2Double1Bool vectorLine=vector[Line-1];
		
		return vectorLine;
	}
	public void SetVector3D_2Double1BoolArrayDefaultElement(Vector3D_2Double1Bool[] vector, int Line, int PositionXYZ){
		
		
	}
	public void SetVector3D_2Double1BoolArrayLine(Vector3D_2Double1Bool[] vector, int Line, int PositionXYZ){
		
		
	}
	public double GetVector3D_2Double1BoolArrayElementX(Vector3D_2Double1Bool[] vector, int Line){
		double vectorElement12=vector[Line-1].getX();
		return vectorElement12;
	}
	public double GetVector3D_2Double1BoolArrayElementY(Vector3D_2Double1Bool[] vector, int Line){
		double vectorElement12=vector[Line-1].getY();
		return vectorElement12;
	}
	public boolean GetVector3D_2Double1BoolArrayElementZ(Vector3D_2Double1Bool[] vector, int Line){
		boolean vectorElement12=vector[Line-1].getZ();
		return vectorElement12;
	}
	
	
	private void CalcFamouseAngles(){
		cos30=Math.cos(Math.toRadians(30));
		sin30=Math.sin(Math.toRadians(30));
		cos60=Math.cos(Math.toRadians(60));
		sin60=Math.sin(Math.toRadians(60));
		
	}
}
