package learning.seleniumjava;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPractise {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");

		String username = "rahulshettyacademy";
		String password = "learning";

		// user rahulshettyacademy and password learning
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);

		// radio button - select okay
		driver.findElement(By.xpath("(//span[@class='checkmark'])[2]")).click();
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(8));

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#okayBtn")));
		driver.findElement(By.cssSelector("button#okayBtn")).click();

		// dropdown - select consultant
		WebElement selectPerson = driver.findElement(By.cssSelector("select[class='form-control']"));
		Select dropdown = new Select(selectPerson);
		dropdown.selectByVisibleText("Consultant");

		// click checkbox
		driver.findElement(By.id("terms")).click();

		// sign in
		driver.findElement(By.id("signInBtn")).click();
		// Wait until app card list row element is visible...
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("app-card-list[class='row']")));

		List<WebElement> products = driver.findElements(By.xpath("//h4[@class='card-title']"));
		// add all items to cart (4 products) dynamically
		// target products to get number of products on page
		for (int i = 0; i < products.size(); i++) {
			// target add to cart button
			driver.findElements(By.cssSelector("button[class*='btn'")).get(i).click();
		}
		// checkout button
		driver.findElement(By.cssSelector("a[class*='btn-primary']")).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[class*='btn-success']")));
		driver.findElement(By.cssSelector("button[class*='btn-success']")).click();

		// Enter location input
		driver.findElement(By.id("country")).sendKeys("Australia");
		driver.findElement(By.cssSelector("div[class*='checkbox-primary']")).click();
		driver.findElement(By.cssSelector("input[class*='btn-lg']")).click();
	}

}
