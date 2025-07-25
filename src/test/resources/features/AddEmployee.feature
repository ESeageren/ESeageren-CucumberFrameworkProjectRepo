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

Feature: add employee scenarios

  Scenario: Add employee without providing an employee ID
    Given admin user is on the Add Employee page
    When admin enters first name "John" and middle name "M" and last name "Doe"
    And admin leaves the employee ID field blank
    And admin clicks the Save button
    Then employee should be added successfully with a system-generated employee ID

  Scenario: Add employee by providing a unique employee ID
    Given admin user is on the Add Employee page
    When admin enters first name "Alice" and middle name "" and last name "Smith"
    And admin enters employee ID "EMP1001"
    And admin clicks the Save button
    Then employee should be added successfully with employee ID "EMP1001"

  Scenario: Submit form with missing required fields
    Given admin user is on the Add Employee page
    When admin enters first name "" and middle name "" and last name ""
    And admin clicks the Save button
    Then user should see the message "First Name is required"
    And user should see the message "Last Name is required"

  Scenario: Submit form with invalid employee ID format
    Given admin user is on the Add Employee page
    When admin enters first name "Jane" and middle name "" and last name "Doe"
    And admin enters employee ID "@@@123"
    And admin clicks the Save button
    Then user should see the message "Invalid Employee ID format"
