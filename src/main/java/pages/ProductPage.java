package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ProductPage {
     private WebDriver driver;
     private  WebDriverWait wait ;


    public ProductPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }


    public void clickOnBestSellers() {
        WebElement bestSellers = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[@class='hmenu-item' and text()='Best Sellers'])[1]")));
        Assert.assertTrue(bestSellers.isDisplayed());
        bestSellers.click();

    }

    public void clickOnHotNewReleases() {
        WebElement hotNewReleases = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Hot New Releases']")));
        Assert.assertTrue(hotNewReleases.isDisplayed());
        hotNewReleases.click();
    }

    public void clickOnFirstItem(){
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[contains(@class, 'p13n-sc-truncate-desktop-type2') and contains(@class, 'p13n-sc-truncated')])[1]")));
        Assert.assertTrue(firstItem.isDisplayed());
        firstItem.click();
    }
}
