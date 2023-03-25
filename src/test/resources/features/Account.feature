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