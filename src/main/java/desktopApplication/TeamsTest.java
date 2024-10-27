package desktopApplication;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TeamsTest {

    public static ExtentReports extent;
    public static ExtentTest test;

    private WindowsDriver<WindowsElement> driver;
    private Process process;
    private static final Logger logger = Logger.getLogger(TeamsTest.class.getName());



    @BeforeClass
    public void setUp() throws IOException, MalformedURLException {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("teamsExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        String winAppDriverPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(winAppDriverPath).inheritIO();
        process = builder.start();
        logger.log(Level.INFO, "WinAppDriver started");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "C:\\Users\\sruthi_s\\AppData\\Local\\Microsoft\\WindowsApps\\MSTeams_8wekyb3d8bbwe\\ms-teams.exe");

        try {
            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);
            logger.log(Level.INFO, "WindowsDriver session created");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to create WindowsDriver session", e);
            throw e;
        }
    }

    @Test
    public void testTeams() {
        test = extent.createTest("testTeams", "Automates the creation of a team in Microsoft Teams");
        WebDriverWait wait = new WebDriverWait(driver, 20);

        try {
            WebElement teamsButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Teams")));
            teamsButton.click();
            test.pass("Clicked on Teams button");

            WebElement create = wait.until(ExpectedConditions.elementToBeClickable(By.name("Create and join teams and channels")));
            create.click();
            test.pass("Clicked on Create and join teams");

            WebElement createTeam = wait.until(ExpectedConditions.elementToBeClickable(By.name("Create team")));
            createTeam.click();
            test.pass("Clicked on Create team");

            WebElement teamName = wait.until(ExpectedConditions.elementToBeClickable(By.name("Team name")));
            teamName.sendKeys("TestTeam");
            test.pass("Entered team name");

            WebElement description = wait.until(ExpectedConditions.elementToBeClickable(By.name("Description")));
            description.sendKeys("April 25th Batch");
            test.pass("Entered description");

            WebElement teamType = wait.until(ExpectedConditions.elementToBeClickable(By.name("Private")));
            teamType.click();
            test.pass("Selected Private as team type");

            WebElement confirmPermission = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Private People need permission to join")));
            confirmPermission.click();
            test.pass("Confirmed Private team permissions");

            WebElement channelName = wait.until(ExpectedConditions.elementToBeClickable(By.name("Name your channel")));
            channelName.sendKeys("General Discussions");
            test.pass("Entered channel name");

            WebElement createTeamButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Create")));
            createTeamButton.click();
            test.pass("Clicked on Create to finish team creation");
        } catch (Exception e) {
            test.fail("Test encountered an exception: " + e.getMessage());
            throw e;
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
        if (process != null) {
            process.destroy();
        }
    }

    @AfterSuite
    public void generateReport() {
        if (extent != null) {
            extent.flush();
        }
    }
}
