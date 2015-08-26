//Script to calculate a parable flight and a visual test function, GM 2015/08/19

using UnityEngine;
using System.Collections;
using System.Collections.Generic;

public class Parable_Position : MonoBehaviour {
	
	public List<Vector3> WaterWay; 	//just for testing, later private
	public float AngleVertical; 	//input degree
	public float AngleHoriz;		//input degree
	public float Range;				//distance y.zero to y.zero
	public float BreakIt;			//breaking point bevor .y == zero - breaking height
	public Vector3 StartPosition;	//start position
	public GameObject TestCube;		//just a game objekt to visual the parable
	public GameObject EndingParticles; //put a plane with scale 0.1;0.1;0.1
	public GameObject ParticleStart;
	
	
	private Vector3 waterPosition; 	//single Vector3 for filling List WaterWay
	private float nullVelocity;		//zero velocity
	private float g=9.81f;			//standard earth gravity
	private float beta; 			//radiant vertical angle
	private float alpha;			//radiant horizonal angle
	private float j;				//cast integer
	private int k;					//index for visual
	private int indexK;				//loop contition
	private Vector3 endPosition;	//last Position, here the partcle effect splash is starting
	private Vector3 indexLastLast;	//next to last Position - calculate angles
	private float alphaTilde;		//x Rotation Splash - radiant 
	private Vector3 angleEnd;		//Rotation Splash x,y,z - degree
	private Vector3 angleStart;		//Rotation WaterBeam x,y,z - degree
	private Vector3 startStartPosition; //second position of Waterway, to calculate angle Start
	private float alphaSnake;		//x Rotation Waterbeam - radiant
	private int delayWaterPos;
	
	
	//public Transform target;
	public ParticleSystem particleSystem;
	private ParticleSystem.Particle[] particles;
	private int indexWaterBeamPos;
	private List<ParticleSystem.Particle> totalPartikles;
	private int indexCount;
	public int WayPointSize;    
	private int iiii = 0;
	private int particlesMovingStep;
	
	// for the wiggle of the water jet
	private float upP;
	private float downP;
	private bool upActive;
	private bool downActive;
	private int counterSweep;
	public int z;
	public float betatilde;
	public float wiggleBoarder;
	
	// particle size from  strat to end
	public float ParticleSizeStart;
	public float ParticleSizeEnd;
	private float particleSizeStep;
	
	// get different interval between parable points
	public float pointsInerval;
	public int sizeOfParablePoints;
	
	public GameObject WaterJetEndParticles;
	
	
	
	void Start () {
		
		particlesMovingStep = 5;
		betatilde = AngleVertical;
		upP=3f*Time.deltaTime;
		z = 0;
		downP=3f*Time.deltaTime;
		upActive = true;
		downActive = false;
		counterSweep = 0;
		
		totalPartikles = new List<ParticleSystem.Particle>();
		indexCount = 0;
		indexWaterBeamPos = 1;
		//calculation velocity and angles, set first position - start position
		beta = AngleVertical* Mathf.Deg2Rad;
		alpha = AngleHoriz* Mathf.Deg2Rad;
		waterPosition = StartPosition;
		WaterWay.Add (new Vector3 (waterPosition.x, waterPosition.y,waterPosition.z));
		nullVelocity = Mathf.Sqrt ((Range * g) / Mathf.Sin (2 * beta));
		
		//loop to fill list parable steps
		for (int i=0; i<200; i++) {
			if(waterPosition.y<=BreakIt&&waterPosition.x>((Range/2)*Mathf.Cos(alpha)))
			{
			}
			else{
				j = 10 * i;
				j = j / 750;
				
				waterPosition.x = nullVelocity * (j) * Mathf.Cos (beta);
				waterPosition.y = nullVelocity * (j) * Mathf.Sin (beta) - ((g / 2) * (j) * (j));
				waterPosition.z = waterPosition.x * Mathf.Tan (alpha);
				
				WaterWay.Add(new Vector3(waterPosition.x,waterPosition.y,waterPosition.z));
				indexK = i;
			}
		}
		WayPointSize= WaterWay.Count;
		sizeOfParablePoints = WaterWay.Count;
		
		
		//calculation for the waterbeam particle effect
		startStartPosition = WaterWay [2];
		alphaSnake = Mathf.Atan ((startStartPosition.y - StartPosition.y) / (startStartPosition.x - StartPosition.x));
		angleStart.x = (alphaSnake * Mathf.Rad2Deg)*-1;
		angleStart.y = 90-AngleHoriz;
		angleStart.z = 0;
		
		//init calculation parameter to the three water_beam particle effects
		ParticleStart.transform.position = StartPosition;
		//ParticleStart.transform.rotation = Quaternion.Euler (angleStart.x, angleStart.y, angleStart.z);
		ParticleStart.transform.rotation = Quaternion.Euler (0, 0, 0);
		ParticleStart.SetActive (true);
		
		//calculation for the splash particle effect - angle, rotation, position
		endPosition = WaterWay [indexK - 1];
		indexLastLast = WaterWay [indexK - 2];
		alphaTilde = Mathf.Atan ((indexLastLast.y - endPosition.y) / (endPosition.x - indexLastLast.x));
		angleEnd.x = 180-90-(alphaTilde*Mathf.Rad2Deg);
		angleEnd.y = 0;
		angleEnd.z = AngleHoriz * -1;
		
		//init calculate parameter to the splash particle effect
		EndingParticles.transform.position = endPosition;
		EndingParticles.transform.rotation = Quaternion.Euler (angleEnd.x, angleEnd.y, angleEnd.z); //unity with euler method
		EndingParticles.SetActive (true);
		
		//particleSystem = ParticleStart.GetComponentInChildren<ParticleSystem>();
		delayWaterPos = 0;
		CalculateParticleSizeStepSize ();
		
		
	}
	
