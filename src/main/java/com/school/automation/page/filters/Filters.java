package com.school.automation.page.filters;

import com.school.automation.framework.Solvent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Filters extends Solvent {
    public Filters(WebDriver driver){
        super(driver);
    }

    @FindBy(css = "#SelectedYearGroupId")
    public WebElement yearGroup;

    @FindBy(css = "button.btn.btn-primary")
    public WebElement searchUsers;

    @FindBy(css = "table#userResults tr td:nth-child(4) label")
    public List<WebElement> yearGroupOptions;

    @FindBy(css = ".pagination a")
    public List<WebElement> pagination;

    public void selectYearGroup(String yearGroupOption){
        selectDropDownByVisibleText(yearGroup, yearGroupOption);
    }

    public void searchUsers(){
        elementClick(searchUsers);
    }

    public boolean isResultFilteredOnYearGroup(String expectedYearGroup){
        boolean result = false;
        int sizeOfPagination = pagination.size();

        if(sizeOfPagination>2){
            for(int i=1; i<pagination.size()-1; i++){
                for(WebElement element: yearGroupOptions){
                    result = getText(element).equalsIgnoreCase(expectedYearGroup)?true:false;

                    if(!result)
                        return result;
                }
                randomElementClick(pagination, i);
                result = (sizeOfPagination==pagination.size())?true:false;

                if(!result)
                    return result;
            }
        }
        else {
            for(WebElement element: yearGroupOptions){
                result = getText(element).equalsIgnoreCase(expectedYearGroup)?true:false;

                if(!result)
                    return result;
            }
        }
        return result;
    }
}
