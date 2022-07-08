package Framework;

import org.openqa.selenium.WebDriver;

public abstract class PageObjectBase {
	private WebDriver driver;
	private String baseUrl;

	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
	}

	public String getCurrentUrl() {
		return getDriver().getCurrentUrl();
	}

	protected WebDriver getDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}
}
