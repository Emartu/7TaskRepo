package com.epam.page_object.pages;

import com.epam.page_object.base.Driver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;


public class NewMailPage extends AbstractPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@name='login']")
    private WebElement login;

    @FindBy(xpath = "//input[@name='passwd']")
    private WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submit;

    @FindBy(xpath = "//a[@data-key='view=toolbar-button-compose-go&id=compose-go']")
    private WebElement createMail;

    @FindBy(xpath = "//*[@class='js-compose-field mail-Bubbles']")
    private WebElement sendTo;

    @FindBy(xpath = "//*[@class='mail-Compose-Field-Input-Controller js-compose-field js-editor-tabfocus-prev']")
    private WebElement subject;

    @FindBy(xpath = "//*[@id='cke_1_contents_wrap']")
    private WebElement body;

    @FindBy(xpath = "//button[@data-action='save']")
    private WebElement popupSaveButton;

    @FindBy(xpath = "//a[@data-key='view=folder&fid=6']")
    private WebElement draftLink;

    @FindBy(xpath = "//span[@title='sent via WebDriver']")
    private WebElement sentSubj;


    public NewMailPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void doLogin(String userName, String passw) {
        login.sendKeys(userName);
        password.sendKeys((passw));
        submit.click();
    }

    public void clickCreateNewMail() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        createMail.click();
    }

    public void setToAdress(String toAdress) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        sendTo.sendKeys(toAdress);
    }

    public void setMailSubject(String mailSubject) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        subject.sendKeys(mailSubject);
    }

    public void clickDraftLink() {
        draftLink.click();
        popupSaveButton.click();
    }

    public boolean messageIsInDraft() {
        try {
            return sentSubj.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
