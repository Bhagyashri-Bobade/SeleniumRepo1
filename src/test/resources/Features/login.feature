Feature: Feature to test login functionality

Scenario Outline: Check login is successfull with valid credentials

Given user is on login page
When user enters <username> and <password>
And clicks on login button
Then user is navigated to home page

Examples:
|username|password|
|Raghav|12345|
|Ele|12345|
