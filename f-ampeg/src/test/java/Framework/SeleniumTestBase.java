package Framework;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.apache.commons.io.FileUtils;

public abstract class SeleniumTestBase {
	protected WebDriver driver;
	protected String baseUrl;

	public SeleniumTestBase(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	@BeforeTest
	protected void setup() {
		System.setProperty("webdriver.chrome.driver", "c:\\temp\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

	@AfterTest
	protected void cleanup() {
		File screenshotFile  = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshotFile , new File("C:\\temp\\TestNG Screenshot.png"));
		}
		catch (IOException e) {
			System.out.println(e.getMessage());
		}
		finally {
			this.driver.quit();
		}
	}
	
	protected WebDriver getDriver() {
		return this.driver;
	}
	
	protected String getBaseUrl() {
		return baseUrl;
	}
}
