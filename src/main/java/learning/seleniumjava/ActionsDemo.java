package learning.seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com.au");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("a[id='nav-link-accountList']"));
		
		a.moveToElement(driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		// Moves to specific element
		a.moveToElement(move).contextClick().build().perform();
		
//		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox'")).click();
//		driver.findElement(By.cssSelector("input[id='twotabsearchtextbox'")).sendKeys("chair");
//		driver.findElement(By.cssSelector("input[id='nav-search-submit-button'")).click();
		
	}

}
