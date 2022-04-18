package com.projects.pages;

import com.projects.utilities.ConfigurationReader;
import com.projects.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.nio.file.WatchEvent;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    //Positive and negative login page
    @FindBy(id = "prependedInput")
    public WebElement usernameInput;

    @FindBy(id = "prependedInput2")
    public WebElement passwordInput;

    @FindBy(id = "_submit")
    public WebElement loginBtn;

    //Login verify page
    @FindBy(className = "title")
    public WebElement getTitle;

    @FindBy(className = "custom-checkbox__icon")
    public WebElement checkbox;

    @FindBy(className = "custom-checkbox__text")
    public WebElement getCheckboxText;

    @FindBy(xpath = "//a[contains(text(),'Forgot')]")
    public WebElement forgotPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement requestBtn;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    public WebElement VerifyForgotErrorText;

    @FindBy(xpath = "//a[contains(text(),'Return')]")
    public WebElement returnToLogin;

    public void loginAsDriver(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }

}
