package basetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserFactory{

    private BrowserFactory() {
        //private constructor as a part of singleton Design Pattern
        //Prevents instantiation
    }
    //single WebDriver instance
    private static WebDriver driver = null;

    // Method to get the instance of WebDriver
    public static WebDriver getDriver() {
        if (driver == null) {
            /*System.setProperty("webdriver.chrome.logfile", "src\\test\\resources\\chromedriver.log");*/
            // System.setProperty("webdriver.chrome.driver", "C:\\Users\\hemavathi_v\\Downloads\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }
        return driver;
    }
    // Method to close and reset the WebDriver instance
    public static void cleanUp() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
