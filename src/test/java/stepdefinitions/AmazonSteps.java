package stepdefinitions;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
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

    private static ExtentReports extent;
    private ExtentTest test;


    @Before
    public void setup() {
        if (extent == null) {

            ExtentSparkReporter sparkReporter = new ExtentSparkReporter("extentReport.html");
            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
        }
        test = extent.createTest("Amazon Test Steps"); // Create a new test instance
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
        test.pass("Navigated to Amazon homepage");
    }

    @When("I search for {string}")
    public void i_search_for(String item) {
        amazonHomePage.searchForItem(item);
       test.info("Searched for item: " + item);

    }

    @When("I select the first item in the search results")
    public void iSelectTheFirstItemInTheSearchResults() {
        WebElement firstItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-main-slot .s-result-item")));
        org.testng.Assert.assertTrue(firstItem.isDisplayed());
        firstItem.click();
       test.pass("Selected the first item in search results");

    }

    @When("I add the item to the wishlist")
    public void iAddTheItemToTheWishList() {
        searchResultsPage.scrollDown();
        searchResultsPage.addToWishList();
        test.pass("Added item to the wishlist");
    }


    @And("I login with valid credentials {string}")
    public void iLoginWithValidCredentials(String mobilenumber) {
        WebElement mobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
        Assert.assertTrue(mobileNumber.isDisplayed());
        mobileNumber.click();
        mobileNumber.sendKeys(mobilenumber);
        test.pass("Entered mobile number for login");

    }

    @Then("Then Click on continue")
    public void thenClickOnContinue() {
        WebElement continueButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='continue']")));
        Assert.assertTrue(continueButton.isDisplayed());
        continueButton.click();
       test.pass("Clicked on Continue button");

    }

    @Then("I should give the {string}")
    public void iShouldGiveThe(String password) {
        WebElement passwordField = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='password']")));
        Assert.assertTrue(passwordField.isDisplayed());
        passwordField.click();
        passwordField.sendKeys(password);
        test.pass("Password entered successfully.");

    }

    @And("click on Signin button")
    public void clickOnSigninButton() {
        WebElement signInButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='signInSubmit']")));
        Assert.assertTrue(signInButton.isDisplayed());
        signInButton.click();
        test.pass("Sign in button clicked successfully.");

    }

    @Then("again i should click on wishList")
    public void againIShouldClickOnWishList() {
        WebElement clickWishList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='add-to-wishlist-button-submit']")));
        Assert.assertTrue(clickWishList.isDisplayed());
        clickWishList.click();
        test.pass("Clicked on wishlist successfully.");
    }

    @Then("the item should be visible in wishlist and click on viewList")
    public void theItemShouldBeVisibleInWishlistAndClickOnviewList() {
        WebElement viewList = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='View Your List']")));
        Assert.assertTrue(viewList.isDisplayed());
        viewList.click();
        test.pass("Item visible in wishlist and clicked on view list successfully.");
    }
    @When("I click on All option")
    public void i_click_on_all_option() {
        //productPage.clickOnAll();
        WebElement allOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='nav-hamburger-menu']")));
        Assert.assertTrue(allOption.isDisplayed());
        allOption.click();
        test.pass("Clicked on 'All' option successfully.");
    }
    @When("click on Best sellers")
    public void click_on_best_sellers() {
        productPage.clickOnBestSellers();
        test.pass("Clicked on 'Best Sellers' successfully.");

    }


    @And("click on Hot new releases")
    public void clickOnHotNewReleases() {
        productPage.clickOnHotNewReleases();
       test.pass("Clicked on 'Hot New Releases' successfully.");
    }

    @Then("select first item from the list")
    public void selectFirstItemFromTheList() {
        productPage.clickOnFirstItem();
       test.pass("First item selected from the list successfully.");
    }

    @And("add the item to the cart")
    public void addTheItemToTheCart() {
        cartPage.addToCart();
        test.pass("Item added to the cart successfully.");

    }
    @After
    public void tearDownReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}

