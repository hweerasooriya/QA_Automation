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
@SignInTestsSets
Feature: 
  Sign In User Feature


 @SignInUsers
  Scenario Outline: SignIn as a Existing user for checkout process
    Given User navigates to E Commerce application
    And User clicks on the "Sign in" button
    And User inputs userName and Password from the   given sheet "<SheetName>" and rownumber <RowNumber>
    And User selects the "Sign in" button
    And User clicks on "Women" Category section
    And User scrolls the Page
    When User verifies the Price and the product name from the page
   	Then User clicks the add to cart button
   	And User performs the further checkout process
    
    Examples: 
      | SheetName | RowNumber |
      | createAcct|         0 |