package framework.stepdef;

import framework.managers.InitManager;
import framework.utils.AllureUtils;
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
