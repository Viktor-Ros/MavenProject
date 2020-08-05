package framework.managers;

import static framework.utils.PropertiesConstantUtils.PATH_CHROME_DRIVER;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import framework.utils.AllureUtils;

public class DriverManager {

    private static WebDriver driver;
    
    private static PropertiesManager props = PropertiesManager.getPropertiesManager();
    
    private DriverManager(){
    }

    public static WebDriver getDriver() {
        if(driver == null) {
        	
        	ChromeOptions chromeOptions= new ChromeOptions();
   		    chromeOptions.setBinary("C:\\Users\\Viktor\\AppData\\Local\\Google\\Chrome\\Application\\chrome.exe"); 
		    System.setProperty("webdriver.chrome.driver", props.getProperty(PATH_CHROME_DRIVER));
		    driver = new ChromeDriver(chromeOptions);		   
		    
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
