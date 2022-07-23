package Pages;

import org.openqa.selenium.WebDriver;
import Framework.PageObjectBase;

public class ComparisonPageObject extends PageObjectBase {
	public static final String URL = "https://ampeg.com/rocket-bass/files/Ampeg-Rocket-Bass-Sales-Comp-Chart-18MAR2021.pdf";

	public ComparisonPageObject(WebDriver driver2, String baseUrl) {
		super(driver2, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}
}
