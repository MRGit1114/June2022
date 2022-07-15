package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.PageObjectBase;

public class RadioButtonPage extends PageObjectBase {

	private final String URL = "/radio-button";
	
	public RadioButtonPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public RadioButtonPage navigate() {
		super.navigate(URL);

		return this;
	}

	public RadioButtonPage setYes() {
		//WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = getDriver().findElement(By.cssSelector("input[name='yesRadio']"));
		boolean radioButton = element.isSelected();
		if(radioButton == false) {
			element.click();
		}
		//WebElement element = getDriver().findElement(By.id("yesRadio"));
		//RadioButton button = new RadioButton(element);
		//button.select("Yes");
		
		//return new 	RadioButtonHomePageObject(getDriver(), getBaseUrl());
		return this;
	
	}

	public Object setImpressive() {
		WebElement element = getDriver().findElement(By.id("impressiveRadio"));
		element.click();
		
		return new 	RadioButtonPage(getDriver(), getBaseUrl());
	}
}
