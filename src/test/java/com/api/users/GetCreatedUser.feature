Feature: 002 API Spec and Schema : Create Users

@smoke
Scenario Outline: Verify user record is created successfully.
    Given I set endpoint as "<--config.props/hostPort_Users" with API "<--config.props/api_createUsers"
    When I create user with name "<name>" and job as "<Job>"
    And I print request
    And I invoke the POST API with json payload
    And I print response
    Then I save value "id-->AppOutput.txt/getOP"
    Then I set endpoint as "<--config.props/hostPort_Users" with API "<--config.props/api_getUsers" along with "<--AppOutput.txt/getOP"
    And I invoke the GET API
    And I print response
    Examples: 
    |name			|	Job			|
    |Sameer Rawat	|	Engineer	|
    
# Note: Create/Get user API doesnt have any field validation(length, min character,mandatory etc.). so not writing any negative test cases.
# Get API doesnt fetch the result when id >=13 . its returning empty json {} as response.
