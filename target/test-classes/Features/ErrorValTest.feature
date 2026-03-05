@tag
Feature: Error Validation
  I want to use this template for my feature file

  @ErrorValidation
  Scenario Outline: Title of our Scenario outline
	Given I landed on Ecommerce Page
	And Logged in with username <username> and password <password>
	Then "Incorrect email or password." message is displayed
	Examples:
	  | username                      | password  |
	  | thakkarsuraj640@gmail.com     | Suraj120@ |