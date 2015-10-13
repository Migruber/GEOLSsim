package Objects;
/**
 * @author Michael Alexander Gruber
 * @date 20150823, V2 20150924
 * 
 * @brief This class create an new object - an Vector3D, format double,
 * three values are bundled into a [3] array like x,y,z coordinates.
 * This format is unused under other languages as C#, java also provide a fixed package, build separate
 * is more memory friendly 
 **/
public class Vector3D_3Double {
	private double x;
	private double y;
	private double z;
	
	/** Constructors
	 * First: Init 3D Vector with the three input values for xyz
	 * Second: Init a empty 3dVector Object Null=0.0d;
	 */
	public Vector3D_3Double(double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	public Vector3D_3Double(){
		this.x=0.0d;
		this.y=0.0d;
		this.z=0.0d;
	}
	
	/** Get ,Set (value(s) and default) Methods
	 */
	public double getX(){return this.x;}
	public double getY(){return this.y;}
	public double getZ(){return this.z;}
	
	public void setX(double x){this.x=x;}
	public void setY(double y){this.y=y;}
	public void setZ(double z){this.z=z;}
	public void setXYZ(double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public void setXdefault(){this.x=0.0d;} // double 0.0d is pos. zero - default state 
	public void setYdefault(){this.y=0.0d;}
	public void setZdefault(){this.z=0.0d;}
	public void setXYZdefault(){
		this.x=0.0;
		this.y=0.0;
		this.z=0.0;
	}
	
	/** Method for printing with short String comment
	 */
	public void printVector(){
		System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y+"; z coordinate: "+this.z);
	}
}
