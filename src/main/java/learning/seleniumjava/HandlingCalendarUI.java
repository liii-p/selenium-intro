package learning.seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCalendarUI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	
		//April 14
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_view_date1']")).click();
		
		while(!driver.findElement(By.cssSelector("div[class='ui-datepicker-title']")).getText().contains("June")) {
			driver.findElement(By.cssSelector("span[class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		List<WebElement> dates = driver.findElements(By.cssSelector("td[data-handler='selectDay']"));
		
		for (int i = 0; i < dates.size(); i++) {
			String text = driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).getText();
			if (text.equalsIgnoreCase("26")) {
				driver.findElements(By.cssSelector("td[data-handler='selectDay']")).get(i).click();
				break;
			}
		}
	}

}
