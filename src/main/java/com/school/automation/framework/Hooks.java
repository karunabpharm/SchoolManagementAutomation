package com.school.automation.framework;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Hooks extends TestBase {

    @Before("@desktop")
    public void setUpDesktop(){
        tearUpScenario("desktop");
    }

    @Before("@mobile")
    public void setUpMobile(){
        tearUpScenario("mobile");
    }

    @After
    public void runAfterEachScenario(Scenario scenario){
        String testStatus = scenario.getStatus().toString();
        try {
            if (!(testStatus == "PASSED")) {
                Calendar calendar = Calendar.getInstance();
                SimpleDateFormat formater = new SimpleDateFormat(
                        "dd_MM_yyyy_hh_mm_ss");
                String destFileName = scenario.getName() + "_"
                        + formater.format(calendar.getTime()) + ".png";
                String destDir = "screenshot";
                File sourceFile = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(sourceFile, new File(destDir + "/"
                        + destFileName));
                String screenshotPath = destDir + "/" + destFileName;
                Reporter.setEscapeHtml(false);
                Reporter.log("Failed_Test_Case <a href = " + screenshotPath
                        + "</a>");
            }
        }
        catch (IOException exception){
            exception.printStackTrace();
        }

        tearDownScenario();
    }
}
