package com.projects.tests.LoginPageTest;

import com.projects.TestBase;
import com.projects.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginVerifyPage extends TestBase {

    @Test
    public void verifyTitle(){
        LoginPage loginPage = new LoginPage();
        Assert.assertEquals(loginPage.getTitle.getText(),"Login", "Verify title");
    }
    @Test //Incele
    public void clickCheckbox(){
        LoginPage loginPage = new LoginPage();
        WebElement checkbox = loginPage.checkbox;
        checkbox.click();
        Assert.assertFalse(checkbox.isSelected());
        Assert.assertEquals(loginPage.getCheckboxText.getText(),"Remember me on this computer", "Verify checkbox text");
    }
}
