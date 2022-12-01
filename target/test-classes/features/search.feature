Feature: Search

Scenario: Verify weather user is able to view search page

Given Browse is open
When user click on textfield
And user enter the valid credentials
When user click on check in 
And user should be able to fix dates
When user clicks on rooms
And user should be able to add the guests
When user clicks on search
Then user should be able to see the related hotel search page
When user click on Price or night
And price or night should be able to be dragged from right to left by the user
When user clicks on drop down
And user should be able to select all filters present in dropdown
When user click on favourite icon
And user should be able to see favourite hotel page
When user click on view deal
And user should be able see best hotele page
And browser is closed