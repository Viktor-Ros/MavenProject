package tests;

import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@EnabledForJreRange
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"},
        glue = {"framework.stepdef"},
        features = {"src/test/resources/cucumbers"},
        tags = {"@checkEmailErrorMessage"}
)
public class CucumberTest {}
