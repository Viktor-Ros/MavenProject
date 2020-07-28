package basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import framework.utils.InitManager;
import framework.utils.PagesManager;
import framework.utils.StepsManager;

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
