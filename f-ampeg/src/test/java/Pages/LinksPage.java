package Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class LinksPage extends PageObjectBase {
	
	private final String URL = "/links";

	public LinksPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public LinksPage navigate() {
		super.navigate(URL);

		return this;
	}

	public LinksPage clickLink() {
		WebElement element = getDriver().findElement(By.linkText("Created"));
		Hyperlink hyperlink = new Hyperlink(element);
		Hyperlink.click();
		

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new 	LinksPage(getDriver(), getBaseUrl());
	}

}
