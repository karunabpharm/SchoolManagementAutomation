package com.school.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static ChromeOptions chromeOptions;
    public static String chromeDriverPath;

    public void tearUpScenario(String platform){
        chromeDriverPath = System.getProperty("user.dir") + "/driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        if(platform.contains("desktop")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        else if(platform.contains("mobile")){
            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", 360);
            deviceMetrics.put("height", 640);
            Map<String, Object> mobileEmulation = new HashMap<>();
            mobileEmulation.put("deviceMetrics", deviceMetrics);
            mobileEmulation.put("userAgent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) " +
                    "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36");

            chromeOptions = new ChromeOptions();
            chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
            driver = new ChromeDriver(chromeOptions);
        }

        driver.get("https://school-demo-web-app.azurewebsites.net/User");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    public void tearDownScenario(){
        driver.quit();
    }
}
