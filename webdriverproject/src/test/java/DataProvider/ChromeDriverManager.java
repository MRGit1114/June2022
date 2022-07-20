package DataProvider;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import DataProvider.ChromeDriverManager;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	public WebDriver createDriver() {
		System.out.println("Initializing Chrome Driver");
		//WebDriverManager.getInstance(CHROME).setup();
		return new ChromeDriver(getChromeOptions());
	}

	private ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		options.addArguments("--start-maximized");
		options.addArguments("--disable-features=EnableEphemeralFlashPermission");
		options.addArguments("--disable-infobars");

		return options;
	}
}
