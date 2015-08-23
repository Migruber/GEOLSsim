package Objects_Geolssim;

/**
 * @author Michael Alexander Gruber
 * @date 20150823
 * 
 * @brief This class create an new object - an Vector3D, format double,
 * three values are bundeled into a [3] array like x,y,z coordinates.
 * This format is unsed under other langages as C#, jave also provide a fixed package, build separate
 * is more mermory friendly 
 **/
public class Vector3D_Double {
	private double x;
	private double y;
	private double z;
	
	public Vector3D_Double(double x, double y, double z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public double getX(){return this.x;}
	public double getY(){return this.y;}
	public double getZ(){return this.z;}
	
	public void setX(double x){this.x=x;}
	public void setY(double y){this.y=y;}
	public void setZ(double z){this.z=z;}
	
	public void printVector(){
		System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y+"; z coordinate: "+this.z);
	}
}
