package stepdefinitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import org.openqa.selenium.WebDriver;
import basetest.BrowserFactory;
import java.time.Duration;

public class AmazonSteps {
    private WebDriver driver;
    private AmazonHomePage amazonHomePage;
    private SearchResultsPage searchResultsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private WebDriverWait wait;

    public AmazonSteps() {
        this.driver = BrowserFactory.getDriver();
        this.amazonHomePage = new AmazonHomePage(driver);
        this.searchResultsPage = new SearchResultsPage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @Given("I am on the Amazon homepage")
    public void i_am_on_the_amazon_homepage() {
        driver.get("https://www.amazon.in/");
    }

    @When("I search for {string}")
    public void i_search_for(String item) {
        amazonHomePage.searchForItem(item);

    }

    @When("I select the first item in the search results")
    public void iSelectTheFirstItemInTheSearchResults() {
        searchResultsPage.selectFirstItem();
        searchResultsPage.selectLaptop();
    }

    @When("I add the item to the wishlist")
    public void iAddTheItemToTheWishList() {
        searchResultsPage.addToWishList();
    }


    @And("I login with valid credentials {string}")
    public void iLoginWithValidCredentials(String mobilenumber) {
        WebElement mobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        Assert.assertTrue(mobileNumber.isDisplayed());
        mobileNumber.click();
        mobileNumber.sendKeys(mobilenumber);

    }

    @Then("Then Click on continue")
    public void thenClickOnContinue() {
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='continue']")));
        Assert.assertTrue(continueButton.isDisplayed());
        continueButton.click();

    }

    @Then("I should give the {string}")
    public void iShouldGiveThe(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        Assert.assertTrue(passwordField.isDisplayed());
        passwordField.click();
        passwordField.sendKeys(password);

    }

    @And("click on Signin button")
    public void clickOnSigninButton() {
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='signInSubmit']")));
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();

    }

    @Then("again i should click on wishList")
    public void againIShouldClickOnWishList() {
        WebElement clickWishList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='add-to-wishlist-button-submit']")));
        Assert.assertTrue(clickWishList.isDisplayed());
        clickWishList.click();
    }

    @Then("the item should be visible in wishlist and click on viewList")
    public void theItemShouldBeVisibleInWishlistAndClickOnviewList() {
        WebElement viewList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Your List']")));
        Assert.assertTrue(viewList.isDisplayed());
        viewList.click();
    }
    @When("I click on All option")
    public void i_click_on_all_option() {
        //productPage.clickOnAll();
        WebElement allOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-hamburger-menu']")));
        Assert.assertTrue(allOption.isDisplayed());
        allOption.click();
    }
    @When("click on Best sellers")
    public void click_on_best_sellers() {
        productPage.clickOnBestSellers();

    }


    @And("click on Hot new releases")
    public void clickOnHotNewReleases() {
        productPage.clickOnHotNewReleases();
    }

    @Then("select first item from the list")
    public void selectFirstItemFromTheList() {
        productPage.clickOnFirstItem();
    }

    @And("add the item to the cart")
    public void addTheItemToTheCart() {
        cartPage.addToCart();
    }
}

