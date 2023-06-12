Feature: 001 UI Spec 

@smoke
Scenario: Verify endpoints are present in page.
    Given I launch the browser and open the URL
    When I scroll to the console section
    Then I verify list of endpoints are present