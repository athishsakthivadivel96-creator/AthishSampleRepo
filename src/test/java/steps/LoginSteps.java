package steps;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
	
	WebDriver driver;
	WebDriverWait wait;
	

@Given("user is in OrangeHRM login Page")
public void user_is_in_orange_hrm_login_page() {
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
     
}

@When("user enters valid username and password")
public void user_enters_valid_username_and_password() {
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username"))).sendKeys("Admin");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password"))).sendKeys("admin123");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']"))).click();
    
}

@Then("user should see the dashboard page")
public void user_should_see_the_dashboard_page() {
	boolean dashBOradVisble = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[text()='Dashboard']"))).isDisplayed();
	Assert.assertTrue("Dashboard not displayed", dashBOradVisble);
	
	driver.quit();
	
   }


}
