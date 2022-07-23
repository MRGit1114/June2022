package Tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Framework.PageObjectBase;
import Pages.LinksPage;
import Pages.RadioButtonPage;
import Pages.SelectMenuPage;
import Pages.SliderPage;

public class ControlExtensionTests extends DemoQaTestBase {

	@Test
	public void canSetRadioButtonYes() {

		String projected = "input[id='yesRadio']";

		String actual = new RadioButtonPage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.setYes()
				.getCurrentUrl();

		assertEquals(actual, projected, "Expected the Radio Button to be selected.");
	}

	@Test
	public void canSetRadioButtonImpressive() {

		String projected = "input[id='impressiveRadio']";

		String actual = ((PageObjectBase) new RadioButtonPage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.setImpressive())
				.getCurrentUrl();

		assertEquals(actual, projected, "Expected the Radio Button to be selected.");
	}

	@Test
	public void canSetRadioButtonNo() {
		//this needs some work to run, attempting to declare that an element is missing (false)
		/*
		 * Boolean projected = true;
		 * 
		 * Boolean actual = new RadioButtonPage(this.getDriver(), this.getBaseUrl())
		 * .navigate() .setNo() .getCurrentUrl();
		 * 
		 * assertEquals(actual, projected,
		 * "Expected the Radio Button to be selectable.");
		 */


	}

	@Test
	public void canClickLink() {

		String ExpectedLink = "Created";

		LinksPage ActualLink = new LinksPage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.clickLink();

		assertEquals(ActualLink, ExpectedLink, "Expected to click on 'created' link.");
	}

	@Test
	public void canSetSliderValueTo80() {
		
		String projected = "80";

		String actual = new SliderPage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.getSliderValue()
				.getCurrentUrl();

		assertEquals(actual, projected, "Expected the slider to be set to 80.");
	}

	@Test
	public void canWrapDropdown() {
		
		String projected = "oldSelectMenu";

		String actual = new SelectMenuPage(this.getDriver(), this.getBaseUrl())
				.navigate()
				.selectDropdown()
				.getCurrentUrl();

		assertEquals(actual, projected, "Expected oldSelectMenu.");
	}
}
