package learning.seleniumjava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class seleniumintro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Invoking Browser
		//Chrome - Chrome Driver -> Methods
		//Firefox - FirefoxDriver -> Methods
		
		// set chromedriver.exe path
		//System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		
		WebDriver driver = new EdgeDriver();
		
		// geckodriver (firefox)
		//System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\webdrivers\\geckodriver.exe");
		// WebDriver driver = new FirefoxDriver();
		
		System.setProperty("webdriver.edge.driver", "C:\\Program Files\\webdrivers\\msedgedriver.exe");
		
		
		driver.get("https://amazon.com.au");
		driver.getTitle();
		
		driver.close();
		//Assert.assertEquals();
	}

}
