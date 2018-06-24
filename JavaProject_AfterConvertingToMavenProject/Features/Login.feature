Feature: Login feature

Scenario: Verify user is able to successfully login to xyz.com
	Given A user is on xyz.com page
	When User clicks on My account link
	And User enters correct username and password
	Then User is able to successfully login 