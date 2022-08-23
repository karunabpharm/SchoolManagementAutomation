package com.school.automation.steps.filters;

import com.school.automation.framework.TestBase;
import com.school.automation.page.filters.Filters;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class FilterSteps extends TestBase {

    public Filters filters;

    @Given("I should select {string} year group")
    public void selectYearGroup(String yearGroup){
        filters = new Filters(driver);
        filters.selectYearGroup(yearGroup);
    }

    @And("I should click on search users")
    public void searchUsers(){
        filters.searchUsers();
    }

    @Then("I should verify result table based upon {string} year group")
    public void usersResultTable(String yearGroup){
        Assert.assertTrue(filters.isResultFilteredOnYearGroup(yearGroup),
                "Filters based upon year group is not working");
    }
}
