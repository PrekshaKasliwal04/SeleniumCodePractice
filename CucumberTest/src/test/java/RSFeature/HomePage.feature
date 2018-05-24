
@tag
Feature: RS Page feature to remove Item
  This file will cover Home page scenarios

 Scenario: Login with User and proceed to payment
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    And Perform Search for "battery" and select item
    When Add item to basket
    Then User should able to remove Item from Cart
    
  