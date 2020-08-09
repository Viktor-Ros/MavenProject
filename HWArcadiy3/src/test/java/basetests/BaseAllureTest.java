package basetests;



import org.junit.AfterClass;
import org.junit.BeforeClass;

import framework.managers.InitManager;
import framework.managers.PagesManager;

public class BaseAllureTest {

    protected PagesManager app = PagesManager.getPagesManager();
    
    @BeforeClass
    public static void setUp() {
        InitManager.initFramework();
    }
       
    @AfterClass
    public static void tearDown() {
    	InitManager.quitFramework();
    }   
}