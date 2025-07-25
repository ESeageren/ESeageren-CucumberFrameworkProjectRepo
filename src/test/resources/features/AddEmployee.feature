#USER STORY- ADD EMPLOYEE TO HRMS
#As an admin user, I want to be able to add an employee to the HRMS application, either
# with or without providing a unique employee ID, so that the system can generate or
# accept a unique employee ID and store the employee's details properly.

#ACCEPTANCE CRITERIA
#1. An admin user should be able to add an employee to the HRMS application without providing an
#employee ID. The system should automatically generate a unique employee ID for the new employee.
# - Required fields for this process: - First Name - Middle Name (optional) - Last Name
#2. An admin user should also have the option to add an employee to the HRMS application by providing a
#unique employee ID. - Required fields for this process: - First Name - Middle Name (optional) - Last Name - Employee ID
#3. The system should provide appropriate error messages or prompts for users who attempt to submit
#incomplete or invalid employee information.
# Error messages should be: - Clear - Easily visible - Placed near the respective input fields.

Feature: Add employee scenarios

  Background:
     #Given user is navigated to HRMS application
    When user enters username and password
    And user clicks on login button
    Then user is successfully logged in
    When user clicks on PIM option
    When user clicks on add employee option

  @smoke @regression
  Scenario: Adding one employee
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee is added successfully

  @datadriven @regression
  Scenario Outline: adding multiple employees for data driven testing using examples table
    And user enters "<firstName>" and "<middleName>" and "<lastName>" values
    And user clicks on save button
    Then employee is added successfully
    Examples:
      | firstName | middleName | lastName |
      | nawab     | ms         | amin     |
      | zafar     | ms         | dana     |
      | latham    | ms         | izanica  |

  @negative @regression
  Scenario: Adding employee with missing required fields
    And user leaves firstname and lastname empty
    And user clicks on save button
    Then error messages should be shown near firstname and lastname fields

  @customID @regression
  Scenario: Adding employee with a provided employee ID
    And user enters "Alice" and "B" and "Johnson" and employee ID "EMP2025"
    And user clicks on save button
    Then employee is added successfully

