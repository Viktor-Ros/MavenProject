package basetests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import framework.managers.InitManager;
import framework.managers.PagesManager;

public class BaseAllureTest {

    protected PagesManager app = PagesManager.getPagesManager();
    
    @BeforeAll
    public static void setUp() {
        InitManager.initFramework();
    }
       
    @AfterAll
    public static void tearDown() {
    	InitManager.quitFramework();
    }   
}