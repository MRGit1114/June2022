package Pages;

import org.openqa.selenium.WebElement;

public class RadioButton {
	
	private WebElement mappedElement;
	
	public RadioButton(WebElement mappedElement) {
		this.mappedElement = mappedElement;
	}
	
	public void setValue(String value) {
		this.mappedElement.sendKeys(value); //change this maybe later for bool
	}
	
	public String getValue() {
		return this.mappedElement.getText();
	}

	public void select(String string) {
		// TODO Auto-generated method stub
		
	}
}
