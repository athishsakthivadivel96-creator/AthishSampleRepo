package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import driver.DriverFactory;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    public LoginPage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Locators
    By username = By.name("username");
    By password = By.name("password");
    By loginBtn = By.xpath("//button[@type='submit']");
    By dashboard = By.xpath("//h6[text()='Dashboard']");
    By errorMessage = By.xpath("//p[text()='Invalid credentials']");
    // Open URL
    public void openLoginPage() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        // Wait for username field to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
    }

    // Login Method
    public void login(String user, String pass) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(username))
                .sendKeys(user);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    // Positive validation
    public boolean isDashboardVisible() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(dashboard));
            return driver.findElement(dashboard).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean isErrorVisible() {
        return driver.findElements(errorMessage).size() > 0;
    }

    // Negative validation
    public boolean isErrorDisplayed() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
            return driver.findElement(errorMessage).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}