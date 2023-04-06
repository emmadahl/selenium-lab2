Feature: Test Lab3SVTPlay

  Scenario: SVT Play should show correct title
    Given SVT Play is available
    When User visits SVT Play
    Then Title should be "SVT Play"

  Scenario: SVT Play logo should be visible
    Given SVT Play is available
    When User visits SVT Play
    Then Logotype should be visible

  Scenario: Start menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Start menu text should be "START"

  Scenario: Program menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Program menu text should be "PROGRAM"

  Scenario: Chanel menu should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Chanel menu text should be "KANALER"

  Scenario:  Availability link should show correct text
    Given SVT Play is available
    When User visits SVT Play
    Then Availability link text should be "Tillgänglighet i SVT Play"

 Scenario: Should show correct heading
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on availability link
   Then Heading should be "Så arbetar SVT med tillgänglighet"

 Scenario: Number of categories should be correct
   Given SVT Play is available
   When User visits SVT Play
   When User clicks on program link
   Then Number of categories should be correct