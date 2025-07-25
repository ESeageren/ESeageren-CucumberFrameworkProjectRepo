package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utils.CommonMethods.driver;
import static utils.PageInitializer.loginPage;

public class LoginSteps {


    @Given("user is on the HRMS login page")
    public void user_is_on_the_hrms_login_page() {
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @When("user enters valid admin credentials")
    public void user_enters_valid_admin_credentials() {
        loginPage.usernameField.sendKeys("admin");
        loginPage.passwordField.sendKeys("Hum@nhrm123");
    }

    @When("user clicks the login button")
    public void user_clicks_the_login_button() {
        loginPage.loginButton.click();
    }

    @When("user leaves the username field empty and enters a valid password")
    public void user_leaves_the_username_field_empty_and_enters_a_valid_password() {
        loginPage.usernameField.clear();
        loginPage.passwordField.sendKeys("Hum@nhrm123");
    }

    @Then("user should see the error message {string}")
    public void user_should_see_the_error_message(String expectedMessage) {
        WebElement error = driver.findElement(By.id("spanMessage"));
        String actualMessage = error.getText().trim();
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @When("user enters a valid username and leaves the password field empty")
    public void user_enters_a_valid_username_and_leaves_the_password_field_empty() {
        loginPage.usernameField.sendKeys("admin");
        loginPage.passwordField.clear();
    }

    @Then("user should see the message for empty password")
    public void user_should_see_the_message_for_empty_password() {
        WebElement error = driver.findElement(By.id("spanMessage"));
        String actualMessage = error.getText().trim();
        Assert.assertEquals("Password is Empty", actualMessage);
    }

    @When("user enters invalid username and valid password")
    public void user_enters_invalid_username_and_valid_password() {
        loginPage.usernameField.sendKeys("wrongUser");
        loginPage.passwordField.sendKeys("Hum@nhrm123");
    }

    @Then("user should see the message for invalid credentials")
    public void user_should_see_the_message_for_invalid_credentials() {
        WebElement error = driver.findElement(By.id("spanMessage"));
        String actualMessage = error.getText().trim();
        Assert.assertEquals("Invalid credentials", actualMessage);
    }

    @When("user enters valid username and invalid password")
    public void user_enters_valid_username_and_invalid_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtUsername")));
        usernameField.clear();
        usernameField.sendKeys("validUsername"); // Replace with your valid username

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtPassword")));
        passwordField.clear();
        passwordField.sendKeys("invalidPassword"); // Replace with invalid password
    }
    @Then("user is successfully logged in")
    public void user_is_successfully_logged_in() {
        // Example: verify the dashboard is visible after login
        WebElement dashboardText = driver.findElement(By.id("welcome")); // Or your actual dashboard element
        Assert.assertTrue("Login was not successful", dashboardText.isDisplayed());
    }
    @Then("user should see the message for empty username")
    public void user_should_see_the_message_for_empty_username() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement error = driver.findElement(By.id("txtUsername-error"));
        String actualMessage = error.getText().trim();
        Assert.assertEquals("Username cannot be empty", actualMessage);
    }

    @When("user enters {string} and {string} in the field and verify {string}")
    public void user_enters_and_in_the_field_and_verify(String username, String password, String errorMessage) {
        WebElement usernameField =driver.findElement(By.id("txtUsername"));
        usernameField.clear();
        usernameField.sendKeys(username); // Replace with your valid username

        WebElement passwordField = driver.findElement(By.id("txtPassword"));
        passwordField.clear();
        passwordField.sendKeys(password);

        loginPage.loginButton.click();

        WebElement error = driver.findElement(By.id("spanMessage"));
        String actualMessage = error.getText();
        Assert.assertEquals(errorMessage, actualMessage);

    }
}
