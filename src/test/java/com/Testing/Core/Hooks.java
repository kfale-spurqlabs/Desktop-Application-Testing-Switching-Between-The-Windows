package com.Testing.Core;

import com.Testing.Util.WinAppUtil;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import java.io.IOException;

public class Hooks extends TestContext {

    @Before("@winApp")
    public void InitializeWinApp(Scenario scenario1) throws IOException {
        winAppDriver = WinAppUtil.winAppInit();
        scenario = scenario1;
    }
}
