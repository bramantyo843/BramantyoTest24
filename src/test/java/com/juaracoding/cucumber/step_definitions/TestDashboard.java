package com.juaracoding.cucumber.step_definitions;

import juara.coding.drivers.pages.Dashboard;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestDashboard {
    WebDriver driver;
    private static ExtentTest extentTest;
    private Dashboard dashboardPage = new Dashboard();

    public TestDashboard() {
        driver = Hooks.driver;
        extentTest = Hooks.extentTest;
    }

    @When("User click menu Dashboard")
    public void user_click_menu_dashboard() {
//		Hooks.delay(1);
        dashboardPage.menuDashboard();
        extentTest.log(LogStatus.PASS, "User click menu DashboardPage");
    }

    @Then("User on menu Dashboard")
    public void user_on_menu_dashboard() {
        Assert.assertEquals(dashboardPage.getTxtDashboard(), "Launching Soon");
        extentTest.log(LogStatus.PASS, "User on menu DashboardPage");
    }
}
