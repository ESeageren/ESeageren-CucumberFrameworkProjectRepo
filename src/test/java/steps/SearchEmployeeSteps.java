
package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.SearchEmployeePage;
import utils.CommonMethods;

public class SearchEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM menu")
    public void user_clicks_on_pim_menu() {
        WebElement pimMenu = driver.findElement(By.id("menu_pim_viewPimModule"));
        click(pimMenu);
    }

    @When("user clicks on Employee List menu")
    public void user_clicks_on_employee_list_menu() {
        WebElement employeeListMenu = driver.findElement(By.id("menu_pim_viewEmployeeList"));
        click(employeeListMenu);
    }

    @When("user enters a valid employee ID")
    public void user_enters_valid_employee_id() {
        sendText("56370773", searchEmployeePage.empIdField);
    }

    @When("user clicks the search button")
    public void user_clicks_the_search_button() {
        click(searchEmployeePage.searchButton);
    }

    @Then("user should see the employee details")
    public void user_should_see_employee_details() {
        System.out.println("Employee details are visible.");
    }

    @When("user enters a valid employee name")
    public void user_enters_valid_employee_name() {
        sendText("mark", searchEmployeePage.empNameField);
    }
}
