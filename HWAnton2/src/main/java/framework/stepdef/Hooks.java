package framework.stepdef;

import framework.utils.AllureUtils;
import framework.utils.InitManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp(){
    	InitManager.initFramework();
    }

    @After
    public void tearDown(){
    	AllureUtils.addScreenshot();
        InitManager.quitFramework();
    }
}
