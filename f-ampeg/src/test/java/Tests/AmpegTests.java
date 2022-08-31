package Tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.Test;
import Pages.BuyNowPageObject;
import Pages.ComparisonPageObject;
import Pages.HomePageObject;
import Pages.RB108ManualPageObject;
import Pages.RB108PageObject;
import Pages.RocketBassPageObject;

public class AmpegTests extends AmpegTestBase {
	@Test
	public void findDealerTest() {
		String actualUrl = new HomePageObject(this.driver, this.getBaseUrl())
				.navigate()
				.products()
				.rocketBass()
				.findDealer()
				.buyNow()
				.getCurrentUrl();

		assertEquals(actualUrl, BuyNowPageObject.URL, "User was expected to be on the main page.");
	}

	@Test
	public void findDescriptionTest() {
		String actualUrl = new HomePageObject(this.driver, this.getBaseUrl())
				.navigate()
				.products()
				.rocketBass()
				.rb108()
				.getCurrentUrl();

		assertEquals(actualUrl, RB108PageObject.URL, "User was expected to be on the main page.");
	}

	@Test
	public void findUserManualTest() {
		String actualUrl = new HomePageObject(this.driver, this.getBaseUrl())
				.navigate()
				.products()
				.rocketBass()
				.rb108()
				.manuals()
				.rb108Manual()
				.getCurrentUrl();

		assertEquals(actualUrl, RB108ManualPageObject.URL, "User was expected to be on the main page.");
	}

	@Test
	public void comparisonChartTest() {
		String actualUrl = new HomePageObject(this.driver, this.getBaseUrl())
				.navigate()
				.products()
				.rocketBass()
				.rb108()
				.comparison()
				.getCurrentUrl();

		assertEquals(actualUrl, ComparisonPageObject.URL, "User was expected to be on the main page.");
	}

	@Test
	public void soundSampleTest() {
		String actualUrl = new HomePageObject(this.driver, this.getBaseUrl())
				.navigate()
				.products()
				.rocketBass()
				.soundSample()
				.getCurrentUrl();

		assertEquals(actualUrl, RocketBassPageObject.URL, "User was expected to be on the main page.");
	}
}
