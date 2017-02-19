package com.epam.page_object.base;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {

    public static WebDriver Instance = null;

    private Driver() {
    }

    public static WebDriver Initialize() {
        System.setProperty("webdriver.chrome.driver", "resource\\chromedriver_win32(1)\\chromedriver.exe");
        if (Instance == null) {
            Instance = new ChromeDriver();
            Instance.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }
        return Instance;
    }

    public static void quit() {
        Instance.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Quit Browser");
        Instance.quit();
    }

}
