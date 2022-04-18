package com.projects.tests.LoginPageTest;

import com.projects.TestBase;
import com.projects.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ForgotPassBtn extends TestBase {

    @Test
    public void clickForgotBtn(){
        LoginPage loginPage = new LoginPage();
        loginPage.forgotPassword.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qa1.vytrack.com/user/reset-request");
        Assert.assertEquals(loginPage.getTitle.getText(),"Forgot Password", "Verify forgot password title");
        loginPage.usernameInput.sendKeys("td@gmail.com");
        loginPage.requestBtn.click();
        Assert.assertEquals(loginPage.VerifyForgotErrorText.getText(), "There is no active user with username or email address \"td@gmail.com\".");
        loginPage.returnToLogin.click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login");
    }


}
