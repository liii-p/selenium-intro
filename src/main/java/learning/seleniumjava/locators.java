package learning.seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class locators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.id("inputUsername")).sendKeys("lianna");
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		driver.findElement(By.className("signInBtn")).click();
		// Timeout issue - needs implicit wait
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		// Need time to allow transition
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000); // Perhaps not preferred method...
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Lianna");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("test@test.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[type='text']:nth-child(3)")).sendKeys("test2@test2.com");
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("0434253425");
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Lianna");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.id("chkboxOne")).click();
		driver.findElement(By.xpath("//button[contains(@class,'submit')]")).click();
		
		
		// CSS Selector
		// tagname.classname
		// tagname#id
		// tagname[attribute='value']
		// e.g. Input[placeholder='Username']
		// p.error
		
		// Xpath
		// //Tagname[@attribute='value']
		// e.g. //input[@placeholder='Username']
		// //input[@placeholder='Name']
	}

}
