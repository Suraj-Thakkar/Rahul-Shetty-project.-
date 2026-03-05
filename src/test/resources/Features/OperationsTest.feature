@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file
  @Regression
  Scenario Outline: Positive test of Submitting the Order
	Given I landed on Ecommerce Page
	And Logged in with username <name> and password <password>
	When I add the product <productName> to cart
	And checkout <productName> and submit the order
	Then "THANKYOU FOR THE ORDER." message is displayed in the confirmation page
	Examples:
	  | name  							 | password  | productName     |
	  | surajqaprofessional624@gmail.com | Suraj123@ | ADIDAS ORIGINAL |