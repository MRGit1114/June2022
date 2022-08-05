package Tests;

import Tests.LargeEngine;

public class Car extends LargeEngine {
	
	protected String carModel;
	protected String carEngine;
	private int odometer;
	
	public Car(String model, String carEngine, int odo) {
		carModel=model;
		LargeEngine carEngine1 = new LargeEngine();
		odometer=odo;
	}
	
	public String getCarModel() {
		
		return carModel;
	}
	
	public int getOdometer() {
		
		return this.odometer;
	}

	public Car Start() {
		System.out.println("Engine started");
		return null;
	}
}
