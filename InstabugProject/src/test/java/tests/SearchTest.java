package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;

public class SearchTest extends TestBase {
    GoogleHomePage google;
    SearchResultsPage results;

    @BeforeMethod
    public void setup() {
        google = new GoogleHomePage(driver);
        results = new SearchResultsPage(driver);
    }

    @Test
    public void searchWithEmptydata() {
        google.fillSearchBox("");
        google.clickOnSearchButton();
        Assert.assertEquals(google.currentURL(), "https://www.google.com/");
    }

    @Test
    public void searchWithValidData() {
        google.fillSearchBox("Facebook");
        google.clickOnSearchButton();
        Assert.assertTrue(google.currentURL().contains("q=Facebook"));
    }

    @Test
    public void searchWithMulipleItems() {
        google.fillSearchBox("Selenium Maven Dependency");
        google.clickOnSearchButton();
        Assert.assertTrue(google.currentURL().contains("q=Selenium+Maven+Dependency"));
    }

    @Test
    public void searchWithMisspellingText() {
        google.fillSearchBox("Labtop");
        google.clickOnSearchButton();
        Assert.assertTrue(results.suggestionForResult().contains("هل تقصد :"));
    }
    @Test
    public void searchWithNoResultItem()  {
        google.fillSearchBox("sfmasmfaskfmalmfskalwfms");
        google.clickOnSearchButton();
        Assert.assertTrue(results.NoResultForItem().contains("لم ينجح بحثك عن "));
}

    @Test
    public void CheckSearchResultsIsaccordingToSearchItem() {
        google.fillSearchBox("Laptop");
        google.clickOnSearchButton();
        Assert.assertTrue(google.currentURL().contains("q=Laptop"));
        Assert.assertTrue(results.ResultElements().contains("Laptop"));
    }

    @Test
    public void searchImageByGoogleLens()  {
        google.clickOnUploadImageButton();
        google.UploadImageLinkToGoogeLens("https://www.brookings.edu/wp-content/uploads" +
                "/2021/06/shutterstock_1708749826_small.jpg");
        google.clickOnSearchButtonInsidePopUp();
        Assert.assertTrue(google.currentURL().contains("lens.google.com"));
    }
}
