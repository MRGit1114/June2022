package Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.PageObjectBase;

public class DealerPageObject extends PageObjectBase {

	long waitForDealersToLoad = 2L;
	TimeUnit time = TimeUnit.SECONDS;

	public static final String URL = "https://ampeg.com/rocket-bass/buy.html";

	public DealerPageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public BuyNowPageObject buyNow() {
		WebElement element = getDriver().findElement(By.cssSelector("a.cta.generic-buy-button-2021"));
		element.click();

		try {

			time.sleep(waitForDealersToLoad);
		}

		catch (InterruptedException e) {
			System.out.println("Interrupted "
					+ "while Sleeping");
		}

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new BuyNowPageObject(getDriver(), getBaseUrl());
	}
}
