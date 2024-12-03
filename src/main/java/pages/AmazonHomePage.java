package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class AmazonHomePage {
    private WebDriver driver;
     private WebDriverWait wait;


    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
       // this.wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void searchForItem(String item) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        Assert.assertTrue(searchBox.isDisplayed());
        searchBox.sendKeys(item);
        WebElement searchButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("nav-search-submit-button")));
        Assert.assertTrue(searchButton.isDisplayed());
        searchButton.click();

    }
}
