package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class RB108PageObject extends PageObjectBase {

	public static final String URL = "https://ampeg.com/rocket-bass/rb-108.html";

	public RB108PageObject(WebDriver driver2, String baseUrl) {
		super(driver2, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public ManualsPageObject manuals() {
		WebElement element = getDriver().findElement(By.linkText("MANUALS"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new 	ManualsPageObject(getDriver(), getBaseUrl());
	}

	public ComparisonPageObject comparison() {
		WebElement element = getDriver().findElement(By.linkText("COMPARISON CHART"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new 	ComparisonPageObject(getDriver(), getBaseUrl());
	}
}
