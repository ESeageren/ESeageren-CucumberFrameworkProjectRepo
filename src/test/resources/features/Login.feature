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

  Scenario: valid admin login
    #Given user is on the HRMS login page
    When user enters username "Admin" and password "admin123"
    And user clicks on login button
    Then user is successfully logged in

  Scenario: empty username login attempt
      #Given user is on the HRMS login page
    When user enters username "" and password "admin123"
    And user clicks the login button
    Then user should see the message "Username cannot be empty"


  Scenario: empty password login attempt
       #Given user is on the HRMS login page
    When user enters username "Admin" and password ""
    And user clicks the login button
    Then user should see the message "Password cannot be empty"

  Scenario: invalid login credentials wrong username
         #Given user is on the HRMS login page
    When user enters username "WrongUser" and password "admin123"
    And user clicks the login button
    Then user should see the message "Invalid credentials"

  Scenario: invalid login credentials wrong password
      #Given user is on the HRMS login page
    When user enters username "Admin" and password "wrongpass"
    And user clicks the login button
    Then user should see the message "Invalid credentials"




