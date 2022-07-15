package Pages;

import org.openqa.selenium.WebDriver;

import Framework.PageObjectBase;

public class SelectMenuPage extends PageObjectBase {
	
	private final String URL = "/slider";
	
	public SelectMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public SelectMenuPage navigate() {
		super.navigate(URL);

		return this;
	}
}
