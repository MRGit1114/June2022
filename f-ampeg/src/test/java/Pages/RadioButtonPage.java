package Pages;

import java.time.Duration;
import java.util.NoSuchElementException;

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
		
		WebElement element = getDriver().findElement(By.cssSelector("input[id='yesRadio']"));
		boolean radioButton = element.isSelected();
		element.click();
		
		return this;
	}

	public Object setImpressive() {
		WebElement element = getDriver().findElement(By.cssSelector("input[id='impressiveRadio']"));
		boolean radioButton = element.isSelected();
		element.click();
		
		return new 	RadioButtonPage(getDriver(), getBaseUrl());
	}
	
	public boolean setNo() {
		boolean itExists = true;
		//attempt to find disabled button in page
		/*
		 * try { getDriver().findElement(By.cssSelector("input[id='noRadio']")); } catch
		 * (NoSuchElementException e) { itExists = false; }
		 */
	    return itExists;
	}
}
