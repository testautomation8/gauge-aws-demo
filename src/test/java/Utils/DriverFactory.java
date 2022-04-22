package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    // Get a new WebDriver Instance.
    static WebDriver driver;

    static WebDriver getDriver() {

        String platform = System.getenv("PLATFORM");

        if (platform.toUpperCase().equals("AWS_CHROME")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("start-maximized");
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.setBinary("/usr/bin/google-chrome");
            System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
            driver = new ChromeDriver(chromeOptions);
        } else {
            //if User is running test locally. Please update chromedriver path
            System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
