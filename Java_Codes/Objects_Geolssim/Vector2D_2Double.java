package Objects_Geolssim;

/**
 * @author Michael Alexander Gruber
 * @date 20150828
 * 
 * @brief This class create an new object - an Vector2D, format two times double,
 * three values are bundled into a [3] array like x,y,z coordinates.
 * This format is used under other languages as C#, java also provide a fixed package, build separate
 * is more memory friendly 
 *
 * If the format double to "high" maybe the double can be changed into float format, uust be 
 * Casted before using the math class
 **/

public class Vector2D_2Double {

		private double x;
		private double y;
	
		
		public Vector2D_2Double(double x, double y){
			this.x=x;
			this.y=y;
		
		}
		
		public double getX(){return this.x;}
		public double getY(){return this.y;}
		
		public void setX(double x){this.x=x;}
		public void setY(double y){this.y=y;}
		
		public void setXYZ(double x, double y, double z){
			this.x=x;
			this.y=y;
		}
		
		public void setXdefault(){this.x=0.0d;} // double 0.0d is pos. zero - default state 
		public void setYdefault(){this.y=0.0d;}
		public void setXYZdefault(){
			this.x=0.0d;
			this.y=0.0d;
		
		}
		public static Vector2D_2Double[] SetArrayDefault(Vector2D_2Double[] cluster){
			for (int i=0;i<6;i++){
				cluster[i].x=0;
				cluster[i].y=0;
			}
			return cluster;
		}
		public void printVector(){
			System.out.println("x coordinate: "+this.x+"; y coordinate: "+this.y);
		}
	}

