@fea1 
Feature: Login Functionality Testing

Background:  
Given User is on the Home Page

@US001 
Scenario Outline: : validate the Positive login functionality(SHO,EO,IO,EO) 
	And Enter username "<username>" and Password"<password>" 
	Then Click on sign in button 
	Then Logout From Home Page
	
	Examples: 
		|username|password|
		|cb1000|cctns@1234|
		|cb1001|cctns@1234|
#		|cb1002|cctns@1234|
#		|cb1003|cctns@1234|
		
@US002 
Scenario Outline: : validate the negative login functionality 
	And Enter Invalid Username "<username>" and Password"<password>" 
	Then Click on sign in button 
	Then Validate the error message "Authentication led : Invalid username or password" 
			
	Examples: 
		|username|password|
		|cb1000|cctns@12345|
		|cb1001|cctns@12345|
#		|cb1002|cctns@12345|
#		|cb1003|cctns@12345|
				
@US003 
Scenario: validate the negative login functionality without data 
	Then Click on sign in button 
	Then Validate the error message "Please enter UserName & Password" without data

@US004
Scenario: To verify the Forget Password is working 
	Then Click on Forgot Password 
	Then User enters UserName and security Q&A details
	
	
	
	
	
	
	