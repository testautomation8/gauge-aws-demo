package StepImplementation;

import Utils.Driver;
import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import static Utils.Driver.webDriver;

public class LaunchApplication {

    public static String APP_URL = System.getenv("APP_URL");

    @Step("User Navigate to page <example>")
    public void userNavigateToPage(String page) {
        webDriver.get(APP_URL + page + ".html");
        boolean isPopUpDisplayed = webDriver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]")).isDisplayed();
        if (isPopUpDisplayed) {
            webDriver.findElement(By.xpath("//*[@id=\"at-cv-lightbox-close\"]")).click();
        }
    }

}
