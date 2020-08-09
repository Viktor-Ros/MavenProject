package framework.utils;

import org.junit.runner.notification.Failure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import framework.managers.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit4.AllureJunit4;

public class Junit4Utils extends AllureJunit4{
	
    @Override
    public void testFailure(Failure failure) {
       addScreenshot();
       super.testFailure(failure);
    }
	
    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
