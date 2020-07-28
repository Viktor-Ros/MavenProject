package framework.steps;

import org.openqa.selenium.support.PageFactory;

import framework.utils.DriverManager;
import framework.utils.PagesManager;
import framework.utils.StepsManager;

public class BaseStep {
	
    protected StepsManager appSteps = StepsManager.getStepsManager();
    
	PagesManager appPages = PagesManager.getPagesManager();

    public BaseStep(){
        PageFactory.initElements(DriverManager.getDriver(), this);
    }
}