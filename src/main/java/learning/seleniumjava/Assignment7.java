package learning.seleniumjava;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class Assignment7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		ChromeOptions ops = new ChromeOptions();
		ops.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		List<WebElement> row = driver.findElements(By.cssSelector(".table-display tr"));
		int count = 0;
		// print number of rows present in table (should be 11)
		for (int i = 0; i < row.size(); i++) {
			count++;
		}
		System.out.println(count);
		
		Assert.assertEquals(count, 11);
	
		// print number of columns (should be 3)
		
		List<WebElement> column = driver.findElements(By.cssSelector(".table-display tr th"));
		int count2 = 0;

		for (int i = 0; i < column.size(); i++) {
			count2++;
		}
		System.out.println(count2);
		
		Assert.assertEquals(count2, 3);
		
		// print second row of data
		System.out.println(driver.findElement(By.cssSelector(".table-display tr:nth-child(3)")).getText());
		
		
	}

}
