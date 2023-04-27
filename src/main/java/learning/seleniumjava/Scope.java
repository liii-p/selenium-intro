package learning.seleniumjava;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scope {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1. Get count of links on page
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//2. Get count of footer links
		//System.out.println(driver.findElements(By.cssSelector("div[id='gf-BIG'] a")).size());
		
		WebElement footerDriver = driver.findElement(By.cssSelector("div#gf-BIG")); //Limiting webdriver scope
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//3. 
		WebElement columnDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
	
		//4. Click on each link in column and check if the pages are opening
		int columnLinks = columnDriver.findElements(By.tagName("a")).size();
		
		for(int i = 1; i < columnLinks; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			
		}
			Set<String> windows = driver.getWindowHandles();
			Iterator<String> it = windows.iterator();
		
			// Get title of each new page
			while(it.hasNext()) {
				driver.switchTo().window(it.next());
				System.out.println(driver.getTitle());
			}
	}

}
