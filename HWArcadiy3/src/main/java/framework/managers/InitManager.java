package framework.managers;

import static framework.utils.PropertiesConstantUtils.APP_URL;
import static framework.utils.PropertiesConstantUtils.IMPLICITLY_WAIT;
import static framework.utils.PropertiesConstantUtils.PAGE_LOAD_TIMEOUT;

import java.util.concurrent.TimeUnit;

public class InitManager {

    public static PropertiesManager props = PropertiesManager.getPropertiesManager();
    
    public static void initFramework() {
    	DriverManager.getDriver().manage().window().maximize();
    	DriverManager.getDriver().manage().timeouts().implicitlyWait(Integer.parseInt(props.getProperty(IMPLICITLY_WAIT)), TimeUnit.SECONDS);
    	DriverManager.getDriver().manage().timeouts().pageLoadTimeout(Integer.parseInt(props.getProperty(PAGE_LOAD_TIMEOUT)), TimeUnit.SECONDS);
    	DriverManager.getDriver().get(props.getProperty(APP_URL));
    }


    public static void quitFramework() {
    	DriverManager.quitDriver();
    }

    
}