	// visual the parabel curve with any game object - Tpublic TextCube
	void Update () {
		//TestCube.transform.position = WaterWay [k];
		SetParticlesPos2 ();
		counterSweep++;
		
	}
	void LateUpdate(){
		SetWaterJetPending ();
		setWaterEndParticles ();
	}
	
	// catch the particles and give them a new position
	void SetParticlesPos2()
	{
		particleSystem.maxParticles=(WayPointSize/particlesMovingStep)-1;
		ParticleSystem.Particle[] particles = new ParticleSystem.Particle[particleSystem.particleCount];
		particleSystem.GetParticles(particles);
		int jj=particles.Length;
		float particleSize = ParticleSizeStart;
		if (iiii == particlesMovingStep) {
			iiii = 0;
		}
		for(int i = iiii; i < (WayPointSize-particlesMovingStep-1); i=i+particlesMovingStep)
		{
			particles[jj-1].position = new Vector3(WaterWay[i].x,WaterWay[i].y,WaterWay[i].z);
			// manipulate size of particles
			
			particles[jj-1].size=ParticleSizeStart;
			particles[jj-1].size=particleSize;
			jj--;
			
			particleSize=particleSize+particleSizeStep;
		}
		particleSystem.SetParticles(particles, particles.Length);
		iiii++;
		
	}
	
	// brings the water jet wiggle
	void SetWaterJetPending()
	{
		
		//pointsInerval = 1 - ((1 / (sizeOfParablePoints/particlesMovingStep)) * (sizeOfParablePoints/(2*particlesMovingStep)));
		
		if (upActive == true) {
			
			betatilde = betatilde + upP;
			if(betatilde>=(AngleVertical+wiggleBoarder)){
				upActive=false;
				downActive=true;
			}
		}
		if (downActive == true) {
			betatilde = betatilde - downP;
			if(betatilde<=(AngleVertical-wiggleBoarder)){
				
				upActive=true;
				downActive=false;
			}
		}
		float betatildeRad = betatilde * Mathf.Deg2Rad;
		alpha = AngleHoriz* Mathf.Deg2Rad;
		nullVelocity = Mathf.Sqrt ((Range * g) / Mathf.Sin (2 * betatildeRad));
		j = 0;
		
		WaterWay.Clear();
		//WayPointSize = 0;
		//loop to delate and new fill of the list parable steps
		pointsInerval = 0.8f;
		for (int i=0; i<(WayPointSize); i++) {
			j = 10 * i;
			j = j / 750;
			//different stepsize on t - start and ending (particles diastanc at the end is bigger then to start)
			j= StepSizeTAxis(j);
			waterPosition.x = nullVelocity * (j) * Mathf.Cos (betatildeRad);
			waterPosition.y = nullVelocity * (j) * Mathf.Sin (betatildeRad) - ((g / 2) * (j) * (j));
			waterPosition.z = waterPosition.x * Mathf.Tan (alpha);
			
			WaterWay.Add(new Vector3(waterPosition.x,waterPosition.y,waterPosition.z));
			indexK = i;
			//WayPointSize= WaterWay.Count;
			
		}
		WayPointSize= WaterWay.Count;
		endPosition = WaterWay [indexK - 5];
		EndingParticles.transform.position = endPosition;
		
	}
	
	void CalculateParticleSizeStepSize(){
		particleSizeStep = (ParticleSizeEnd - ParticleSizeStart) / (WaterWay.Count / particlesMovingStep);
		
	}
	
	float StepSizeTAxis(float j){
		
		j = j * pointsInerval;
		
		pointsInerval = pointsInerval + 0.0025f;
		return j;
		
	}
	
	void setWaterEndParticles(){
		
		WaterJetEndParticles.transform.position = WaterWay[WaterWay.Count-(WaterWay.Count/4)];
		WaterJetEndParticles.transform.rotation = Quaternion.Euler(new Vector3(35,(90+Mathf.Abs(AngleHoriz)),0));
	}
}
