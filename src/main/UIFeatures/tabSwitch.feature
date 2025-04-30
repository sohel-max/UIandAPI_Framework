Feature: Switch to child window

@verifyTitle
  Scenario: Open website and assert title after switching to child window
    Given User is redirect to website
    When User clicks on multiWin and click here link
    Then User verify title

