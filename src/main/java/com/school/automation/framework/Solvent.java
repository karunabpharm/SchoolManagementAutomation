package com.school.automation.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Solvent {
    public WebDriver driver;

    public Solvent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void elementClick(WebElement element){
        element.click();
    }

    public void randomElementClick(List<WebElement> elementList, int index){
        elementList.get(index).click();
    }

    public void selectDropDownByVisibleText(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getText(WebElement element){
        return element.getText();
    }
}
