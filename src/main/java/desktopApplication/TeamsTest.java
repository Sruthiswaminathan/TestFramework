package desktopApplication;

import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TeamsTest {

    private WindowsDriver<WindowsElement> driver;
    private Process process;
    private static final Logger logger = Logger.getLogger(TeamsTest.class.getName());

    @BeforeClass
    public void setUp() throws IOException, MalformedURLException {
        String winAppDriverPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(winAppDriverPath).inheritIO();
        process = builder.start();
        logger.log(Level.INFO, "WinAppDriver started");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        //capabilities.setCapability("app", "MSTeams_8wekyb3d8bbwe!MSTeams"); // Use AUMID instead of executable path
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
    public void testTeams() throws InterruptedException {
        // Wait for the application to launch
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Wait for the calculator to be ready
        WebElement teamsButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Teams")));
        teamsButton.isDisplayed();
        teamsButton.click();

        WebElement create = wait.until(ExpectedConditions.elementToBeClickable(By.name("Create and join teams and channels")));
        create.click();

        WebElement createTeam = wait.until(ExpectedConditions.elementToBeClickable(By.name("Create team")));
        createTeam.click();

        WebElement teamName = wait.until(ExpectedConditions.elementToBeClickable(By.name("Team name")));
        teamName.click();
        teamName.sendKeys("TestTeam");

        WebElement description = wait.until(ExpectedConditions.elementToBeClickable(By.name("Description")));
        description.click();
        description.sendKeys("April 25th Batch");

        WebElement teamType = wait.until(ExpectedConditions.elementToBeClickable(By.name("Private")));
        teamType.isDisplayed();
        teamType.click();

        WebElement confirmPermission = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Private People need permission to join")));
        confirmPermission.isDisplayed();
        confirmPermission.click();

        WebElement channelName = wait.until(ExpectedConditions.elementToBeClickable(By.name("Name your channel")));
        channelName.click();
        channelName.sendKeys("General Discussions");

        WebElement createTeamButton= wait.until(ExpectedConditions.elementToBeClickable(By.name("Create")));
        createTeamButton.isDisplayed();
        createTeamButton.click();

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
}