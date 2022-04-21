package StepImplementation;

import com.thoughtworks.gauge.Step;
import org.openqa.selenium.By;

import static Utils.Driver.webDriver;
import static org.junit.Assert.assertTrue;

public class InputForms {

    @Step("User enter <message> in the input field")
    public void enterMessage(String message) {

        webDriver.findElement(By.xpath("//input[@id='user-message']")).sendKeys(message);
        webDriver.findElement(By.xpath("//button[contains(text(),'Show Message')]")).click();

    }

    @Step("User able to view <message> under Your Message")
    public void validateMessage(String message) {
        String displayedMessage = webDriver.findElement(By.xpath("//span[@id='display']")).getText();
        assertTrue(displayedMessage.contains(message));

    }

}
