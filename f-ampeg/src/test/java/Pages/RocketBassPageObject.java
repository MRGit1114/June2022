package Pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Framework.PageObjectBase;

public class RocketBassPageObject extends PageObjectBase {

	long durationToRunAudioSample = 10L;
	TimeUnit time = TimeUnit.SECONDS;
	public static final String URL = "https://ampeg.com/rocket-bass/";

	public RocketBassPageObject(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public String getCurrentUrl() {
		return this.getDriver().getCurrentUrl();
	}

	public DealerPageObject findDealer() {
		WebElement element = getDriver().findElement(By.id("powercab-dealer-btn"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new DealerPageObject(getDriver(), getBaseUrl());
	}

	public RB108PageObject rb108() {
		WebElement element = getDriver().findElement(By.linkText("RB-108"));
		element.click();

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new RB108PageObject(getDriver(), getBaseUrl());
	}

	public RocketBassPageObject soundSample() {

		WebElement element = getDriver().findElement(By.id("fx-1"));
		element.click();
		try {

			time.sleep(durationToRunAudioSample);
		}

		catch (InterruptedException e) {
			System.out.println("Interrupted "
					+ "while Sleeping");
		}

		Set<String> handles = getDriver().getWindowHandles();
		String lastHandle = Helpers.getLastWindowHandle(handles);

		getDriver().switchTo().window(lastHandle);

		return new RocketBassPageObject(getDriver(), getBaseUrl());
	}
}
