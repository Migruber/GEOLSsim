package Objects_Geolssim.OldClasses_NotUsedClasses;

/**
 * @author Michael Alexander Gruber
 * @date 20150823
 * 
 *  @brief see also Vector3D_Double, create a Vector3D with int conditions.
 **/
public class Vector3D_String {
	private String x;
	private String y;
	private String z;
	
	public Vector3D_String(String x, String y, String z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public String getX(){return this.x;}
	public String getY(){return this.y;}
	public String getZ(){return this.z;}
	
	public void setX(String x){this.x=x;}
	public void setY(String y){this.y=y;}
	public void setZ(String z){this.z=z;}
	
	public void printVector(){
		System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y+"; z coordinate: "+this.z);
	}
}
