package learning.seleniumjava;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLCheck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions ops = new ChromeOptions();
		// for other browsers FirefoxOptions...SafariOptions...EdgeOptions...
		ops.addArguments("--remote-allow-origins=*");
		ops.setAcceptInsecureCerts(true);
		Proxy proxy = new Proxy(); //set proxy settings
		proxy.setHttpProxy("ipadress:342");
		ops.setCapability("proxy", proxy);
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\webdrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(ops);
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());
		
		// refer to chromedriver.chromium.org/capabilities for more info
	}

}
