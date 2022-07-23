package Tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import DataProvider.DriverManager;


public class TestBase extends DriverManager {
	@Test
	public void readValuesFromConfigFile() {
		String actualLocation = propertyFilePath;
		String testLocation = "src//main//resources//config.properties";

		assertEquals(testLocation, actualLocation, "Config.properties was found in another location.");
	}
	
	@Test
	public void canLaunchCorrectWebDriver() {
		String browserType = "edge";
		String expectedWebDriver = getBrowser();
		
		assertEquals(expectedWebDriver, browserType, "The expected string value for the specified browser was not found.");
	}
}