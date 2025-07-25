#USER STORY-LOGIN VALIDATION FOR HRMS PORTAL
#As a user attempting to log into the HRM portal,
#I want clear and specific error messages during the login process,
#So that I can understand if my login attempt failed due to missing fields or incorrect credentials.

  #ACCEPTANCE CRITERIA
#1. If a user attempts to log in with an empty username field, the system should display an error message
#stating "Username cannot be empty."
#2. If a user attempts to log in with an empty password field, the system should display an error message
#stating "Password is empty."
#3. If a user enters incorrect login credentials (either the wrong username or password), the system should
#display an error message stating "Invalid credentials."
#4. The error messages should be clear and easily visible to the user, ideally placed near the respective input
#fields.
#5. After displaying the error message, the system should allow the user to correct their input and attempt to
#log in again.

Feature: login scenarios

  Background:
    Given user is on the HRMS login page

  @login
  Scenario: Valid admin login
    When user enters valid admin credentials
    And user clicks the login button
    Then user is successfully logged in

  @login
  Scenario: Empty username login attempt
    When user leaves the username field empty and enters a valid password
    And user clicks the login button
    Then user should see the message for empty username

  @login
  Scenario: Empty password login attempt
    When user enters a valid username and leaves the password field empty
    And user clicks the login button
    Then user should see the message for empty password

  @login
  Scenario: Invalid login with wrong username
    When user enters invalid username and valid password
    And user clicks the login button
    Then user should see the message for invalid credentials

  @login
  Scenario: Invalid login with wrong password
    When user enters valid username and invalid password
    And user clicks the login button
    Then user should see the message for invalid credentials

    @error
    Scenario Outline: Error validation
      When user enters "<username>" and "<password>" in the field and verify "<errormessage>"
      Examples:
        | username | password | errormessage |
        |admin     |          |Password is Empty|
        |          |test      |Username cannot be empty|
        |admin     |test      |Invalid credentials     |
        |admin123  |Hrm123    |Invalid credentials    |








