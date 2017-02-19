package com.epam.page_object.test;


import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.User;
import com.epam.page_object.steps.TestLoginSteps;
import com.epam.page_object.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class TestLogInPage {

    private TestLoginSteps objTestloginSteps;


    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @BeforeClass(dependsOnMethods = "setup", description = "Add implicit wait")
    public void addImplicitly() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, description = "Add implicit wait")
    public void addImplicityBeforeClose()  {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        Driver.Instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        try {
            Driver.Instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "Login_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
                {new User(TestInput.login, TestInput.password)}
        };
    }

    @Test(dataProvider = "Login_Provider", groups = "Login Page Test", description = "Tests whether user is Logged In", testName = "testLogin")
     public void testLogin(User user) {
        objTestloginSteps = new TestLoginSteps();
        objTestloginSteps.openMailWebAddress(TestInput.mailBoxUrl);
        objTestloginSteps.doLogin(user);
        Assert.assertTrue(objTestloginSteps.isLoginSuccessful(), "Element is not found, seems like User is not logged in ... ");
    }

}



