package com.school.automation;

import com.school.automation.framework.ReportManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterSuite;

@CucumberOptions(
        features = "src/test/resources/features",
        glue="",
        tags="@sanity",
        plugin = {"pretty", "html:target/site/cucumber-pretty", "json:target/cucumber.json"},
        monochrome = true
)
public class SchoolRunnerTest extends AbstractTestNGCucumberTests {
    @AfterSuite
    public void createReport(){
        ReportManager.createReport();
    }
}
