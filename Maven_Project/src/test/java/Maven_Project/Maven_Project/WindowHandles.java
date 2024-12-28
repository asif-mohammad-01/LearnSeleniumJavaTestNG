package Maven_Project.Maven_Project;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

	@Test
	public void learnWindowHandles() throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anjum\\Selenium-Maven-CICD\\Drivers\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		String parentWindow = driver.getWindowHandle();
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("newWindowBtn")));
		WebElement newWindow = driver.findElement(By.id("newWindowBtn"));
		//JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].click();", newWindow);
		
		 JavaScriptUtils jsUtils = new JavaScriptUtils(driver);
		 jsUtils.clickElement(newWindow);
		Set<String> handles = driver.getWindowHandles();
		
		for(String handle: handles) {
			if(!handle.equals(parentWindow)) {
				driver.switchTo().window(handle);
				driver.manage().window().maximize();
				WebElement firstName = driver.findElement(By.id("firstName"));
				//js.executeScript("arguments[0].value = arguments[1]", firstName, "Anjum is Good Girl");
				jsUtils.typeValue(firstName, "Anjum is Good Girl");
			}
		}
		Thread.sleep(2000);
		driver.close();
		driver.quit();
	}
	
	
}
