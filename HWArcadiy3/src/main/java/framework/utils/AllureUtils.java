package framework.utils;

import static io.qameta.allure.junitplatform.AllureJunitPlatform.ALLURE_FIXTURE;
import static io.qameta.allure.junitplatform.AllureJunitPlatform.EVENT_FAILURE;
import static io.qameta.allure.junitplatform.AllureJunitPlatform.TEAR_DOWN;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ReflectiveInvocationContext;
import org.junit.jupiter.api.extension.InvocationInterceptor.Invocation;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import framework.managers.DriverManager;
import io.qameta.allure.Attachment;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.model.Status;
import io.qameta.allure.model.StatusDetails;
import io.qameta.allure.util.ResultsUtils;

public class AllureUtils extends AllureJunit5{
	

    @Attachment(value = "screenshot", type = "image/png")
    public static byte[] addScreenshot() {
        return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
