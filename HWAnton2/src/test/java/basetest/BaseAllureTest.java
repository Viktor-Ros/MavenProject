package basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import framework.managers.InitManager;
import framework.managers.StepsManager;

public class BaseAllureTest {

    protected StepsManager appSteps = StepsManager.getStepsManager();
    
    @BeforeAll
    public static void setUp() {
        InitManager.initFramework();
    }
       
    @AfterAll
    public static void tearDown() {
    	InitManager.quitFramework();
    }   
}
