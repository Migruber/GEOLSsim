package Objects;
/**
 * @author Michael Alexander Gruber
 * @date 20150828, V2:20150923
 * 
 * @brief This class create an new object - an Vector2D, format two times double.
 * This format is used under other languages as C#, java also provide a fixed package, build separate
 * is more memory friendly 
 *
 * If the format double to "high" maybe the double can be changed into float format, must be 
 * Casted before using the math class
 **/

public class Vector2D_2Double {

		private double x;
		private double y;
	
		/** first constructor for the init a 2DVector, input two times double
		 *  second constructor for a NULL init 
		 */
		public Vector2D_2Double(double x, double y){
			this.x=x;
			this.y=y;
		}
		public Vector2D_2Double(){
			this.x=0.0d;
			this.y=0.0d;
		}
		
		/** Get - Set Methods x,y,xy
		 * Set default, 0.0d x,y,xy
		 */
		public double getX(){return this.x;}
		public double getY(){return this.y;}
		
		public void setX(double x){this.x=x;}
		public void setY(double y){this.y=y;}
		
		public void setXY(double x, double y){
			this.x=x;
			this.y=y;
		}
		
		public void setXdefault(){this.x=0.0d;} // double 0.0d is pos. zero - default state 
		public void setYdefault(){this.y=0.0d;}
		public void setXYdefault(){
			this.x=0.0d;
			this.y=0.0d;
		
		}
		
		/** Set an array with Vector2D_2Double objects to NULL - 0.0d
		 * Print the Vector values with info strings
		 */
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

