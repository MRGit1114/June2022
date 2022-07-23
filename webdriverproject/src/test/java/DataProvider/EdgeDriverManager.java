package DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import DataProvider.EdgeDriverManager;

public class EdgeDriverManager extends DriverManager {

	@Override
	public WebDriver createDriver() {
		System.out.println("Initializing Edge Driver");
		//WebDriverManager.getInstance(EDGE).setup();
		return new EdgeDriver(getEdgeOptions());
	}

	private EdgeOptions getEdgeOptions() {
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("--disable-infobars");

		return options;
	}
}
