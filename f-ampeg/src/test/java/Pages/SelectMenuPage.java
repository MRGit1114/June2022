package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Framework.PageObjectBase;

public class SelectMenuPage extends PageObjectBase {
	
	private final String URL = "/select-menu";
	
	public SelectMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public SelectMenuPage navigate() {
		super.navigate(URL);

		return this;
	}

	public PageObjectBase selectDropdown() {
		WebElement element = getDriver().findElement(By.cssSelector("select[id='oldSelectMenu']"));
		boolean radioButton = element.isSelected();
		element.click();
		
		return this;
	}
}
