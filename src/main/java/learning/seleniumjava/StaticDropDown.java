package learning.seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

//TestNG is one of the testing frameworks
public class StaticDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// //header/div/button[1]/following-sibling::button[1]
			System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			//System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();
			System.out.println(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).isSelected());
			
			// click round trip and check it is enabled/disabled
			driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
			if (driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
				System.out.println("It's enabled.");
				Assert.assertTrue(true);
			} 
			else {
				Assert.assertTrue(false);
			}
			
			// Check how many checkboxes are selected
			List<WebElement> checkboxes = driver.findElements(By.cssSelector("div[id='discount-checkbox'] input[type='checkbox']"));
			
			int counter = 0;
			
			for (WebElement checkbox : checkboxes) {
				if (checkbox.isSelected()) {
					counter++;
				}
			}
			System.out.println(counter);
			
			System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
			
			
			WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
			//Dropdown with select tag
			Select dropdown = new Select(staticDropdown);
			dropdown.selectByIndex(3);
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByVisibleText("AED");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			dropdown.selectByValue("INR");
			System.out.println(dropdown.getFirstSelectedOption().getText());
			
			driver.findElement(By.id("divpaxinfo")).click();
			//Thread.sleep(2000);
			
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			for (int i = 1; i < 5; i++) {
				driver.findElement(By.id("hrefIncAdt")).click();
			}
			
			driver.findElement(By.id("btnclosepaxoption")).click();
			Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
			System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
			
	}

}
