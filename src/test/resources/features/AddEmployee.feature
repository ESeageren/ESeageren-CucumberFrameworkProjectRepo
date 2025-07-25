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

  @add
  Scenario: Add employee without providing an employee ID
    #Given admin user is on the Add Employee page
    When admin enters a valid name
    And admin leaves the employee ID field blank
    And admin clicks the Save button
    Then employee should be added successfully with a system-generated employee ID

  @add
  Scenario: Add employee by providing a unique employee ID
    #Given admin user is on the Add Employee page
    When admin enters a valid name and a valid employee ID
    And admin clicks the Save button
    Then employee should be added successfully with employee ID EMP1001

  @add
  Scenario: Submit form with missing required fields
    #Given admin user is on the Add Employee page
    When admin enters a name with missing required fields
    And admin clicks the Save button
    Then user should see the required field messages

  @add
  Scenario: Submit form with invalid employee ID format
    #Given admin user is on the Add Employee page
    When admin enters an invalid employee ID
    And admin clicks the Save button
    Then user should see the invalid employee ID message
