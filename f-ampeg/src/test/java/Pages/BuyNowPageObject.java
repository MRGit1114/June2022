package Pages;

import org.openqa.selenium.WebDriver;
import Framework.PageObjectBase;

public class BuyNowPageObject extends PageObjectBase {

	public static final String URL = "https://ampeg.com/rocket-bass/buy.html";

	public BuyNowPageObject(WebDriver driver2, String baseUrl) {
		super(driver2, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}
}
