package steps;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps {

    LoginPage loginPage;

    @Given("user is in OrangeHRM login page")
    public void user_is_in_orange_hrm_login_page() {

        loginPage = new LoginPage();
        loginPage.openLoginPage();
    }

    // ---------- POSITIVE SCENARIO ----------

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {

        loginPage.login("Admin", "admin123");
    }

    @Then("user should see the dashboard page")
    public void user_should_see_the_dashboard_page() {

        Assert.assertTrue(
                loginPage.isDashboardVisible(),
                "Dashboard is not visible — Login failed"
        );
    }

    // ---------- NEGATIVE SCENARIO ----------

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {

        loginPage.login("athishy", "wrongpassword");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {

        Assert.assertTrue(
                loginPage.isErrorDisplayed(),
                "Error message not displayed for invalid login"
        );
    }
}
