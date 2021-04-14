#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@SignUpTestsSets
Feature: 
  New Users Creation Feature

  @SignUpUsers
  Scenario Outline: Sign Up as a new user registration
    Given User navigates to E Commerce application
    And User clicks on the "Sign in" button
    And User inputs E-mail Address from the   given sheet "<SheetName>" and rownumber <RowNumber>
    And User click on the "SubmitCreate" button
    When User inputs account details from the   given sheet "<SheetName>" and rownumber <RowNumber>
    Then User clicks on "Register" Button
    And User navigates to the My Account Page
    And User clicks on the SignOut Button

    Examples: 
      | SheetName | RowNumber |
      | createAcct|         0 |
      | createAcct|         1 |
      | createAcct|       	2 |
      | createAcct|       	3 |
      | createAcct|       	4 |
     
