package com.Testing.Core;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = {"src/test/java/com/Testing/Features"},
        glue = "com.Testing",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", "pretty", "json:test-output/Cucumber.json"})

public class TestRunner extends AbstractTestNGCucumberTests {
    @DataProvider
    @Override
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
