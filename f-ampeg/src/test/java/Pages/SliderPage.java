package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class SliderPage extends PageObjectBase {
	
	private final String URL = "/slider";
	
	public SliderPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public SliderPage navigate() {
		super.navigate(URL);

		return this;
	}
	
	public SliderPage getSliderValue() {
		WebElement element = getDriver().findElement(By.cssSelector("input[value='25']"));
		return this;
	}
	
	public SliderPage setValue() {
		Integer value = 80;
		WebElement element = getDriver().findElement(By.cssSelector("input[value='80']"));
		Slider slider = new Slider(element);
		
		return new SliderPage(getDriver(), getBaseUrl());
	}
}
