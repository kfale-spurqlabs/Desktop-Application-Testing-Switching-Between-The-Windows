@winApp
Feature:Switching to notepad app in desktop application automation

  Scenario: Verify Basic Operations in the calculator application
    Given I am on Calculator Windows App
    When  I enter '5' in the App
    And   I press '+' operator
    And   I enter '7' in the App
    And  I see the result is '12' in the App
    And I switch to notepad app with name 'SwitchToNotepad'
    And I enter 'I have switched to notepad app from calculator app' text
    Then I verify text entered

