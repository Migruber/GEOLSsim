using UnityEngine;
using System.Collections;

public class Hex_Mesh : MonoBehaviour {


	public int CirclePointSize=20;
	public float Radius=5f;
	public int[] myTrian;
	public Vector3[] CirclePoints;
	public int CircleNo=1;
	public float CircleDistance=5f;
	public float[] Z_Length;

	public Vector3 MeshPosition;
	public GameObject MyHex;
	public float YRotation=180f;


		
	void Start () {
		Z_Length = new float[CircleNo];
		Z_Length = FillZ_Length (CircleNo, CircleDistance);

		MeshFilter myMeshfilter = GetComponent<MeshFilter> ();
		Mesh myMesh = new Mesh ();
		myMeshfilter.mesh = myMesh;
			
		//Vertices
		Vector3[] myVerticles = new Vector3[14];//(CirclePointSize*CircleNo)+CircleNo];
		myVerticles = GetCirclePoints (CirclePointSize, Radius,Z_Length);
			
		//Triangles, init the three triangle points, in clocktime
		myTrian = new int[36];//((CirclePointSize)*3)*CircleNo];
		myTrian = GetCircleTriangles (CirclePointSize,CircleNo);
			
		//Normals (only if object is displayed in game)
		Vector3[] myNormals = new Vector3[(CirclePointSize*CircleNo)+CircleNo];
		myNormals = GetCircleNormals(CirclePointSize,CircleNo);

		//UVs (how textures are displayed), 0 to 1, 100%=1
		/*Vector2[] myUv = new Vector2[4];
		
		myUv [0] = new Vector2 (0, 0);
		myUv [1] = new Vector2 (1, 0);
		myUv [2] = new Vector2 (0, 1);
		myUv [3] = new Vector2 (1, 1);
		*/
		//Assign Arrays
		
		myMesh.vertices = myVerticles;
		myMesh.triangles = myTrian;
		myMesh.normals = myNormals;
		//myMesh.uv = myUv;

		SetYRotationHex ();
		SetPositionHex ();
	
	}
	
	Vector3[] GetCirclePoints (int pointSize, float radius, float[] z){
		int counter = z.Length;
		float angle = (360 / (pointSize)) * Mathf.Deg2Rad;
		float angleOngoing = angle;
		CirclePoints = new Vector3[(pointSize)*counter+counter];
		int ending = CirclePoints.Length;
		int k=0;
		for (int j=0; j<counter; j++) {
			
			for (int i=0+k; i<pointSize+k; i++) {
				float ax = radius * Mathf.Sin (angleOngoing);
				float ay = radius * Mathf.Cos (angleOngoing);
				CirclePoints [i] = new Vector3 (ax, ay, z[j]);
				angleOngoing = angle + angleOngoing;
			}
			CirclePoints [pointSize+k] = new Vector3 (0, 0, z[j]);
			k=k+pointSize+1;
			angleOngoing=angle;
		}
		
		return CirclePoints;
	}

	int[] GetCircleTriangles(int pointSize, int circleNo){
		int arrayTriagnlePointSize = CalcTriangleNo (pointSize, circleNo);
		arrayTriagnlePointSize = CalcTrianglePointNo (arrayTriagnlePointSize);
		int counter = circleNo;
		int [] triangles = new int[arrayTriagnlePointSize];
		int l = 0;
		int k = 0;
		int b = 0;
		int v = pointSize * 3;
		for (int j=0; j<counter; j++) {
			
			for (int i=0+b; i<(v+b); i=i+3) {
				triangles [i] = ((pointSize + k));
				triangles [i + 1] = l + 1;
				triangles [i + 2] = l;
				l++;
			}
			triangles [(pointSize * 3) + b - 3] = pointSize + k;
			triangles [(pointSize * 3) + b - 1] = pointSize + k - 1;
			triangles [(pointSize * 3) + b - 2] = 0 + k;
			k = k + pointSize + 1;
			l++;
			b = b + pointSize * 3;
			
		}
		return triangles;
	}

	Vector3[] GetCircleNormals(int pointSize, int circleNo){
		Vector3[] CircleNormals = new Vector3[(pointSize*circleNo) + (circleNo)];
		for (int i=0; i<((pointSize*circleNo)+circleNo); i++) {
			CircleNormals [i] = -Vector3.forward;
		}
		return CircleNormals;
	}
	
	float[] FillZ_Length(int circleNo, float circleDistance){
		float[] Z_Length=new float[circleNo];
		float distance = circleDistance;
		for(int i= 0; i<circleNo;i++){
			Z_Length[i]=distance;
			distance=distance+circleDistance;
		}
		return Z_Length;
	}

	int CalcTriangleNo(int pointSize, int circleNo){
		int triangleNo;
		if (circleNo == 1) {
			triangleNo = pointSize;
		} else {
			triangleNo = pointSize;
			for (int i=1; i<circleNo; i++) {
				triangleNo = triangleNo + (pointSize * 3);
			}
		}
		return triangleNo;
	}
	
	int CalcTrianglePointNo(int triangelNo){
		triangelNo = triangelNo * 3;
		return triangelNo;
	}

	void SetYRotationHex(){
		MyHex.transform.rotation = Quaternion.Euler (0, YRotation, 0);

	}

	void SetPositionHex(){
		MyHex.transform.position = new Vector3 (MeshPosition.x, MeshPosition.y, MeshPosition.z);

	}
}
