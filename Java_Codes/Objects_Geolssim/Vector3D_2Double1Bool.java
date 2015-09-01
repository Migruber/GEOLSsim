package Objects_Geolssim;

/**
 * @author Michael Alexander Gruber
 * @date 20150829
 * 
 * @brief This class create an new object - an Vector3D, format 2 times double and one boolean
 * three values are bundeled into a [3] array like x,y,z coordinates.
 * This format is unsed under other langages as C#, jave also provide a fixed package, build separate
 * is more mermory friendly 
 **/

public class Vector3D_2Double1Bool {
	
		private double x;
		private double y;
		private boolean z;
		
		public Vector3D_2Double1Bool(double x, double y, boolean z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
		
		public double getX(){return this.x;}
		public double getY(){return this.y;}
		public boolean getZ(){return this.z;}
		public void setX(double x){this.x=x;}
		public void setY(double y){this.y=y;}
		public void setZ(boolean z){this.z=z;}
		public void setXYZ(double x, double y, boolean z){
			this.x=x;
			this.y=y;
			this.z=z;
		}
		public void setXdefault(){this.x=0.0d;} // double 0.0d is pos. zero - default state 
		public void setYdefault(){this.y=0.0d;}
		public void setZdefault(){this.z=false;}
		public void setXYZdefault(){
			this.x=0.0d;
			this.y=0.0d;
			this.z=false;
		}
		public static Vector3D_2Double1Bool[] SetVector3D_2D1B_ArrayDefault(Vector3D_2Double1Bool[] hexfull){
			int length = hexfull.length;
			for (int i=0;i<length;i++){
				hexfull[i].setXYZ(0.0d,0.0d,false);
			}
			return hexfull;
		}
		public static Vector3D_2Double1Bool[] SetVector3D_2D1B_Array(Vector3D_2Double1Bool[] hexfull){
			return hexfull;
		}
		public Vector3D_2Double1Bool[] GetVector3D_2D1B_Array(Vector3D_2Double1Bool[] hexfull){
			return hexfull;
		}
		public static Vector3D_2Double1Bool SetVector3D_2D1B_LineDefaut(Vector3D_2Double1Bool hexfull){
			
			//hexfull.setXYZdefault();
			return hexfull;
		}
		public static Vector3D_2Double1Bool SetVector3D_2D1B_Line(Vector3D_2Double1Bool hexfull, double x, double y, boolean z){
			hexfull.x=(x);
			hexfull.y=(y);
			hexfull.z=(z);
			return hexfull;
		}
		public Vector3D_2Double1Bool GetVector3D_2D1B_Line(Vector3D_2Double1Bool[] hexfull, int line){
			Vector3D_2Double1Bool hexfulline=hexfull[line-1];
			return hexfulline;
		}
		public static Vector3D_2Double1Bool SetVector3D_2D1B_ElementDefault(Vector3D_2Double1Bool hexfull,  int element){
			switch (element){
			case 1:
				hexfull.setXdefault();
				break;
			case 2:
				hexfull.setYdefault();
				break;
			case 3:
				hexfull.setZdefault();
				break;
			default:
				break;	
			}
			return hexfull;
		}
		public static boolean GetVector3D_2D1B_Element3(Vector3D_2Double1Bool hexfull[], int line){
			boolean z=hexfull[line-1].getZ();
			return z;
		}
		public void printVector(){
			System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y+"; z coordinate: "+this.z);
		}
	}


