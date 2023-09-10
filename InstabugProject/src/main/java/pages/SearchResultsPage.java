package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchResultsPage extends PageBase{

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    By searchResults = By.xpath("//*[@class=\"MjjYud\"]");
    By suggestionText = By.xpath("//*[@class=\"gL9Hy d2IKib\"]");
    By NoResultText = By.xpath("//*[@class=\"card-section\"]//p");

    public String ResultElements() {
        List<WebElement> element = driver.findElements(searchResults);
        String result = null;
        for (WebElement e : element) {
            result = e.getText();
        }
        return result;
    }
    public String suggestionForResult(){
        String res;
        res = driver.findElement(suggestionText).getText();
        return res;
    }

    public String NoResultForItem(){
        String res;
        res = driver.findElement(NoResultText).getText();
        return res;
    }
}
