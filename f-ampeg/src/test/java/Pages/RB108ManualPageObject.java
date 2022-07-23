package Pages;

import org.openqa.selenium.WebDriver;

import Framework.PageObjectBase;

public class RB108ManualPageObject extends PageObjectBase {

	public static final String URL = "https://ampeg.com/support/manuals/rocket-bass-108";

	public RB108ManualPageObject(WebDriver driver2, String baseUrl) {
		super(driver2, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}
}
