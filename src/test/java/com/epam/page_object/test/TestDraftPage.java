package com.epam.page_object.test;

import com.epam.page_object.base.Driver;
import com.epam.page_object.business_objects.MailData;
import com.epam.page_object.steps.TestDraftSteps;
import com.epam.page_object.test_data.TestInput;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class TestDraftPage {
    TestDraftSteps testDraftSteps;

    @Parameters({"browser"})
    @BeforeClass(alwaysRun = true, description = "Start browser")
    public void setup() {
        Driver.Initialize();
    }

    @BeforeClass(dependsOnMethods = "setup", description = "Add implicit wait")
    public void addImplicitly() {
        Driver.Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, description = "Add implicit wait")
    public void addImplicityBeforeClose() {
        Driver.Instance.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass(alwaysRun = true, dependsOnMethods = "addImplicityBeforeClose")
    public void closeBrowser() throws Exception {
        Driver.Instance.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
        try {
            Driver.Instance.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "NewMail_Provider")
    public Object[][] dataProvider() {
        return new Object[][]{
//                {new User(TestInput.login, TestInput.password)},
                {new MailData(TestInput.login, TestInput.password, TestInput.to, TestInput.subject, TestInput.body)}
        };
    }

    @Test(dataProvider = "NewMail_Provider", groups = "Draft Page Test", description = "Tests whether email is sent")
    public void testMailIsInDraft(MailData mailData) {
        testDraftSteps = new TestDraftSteps();
        testDraftSteps.openMailWebAddress(TestInput.mailBoxUrl);
        testDraftSteps.doLogin(mailData);
        testDraftSteps.createNewMail(mailData);
        testDraftSteps.sendFromDrafts();
        Assert.assertTrue(testDraftSteps.verifyMessageIsSent(), "Element is not found, seems like message is not sent ... ");
    }
}

