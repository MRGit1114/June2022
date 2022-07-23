package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class ManualsPageObject extends PageObjectBase {

	public static final String URL = "https://ampeg.com/support/manuals/#rocketbass";

	public ManualsPageObject(WebDriver driver2, String baseUrl) {
		super(driver2, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public RB108ManualPageObject rb108Manual() {
		WebElement element = getDriver().findElement(By.cssSelector("a[href*='/support/manuals/rocket-bass-108']"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new 	RB108ManualPageObject(getDriver(), getBaseUrl());
	}
}
