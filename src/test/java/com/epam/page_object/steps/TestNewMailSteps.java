package com.epam.page_object.steps;


import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.MailData;
import com.epam.page_object.pages.NewMailPage;
import org.openqa.selenium.WebDriver;

public class TestNewMailSteps {

    private WebDriver driver = Driver.Initialize();

    public void openMailWebAddress(String url) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.getURL(url);
    }

    public void doLogin(MailData mailData) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.doLogin(mailData.getLogin(), mailData.getPassword());
    }

    public void createNewMail(MailData mailData) {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.clickCreateNewMail();
        newMailPage.setToAdress(mailData.getTo());
        newMailPage.setMailSubject(mailData.getSubject());
    }

    public void goDrafts() {
        NewMailPage newMailPage = new NewMailPage(driver);
        newMailPage.clickDraftLink();
    }

    public boolean isMessageSent() {
        NewMailPage newMailPage = new NewMailPage(driver);
        return newMailPage.messageIsInDraft();
    }
}
