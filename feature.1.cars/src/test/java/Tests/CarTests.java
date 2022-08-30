package Tests;

import org.testng.annotations.Test;

public class CarTests extends Car{
	
	public CarTests(String model, String carEngine, int odo) {
		super(model, carEngine, odo);
		return;
	}
	
  @Test
  public void canBuildCar() {
		
		carModel = "Corvette";
		Car car = new Car(carModel, carEngine, getOdometer())
		.Start();
		
		System.out.println(carModel);
	}
}
