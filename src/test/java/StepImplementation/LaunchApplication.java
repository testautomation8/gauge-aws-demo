package StepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static Utils.Driver.webDriver;

public class LaunchApplication {

    public static String APP_URL = System.getenv("APP_URL");

    @Step("User Navigate to page <example>")
    public void userNavigateToPage(String page) {
        webDriver.get(APP_URL + page + ".html");
        try {
            new WebDriverWait(webDriver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='at-cv-lightbox-close']")));
            webDriver.findElement(By.xpath("//*[@id='at-cv-lightbox-close']")).click();
        } catch (Exception e) {
            System.out.println("Pop up is not present");
        }
    }
}

