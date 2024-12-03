package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class SearchResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        //this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void selectFirstItem() {
       WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal' and contains(text(),'Apple MacBook Air Laptop: Apple M1 chip')]")));
        //WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot .s-result-item")));
        Assert.assertTrue(firstItem.isDisplayed());
        firstItem.click();

    }

    public void selectLaptop() {
        WebElement macbook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_apple-brand-showcase_showcase_showcase-link__3QpvX qa-link']/p[@class='a-spacing-none a-size-small _apple-brand-showcase_showcase_hidden-overflow__1m64t']/span[text()='MacBook Pro (14-inch)']")));
        Assert.assertTrue(macbook.isDisplayed());
        macbook.click();

    }



    public void selectMacbook(){
        WebElement macbook = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='_apple-brand-showcase_showcase_showcase-link__3QpvX qa-link']/p[@class='a-spacing-none a-size-small _apple-brand-showcase_showcase_hidden-overflow__1m64t']/span[text()='MacBook Pro (14-inch)']")));
        Assert.assertTrue(macbook.isDisplayed());
        macbook.click();

    }

    public void addToWishList() {
        WebElement wishList = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='a-button-inner']/a[@title='Add to Wish List' and contains(@href, 'amazon.in/ap/signin')]")));
        Assert.assertTrue(wishList.isDisplayed());
        wishList.click();
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,200)");

    }
}
