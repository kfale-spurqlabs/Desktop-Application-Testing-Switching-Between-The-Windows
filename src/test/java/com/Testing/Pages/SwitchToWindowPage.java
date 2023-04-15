package com.Testing.Pages;

import com.Testing.Core.TestContext;
import com.Testing.Util.WinAppUtil;
import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

import static java.lang.Thread.sleep;

public class SwitchToWindowPage extends TestContext {
    private static WindowsDriver winAppDriver;

    public SwitchToWindowPage(WindowsDriver _winAppdriver) {
        this.winAppDriver = _winAppdriver;
    }



    public void EnterNumber(String number) {

        switch (number) {
            case "1":
                winAppDriver.findElementByName("One").click();
                break;
            case "2":
                winAppDriver.findElementByName("Two").click();
                break;
            case "3":
                winAppDriver.findElementByName("Three").click();
                break;
            case "4":
                winAppDriver.findElementByName("Four").click();
                break;
            case "5":
                winAppDriver.findElementByName("Five").click();
                break;
            case "6":
                winAppDriver.findElementByName("Six").click();
                break;
            case "7":
                winAppDriver.findElementByName("Seven").click();
                break;
            case "8":
                winAppDriver.findElementByName("Eight").click();
                break;
            case "9":
                winAppDriver.findElementByName("Nine").click();
                break;
            case "0":
                winAppDriver.findElementByName("Zero").click();
                break;
        }
    }


    public void ClickOperator(String Operator) {
        switch (Operator) {
            case "+":
                winAppDriver.findElementByName("Plus").click();
                break;
            case "-":
                winAppDriver.findElementByName("Minus").click();
                break;
            case "/":
                winAppDriver.findElementByName("Multiply by").click();
                break;
            case "*":
                winAppDriver.findElementByName("Divide by").click();
                break;
        }
    }

    public String returnResult()
    {
        winAppDriver.findElementByName("Equals").click();
        WebElement CalculatorResult = winAppDriver.findElementByAccessibilityId("CalculatorResults");
        return CalculatorResult.getText().replace("Display is", "").trim();
    }

    public void switchToNotepadWindow(String fileName) throws MalformedURLException, InterruptedException {
        sleep(2000);
        winAppDriver= WinAppUtil.switchToWindowWithName(fileName);
        sleep(100);
    }

    public void enterTextInNotePad(String text) throws InterruptedException {
        sleep(500);
        winAppDriver.getKeyboard().sendKeys(Keys.ENTER);
        winAppDriver.getKeyboard().sendKeys(Keys.ENTER);
        winAppDriver.getKeyboard().sendKeys(text);
    }

    public String readTextFromNotePad() {
        String readText=winAppDriver.findElementByAccessibilityId("15").getText();
        System.out.println("Text from NotePad :"+readText);
        return readText;
    }
}
