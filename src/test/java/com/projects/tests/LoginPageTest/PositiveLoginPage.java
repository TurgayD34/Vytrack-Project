package com.projects.tests.LoginPageTest;

import com.projects.TestBase;
import com.projects.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveLoginPage extends TestBase {

    @Test
    public void loginAsDriver(){
        LoginPage loginPage = new LoginPage();
        loginPage.loginAsDriver();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/");
    }
}
