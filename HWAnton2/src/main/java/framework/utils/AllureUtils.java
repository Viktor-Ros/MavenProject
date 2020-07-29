package framework.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import framework.managers.DriverManager;

import java.nio.charset.StandardCharsets;

public class AllureUtils {

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "text attachment", type = "text/plain")
    public static byte[] addTextPlain(String text) {
        return text.getBytes(StandardCharsets.UTF_8);
    }
}