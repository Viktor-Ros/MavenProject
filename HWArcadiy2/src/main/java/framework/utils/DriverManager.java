package framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static framework.utils.PropertiesConstant.*;

public class DriverManager {

    private static WebDriver driver;
    
    private static PropertiesManager props = PropertiesManager.getPropertiesManager();
    
    private DriverManager(){
    }

    public static WebDriver getDriver() {
        if(driver == null) {
        	
		    System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
		    driver = new ChromeDriver();
        }
        return driver;
    }

    public static void quitDriver(){
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        driver.quit();
        driver = null;
    }
}