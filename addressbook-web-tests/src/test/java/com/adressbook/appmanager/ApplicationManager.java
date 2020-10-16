package com.adressbook.appmanager;

import com.google.gson.reflect.TypeToken;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class ApplicationManager<T extends RemoteWebDriver> {

    private T driver;
    public GroupHelper groupHelper;
    public NavigationHelper navigationHelper;
    public SessionHelper sessionHelper;
    private String browserType;

    public ApplicationManager(String browserType) {
        this.browserType = browserType;
    }

    public ApplicationManager() {
    }

    public void init() {
       Type tp = new TypeToken<ApplicationManager<T>>(){}.getType();
        System.out.println("Type: " + tp.getTypeName());
        if (browserType.equals(BrowserType.FIREFOX)) {
            WebDriverManager.firefoxdriver().setup();
            driver = (T) new FirefoxDriver();
        } else if (browserType.equals(BrowserType.CHROME)) {
            WebDriverManager.chromedriver().setup();
            driver = (T) new ChromeDriver();
        }
//        if (browserType.equals(BrowserType.FIREFOX)) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = (T) new FirefoxDriver();
//        } else if (browserType.equals(BrowserType.CHROME)) {
//            WebDriverManager.chromedriver().setup();
//            driver = (T) new ChromeDriver();
//        }

        driver.get("http://localhost:8082/addressbook/index.php");
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

        groupHelper = new GroupHelper(driver);
        navigationHelper = new NavigationHelper(driver);
        sessionHelper = new SessionHelper(driver);
        sessionHelper.login("admin", "secret");
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper group() {
        return groupHelper;
    }

    public NavigationHelper goTo() {
        return navigationHelper;
    }

    public SessionHelper getSessionHelper() {
        return sessionHelper;
    }
}