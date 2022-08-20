package stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.concurrent.TimeUnit;

public class Steps {
	private WebDriver driver = null;

	  @Given("User is on home page")
	  public void UserIsOnHomePageT1() {
	  	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.get("http://ampeg.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @And("User selects Products button")
	  public void UserSelectsProductsButtonT1() {
		  this.driver.findElement(By.cssSelector(".main-item.products")).click();
	  }
	  
	  @And("User selects Rocket Bass from the list")
	  public void UserSelectsRocketBassT1() {
		  this.driver.findElement(By.cssSelector("a[href*='/rocket-bass']")).click();
	  }
	  
	  @And("User selects Find a Dealer button")
	  public void UserSelectsDealerButtonT1() {
		  this.driver.findElement(By.id("powercab-dealer-btn")).click();
	  }
	  
	  @Then("User selects Buy Now button near the RB-108 product image")
	  public void UserSelectsBuyNowButtonT1() {
		  this.driver.findElement(By.cssSelector("a.cta.generic-buy-button-2021")).click();
		  this.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	  }
	  
	  @Given("User is on home page")
	  public void UserIsOnHomePageT2() {
	  	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.get("http://ampeg.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @And("User selects Products button")
	  public void UserSelectsProductsButtonT2() {
		  this.driver.findElement(By.cssSelector(".main-item.products")).click();
	  }
	  
	  @And("User selects Rocket Bass from the list")
	  public void UserSelectsRocketBassT2() {
		  this.driver.findElement(By.cssSelector("a[href*='/rocket-bass']")).click();
	  }
	  
	  @Then("User selects RB-108 button")
	  public void UserSelectsRB108T2() {
		  this.driver.findElement(By.linkText("RB-108")).click();
	  }
	  
	  @Given("User is on home page")
	  public void UserIsOnHomePageT3() {
	  	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.get("http://ampeg.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @And("User selects Products button")
	  public void UserSelectsProductsButtonT3() {
		  this.driver.findElement(By.cssSelector(".main-item.products")).click();
	  }
	  
	  @And("User selects Rocket Bass from the list")
	  public void UserSelectsRocketBassT3() {
		  this.driver.findElement(By.cssSelector("a[href*='/rocket-bass']")).click();
	  }
	  
	  @And("User selects RB-108 button")
	  public void UserSelectsRB108T3() {
		  this.driver.findElement(By.linkText("RB-108")).click();
	  }
	  
	  @And("User selects Manuals button")
	  public void UserSelectsManualsT3() {
		  this.driver.findElement(By.linkText("MANUALS")).click();
	  }
	  
	  @Then("User selects Rocket Bass 108 from the list")
	  public void UserSelectsRocketBass108T3() {
		  this.driver.findElement(By.cssSelector("a[href*='/support/manuals/rocket-bass-108']")).click();
	  }
	  
	  @Given("User is on home page")
	  public void UserIsOnHomePageT4() {
	  	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.get("http://ampeg.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @And("User selects Products button")
	  public void UserSelectsProductsButtonT4() {
		  this.driver.findElement(By.cssSelector(".main-item.products")).click();
	  }
	  
	  @And("User selects Rocket Bass from the list")
	  public void UserSelectsRocketBassT4() {
		  this.driver.findElement(By.cssSelector("a[href*='/rocket-bass']")).click();
	  }
	  
	  @And("User selects RB-108 button")
	  public void UserSelectsRB108T4() {
		  this.driver.findElement(By.linkText("RB-108")).click();
	  }
	  
	  @Then("User selects Comparison Chart button")
	  public void UserSelectsComparisonChartT4() {
		  this.driver.findElement(By.linkText("COMPARISON CHART")).click();
	  }
	  
	  @Given("User is on home page")
	  public void UserIsOnHomePageT5() {
	  	System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
		this.driver = new ChromeDriver();
		this.driver.get("http://ampeg.com/");
		this.driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  }
	  
	  @And("User selects Products button")
	  public void UserSelectsProductsButtonT5() {
		  this.driver.findElement(By.cssSelector(".main-item.products")).click();
	  }
	  
	  @And("User selects Rocket Bass from the list")
	  public void UserSelectsRocketBassT5() {
		  this.driver.findElement(By.cssSelector("a[href*='/rocket-bass']")).click();
	  }
	  
	  @Then("User selects RB-108 EQ Flat image")
	  public void UserSelectsRB108EQFlatT5() {
		  this.driver.findElement(By.id("fx-1")).click();
	  }
	  
}
