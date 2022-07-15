package Tests;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Pages.LinksPage;
import Pages.RadioButtonPage;
import Pages.SelectMenuPage;
import Pages.SliderPage;

public class ControlExtensionTests extends DemoQaTestBase {

	@Test
	public void canSetRadioButton() {
		
		String actualUrl = new RadioButtonPage(this.getDriver(), this.getBaseUrl())
		.navigate()
		.setYes()
		//TODO .setImpressive()
		//TODO .setNo() and catch exception to pass
		.getCurrentUrl();
		
		//assertEquals(actual, projected, "");
	}
	
	@Test
	public void canClickLink() {
		
		String actualUrl = new LinksPage(this.getDriver(), this.getBaseUrl())
		.navigate()
		.clickLink()
		//TODO .getResult()
		.getCurrentUrl();
		
		//assertEquals(actual, projected, "");
	}
	
	@Test
	public void canSetSliderValues() {
		
		String actualUrl = new SliderPage(this.getDriver(), this.getBaseUrl())
		.navigate()
		//TODO .setValue(80);
		//TODO .setValue(17);
		//TODO .setValue(0);
		//TODO .setValue(100);
		.getCurrentUrl();
		
		//assertEquals(actual, projected, "");
	}
	
	@Test
	public void canWrapDropdown() {
		
		String actualUrl = new SelectMenuPage(this.getDriver(), this.getBaseUrl())
		.navigate()
		//TODO .setValue/.getValue()
		//TODO .getOptionsAsString()
		.getCurrentUrl();
		
		//assertEquals(actual, projected, "");
	}
}
