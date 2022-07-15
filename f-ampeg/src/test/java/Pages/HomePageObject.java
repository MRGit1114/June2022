package Pages;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.PageObjectBase;

public class HomePageObject extends PageObjectBase {

	public HomePageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public HomePageObject navigate() {
		getDriver().navigate().to(getBaseUrl());

		return this;
	}

	public ProductsPageObject products() {
		WebElement element = getDriver().findElement(By.cssSelector(".main-item.products"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new ProductsPageObject(getDriver(), getBaseUrl());
	}
}
