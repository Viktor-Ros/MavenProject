package tests;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        glue = {"framework.stepdef"},
        features = {"src/test/resources/cucumbers"},
        tags = {"@checkEmailErrorMessage"}
)
public class CucumberTest {}
