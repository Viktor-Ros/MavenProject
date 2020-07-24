package basetest;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import framework.utils.InitManager;
import framework.utils.PagesManager;

public class BaseTest {

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
