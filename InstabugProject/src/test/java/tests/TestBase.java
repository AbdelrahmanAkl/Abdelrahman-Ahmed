package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    public static WebDriver driver;
    @BeforeMethod
    public void openBrowser() {
        WebDriverManager.firefoxdriver().setup();
        driver= new FirefoxDriver();
        driver.navigate().to("https://www.google.com/");
    }
    @AfterMethod
    public void closeBrowser()
    {
        driver.quit();
    }
}

