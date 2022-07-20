package DataProvider;

import org.openqa.selenium.WebDriver;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

	protected ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	private Driver WebDriver;
	private Properties properties;
	protected final String propertyFilePath= "src//main//resources//config.properties";

	public WebDriver createDriver() {
		return null;
	}

	public WebDriver getDriver() {
		if (null == drivers.get()) {
			drivers.set(this.createDriver());
		}
		drivers.get().manage().timeouts().implicitlyWait(1L, TimeUnit.SECONDS);

		return drivers.get();
	}

	protected void setDriver(WebDriver driver) {
		return;
	}

	public void quitDriver() {
		if (null != drivers.get()) {
			try {
				drivers.get().quit();
				drivers.remove();
			} catch (Exception e) {
				System.err.println("Unable to gracefully quit WebDriver." +e);
			}

		}
	}

	public DriverManager(){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at " + propertyFilePath);
		}		
	}

	public String getDriverPath(){
		String driverPath = properties.getProperty("driverPath");
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("driverPath not specified in the config.properties file.");		
	}

	public long getImplicitlyWait() {		
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if(implicitlyWait != null) return Long.parseLong(implicitlyWait);
		else throw new RuntimeException("implicitlyWait not specified in the config.properties file.");		
	}

	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if(url != null) return url;
		else throw new RuntimeException("url not specified in the config.properties file.");
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		if(browser != null) return browser;
		else throw new RuntimeException("browser not specified in the config.properties file.");
	}
}