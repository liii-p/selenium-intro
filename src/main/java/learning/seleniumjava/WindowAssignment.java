package learning.seleniumjava;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowAssignment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		// multiple windows - https://the-internet.herokuapp.com/windows
		driver.get("https://the-internet.herokuapp.com/windows");
		
		// click on click here
		driver.findElement(By.cssSelector("div[class='example'] a")).click();
		
		// switch to new window and capture text, print in output
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example']")).getText());
		
		// switch back to first window and capture "opening a new window", print in output
		driver.switchTo().window(parentId);
		System.out.println(driver.findElement(By.cssSelector("div[class='example'] h3")).getText());
		
		
	}

}
