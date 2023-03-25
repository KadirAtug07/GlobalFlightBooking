Feature: Sign-Up and Login



  @smoke
  Scenario: Sign-Up
    Given User navigates to website and verify title as "React App"
    When User verify Home Page header title as "Search Flight"
    Then User clicks signup button and verifies signup page header as "Sign Up"
    And User fills up signup form
    Then User clicks signup button
    And User verify success message as "User Created"

    @smoke1
    Scenario: Able to login with valid credentials
      Given User navigates to website and verify title as "React App"
      When User verify Home Page header title as "Search Flight"
      Then User clicks signup button and verifies signup page header as "Sign Up"
      And User fills up signup form
      Then User clicks signup button
      And User verify success message as "User Created"
      Then User clicks login button
      And User enters email and password
      Then click login with provided credentials
      And verify username on header


      @smoke2
      Scenario: Verify Signup in Database
        Given User navigates to website and verify title as "React App"
        When User verify Home Page header title as "Search Flight"
        Then User clicks signup button and verifies signup page header as "Sign Up"
        And User fills up signup form
        Then User clicks signup button
        And User verify success message as "User Created"
        Then Verify User is created in Database

       @smoke3
       Scenario: SignUp with API
         Given User add request Payload
         When User send request
         Then User verifies status code is 201


         @smoke4
         Scenario: SignUp with API and login with UI
           Given User add request Payload
           When User send request
           Then User verifies status code is 201
           Then User login with UI by given credentials from API