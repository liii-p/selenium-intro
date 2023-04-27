package learning.seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Assignment8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//type in dropdown and select desired country (can -> canada)
		driver.findElement(By.cssSelector("input[id='autocomplete']")).sendKeys("can");
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));
		
		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("Canada")) {
				option.click();
				break;
			}
		}
	}

}
