package com.Testing.Steps;

import com.Testing.Core.TestContext;
import com.Testing.Pages.SwitchToWindowPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;

public class SwitchToWindowStep extends TestContext {
    private final SwitchToWindowPage switchToWindowPage;

    public SwitchToWindowStep() throws IOException {
        switchToWindowPage = new SwitchToWindowPage(winAppDriver);
    }
    @Given("I am on Calculator Windows App")
    public void iAmOnCalculatorWindowsApp() {

        //Assert.assertEquals("0", demoWinAppPage.returnResult());

    }


    @When("I enter {string} in the App")
    public void iEnterNumberInTheApp(String number) {
        switchToWindowPage.EnterNumber(number);
        scenario.log("Number:"+number);
    }

    @And("I press {string} operator")
    public void iPressOperatorOperator(String operator) {
        switchToWindowPage.ClickOperator(operator);
        scenario.log("operator:"+operator);
    }

    @And("I see the result is {string} in the App")
    public void iSeeTheResultIsResultInTheApp(String expectedResult) throws Exception {
        String actualResult = switchToWindowPage.returnResult();
        Assert.assertEquals(actualResult,expectedResult,  "Result "+expectedResult+" Does not match with "+actualResult);
    }

    @And("I switch to notepad app with name {string}")
    public void iSwitchToNotepad(String fileName) throws MalformedURLException, InterruptedException {
        switchToWindowPage.switchToNotepadWindow(fileName);

    }

    @And("I enter {string} text")
    public void iEnterIHaveSwitchedToNotepadAppFromCalculatorAppText(String text) throws InterruptedException {
        switchToWindowPage.enterTextInNotePad(text);
    }

    @Then("I verify text entered")
    public void iVerifyTextEntered() {
        String textFromNotePad=switchToWindowPage.readTextFromNotePad();
        boolean flag=false;
        if(textFromNotePad.contains("I have switched to notepad app from calculator app")) {
            flag=true;
        }
        Assert.assertTrue(flag,"Notepad doesnot contain expected text");
    }
}
