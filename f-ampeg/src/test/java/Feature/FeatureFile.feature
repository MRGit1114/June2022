@tag
Feature: Ampeg tests
  I want to run my Ampeg tests using Cucumber and Gherkin

  @tag1
  Scenario: Display Rocket Bass RB-108 authorized dealers
    Given User is on home page
    And User selects Products button
    And User selects Rocket Bass from the list
    And User selects Find a Dealer button
    Then User selects Buy Now button near the RB-108 product image

  @tag2
  Scenario: Display Rocket Bass RB-108 description
    Given User is on home page
    And User selects Products button
    And User selects Rocket Bass from the list
    Then User selects RB-108 button
    
  @tag3
  Scenario: Display Rocket Bass RB-108 user manual
    Given User is on home page
    And User selects Products button
    And User selects Rocket Bass from the list
    And User selects RB-108 button
    And User selects Manuals button
    Then User selects Rocket Bass 108 from the list
    
  @tag4
  Scenario: Display Rocket Bass RB-108 comparison chart
    Given User is on home page
    And User selects Products button
    And User selects Rocket Bass from the list
    And User selects RB-108 button
    Then User selects Comparison Chart button
    
  @tag5
  Scenario: Hear Rocket Bass RB-108 sound sample
    Given User is on home page
    And User selects Products button
    And User selects Rocket Bass from the list
    Then User selects RB-108 EQ Flat image
