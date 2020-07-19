import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private static WebDriver driver;
    
	private final static String URL = "http://www.sberbank.ru/ru/person";

    private Driver(){
    }

    public static WebDriver getDriver() {
        if(driver == null) {
        	
		    System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
		    driver = new ChromeDriver();
		    driver.manage().window().maximize();
		    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		    driver.get(URL);
        }
        return driver;
    }

    public static void quitDriver(){
    	try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        driver.quit();
        driver = null;
    }
}