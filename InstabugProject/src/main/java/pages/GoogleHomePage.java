package pages;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleHomePage extends PageBase{

    public GoogleHomePage(WebDriver driver) {
        super(driver);
    }

    By searchBox = By.xpath("//*[@id=\"APjFqb\"]");
    By searchButton = By.xpath("//*[@class=\"gNO89b\"]");
    By SearchByImageButton = By.xpath("//*[@class=\"Gdd5U\"]");
    By ImageLink= By.xpath("//*[@class=\"cB9M7\"]");
    By searchButtonInsidePopUP = By.xpath("//*[@class=\"Qwbd3\"]");
    public void fillSearchBox(String searchItem){
        sendKey(searchBox,searchItem);
    }
    public void clickOnSearchButton(){
        clickElement(searchButton);
    }
    public void clickOnUploadImageButton(){
        clickElement(SearchByImageButton);
    }
    public void UploadImageLinkToGoogeLens(String image){
        sendKey(ImageLink,image);
    }
    public void clickOnSearchButtonInsidePopUp(){
        clickElement(searchButtonInsidePopUP);
    }






}
