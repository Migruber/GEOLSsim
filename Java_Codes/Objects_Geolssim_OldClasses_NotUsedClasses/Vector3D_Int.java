package Objects_Geolssim_OldClasses_NotUsedClasses;

/**
 * @author Michael Alexander Gruber
 * @date 20150823
 * 
 * @brief see also Vector3D_Double, create a Vector3D with int conditions  
 **/
public class Vector3D_Int {
	private int x;
	private int y;
	private int z;
	
	public Vector3D_Int(int x, int y, int z){
		this.x=x;
		this.y=y;
		this.z=z;
	}
	
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	public int getZ(){return this.z;}
	
	public void setX(int x){this.x=x;}
	public void setY(int y){this.y=y;}
	public void setZ(int z){this.z=z;}
	
	public void printVector(){
		System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y+"; z coordinate: "+this.z);
	}
}
