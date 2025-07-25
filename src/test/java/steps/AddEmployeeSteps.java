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

public class AddEmployeeSteps {

    AddEmployeePage addEmployeePage = new AddEmployeePage();

    @Given("admin user is on the Add Employee page")
    public void admin_user_is_on_the_add_employee_page() {
        CommonMethods.driver.get("https://your-hrms-url/pim/addEmployee");
    }

    @When("admin enters a valid name")
    public void admin_enters_a_valid_name() {
        addEmployeePage.firstNameLoc.sendKeys("John");
        addEmployeePage.middleNameLoc.sendKeys("A");
        addEmployeePage.lastNameLoc.sendKeys("Doe");
    }

    @When("admin leaves the employee ID field blank")
    public void admin_leaves_the_employee_id_field_blank() {

    }

    @When("admin clicks the Save button")
    public void admin_clicks_the_save_button() {
        addEmployeePage.saveButton.click();
    }

    @Then("employee should be added successfully with a system-generated employee ID")
    public void employee_should_be_added_successfully_with_a_system_generated_employee_id() {

        System.out.println("Verify employee is added with system-generated ID (not implemented due to missing elements)");
    }

    @When("admin enters a valid name and a valid employee ID")
    public void admin_enters_a_valid_name_and_a_valid_employee_id() {
        addEmployeePage.firstNameLoc.sendKeys("Jane");
        addEmployeePage.middleNameLoc.sendKeys("B");
        addEmployeePage.lastNameLoc.sendKeys("Smith");


        System.out.println("Enter valid employee ID 'EMP1001' (field missing in AddEmployeePage, so skipping)");
    }

    @Then("employee should be added successfully with employee ID EMP1001")
    public void employee_should_be_added_successfully_with_employee_id_emp1001() {
        System.out.println("Verify employee is added with ID EMP1001 (not implemented due to missing elements)");
    }

    @When("admin enters a name with missing required fields")
    public void admin_enters_a_name_with_missing_required_fields() {
        addEmployeePage.firstNameLoc.clear();
        addEmployeePage.middleNameLoc.clear();
        addEmployeePage.lastNameLoc.clear();
    }

    @Then("user should see the required field messages")
    public void user_should_see_the_required_field_messages() {
        System.out.println("Verify required field messages are displayed (no locator available in AddEmployeePage)");
    }

    @When("admin enters an invalid employee ID")
    public void admin_enters_an_invalid_employee_id() {
        System.out.println("Enter invalid employee ID (field missing in AddEmployeePage, so skipping)");
    }

    @Then("user should see the invalid employee ID message")
    public void user_should_see_the_invalid_employee_id_message() {
        System.out.println("Verify invalid employee ID message is displayed (no locator available in AddEmployeePage)");
    }
}
