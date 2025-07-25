package steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.AddEmployeePage;
import utils.CommonMethods;

import static utils.CommonMethods.driver;
import static utils.PageInitializer.addEmployeePage;

public class AddEmployeeSteps extends CommonMethods {

    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @Given("admin user is on the Add Employee page")
    public void admin_user_is_on_the_add_employee_page() {
        CommonMethods.driver.get("https://your-hrms-url/pim/addEmployee");
    }
    @When("user clicks on add employee option")
    public void user_clicks_on_add_employee_option() {
        WebElement addEmployeeButton = driver.findElement(By.id("menu_pim_addEmployee"));
        click(addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        sendText("Rabab", addEmployeePage.firstNameLoc);
        sendText("ms", addEmployeePage.middleNameLoc);
        sendText("karimzada", addEmployeePage.lastNameLoc);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("employee is added successfully")
    public void employee_is_added_successfully() {
        System.out.println("employee added");
    }

    @When("user enters {string} and {string} and {string} values")
    public void user_enters_and_and_values(String fn, String mn, String ln) {
        sendText(fn, addEmployeePage.firstNameLoc);
        sendText(mn, addEmployeePage.middleNameLoc);
        sendText(ln, addEmployeePage.lastNameLoc);
    }

    @When("user leaves firstname and lastname empty")
    public void user_leaves_firstname_and_lastname_empty() {
        sendText("", addEmployeePage.firstNameLoc);
        sendText("", addEmployeePage.lastNameLoc);
        // Optional: middle name left out intentionally
    }

    @Then("error messages should be shown near firstname and lastname fields")
    public void error_messages_should_be_shown_near_firstname_and_lastname_fields() {
        Assert.assertTrue(addEmployeePage.firstNameError.isDisplayed());
        Assert.assertTrue(addEmployeePage.lastNameError.isDisplayed());
    }

    @When("user enters {string} and {string} and {string} and employee ID {string}")
    public void user_enters_and_and_and_employee_id(String firstName, String middleName, String lastName, String empID) {
        sendText(firstName, addEmployeePage.firstNameLoc);
        sendText(middleName, addEmployeePage.middleNameLoc);
        sendText(lastName, addEmployeePage.lastNameLoc);
        sendText(empID, addEmployeePage.employeeIdLoc);
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        WebElement pimOption = driver.findElement(By.id("menu_pim_viewPimModule"));
        //the benefit of using this method is to get extra facilities available in it.
        //it will wait first for the element to be clickable
        click(pimOption);
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        //  WebElement loginButton = driver.findElement(By.id("btnLogin"));
        //loginButton.click();
        click(loginPage.loginButton);

    }

    @When("user enters username and password")
    public void user_enters_username_and_password() {
        //  WebElement usernameField = driver.findElement(By.id("txtUsername"));
        loginPage.usernameField.sendKeys("admin");

        //  WebElement passwordField = driver.findElement(By.id("txtPassword"));
        loginPage.passwordField.sendKeys("Hum@nhrm123");

    }
}

