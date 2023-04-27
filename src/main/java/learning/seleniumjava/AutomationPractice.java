package learning.seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		// Enter name, email and password
		driver.findElement(By.name("name")).sendKeys("Lianna");
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
		
		// Select checkbox
		driver.findElement(By.id("exampleCheck1")).click();
		
		// Select dropdown
		WebElement dropdown = driver.findElement(By.id("exampleFormControlSelect1"));
		Select genderDropdown = new Select(dropdown);
		genderDropdown.selectByVisibleText("Female");
		
		// Select student
		driver.findElement(By.xpath("//input[@id='inlineRadio1']")).click();
		
		// Enter date of birth
		driver.findElement(By.name("bday")).sendKeys("1/1/1901");
		
		// Submit
		driver.findElement(By.cssSelector("input[value='Submit']")).click();
		
		// Capture success message
		System.out.println(driver.findElement(By.cssSelector("div[class*='alert']")).getText());
	}

}
