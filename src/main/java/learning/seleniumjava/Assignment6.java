package learning.seleniumjava;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//1. Select one checkbox (any).
		driver.findElement(By.cssSelector("input#checkBoxOption3")).click();
		
		//2. grab the text for that checkbox
		String checkBoxText = driver.findElement(By.cssSelector("label[for='honda']")).getText();
		System.out.println(checkBoxText); // Check it's the correct text
		
		//3. Select an option in dropdown. Same option as step 2. NO hardcoding.
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select option = new Select(dropdown);
		option.selectByVisibleText(checkBoxText);
		
		//4. Enter the step 2 text in editbox (switch to alert example).
		driver.findElement(By.cssSelector("input[id='name']")).click();
		driver.findElement(By.cssSelector("input[id='name']")).sendKeys(checkBoxText);
		
		
		//5. Click alert button and then verify if text from step 2 is present in pop-up message
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		String alertText = driver.switchTo().alert().getText();
		System.out.println(alertText); // See the text output
		alertText.contains(checkBoxText);
		driver.switchTo().alert().accept();
	}

}
