package com.projects.pages;

import com.projects.utilities.BrowserUtils;
import com.projects.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.browser.Browser;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;

public class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(xpath = "//h1[@class='logo logo-text']")
    public WebElement fleetmanagementText;

    @FindBy(className = "oro-subtitle")
    public WebElement subtitleText;

    //Click Shortcuts
    @FindBy(xpath = "//a[@title='Shortcuts']")
    public WebElement clickShortcuts;

    @FindBy(className = "nav-header nav-header-title")
    public WebElement getShortcutsText;


   public void naviagetToModule(String tab, String module){
        String tabLocator = "//span[contains(text(),'"+tab+"') and @class='title title-level-1']";
        String moduleLocator = "//span[contains(text(),'"+module+"') and @class='title title-level-2']";

       try {
           BrowserUtils.waitForClickablility(By.xpath(tabLocator), 5);
           WebElement tabElement = Driver.get().findElement(By.xpath(tabLocator));
           new Actions(Driver.get()).moveToElement(tabElement).pause(200).doubleClick(tabElement).build().perform();
       }catch (Exception e){
           BrowserUtils.clickWithWait(By.xpath(tabLocator), 5);
       }
       try {
           BrowserUtils.waitForClickablility(By.xpath(moduleLocator), 5);
           BrowserUtils.waitForVisibility(By.xpath(moduleLocator),5);
           BrowserUtils.scrollToElement(Driver.get().findElement(By.xpath(moduleLocator)));
           Driver.get().findElement(By.xpath(moduleLocator)).click();
       }catch (Exception e){
           BrowserUtils.clickWithTimeOut(Driver.get().findElement(By.xpath(moduleLocator)),5);
       }
   }
}
