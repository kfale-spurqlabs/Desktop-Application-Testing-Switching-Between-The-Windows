package com.Testing.Core;


import com.Testing.Pages.SwitchToWindowPage;
import io.appium.java_client.windows.WindowsDriver;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {
    public static WebDriver webDriver;
    public static WebDriverWait wait;
    public static String APIURL;


    public static WindowsDriver winAppDriver;

    public static Scenario scenario;

    public static SwitchToWindowPage switchToWindowPage;
}
