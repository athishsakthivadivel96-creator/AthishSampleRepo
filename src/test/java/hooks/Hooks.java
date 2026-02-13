package hooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import driver.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;


public class Hooks{
	
	@Before
	public void setup() {
		DriverFactory.initDriver();
		
	}
	
	
	@After
	public void tearDown(Scenario Scenario) {
		
		WebDriver driver = DriverFactory.getDriver();
		
		if (Scenario.isFailed() ) {
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		
		Scenario.attach(screenshot, "image/png", "Failure Screenshot");
		}
		
		DriverFactory.quitDriver();
	}
}
