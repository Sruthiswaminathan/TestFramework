/*
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

public class CalculatorAutomation {

    private WindowsDriver<WindowsElement> driver;
    private Process process;
   // private static final Logger logger = Logger.getLogger(TeamsTest.class.getName());

    @BeforeClass
    public void setUp() throws IOException, MalformedURLException {
        String winAppDriverPath = "C:\\Program Files (x86)\\Windows Application Driver\\WinAppDriver.exe";
        ProcessBuilder builder = new ProcessBuilder(winAppDriverPath).inheritIO();
        process = builder.start();
       // logger.log(Level.INFO, "WinAppDriver started");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app","Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");

        try {
            driver = new WindowsDriver<>(new URL("http://127.0.0.1:4723/"), capabilities);
            //logger.log(Level.INFO, "WindowsDriver session created");
        } catch (Exception e) {
            //logger.log(Level.SEVERE, "Failed to create WindowsDriver session", e);
            throw e;
        }
    }


    @Test
    public void testTeams() throws InterruptedException {
        // Wait for the application to launch
        WebDriverWait wait = new WebDriverWait(driver, 20);

        // Automate calculator
        // Wait for the calculator to be ready
        WebElement oneButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("One")));
        oneButton.click();

        WebElement plusButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Plus")));
        plusButton.click();

        WebElement twoButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Two")));
        twoButton.click();

        WebElement equalsButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("Equals")));
        equalsButton.click();
    }

        @AfterClass
        public void tearDown () {
            if (driver != null) {
                driver.quit();
            }
            if (process != null) {
                process.destroy();
            }
        }
}

*/
