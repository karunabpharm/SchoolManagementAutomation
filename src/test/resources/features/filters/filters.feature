Feature: Ensure filters functionality is working as expected

  @filters @sanity @regression @desktop
  Scenario: Verify filter the user list based upon year group
    Given I should select "Year 1" year group
    And I should click on search users
    Then I should verify result table based upon "Year 1" year group

  @filters @sanity @regression @mobile
  Scenario: Verify filter the user list based upon year group
    Given I should select "Year 1" year group
    And I should click on search users
    Then I should verify result table based upon "Year 1" year group