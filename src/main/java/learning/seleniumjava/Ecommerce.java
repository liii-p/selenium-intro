package learning.seleniumjava;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ecommerce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// expected array
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(7));

		String[] veggieItems = { "Cucumber", "Brocolli", "Beetroot", "Beans" };

		addItems(driver, veggieItems);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		//explicit wait to target certain step
		//WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//w.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]")).click();
	
		WebElement countryDropDown = driver.findElement(By.cssSelector("select"));
	
		Select selectCountry = new Select(countryDropDown);
		selectCountry.selectByVisibleText("Australia");
		
		driver.findElement(By.cssSelector("input.chkAgree")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Proceed')]")).click();
	}
	
	public static void addItems(WebDriver driver, String[] veggieItems) {
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			// check whether extracted name is present or not in arrayList
			// convert array into arrayList for easy search

			String productName = name[0].trim();

			List veggieItemsList = Arrays.asList(veggieItems);

			if (veggieItemsList.contains(productName)) {
				j++;

				driver.findElements(By.xpath("//div[@class='product-action'] //button")).get(i).click();
				if (j == veggieItemsList.size()) {
					break;
				}
			}
		}
	}

}
