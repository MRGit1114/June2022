package Pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.PageObjectBase;

public class ProductsPageObject extends PageObjectBase {

	public static final String URL = "https://ampeg.com/products/";

	public ProductsPageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public RocketBassPageObject rocketBass() {
		WebElement element = getDriver().findElement(By.cssSelector("a[href*='/rocket-bass']"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new RocketBassPageObject(getDriver(), getBaseUrl());
	}
}
