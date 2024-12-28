package Maven_Project.Maven_Project;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasicAutomation {

	@Test
	public void EdgeTest() throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.edge.driver", "C:\\Users\\anjum\\Selenium-Maven-CICD\\Drivers\\msedgedriver.exe");
		//EdgeDriver edge_driver = new EdgeDriver();
		//WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--headless");
		WebDriver edge_driver = new EdgeDriver(options);
		edge_driver.get("https://www.w3schools.com");
		try {
			Thread.sleep(2000);
			System.out.println("Edge hasbeen launched");
			//implicit Wait
			edge_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			//Explicit Wait
			WebDriverWait wait = new WebDriverWait(edge_driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@aria-label='Login to your account'])[1]")));
			edge_driver.findElement(By.xpath("(//a[@aria-label='Login to your account'])[1]")).click();
			edge_driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asiftaj0160@gmail.com");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
			edge_driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@12345");
			edge_driver.findElement(By.xpath("//button[@type='submit']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		edge_driver.quit();
		}
	
	@Test
	public void ChromeTest() throws Exception {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\anjum\\Selenium-Maven-CICD\\Drivers\\chromedriver.exe");
		//ChromeDriver driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		//options.addArguments("--headless");
		WebDriver driver = new ChromeDriver(options);

		driver.get("https://www.w3schools.com");
		try {
			Thread.sleep(2000);
			System.out.println("Chrome hasbeen launched");
			String Title=driver.getTitle();
			System.out.println("The Title is: "+ Title);
			//System.out.println("Edge hasbeen launched");
			//implicit Wait
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			//Explicit Wait
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@aria-label='Login to your account'])[1]")));
			driver.findElement(By.xpath("(//a[@aria-label='Login to your account'])[1]")).click();
			driver.findElement(By.xpath("//input[@name='email']")).sendKeys("asiftaj0160@gmail.com");
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='password']")));
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("abc@12345");
			driver.findElement(By.xpath("//button[@type='submit']")).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.sleep(2000);
		driver.quit();
		}

}
