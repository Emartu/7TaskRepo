package com.epam.page_object.steps;


import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.User;
import com.epam.page_object.pages.LogInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestLoginSteps {

    private WebDriver driver = Driver.Initialize() ;

    public void openMailWebAddress(String url) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.getURL(url);
    }

    public void doLogin(User user) {
        LogInPage logInPage = new LogInPage(driver);
        logInPage.doLogin(user.getLogin(), user.getPassword());
    }

    public boolean isLoginSuccessful() {
        LogInPage logInPage = new LogInPage(driver);
        return logInPage.userPresented();
    }

}



