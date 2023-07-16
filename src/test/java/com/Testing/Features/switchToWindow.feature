@winApp
Feature:Switching to notepad app in desktop application automation

  Scenario: Verify Basic Operations in the calculator application
    Given I am on Calculator Windows App
    When  I enter '5' in the App
    And   I press '+' operator
    And   I enter '7' in the App
    And  I see the result is '12' in the App
    And I switch to notepad app with name 'InputFile'
    And I enter 'I have switched to notepad app from calculator app' text
    Then I verify text entered



  Scenario: Switching between calculator and excel workbook
    Given I am on Calculator Windows App
    When  I switch to 'InputFile' excel workbook
    And   I read first number from sheet
    And   I read operator from the sheet
    And   I read second number from sheet
    And   I switch to calculator
    And   I do calculation as per the data which I read from excel
    And   I switch to 'InputFile' excel workbook
    Then  I save the result in excel workbook



