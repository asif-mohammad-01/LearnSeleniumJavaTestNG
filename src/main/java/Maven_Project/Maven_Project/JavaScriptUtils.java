package Maven_Project.Maven_Project;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtils {

    private WebDriver driver;

    public JavaScriptUtils(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Clicks on a WebElement using JavaScript.
     * @param element The WebElement to be clicked.
     */
    public void clickElement(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    /**
     * Types a value into an input field using JavaScript.
     * @param element The input field WebElement.
     * @param value The value to be entered.
     */
    public void typeValue(WebElement element, String value) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, value);
    }
}
