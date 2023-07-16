package com.Testing.Util;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;

import static java.lang.Thread.sleep;

public class WinAppUtil {
    private static WindowsDriver winAppDriver = null;
    private static WindowsDriver rootDriver = null;


    public static WindowsDriver winAppInit() {
        try {
            if (!serverListening("localhost", 4723))
                Runtime.getRuntime().exec("cmd /c start cmd.exe /K " + ConfigUtil.getPropValues("WinAppDriverLocation"));
            sleep(2000);
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
            capabilities.setCapability("platformName", "Windows 10");
            capabilities.setCapability("ms:experimental-webdriver", true);
            winAppDriver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
            winAppDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        return winAppDriver;
    }


    public static boolean serverListening(String host, int port) {
        Socket s = null;
        try {
            s = new Socket(host, port);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            if (s != null)
                try {
                    s.close();
                } catch (Exception e) {
                }
        }
    }

    public static WindowsDriver switchToWindowWithName(String name) throws MalformedURLException,
            InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "Root");
        capabilities.setCapability("platformName", "Windows");
        capabilities.setCapability("ms:experimental-webdriver", true);
        rootDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), capabilities);
        sleep(3);
        List<WebElement> windows = rootDriver.findElementsByXPath("/Pane/Window");
        for (WebElement window : windows) {
            String windowName = window.getAttribute("Name");
              if (windowName.contains(name)) {
                sleep(100);
                String hex = window.getAttribute("NativeWindowHandle");
                int handle = Integer.parseInt(hex);
                String windowHandle = Integer.toHexString(handle);
                windowHandle = "0x" + windowHandle;
                DesiredCapabilities caps = new DesiredCapabilities();
                caps.setCapability("appTopLevelWindow", windowHandle);
                caps.setCapability("platformName", "Windows");
                caps.setCapability("ms:experimental-webdriver", true);
                winAppDriver = new WindowsDriver(new URL("http://127.0.0.1:4723"), caps);
                // todo change the time
                winAppDriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
                System.out.println("Switched to window with name 1: " + winAppDriver.getTitle());
                return winAppDriver;
            }
        }
        return null;
    }
}
