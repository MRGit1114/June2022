package Framework;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class SeleniumTestBase {
	protected WebDriver driver;
	protected final String BASE_URL = "http://www.ampeg.com";

	@BeforeTest
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\temp\\chromedriver.exe");
		this.driver = new ChromeDriver();
		//this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterTest
	protected void cleanup() {
		this.driver.quit();
	}
}
