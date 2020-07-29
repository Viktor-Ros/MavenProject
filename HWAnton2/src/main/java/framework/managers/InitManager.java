package framework.managers;

import java.util.concurrent.TimeUnit;
import static framework.utils.PropertiesConstantUtils.*;

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
