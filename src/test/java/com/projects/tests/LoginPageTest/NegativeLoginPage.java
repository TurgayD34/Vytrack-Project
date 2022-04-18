package com.projects.tests.LoginPageTest;

import com.projects.TestBase;
import com.projects.pages.LoginPage;
import com.projects.utilities.ConfigurationReader;
import com.projects.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginPage extends TestBase {

    String username = ConfigurationReader.get("driver_username");
    String password = ConfigurationReader.get("driver_password");

    @Test
    public void wrongUsername(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("User");
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void wrongPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys("1234");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void wrongUsernameAndPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("user");
        loginPage.passwordInput.sendKeys("1234");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void emptyUsername(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys("");
        loginPage.passwordInput.sendKeys(password);
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void emptyPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys("");
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
    @Test
    public void changeUsernameAndPassword(){
        LoginPage loginPage = new LoginPage();
        loginPage.usernameInput.sendKeys(password);
        loginPage.passwordInput.sendKeys(username);
        loginPage.loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }
}
