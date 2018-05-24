Feature: RS Home Page feature
  This file will cover Home page scenarios

  Scenario: Login with User and proceed to payment
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    And Perform Search for "battery" and select item
    When Adds item to basket and proceed to checkout securly
    Then User should see Proceed for Payment

  Scenario: Login with User and check for Filter labels and Table headings
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    When Perform Search for "battery" and apply filter
    Then All filter headings should be as expected
    And Result table headings should be as expected

  Scenario: Login with User Apply filter after Search
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    When Perform Search for "battery" and apply filter
    Then Results should include "Battery Chargers - Lead Acid & Automotive"

  Scenario: Login with User and remove selected Item from cart
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    And Perform Search for "battery" and select item
    When Add item to basket
    Then User should able to remove Item from Cart

  Scenario Outline: Login with User and search for more Options
    Given Login with User "prekshakasliwal" Password "preksha" on website "http://uk.rs-online.com/web/"
    And User logs in successfully
    When Perform Search for <searchString> and apply filter
    Then User should see selection name as <searchResult>

    Examples: 
      | searchString | searchResult                                  |
      | "battery"    | "Battery Chargers - Lead Acid & Automotive"   |
      | "connectors" | "Industrial & Automation Circular Connectors" |
