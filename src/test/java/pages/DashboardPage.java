package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DashboardPage {
	
	WebDriver driver;
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	By dashboardText =By.xpath("//h6[text()='Dashboard']");
	By profileIcon = By.xpath("//span[@class='oxd-userdropdown-tab']");
	
	public boolean isDashboardVisible() {
		return driver.findElement(dashboardText).isDisplayed();
	}
	public void mouseHoverProfile() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(profileIcon)).perform();
	}
}
