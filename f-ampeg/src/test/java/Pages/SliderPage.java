package Pages;

import java.util.Set;

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
	
	public SliderPage setSlider() {
		//TODO add web element for slider and values (value="25" on ToolsQA) to pass
		WebElement element = getDriver().findElement(By.id("sliderValue"));
		Slider slider = new Slider(element);
		return null;
	}
}
