Feature: Testing different request on the restful booker app

 Scenario: Check if the booking ids accessed by the users
   When User sends a GET request to booking endpoints
   Then User must get back with a valid status code 200





