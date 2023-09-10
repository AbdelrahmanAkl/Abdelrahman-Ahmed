package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.datatype.Duration;

public class PageBase {
    WebDriver driver;
    public  final long WAIT = 100;



    public PageBase(WebDriver driver)  {
        this.driver= driver;
    }
    public void waitTime(By element) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void waitTimeUrl(String url) {
        WebDriverWait wait;
        wait = new WebDriverWait(driver,WAIT);
        wait.until(ExpectedConditions.urlToBe(url));
    }
    public void clickElement(By element)
    {
        waitTime(element);
        driver.findElement(element).click();
    }
    public void sendKey(By element, String value)
    {   waitTime(element);
        driver.findElement(element).sendKeys(value);
    }


    public void Submit(By element) {
        waitTime(element);
        driver.findElement(element).submit();
    }
    public void scrollDown(int A,int B) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(A,B)");

    }

    public String currentURL(){
        String URL;
        URL = driver.getCurrentUrl();
        return URL;
    }
}
